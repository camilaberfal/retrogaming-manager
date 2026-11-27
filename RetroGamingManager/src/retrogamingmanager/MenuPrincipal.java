package retrogamingmanager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame implements ActionListener {

    private Empleados empleado;
    private GestionPersonal gestionPersonal;
    private GestionClientes gestionClientes;

    private JLabel lblBienvenida;
    private JLabel lblRol;
    private JPanel panelBotones;

    private JButton btnEmpleados;
    private JButton btnClientes;
    private JButton btnJuguetes;
    private JButton btnServicios;
    private JButton btnNuevaOrden;
    private JButton btnInventario;
    private JButton btnSeguimiento;
    private JButton btnPreparacion;
    private JButton btnReportes;
    private JButton btnCerrarSesion;

    public MenuPrincipal(Empleados empleado, GestionPersonal gestionPersonal, GestionClientes gestionClientes) {
        this.empleado = empleado;
        this.gestionPersonal = gestionPersonal;
        this.gestionClientes = gestionClientes;

        setTitle("Retro Gaming Manager - Menú principal");
        setSize(450, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblBienvenida = new JLabel("Bienvenido, " + empleado.getNombres() + " " + empleado.getApellidos());
        lblBienvenida.setBounds(20, 10, 400, 25);
        add(lblBienvenida);

        lblRol = new JLabel("Rol: " + empleado.getRol());
        lblRol.setBounds(20, 35, 400, 25);
        add(lblRol);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0, 2, 10, 10));
        panelBotones.setBounds(20, 70, 400, 280);
        add(panelBotones);

        btnEmpleados = crearBoton("Gestión de empleados");
        btnClientes = crearBoton("Gestión de clientes");
        btnJuguetes = crearBoton("Juguetes");
        btnServicios = crearBoton("Servicios y paquetes");
        btnNuevaOrden = crearBoton("Nueva orden");
        btnInventario = crearBoton("Consulta de inventario");
        btnSeguimiento = crearBoton("Seguimiento de órdenes");
        btnPreparacion = crearBoton("Preparación y entrega");
        btnReportes = crearBoton("Reportes");
        btnCerrarSesion = crearBoton("Cerrar sesión");

        // Cada rol ve solo sus botones
        String rol = empleado.getRol();
        if (!rol.equals("Administrador")) {
            panelBotones.remove(btnEmpleados);
            panelBotones.remove(btnReportes);
        }
        if (rol.equals("Almacenero")) {
            panelBotones.remove(btnClientes);
            panelBotones.remove(btnServicios);
            panelBotones.remove(btnNuevaOrden);
            panelBotones.remove(btnSeguimiento);
        }
        if (rol.equals("Vendedor")) {
            panelBotones.remove(btnPreparacion);
        }

        setLocationRelativeTo(null);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.addActionListener(this);
        panelBotones.add(boton);
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEmpleados) {
            VentanaEmpleados ventana = new VentanaEmpleados(gestionPersonal, empleado);
            ventana.setVisible(true);
        } else if (e.getSource() == btnClientes) {
            VentanaClientes ventana = new VentanaClientes(gestionClientes);
            ventana.setVisible(true);
        } else if (e.getSource() == btnCerrarSesion) {
            dispose();
            Login login = new Login(gestionPersonal, gestionClientes);
            login.setVisible(true);
        } else {
            // Botones de las partes 2 y 3
            JOptionPane.showMessageDialog(this, "Disponible en la integración");
        }
    }
}
