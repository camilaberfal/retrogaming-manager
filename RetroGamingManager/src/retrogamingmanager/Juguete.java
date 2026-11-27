/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;


public abstract class Juguete {
    
    protected String codigo;
    protected String nombre;
    protected int anioFabricacion;
    protected double precioBase;
    protected int stock;
    protected String estado;

    public Juguete(String codigo, String nombre, int anioFabricacion, double precioBase, int stock, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioFabricacion = anioFabricacion;
        this.precioBase = precioBase;
        this.stock = stock;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int calcularAntiguedad(){
        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return anioActual - anioFabricacion;
    }
    
    public abstract double calcularPrecioVenta();
    
    public abstract String getCategoria();
    
}
