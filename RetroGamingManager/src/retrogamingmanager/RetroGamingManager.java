/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package retrogamingmanager;

/**
 *
 * @author ASUS
 */
public class RetroGamingManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        gestionEmpleados.registrarEmpleado(
                "12345678", "Ana", "Torres", "admin", "demo123", "Vendedor");

        java.awt.EventQueue.invokeLater(() -> {
            VentanaLogin ventana = new VentanaLogin(gestionEmpleados);
            ventana.setVisible(true);
        });
    }
    
}
