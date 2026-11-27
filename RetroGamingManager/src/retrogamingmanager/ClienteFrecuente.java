/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;

/**
 *
 * @author emmanuel
 */
public class ClienteFrecuente extends Clientes {
    private static final String tipo = "Coleccionista Frecuente";
    public ClienteFrecuente(String DNI, String nombre, String apellidos, String telefono, String correo) {
        super(DNI, nombre, apellidos, telefono, correo, tipo);
    }
    
    @Override
    public double calcularDescuento() { 
        return 0.1; // Aca es % de descuento
    }
}
