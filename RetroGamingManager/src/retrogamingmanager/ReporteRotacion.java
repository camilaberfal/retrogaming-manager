package retrogamingmanager;

/**
 *
 * @author camila
 */
public class ReporteRotacion extends ReporteGerencial {
    private GestionEstadoOrden ordenes;
    private Fecha desde;
    private Fecha hasta;

    public ReporteRotacion(GestionEstadoOrden ordenes, Fecha desde, Fecha hasta) {
        super("Rotación por categoría");
        this.ordenes = ordenes;
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public Object[][] generarFilas() {
        String[] categorias = {"Figura de Acción", "Consola Retro", "Juego de Mesa", "Sin categoría"};
        int[] unidades = new int[categorias.length];
        int totalVendido = 0;
        for (int i = 0; i < ordenes.getContador(); i++) {
            OrdenVenta orden = ordenes.obtener(i);
            if (!"Finalizada".equals(orden.getEstado()) || !estaEnPeriodo(orden.getFechaFinalizacion(), desde, hasta)) {
                continue;
            }

            DetalleVenta[] detalles = orden.getDetalles();
            for (int j = 0; j < detalles.length; j++) {
                DetalleVenta detalle = detalles[j];
                if (!"Juguete".equals(detalle.getTipo())) {
                    continue;
                }
                int categoria = 0;
                while (categoria < categorias.length - 1 && !categorias[categoria].equals(detalle.getCategoria())) {
                    categoria++;
                }
                unidades[categoria] += detalle.getCantidad();
                totalVendido += detalle.getCantidad();
            }
        }

        int cantidadFilas = categorias.length;
        if (unidades[categorias.length - 1] == 0) {
            cantidadFilas--;
        }
        Object[][] filas = new Object[cantidadFilas][];
        for (int i = 0; i < filas.length; i++) {
            double porcentaje = 0;
            if (totalVendido > 0) {
                porcentaje = FacturacionAutomatica.redondear(100.0 * unidades[i] / totalVendido);
            }
            filas[i] = new Object[]{categorias[i], unidades[i], porcentaje};
        }
        return filas;
    }
}
