package retrogamingmanager;

public class Cliente extends Persona {

    private String telefono;
    private String correo;
    private int comprasFinalizadas;
    private String tipo = "Regular";

    public Cliente(String dni, String nombres, String apellidos, String telefono, String correo) {
        super(dni, nombres, apellidos);
        this.telefono = telefono;
        this.correo = correo;
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

    public double calcularDescuento(double importeArticulos) {
        if ("Coleccionista Frecuente".equals(tipo)) {
            return importeArticulos * 0.1;
        }
        return 0;
    }

    public void registrarCompraFinalizada() {
        comprasFinalizadas++;
        if (comprasFinalizadas == 5) {
            tipo = "Coleccionista Frecuente";
        }
    }

    public void actualizarDatos(String dni, String nombres, String apellidos, String telefono, String correo) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }
}
