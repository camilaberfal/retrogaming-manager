package retrogamingmanager;

/**
 *
 * @author camila
 */
public class CuentaVenta {
    int numeroOrden;
    private DetalleVenta[] detalles;
    double descuento;
    double envio;
    double subtotal;
    double igv;
    double adelanto;
    private double total;
    private double saldo;
    private boolean dePrueba;

    CuentaVenta(int numeroOrden, DetalleVenta[] detalles, double descuento, double envio, double subtotal, double igv, double adelanto) {
        this.numeroOrden = numeroOrden;
        this.detalles = detalles;
        this.descuento = descuento;
        this.envio = envio;
        this.subtotal = subtotal;
        this.igv = igv;
        this.adelanto = adelanto;
        total = FacturacionAutomatica.redondear(subtotal + igv);
        saldo = FacturacionAutomatica.redondear(total - adelanto);
    }

    DetalleVenta[] getDetalles() {
        return detalles.clone();
    }

    void marcarComoCuentaDePrueba() {
        dePrueba = true;
    }

    boolean esDePrueba() {
        return dePrueba;
    }

    public double getTotal() {
        return total;
    }

    public double getSaldo() {
        return saldo;
    }

    public String obtenerResumenParaPantalla() {
        String texto = "Orden N.º " + numeroOrden + "\n\n";
        for (DetalleVenta detalle : detalles) {
            texto += String.format("%s - %s: %d × S/ %.2f = S/ %.2f%n", detalle.getTipo(), detalle.getNombre(), detalle.getCantidad(), detalle.getPrecioUnitario(), detalle.getImporte());
        }
        texto += String.format("%nDescuento: S/ %.2f%nEnvío: S/ %.2f%nSubtotal: S/ %.2f%n", descuento, envio, subtotal);
        texto += String.format("IGV: S/ %.2f%nTotal: S/ %.2f%n", igv, getTotal());
        texto += String.format("Adelanto: S/ %.2f%nSaldo a pagar: S/ %.2f", adelanto, getSaldo());
        return texto;
    }
}
