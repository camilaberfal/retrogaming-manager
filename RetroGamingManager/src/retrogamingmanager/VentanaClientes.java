package retrogamingmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaClientes extends JFrame implements ActionListener {

    private GestionClientes gestion;

    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtTelefono;
    private JTextField txtCorreo;

    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnCompra;

    private JTable tblClientes;
    private DefaultTableModel modelo;

    public VentanaClientes(GestionClientes gestion) {
        this.gestion = gestion;

        setTitle("Gestión de clientes");
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

        agregarEtiqueta("Teléfono:", 400, 20);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(480, 20, 200, 25);
        add(txtTelefono);

        agregarEtiqueta("Correo:", 400, 55);
        txtCorreo = new JTextField();
        txtCorreo.setBounds(480, 55, 200, 25);
        add(txtCorreo);

        // Botones
        btnRegistrar = crearBoton("Registrar", 20, 135, 110);
        btnModificar = crearBoton("Modificar", 140, 135, 110);
        btnEliminar = crearBoton("Eliminar", 260, 135, 110);
        btnLimpiar = crearBoton("Limpiar", 380, 135, 110);
        btnCompra = crearBoton("Registrar compra finalizada", 500, 135, 220);

        // Tabla
        String[] columnas = {"DNI", "Nombres", "Apellidos", "Teléfono", "Correo", "Tipo", "Compras", "Desc."};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tblClientes = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tblClientes);
        scroll.setBounds(20, 185, 840, 300);
        add(scroll);

        tblClientes.addMouseListener(new MouseAdapter() {
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

    private JButton crearBoton(String texto, int x, int y, int ancho) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, 30);
        boton.addActionListener(this);
        add(boton);
        return boton;
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (int i = 0; i < gestion.getContador(); i++) {
            Clientes c = gestion.obtener(i);
            int descuento = (int) (c.calcularDescuento() * 100);
            Object[] fila = {c.getDNI(), c.getNombres(), c.getApellidos(), c.getTelefono(),
                c.getCorreo(), c.getTipo(), c.getComprasFinalizadas(), descuento + "%"};
            modelo.addRow(fila);
        }
    }

    private void limpiar() {
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDni.setEnabled(true);
        tblClientes.clearSelection();
    }

    private void cargarFilaSeleccionada() {
        int fila = tblClientes.getSelectedRow();
        if (fila == -1) {
            return;
        }
        String dni = modelo.getValueAt(fila, 0).toString();
        Clientes c = gestion.buscarPorDni(dni);
        if (c != null) {
            txtDni.setText(c.getDNI());
            txtNombres.setText(c.getNombres());
            txtApellidos.setText(c.getApellidos());
            txtTelefono.setText(c.getTelefono());
            txtCorreo.setText(c.getCorreo());
            txtDni.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dni = txtDni.getText().trim();
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (e.getSource() == btnRegistrar) {
            Clientes nuevo = new ClienteRegular(dni, nombres, apellidos, telefono, correo);
            String error = gestion.registrar(nuevo);
            if (error != null) {
                JOptionPane.showMessageDialog(this, error);
                return;
            }
            JOptionPane.showMessageDialog(this, "Cliente registrado");
            actualizarTabla();
            limpiar();

        } else if (e.getSource() == btnModificar) {
            String error = gestion.modificar(dni, nombres, apellidos, telefono, correo);
            if (error != null) {
                JOptionPane.showMessageDialog(this, error);
                return;
            }
            JOptionPane.showMessageDialog(this, "Cliente modificado");
            actualizarTabla();
            limpiar();

        } else if (e.getSource() == btnEliminar) {
            if (dni.equals("")) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla");
                return;
            }
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar al cliente " + dni + "?");
            if (respuesta == JOptionPane.YES_OPTION) {
                gestion.eliminar(dni);
                actualizarTabla();
                limpiar();
            }

        } else if (e.getSource() == btnLimpiar) {
            limpiar();

        } else if (e.getSource() == btnCompra) {
            if (dni.equals("")) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla");
                return;
            }
            String tipoAntes = gestion.buscarPorDni(dni).getTipo();
            gestion.registrarCompraFinalizada(dni);
            String tipoDespues = gestion.buscarPorDni(dni).getTipo();
            actualizarTabla();
            if (!tipoAntes.equals(tipoDespues)) {
                JOptionPane.showMessageDialog(this, "El cliente ahora es " + tipoDespues);
            }
            limpiar();
        }
    }
}
