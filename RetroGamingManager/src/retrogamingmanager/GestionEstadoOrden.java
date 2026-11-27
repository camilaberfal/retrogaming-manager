package retrogamingmanager;

/**
 *
 * @author camila
 */
public class GestionEstadoOrden {
    private final GestionOrdenVenta gestionOrdenVenta;
    private FacturacionAutomatica facturacion = new FacturacionAutomatica();

    public FacturacionAutomatica getFacturacion() {
        return facturacion;
    }
    private final Cambio[][] historial = new Cambio[GestionOrdenVenta.CAPACIDAD][4];

    public GestionEstadoOrden(GestionOrdenVenta gestionOrdenVenta) {
        this.gestionOrdenVenta = gestionOrdenVenta;
    }

    public int buscar(int numero) {
        return gestionOrdenVenta.buscar(numero);
    }

    public int getContador() {
        return gestionOrdenVenta.getContador();
    }

    public OrdenVenta obtener(int indice) {
        return gestionOrdenVenta.obtener(indice);
    }

    public String confirmarAdelanto(int numero, Empleados empleado) {
        int indice = buscar(numero);
        if (indice == -1) {
            return "No se encontró la orden.";
        }

        OrdenVenta orden = obtener(indice);
        if (!orden.getEstado().equals("Pendiente")) {
            return "Solo se puede confirmar una orden pendiente.";
        }

        orden.confirmarAdelanto();
        guardarCambio(indice, empleado, "Confirmar adelanto");
        return "Se registró el adelanto del 50%.";
    }

    public String verificarProducto(int numero, Empleados empleado) {
        int indice = buscar(numero);
        if (indice == -1) {
            return "No se encontró la orden.";
        }

        OrdenVenta orden = obtener(indice);
        if (!orden.getEstado().equals("Confirmada")) {
            return "Solo se puede verificar una orden confirmada.";
        }

        orden.preparar(empleado.getDNI());
        guardarCambio(indice, empleado, "Verificar producto");
        return "La orden pasó a En Preparación.";
    }

    public String registrarFinalizacion(int numero, Empleados empleado) {
        int indice = buscar(numero);
        if (indice == -1) {
            return "No se encontró la orden.";
        }

        OrdenVenta orden = obtener(indice);
        if (!orden.getEstado().equals("En Preparación")) {
            return "Solo se puede finalizar una orden en preparación.";
        }

        orden.finalizar();
        guardarCambio(indice, empleado, "Registrar finalización");
        return "La orden pasó a Finalizada.";
    }

    public String registrarCancelacion(int numero, Empleados empleado, Fecha fecha, Hora hora) {
        int indice = buscar(numero);
        if (indice == -1) {
            return "No se encontró la orden.";
        }

        OrdenVenta orden = obtener(indice);
        String estado = orden.getEstado();
        if (estado.equals("Cancelada") || estado.equals("Finalizada")) {
            return "La orden ya está cerrada.";
        }

        String resultado = "No hay adelanto registrado.";
        if (orden.getAdelanto() > 0) {
            if (orden.minutosHastaEntrega(fecha, hora) >= 1440) {
                resultado = "Corresponde devolver el adelanto.";
            } else {
                resultado = "El adelanto queda retenido por gastos administrativos.";
            }
        }

        orden.cancelar(resultado);
        guardarCambio(indice, empleado, "Registrar cancelación");
        return "La orden pasó a Cancelada. " + resultado;
    }

    private void guardarCambio(int indice, Empleados empleado, String accion) {
        String nombre = empleado.getNombres() + " " + empleado.getApellidos();
        for (int i = 0; i < historial[indice].length; i++) {
            if (historial[indice][i] == null) {
                historial[indice][i] = new Cambio(nombre, accion, obtener(indice).getEstado());
                return;
            }
        }
    }

    public Cambio[] verHistorial(int numero) {
        int indice = buscar(numero);
        if (indice == -1) {
            return new Cambio[0];
        }

        int cantidad = 0;
        while (cantidad < historial[indice].length && historial[indice][cantidad] != null) {
            cantidad++;
        }
        Cambio[] cambios = new Cambio[cantidad];
        for (int i = 0; i < cambios.length; i++) {
            cambios[i] = historial[indice][i];
        }
        return cambios;
    }
}
