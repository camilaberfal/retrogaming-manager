package retrogamingmanager;

/**
 *
 * @author camila
 */
public class Comprobante {
    private int numero;
    private String tipo;
    private String ruc;
    private String razonSocial;
    private CuentaVenta cuenta;
    private Fecha fechaEmision;

    Comprobante(int numero, String tipo, String ruc, String razonSocial, CuentaVenta cuenta) {
        this.numero = numero;
        this.tipo = tipo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.cuenta = cuenta;
        fechaEmision = Fecha.hoy();
    }

    public Fecha getFechaEmision() {
        return fechaEmision;
    }

    public boolean esDePrueba() {
        return cuenta.esDePrueba();
    }

    public int getNumero() {
        return numero;
    }

    public int getNumeroOrden() {
        return cuenta.numeroOrden;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRuc() {
        return ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public DetalleVenta[] getDetalles() {
        return cuenta.getDetalles();
    }

    public double getDescuento() {
        return cuenta.descuento;
    }

    public double getEnvio() {
        return cuenta.envio;
    }

    public double getSubtotal() {
        return cuenta.subtotal;
    }

    public double getIgv() {
        return cuenta.igv;
    }

    public double getTotal() {
        return cuenta.getTotal();
    }

    public double getAdelanto() {
        return cuenta.adelanto;
    }

    public double getSaldo() {
        return cuenta.getSaldo();
    }
}
