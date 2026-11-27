package retrogamingmanager;

/**
 *
 * @author emmanuel
 */
public abstract class Persona {
    protected String DNI;
    protected String nombres;
    protected String apellidos;
    public Persona(String DNI, String nombres, String apellidos)
    {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    } 

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
