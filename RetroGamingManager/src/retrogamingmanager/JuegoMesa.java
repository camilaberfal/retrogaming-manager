/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;


public class JuegoMesa extends Juguete{
    
    public JuegoMesa(String codigo, String nombre, int anioFabricacion, double precioBase, int stock, String estado) {
        super(codigo, nombre, anioFabricacion, precioBase, stock, estado);
    }
    
    @Override
    public double calcularPrecioVenta() {
        if (calcularAntiguedad() > 30) {
            return precioBase + (precioBase * 0.10);
        } else {
            return precioBase;
        }
    }

    @Override
    public String getCategoria() {
        return "Juego de Mesa";
    }
    
    
}
