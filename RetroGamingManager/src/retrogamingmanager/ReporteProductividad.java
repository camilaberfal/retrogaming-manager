package retrogamingmanager;

import java.util.Arrays;

/**
 *
 * @author camila
 */
public class ReporteProductividad extends ReporteGerencial {
    private GestionPersonal personal;
    private GestionEstadoOrden ordenes;

    public ReporteProductividad(GestionPersonal personal, GestionEstadoOrden ordenes) {
        super("Productividad del personal");
        this.personal = personal;
        this.ordenes = ordenes;
    }

    @Override
    public Object[][] generarFilas() {
        Object[][] filas = new Object[personal.getContador()][];
        int cantidadFilas = 0;
        for (int i = 0; i < personal.getContador(); i++) {
            Empleados empleado = personal.obtener(i);
            if ("Vendedor".equals(empleado.getRol()) || "Almacenero".equals(empleado.getRol())) {
                int ordenesRegistradas = 0;
                int paquetesVerificados = 0;
                for (int j = 0; j < ordenes.getContador(); j++) {
                    OrdenVenta orden = ordenes.obtener(j);
                    if (empleado.getDNI().equals(orden.getDniVendedor())) {
                        ordenesRegistradas++;
                    }
                    if (empleado.getDNI().equals(orden.getDniAlmacenero())) {
                        paquetesVerificados++;
                    }
                }
                String nombre = empleado.getNombres() + " " + empleado.getApellidos();
                filas[cantidadFilas] = new Object[]{nombre, empleado.getRol(), ordenesRegistradas, paquetesVerificados};
                cantidadFilas++;
            }
        }
        return Arrays.copyOf(filas, cantidadFilas);
    }
}
