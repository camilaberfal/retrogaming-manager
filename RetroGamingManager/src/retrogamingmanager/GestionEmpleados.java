package retrogamingmanager;

/**
 *
 * @author camila
 */

public class GestionEmpleados extends GestionPersonas {
    public GestionEmpleados() {
        super(new Empleado[50], "empleado");
    }

    public Empleado obtenerEmpleado(int indice) {
        return (Empleado) personas[indice];
    }

    public String registrarEmpleado(String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        if ("".equals(dni) || "".equals(nombres) || "".equals(apellidos) || "".equals(usuario) || "".equals(contrasena)) {
            return "Completa todos los campos.";
        }

        if (buscar(dni) != -1) {
            return "Ya existe un empleado con ese DNI.";
        }

        for (int i = 0; i < cont; i++) {
            if (obtenerEmpleado(i).getUsuario().equals(usuario)) {
                return "Ya existe un empleado con ese usuario.";
            }
        }

        if (estaLleno()) {
            return "El registro de empleados está lleno.";
        }

        agregar(new Empleado(usuario, contrasena, rol, dni, nombres, apellidos));
        return "Exitoso";
    }
    
    public String modificarEmpleado(int indice, String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        if (!indiceValido(indice)) {
            return "Selecciona un empleado para modificar.";
        }

        if ("".equals(dni) || "".equals(nombres) || "".equals(apellidos) || "".equals(usuario) || "".equals(contrasena)) {
            return "Completa todos los campos.";
        }

        if (buscar(dni, indice) != -1) {
            return "Ya existe un empleado con ese DNI.";
        }

        for (int i = 0; i < cont; i++) {
            if (i != indice && obtenerEmpleado(i).getUsuario().equals(usuario)) {
                return "Ya existe un empleado con ese usuario.";
            }
        }

        obtenerEmpleado(indice).actualizarDatos(dni, nombres, apellidos, usuario, contrasena, rol);
        return "Exitoso";
    }
    
    public Empleado autenticar(String usuario, String contrasena) {
        for (int i = 0; i < cont; i++) {
            Empleado empleado = obtenerEmpleado(i);

            if (empleado.coincidenCredenciales(usuario, contrasena)) {
                return empleado;
            }
        }

        return null;
    }

    public Empleado[] getEmpleados() {
        return (Empleado[]) personas;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.personas = empleados;
    }
    
}
