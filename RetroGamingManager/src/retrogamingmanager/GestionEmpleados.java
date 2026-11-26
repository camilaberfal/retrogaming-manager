package retrogamingmanager;

/**
 *
 * @author camila
 */

public class GestionEmpleados {
    private Empleado[] empleados;
    private int cont;

    public GestionEmpleados() {
        empleados = new Empleado[50];
        cont = 0;
    }

    public Empleado obtenerEmpleado(int indice) {
        return empleados[indice];
    }

    public int buscarEmpleadoPorDni(String dni) {
        for (int i = 0; i < cont; i++) {
            if (empleados[i].getDni().equals(dni)) {
                return i;
            }
        }
        return -1;
    }
    
    private String normalizarRol(String rol) {
        if ("Administrador".equals(rol) || "administrador".equals(rol) || "ADMINISTRADOR".equals(rol)) {
            return "Administrador";
        }
        if ("Vendedor".equals(rol) || "vendedor".equals(rol) || "VENDEDOR".equals(rol)) {
            return "Vendedor";
        }
        if ("Almacenero".equals(rol) || "almacenero".equals(rol) || "ALMACENERO".equals(rol)) {
            return "Almacenero";
        }
        return "Invalido";
    }
    
    public String registrarEmpleado(String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        if ("".equals(dni) || "".equals(nombres) || "".equals(apellidos) || "".equals(usuario) || "".equals(contrasena)) {
            return "Completa todos los campos.";
        }

        rol = normalizarRol(rol);
        if ("Invalido".equals(rol)) {
            return "Selecciona un rol válido.";
        }

        for (int i = 0; i < cont; i++) {
            if (empleados[i].getDni().equals(dni)) {
                return "Ya existe un empleado con ese DNI.";
            }

            if (empleados[i].getUsuario().equals(usuario)) {
                return "Ya existe un empleado con ese usuario.";
            }
        }

        if (cont == empleados.length) {
            return "El registro de empleados está lleno.";
        }

        empleados[cont] = new Empleado(usuario, contrasena, rol, dni, nombres, apellidos);
        cont++;
        return "Exitoso";
    }
    
    public String modificarEmpleado(int indice, String dni, String nombres, String apellidos, String usuario, String contrasena, String rol) {
        if (indice < 0 || indice >= cont) {
            return "Selecciona un empleado para modificar.";
        }

        if ("".equals(dni) || "".equals(nombres) || "".equals(apellidos) || "".equals(usuario) || "".equals(contrasena)) {
            return "Completa todos los campos.";
        }

        rol = normalizarRol(rol);
        if ("Invalido".equals(rol)) {
            return "Selecciona un rol válido.";
        }

        for (int i = 0; i < cont; i++) {
            if (i != indice && empleados[i].getDni().equals(dni)) {
                return "Ya existe un empleado con ese DNI.";
            }
            if (i != indice && empleados[i].getUsuario().equals(usuario)) {
                return "Ya existe un empleado con ese usuario.";
            }
        }

        empleados[indice] = new Empleado(usuario, contrasena, rol, dni, nombres, apellidos);
        return "Exitoso";
    }
    
    public String eliminarEmpleado(int indice) {
        if (indice < 0 || indice >= cont) {
            return "Selecciona un empleado para eliminar.";
        }

        for (int i = indice; i < cont - 1; i++) {
            empleados[i] = empleados[i + 1];
        }

        cont--;
        empleados[cont] = null;
        return "Exitoso";
    }
    
    public Empleado autenticar(String usuario, String contrasena) {
        for (int i = 0; i < cont; i++) {
            Empleado empleado = empleados[i];

            if (empleado.getUsuario().equals(usuario) && empleado.getContrasena().equals(contrasena)) {
                return empleado;
            }
        }

        return null;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
}
