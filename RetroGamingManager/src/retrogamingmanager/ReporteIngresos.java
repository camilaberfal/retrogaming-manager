package retrogamingmanager;

/**
 *
 * @author camila
 */
public class ReporteIngresos extends ReporteGerencial {
    private FacturacionAutomatica facturacion;
    private Fecha desde;
    private Fecha hasta;

    public ReporteIngresos(FacturacionAutomatica facturacion, Fecha desde, Fecha hasta) {
        super("Ingresos por concepto");
        this.facturacion = facturacion;
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public Object[][] generarFilas() {
        double juguetes = 0;
        double servicios = 0;
        double paquetes = 0;
        for (int i = 0; i < facturacion.getCantidadComprobantes(); i++) {
            Comprobante comprobante = facturacion.obtener(i);
            if (comprobante.esDePrueba() || !estaEnPeriodo(comprobante.getFechaEmision(), desde, hasta)) {
                continue;
            }

            DetalleVenta[] detalles = comprobante.getDetalles();
            for (int j = 0; j < detalles.length; j++) {
                String tipo = detalles[j].getTipo();
                double importe = detalles[j].getImporte();
                if ("Juguete".equals(tipo)) {
                    juguetes += importe;
                } else if ("Servicio".equals(tipo)) {
                    servicios += importe;
                } else if ("Paquete".equals(tipo)) {
                    paquetes += importe;
                }
            }
            juguetes -= comprobante.getDescuento();
        }

        return new Object[][] {
            {"Juguetes", FacturacionAutomatica.redondear(juguetes)},
            {"Servicios adicionales", FacturacionAutomatica.redondear(servicios)},
            {"Paquetes promocionales", FacturacionAutomatica.redondear(paquetes)},
            {"Total", FacturacionAutomatica.redondear(juguetes + servicios + paquetes)}
        };
    }
}
