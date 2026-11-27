package retrogamingmanager;

/**
 *
 * @author camila
 */
public class FacturacionAutomatica {
    private static double TASA_IGV = 0.18;
    private Comprobante[] comprobantes;
    private int cantidadComprobantes;

    public FacturacionAutomatica() {
        comprobantes = new Comprobante[GestionOrdenVenta.CAPACIDAD];
        cantidadComprobantes = 0;
    }

    public String generarBoletaDePago(CuentaVenta cuenta) {
        return registrarComprobante(cuenta, "Boleta", "", "");
    }

    public String generarFacturaDePago(CuentaVenta cuenta, String ruc, String razonSocial) {
        if (ruc.equals("") || razonSocial.equals("")) {
            return "Ingresa el RUC y la razón social.";
        }

        return registrarComprobante(cuenta, "Factura", ruc, razonSocial);
    }

    private String registrarComprobante(CuentaVenta cuenta, String tipo, String ruc, String razonSocial) {
        if (tieneComprobante(cuenta.numeroOrden)) {
            return "La orden ya tiene un comprobante.";
        }
        int numero = cantidadComprobantes + 1;
        comprobantes[cantidadComprobantes] = new Comprobante(numero, tipo, ruc, razonSocial, cuenta);
        cantidadComprobantes++;
        return "Se emitió el comprobante N.º " + numero + ".";
    }

    public boolean tieneComprobante(int numeroOrden) {
        for (int i = 0; i < cantidadComprobantes; i++) {
            if (comprobantes[i].getNumeroOrden() == numeroOrden) {
                return true;
            }
        }
        return false;
    }

    public CuentaVenta calcularCuentaDePrueba(OrdenVenta orden) {
        double subtotal = redondear(orden.getTotal() / (1 + TASA_IGV));
        double igv = redondear(orden.getTotal() - subtotal);
        DetalleVenta[] detalles = {new DetalleVenta("Juguete", "Importe de la orden de prueba", subtotal, 1)};
        CuentaVenta cuenta = new CuentaVenta(orden.getNumero(), detalles, 0, 0, subtotal, igv, orden.getAdelanto());
        cuenta.marcarComoCuentaDePrueba();
        return cuenta;
    }

    public CuentaVenta calcularMontosDeLaOrden(OrdenVenta orden, Clientes cliente, DetalleVenta[] detalles, double envio) {
        double sumaDetalles = 0;
        double sumaJuguetes = 0;
        for (DetalleVenta detalle : detalles) {
            double importe = detalle.getImporte();
            sumaDetalles += importe;
            if ("Juguete".equals(detalle.getTipo())) {
                sumaJuguetes += importe;
            }
        }

        double descuento = redondear(sumaJuguetes * cliente.calcularDescuento());
        double cargoEnvio = redondear(envio);
        double subtotal = redondear(sumaDetalles - descuento + cargoEnvio);
        double igv = redondear(subtotal * TASA_IGV);
        return new CuentaVenta(orden.getNumero(), detalles, descuento, cargoEnvio, subtotal, igv, orden.getAdelanto());
    }

    public Comprobante obtener(int indice) {
        return comprobantes[indice];
    }

    public int getCantidadComprobantes() {
        return cantidadComprobantes;
    }

    static double redondear(double monto) {
        return Math.round(monto * 100) / 100.0;
    }
}
