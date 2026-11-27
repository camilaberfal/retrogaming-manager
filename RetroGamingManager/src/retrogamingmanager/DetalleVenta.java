// detalle provisional hasta integrar los precios del catálogo de la parte 2
package retrogamingmanager;

public class DetalleVenta {
    private String tipo;
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private String categoria = "Sin categoría";

    public DetalleVenta(String tipo, String nombre, double precioUnitario, int cantidad, String categoria) {
        this(tipo, nombre, precioUnitario, cantidad);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public DetalleVenta(String tipo, String nombre, double precioUnitario, int cantidad) {
        if (!"Juguete".equals(tipo) && !"Servicio".equals(tipo) && !"Paquete".equals(tipo)) {
            throw new IllegalArgumentException("El detalle debe ser un juguete, servicio o paquete.");
        }
        if (nombre.equals("") || !Double.isFinite(precioUnitario) || precioUnitario < 0 || cantidad < 1) {
            throw new IllegalArgumentException("Revisa el nombre, el precio y la cantidad del detalle.");
        }
        this.tipo = tipo;
        this.nombre = nombre;
        this.precioUnitario = FacturacionAutomatica.redondear(precioUnitario);
        this.cantidad = cantidad;
    }

    public static DetalleVenta crearJuguete(String nombre, double precioBase, int cantidad, int antiguedad, double recargoCategoria) {
        if (antiguedad < 0 || !Double.isFinite(recargoCategoria) || recargoCategoria < 0) {
            throw new IllegalArgumentException("Revisa la antigüedad y el recargo del juguete.");
        }
        double precio = precioBase;
        if (antiguedad > 30) {
            precio += precioBase * recargoCategoria;
        }
        return new DetalleVenta("Juguete", nombre, precio, cantidad);
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getImporte() {
        return FacturacionAutomatica.redondear(precioUnitario * cantidad);
    }
}
