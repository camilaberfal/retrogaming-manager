package retrogamingmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleados extends JFrame implements ActionListener {

    private GestionPersonal gestion;
    private Empleados empleadoActual;

    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtUsuario;
    private JPasswordField pwdClave;
    private JComboBox<String> cmbRol;

    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    private JTable tblEmpleados;
    private DefaultTableModel modelo;

    public VentanaEmpleados(GestionPersonal gestion, Empleados empleadoActual) {
        this.gestion = gestion;
        this.empleadoActual = empleadoActual;

        setTitle("Gestión de empleados");
        setSize(900, 550);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Campos
        agregarEtiqueta("DNI:", 20, 20);
        txtDni = new JTextField();
        txtDni.setBounds(130, 20, 200, 25);
        add(txtDni);

        agregarEtiqueta("Nombres:", 20, 55);
        txtNombres = new JTextField();
        txtNombres.setBounds(130, 55, 200, 25);
        add(txtNombres);

        agregarEtiqueta("Apellidos:", 20, 90);
        txtApellidos = new JTextField();
        txtApellidos.setBounds(130, 90, 200, 25);
        add(txtApellidos);

        agregarEtiqueta("Usuario:", 400, 20);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(480, 20, 200, 25);
        add(txtUsuario);

        agregarEtiqueta("Contraseña:", 400, 55);
        pwdClave = new JPasswordField();
        pwdClave.setBounds(480, 55, 200, 25);
        add(pwdClave);

        agregarEtiqueta("Rol:", 400, 90);
        String[] roles = {"Administrador", "Vendedor", "Almacenero"};
        cmbRol = new JComboBox<>(roles);
        cmbRol.setBounds(480, 90, 200, 25);
        add(cmbRol);

        // Botones
        btnRegistrar = crearBoton("Registrar", 20, 135);
        btnModificar = crearBoton("Modificar", 140, 135);
        btnEliminar = crearBoton("Eliminar", 260, 135);
        btnLimpiar = crearBoton("Limpiar", 380, 135);

        // Tabla
        String[] columnas = {"DNI", "Nombres", "Apellidos", "Usuario", "Rol"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblEmpleados = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tblEmpleados);
        scroll.setBounds(20, 185, 840, 300);
        add(scroll);

        tblEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarFilaSeleccionada();
            }
        });

        actualizarTabla();
        setLocationRelativeTo(null);
    }

    private void agregarEtiqueta(String texto, int x, int y) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, 100, 25);
        add(etiqueta);
    }

    private JButton crearBoton(String texto, int x, int y) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, 110, 30);
        boton.addActionListener(this);
        add(boton);
        return boton;
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (int i = 0; i < gestion.getContador(); i++) {
            Empleados emp = gestion.obtener(i);
            Object[] fila = {emp.getDNI(), emp.getNombres(), emp.getApellidos(), emp.getUsuario(), emp.getRol()};
            modelo.addRow(fila);
        }
    }

    private void limpiar() {
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtUsuario.setText("");
        pwdClave.setText("");
        cmbRol.setSelectedIndex(0);
        txtDni.setEnabled(true);
        tblEmpleados.clearSelection();
    }

    private void cargarFilaSeleccionada() {
        int fila = tblEmpleados.getSelectedRow();
        if (fila == -1) {
            return;
        }
        String dni = modelo.getValueAt(fila, 0).toString();
        Empleados emp = gestion.buscarPorDni(dni);
        if (emp != null) {
            txtDni.setText(emp.getDNI());
            txtNombres.setText(emp.getNombres());
            txtApellidos.setText(emp.getApellidos());
            txtUsuario.setText(emp.getUsuario());
            pwdClave.setText(emp.getPassword());
            cmbRol.setSelectedItem(emp.getRol());
            txtDni.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dni = txtDni.getText().trim();
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String clave = new String(pwdClave.getPassword());
        String rol = cmbRol.getSelectedItem().toString();

        if (e.getSource() == btnRegistrar) {
            Empleados nuevo = new Empleados(dni, nombres, apellidos, usuario, clave, rol);
            String error = gestion.registrar(nuevo);
            if (error != null) {
                JOptionPane.showMessageDialog(this, error);
                return;
            }
            JOptionPane.showMessageDialog(this, "Empleado registrado");
            actualizarTabla();
            limpiar();

        } else if (e.getSource() == btnModificar) {
            String error = gestion.modificar(dni, nombres, apellidos, usuario, clave, rol);
            if (error != null) {
                JOptionPane.showMessageDialog(this, error);
                return;
            }
            JOptionPane.showMessageDialog(this, "Empleado modificado");
            actualizarTabla();
            limpiar();

        } else if (e.getSource() == btnEliminar) {
            if (dni.equals("")) {
                JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla");
                return;
            }
            if (dni.equals(empleadoActual.getDNI())) {
                JOptionPane.showMessageDialog(this, "No puede eliminarse a sí mismo");
                return;
            }
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar al empleado " + dni + "?");
            if (respuesta == JOptionPane.YES_OPTION) {
                gestion.eliminar(dni);
                actualizarTabla();
                limpiar();
            }

        } else if (e.getSource() == btnLimpiar) {
            limpiar();
        }
    }
}
