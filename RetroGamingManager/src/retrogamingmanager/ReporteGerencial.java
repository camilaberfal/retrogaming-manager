package retrogamingmanager;

/**
 *
 * @author camila
 */
public abstract class ReporteGerencial {
    private String titulo;

    protected ReporteGerencial(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract Object[][] generarFilas();

    protected boolean estaEnPeriodo(Fecha fecha, Fecha desde, Fecha hasta) {
        long dia = fecha.enDias();
        return dia >= desde.enDias() && dia <= hasta.enDias();
    }
}
