package retrogamingmanager;

/**
 *
 * @author camila
 */

public class Empleado extends Persona {
    private String usuario, contrasena, rol;

    public Empleado(String usuario, String contrasena, String rol, String dni, String nombres, String apellidos) {
        super(dni, nombres, apellidos);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }


    public void actualizarDatos(String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean coincidenCredenciales(String usuario, String contrasena) {
        return usuario != null && usuario.equals(this.usuario)
                && contrasena != null && contrasena.equals(this.contrasena);
    }

}
