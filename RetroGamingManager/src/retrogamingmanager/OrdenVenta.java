// modelo provisional hasta integrar las órdenes y el catálogo de la parte 2
package retrogamingmanager;

public class OrdenVenta {
    private final int numero;
    private final double total;
    private final Fecha fechaEntrega;
    private final Hora horaEntrega;
    private String estado = "Pendiente";
    private String estadoJuguetes = "Disponible";
    private double adelanto;
    private String resultadoAdelanto = "";
    private String dniVendedor = "";
    private String dniCliente = "";
    private String dniAlmacenero = "";
    private DetalleVenta[] detalles = new DetalleVenta[0];
    private Fecha fechaFinalizacion;

    public OrdenVenta(int numero, double total, Fecha fechaEntrega, Hora horaEntrega) {
        if (numero < 1 || !Double.isFinite(total) || total <= 0) {
            throw new IllegalArgumentException("El número y el total deben ser válidos.");
        }
        this.numero = numero;
        this.total = total;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
    }

    public int getNumero() {
        return numero;
    }

    void registrarDatosDeVenta(String dniVendedor, String dniCliente, DetalleVenta[] detalles) {
        this.dniVendedor = dniVendedor;
        this.dniCliente = dniCliente;
        this.detalles = detalles.clone();
    }

    public String getDniVendedor() {
        return dniVendedor;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public String getDniAlmacenero() {
        return dniAlmacenero;
    }

    public DetalleVenta[] getDetalles() {
        return detalles.clone();
    }

    public Fecha getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public double getTotal() {
        return total;
    }

    public Fecha getFechaEntrega() {
        return fechaEntrega;
    }

    public Hora getHoraEntrega() {
        return horaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public String getEstadoJuguetes() {
        return estadoJuguetes;
    }

    public double getAdelanto() {
        return adelanto;
    }

    public String getResultadoAdelanto() {
        return resultadoAdelanto;
    }

    void confirmarAdelanto() {
        adelanto = Math.round(total * 50) / 100.0;
        estado = "Confirmada";
    }

    void preparar(String dniAlmacenero) {
        this.dniAlmacenero = dniAlmacenero;
        estadoJuguetes = "Apartado";
        estado = "En Preparación";
    }

    void finalizar() {
        fechaFinalizacion = Fecha.hoy();
        estadoJuguetes = "Vendido";
        estado = "Finalizada";
    }

    void cancelar(String resultadoAdelanto) {
        this.resultadoAdelanto = resultadoAdelanto;
        estadoJuguetes = "Disponible";
        estado = "Cancelada";
    }

    long minutosHastaEntrega(Fecha fecha, Hora hora) {
        long dias = fechaEntrega.enDias() - fecha.enDias();
        return dias * 1440 + horaEntrega.enMinutos() - hora.enMinutos();
    }
}
