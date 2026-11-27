package retrogamingmanager;

public class Empleados extends Persona {
    private String usuario;
    private String password;
    private String rol; // Administrador, Vendedor o Almacener
    
    public boolean ValidarRol(String rol)
    { 
        if (rol.equals("Administrador") || rol.equals("Vendedor") || rol.equals("Almacenero")) 
            return true;  
        System.out.println("Error de contrato, el empleado debe ser: Administrador, Vendedor o Almacenero");
        return false;
    }
    
    public Empleados(String DNI, String nombre, String apellidos, String usuario, String password, String rol) {
        super(DNI, nombre, apellidos);
        this.usuario = usuario;
        this.password = password;
        this.setRol(rol);  
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean setRol(String rol) {
        if (ValidarRol(rol))
        {
            this.rol = rol;
            return true;
        }
        return false;
    }
    
    
}
