/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;


public class ConsolaRetro extends Juguete{
    
    public ConsolaRetro(String codigo, String nombre, int anioFabricacion, double precioBase, int stock, String estado) {
        super(codigo, nombre, anioFabricacion, precioBase, stock, estado);
    }
    
    @Override
    public double calcularPrecioVenta() {
        if (calcularAntiguedad() > 30) {
            return precioBase + (precioBase * 0.15);
        } else {
            return precioBase;
        }
    }

    @Override
    public String getCategoria() {
        return "Consola Retro";
    }
    
}
