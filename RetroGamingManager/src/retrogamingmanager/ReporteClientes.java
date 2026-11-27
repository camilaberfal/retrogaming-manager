package retrogamingmanager;

import java.util.Arrays;

/**
 *
 * @author camila
 */
public class ReporteClientes extends ReporteGerencial {
    private GestionClientes clientes;
    private GestionEstadoOrden ordenes;

    public ReporteClientes(GestionClientes clientes, GestionEstadoOrden ordenes) {
        super("Clientes con más compras");
        this.clientes = clientes;
        this.ordenes = ordenes;
    }

    @Override
    public Object[][] generarFilas() {
        Object[][] filas = new Object[clientes.getContador()][];
        for (int i = 0; i < filas.length; i++) {
            Clientes cliente = clientes.obtener(i);
            int compras = cliente.getComprasFinalizadas();
            for (int j = 0; j < ordenes.getContador(); j++) {
                OrdenVenta orden = ordenes.obtener(j);
                if ("Finalizada".equals(orden.getEstado()) && cliente.getDNI().equals(orden.getDniCliente())) {
                    compras++;
                }
            }
            String nombre = cliente.getNombres() + " " + cliente.getApellidos();
            filas[i] = new Object[]{cliente.getDNI(), nombre, compras};
        }
        Arrays.sort(filas, (primera, segunda) -> Integer.compare((int) segunda[2], (int) primera[2]));
        return filas;
    }
}
