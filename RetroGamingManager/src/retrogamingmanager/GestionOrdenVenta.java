// registro provisional hasta integrar la creación de órdenes de la parte 2
package retrogamingmanager;

public class GestionOrdenVenta {
    static final int CAPACIDAD = 100;

    private final OrdenVenta[] ordenes = new OrdenVenta[CAPACIDAD];
    private int cont;

    public String crearOrden(double total, Fecha fechaEntrega, Hora horaEntrega) {
        return crearOrden(total, fechaEntrega, horaEntrega, "", "", new DetalleVenta[0]);
    }

    public String crearOrden(double total, Fecha fechaEntrega, Hora horaEntrega, String dniVendedor, String dniCliente, DetalleVenta[] detalles) {
        if (cont == ordenes.length) {
            return "El registro de órdenes está lleno.";
        }
        if (!Double.isFinite(total) || total <= 0) {
            return "El total debe ser mayor que cero.";
        }

        int numero = cont + 1;
        ordenes[cont] = new OrdenVenta(numero, total, fechaEntrega, horaEntrega);
        ordenes[cont].registrarDatosDeVenta(dniVendedor, dniCliente, detalles);
        cont++;
        return "Se creó la orden N.º " + numero + ".";
    }

    public int buscar(int numero) {
        for (int i = 0; i < cont; i++) {
            if (ordenes[i].getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    public int getContador() {
        return cont;
    }

    public OrdenVenta obtener(int indice) {
        return ordenes[indice];
    }
}
