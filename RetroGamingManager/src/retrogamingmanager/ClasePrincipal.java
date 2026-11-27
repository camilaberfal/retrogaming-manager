package retrogamingmanager;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.swing.SwingUtilities;

/**
 *
 * @author grupo14
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        registrarFuentes();
        GestionClientes gestionClientes = new GestionClientes();
        GestionPersonal gestionPersonal = new GestionPersonal();
        GestionJuguetes gestionJuguetes = new GestionJuguetes();
        GestionServicios gestionServicios = new GestionServicios();
        GestionOrdenVenta gestionOrdenVenta = new GestionOrdenVenta();
        GestionEstadoOrden gestionEstadoOrden = new GestionEstadoOrden(gestionOrdenVenta);
        
        cargarDatosDePrueba(gestionPersonal, gestionClientes, gestionOrdenVenta, gestionEstadoOrden);
        SwingUtilities.invokeLater(() -> {
            new Login(gestionPersonal, gestionClientes, gestionEstadoOrden,
                    gestionJuguetes, gestionServicios).setVisible(true);
        });
    }

    private static void registrarFuentes() {
        GraphicsEnvironment entorno = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (String peso : new String[]{"Regular", "Medium", "SemiBold"}) {
            String recurso = "/fuentes/Poppins-" + peso + ".ttf";
            try (InputStream archivo = ClasePrincipal.class.getResourceAsStream(recurso)) {
                if (archivo != null) {
                    entorno.registerFont(Font.createFont(Font.TRUETYPE_FONT, archivo));
                }
            } catch (FontFormatException | IOException e) {
                System.err.println("No se pudo cargar " + recurso + ": " + e.getMessage());
            }
        }
    }

    private static void cargarDatosDePrueba(GestionPersonal gp, GestionClientes gc,
        GestionOrdenVenta ventas, GestionEstadoOrden estados) {
        Empleados vendedor = new Empleados("22222222", "Luis", "Ramos", "vendedor", "vende123", "Vendedor");
        Empleados almacenero = new Empleados("33333333", "Rosa", "Diaz", "almacen", "alma123", "Almacenero");
        mostrarSiHayError(gp.registrar(new Empleados("11111111", "Ana", "Torres", "admin", "admin123", "Administrador")));
        mostrarSiHayError(gp.registrar(vendedor));
        mostrarSiHayError(gp.registrar(almacenero));

        mostrarSiHayError(gc.registrar(new ClienteRegular("70000001", "Carlos", "Mendoza", "987654321", "carlos@mail.com")));
        mostrarSiHayError(gc.registrar(new ClienteRegular("70000002", "Lucia", "Paredes", "987654322", "lucia@mail.com")));
        mostrarSiHayError(gc.registrar(new ClienteRegular("70000003", "Jorge", "Salas", "987654323", "jorge@mail.com")));
        mostrarSiHayError(gc.registrar(new ClienteFrecuente("70000004", "Marta", "Rojas", "987654324", "marta@mail.com")));

        // Jorge queda con 4 compras: con una más pasa a Coleccionista Frecuente
        for (int i = 0; i < 4; i++) {
            gc.registrarCompraFinalizada("70000003");
        }

        cargarOrdenesDePrueba(ventas, estados, vendedor, almacenero);
    }

    private static void cargarOrdenesDePrueba(GestionOrdenVenta ventas, GestionEstadoOrden estados, Empleados vendedor, Empleados almacenero) {
        Calendar entrega = Calendar.getInstance();
        entrega.add(Calendar.HOUR_OF_DAY, 12);
        Fecha fechaCercana = new Fecha(entrega.get(Calendar.YEAR), entrega.get(Calendar.MONTH) + 1,
                entrega.get(Calendar.DAY_OF_MONTH));
        Hora hora = new Hora(entrega.get(Calendar.HOUR_OF_DAY), entrega.get(Calendar.MINUTE));

        entrega.add(Calendar.DAY_OF_MONTH, 2);
        Fecha fechaLejana = new Fecha(entrega.get(Calendar.YEAR), entrega.get(Calendar.MONTH) + 1,
                entrega.get(Calendar.DAY_OF_MONTH));

        ventas.crearOrden(120, fechaLejana, hora);
        ventas.crearOrden(180, fechaLejana, hora);
        ventas.crearOrden(240, fechaLejana, hora);
        ventas.crearOrden(320, fechaLejana, hora);
        ventas.crearOrden(150, fechaCercana, hora);
    }

    private static void mostrarSiHayError(String error) {
        if (error != null) {
            System.out.println("Error en datos de prueba: " + error);
        }
    }
}
