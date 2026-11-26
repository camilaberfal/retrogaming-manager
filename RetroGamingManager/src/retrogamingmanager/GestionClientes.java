package retrogamingmanager;

public class GestionClientes extends GestionPersonas {
    public GestionClientes() {
        super(new Cliente[50], "cliente");
    }

    public Cliente obtenerCliente(int indice) {
        return (Cliente) personas[indice];
    }

    public String registrarCliente(String dni, String nombres, String apellidos, String telefono, String correo) {
        if (faltanCampos(dni, nombres, apellidos, telefono, correo)) {
            return "Completa todos los campos.";
        }

        if (buscar(dni) != -1) {
            return "Ya existe un cliente con ese DNI.";
        }

        if (estaLleno()) {
            return "El registro de clientes está lleno.";
        }

        agregar(new Cliente(dni, nombres, apellidos, telefono, correo));
        return "Exitoso";
    }

    public String modificarCliente(int indice, String dni, String nombres, String apellidos, String telefono, String correo) {
        if (!indiceValido(indice)) {
            return "Selecciona un cliente para modificar.";
        }

        if (faltanCampos(dni, nombres, apellidos, telefono, correo)) {
            return "Completa todos los campos.";
        }

        if (buscar(dni, indice) != -1) {
            return "Ya existe un cliente con ese DNI.";
        }

        obtenerCliente(indice).actualizarDatos(dni, nombres, apellidos, telefono, correo);
        return "Exitoso";
    }

    private boolean faltanCampos(String dni, String nombres, String apellidos, String telefono, String correo) {
        return estaVacio(dni) || estaVacio(nombres) || estaVacio(apellidos)
                || estaVacio(telefono) || estaVacio(correo);
    }

    private boolean estaVacio(String valor) {
        return valor == null || "".equals(valor);
    }
}
