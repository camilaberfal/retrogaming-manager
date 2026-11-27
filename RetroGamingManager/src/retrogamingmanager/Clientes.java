package retrogamingmanager;

/**
 *
 * @author emmanuel
 */
public abstract class Clientes extends Persona {
    private String telefono;
    private String correo;
    private String tipo; // Regular o Coleccionista Frecuente
    private int comprasFinalizadas;
    
    public boolean ValidarTipo(String tipo)
    { 
        if (tipo.equals("Regular") || tipo.equals("Coleccionista Frecuente")) 
            return true;  
        System.out.println("Error de contrato, el cliente debe ser: Regular o Coleccionista Frecuente");
        return false;
    }
    
    public Clientes(String DNI, String nombre, String apellidos, String telefono, String correo, String tipo) {
        super(DNI, nombre, apellidos);
        this.telefono = telefono;
        this.correo = correo;
        this.setTipo(tipo);
    }

    public int sumarCompraFinalizada()
    {
        comprasFinalizadas++;
        return comprasFinalizadas;
    }

    public int getComprasFinalizadas() {
        return comprasFinalizadas;
    } 
    
    
    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public abstract double calcularDescuento();
    public boolean setTipo(String tipo) { 
        if (ValidarTipo(tipo))
        {
            this.tipo = tipo;
            return true;
        }
        return false; 
    }

    public void setComprasFinalizadas(int comprasFinalizadas) {
        if (0 > comprasFinalizadas)
            return;
        this.comprasFinalizadas = comprasFinalizadas;
    }
    
    
    
}
