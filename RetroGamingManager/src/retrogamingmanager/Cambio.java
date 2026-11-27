package retrogamingmanager;

/**
 *
 * @author camila
 */
public class Cambio {
    private final String empleado;
    private final String accion;
    private final String estado;

    public Cambio(String empleado, String accion, String estado) {
        this.empleado = empleado;
        this.accion = accion;
        this.estado = estado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public String getAccion() {
        return accion;
    }

    public String getEstado() {
        return estado;
    }
}
