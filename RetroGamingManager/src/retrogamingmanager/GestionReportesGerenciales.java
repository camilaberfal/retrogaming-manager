package retrogamingmanager;

/**
 *
 * @author camila
 */
public class GestionReportesGerenciales {
    private GestionEstadoOrden ordenes;
    private GestionPersonal personal;
    private GestionClientes clientes;

    public GestionReportesGerenciales(GestionEstadoOrden ordenes, GestionPersonal personal, GestionClientes clientes) {
        this.ordenes = ordenes;
        this.personal = personal;
        this.clientes = clientes;
    }

    public ReporteRotacion generarRotacion(Fecha desde, Fecha hasta) {
        validarPeriodo(desde, hasta);
        return new ReporteRotacion(ordenes, desde, hasta);
    }

    public ReporteProductividad generarProductividad() {
        return new ReporteProductividad(personal, ordenes);
    }

    public ReporteClientes generarClientesConMasCompras() {
        return new ReporteClientes(clientes, ordenes);
    }

    public ReporteIngresos generarIngresos(Fecha desde, Fecha hasta) {
        validarPeriodo(desde, hasta);
        return new ReporteIngresos(ordenes.getFacturacion(), desde, hasta);
    }

    private void validarPeriodo(Fecha desde, Fecha hasta) {
        if (desde.enDias() > hasta.enDias()) {
            throw new IllegalArgumentException("La fecha inicial debe ser anterior o igual a la fecha final.");
        }
    }
}
