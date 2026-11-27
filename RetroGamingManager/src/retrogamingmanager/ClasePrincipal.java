/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package retrogamingmanager;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class ClasePrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionClientes gestionClientes = new GestionClientes();
        GestionPersonal gestionPersonal = new GestionPersonal();
        
        cargarDatosDePrueba(gestionPersonal, gestionClientes);
        SwingUtilities.invokeLater(() -> {
            new Login(gestionPersonal, gestionClientes).setVisible(true);
        });
    }
    private static void cargarDatosDePrueba(GestionPersonal gp, GestionClientes gc) {
        mostrarSiHayError(gp.registrar(new Empleados("11111111", "Ana", "Torres", "admin", "admin123", "Administrador")));
        mostrarSiHayError(gp.registrar(new Empleados("22222222", "Luis", "Ramos", "vendedor", "vende123", "Vendedor")));
        mostrarSiHayError(gp.registrar(new Empleados("33333333", "Rosa", "Diaz", "almacen", "alma123", "Almacenero")));

        mostrarSiHayError(gc.registrar(new ClienteRegular("70000001", "Carlos", "Mendoza", "987654321", "carlos@mail.com")));
        mostrarSiHayError(gc.registrar(new ClienteRegular("70000002", "Lucia", "Paredes", "987654322", "lucia@mail.com")));
        mostrarSiHayError(gc.registrar(new ClienteRegular("70000003", "Jorge", "Salas", "987654323", "jorge@mail.com")));
        mostrarSiHayError(gc.registrar(new ClienteFrecuente("70000004", "Marta", "Rojas", "987654324", "marta@mail.com")));

        // Jorge queda con 4 compras: con una más pasa a Coleccionista Frecuente
        for (int i = 0; i < 4; i++) {
            gc.registrarCompraFinalizada("70000003");
        }
    }

    private static void mostrarSiHayError(String error) {
        if (error != null) {
            System.out.println("Error en datos de prueba: " + error);
        }
    }
}
