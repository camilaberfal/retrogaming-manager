/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retrogamingmanager;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo 13
 */
public class VentanaEmpleados extends javax.swing.JFrame {

    private final GestionPersonal gestion;
    private final Empleados empleadoActual;
    private DefaultTableModel modelo;

    public VentanaEmpleados(GestionPersonal gestion, Empleados empleadoActual) {
        this.gestion = gestion;
        this.empleadoActual = empleadoActual;
        initComponents();
        modelo = (DefaultTableModel) tblEmpleados.getModel();
        actualizarTabla();
        setLocationRelativeTo(null);
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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        pwdClave = new javax.swing.JPasswordField();
        lblRol = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblDni.setText("DNI:");
        getContentPane().add(lblDni);
        lblDni.setBounds(20, 20, 100, 25);

        getContentPane().add(txtDni);
        txtDni.setBounds(130, 20, 200, 25);

        lblNombres.setText("Nombres:");
        getContentPane().add(lblNombres);
        lblNombres.setBounds(20, 55, 100, 25);

        getContentPane().add(txtNombres);
        txtNombres.setBounds(130, 55, 200, 25);

        lblApellidos.setText("Apellidos:");
        getContentPane().add(lblApellidos);
        lblApellidos.setBounds(20, 90, 100, 25);

        getContentPane().add(txtApellidos);
        txtApellidos.setBounds(130, 90, 200, 25);

        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(400, 20, 100, 25);

        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(480, 20, 200, 25);

        lblClave.setText("Contraseña:");
        getContentPane().add(lblClave);
        lblClave.setBounds(400, 55, 100, 25);

        getContentPane().add(pwdClave);
        pwdClave.setBounds(480, 55, 200, 25);

        lblRol.setText("Rol:");
        getContentPane().add(lblRol);
        lblRol.setBounds(400, 90, 100, 25);

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor", "Almacenero" }));
        getContentPane().add(cmbRol);
        cmbRol.setBounds(480, 90, 200, 25);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(20, 135, 110, 30);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(140, 135, 110, 30);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(260, 135, 110, 30);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(380, 135, 110, 30);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Usuario", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 185, 840, 300);

        setSize(new java.awt.Dimension(900, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String rol = cmbRol.getSelectedItem().toString();
        Empleados nuevo = new Empleados(txtDni.getText().trim(), txtNombres.getText().trim(),
                txtApellidos.getText().trim(), txtUsuario.getText().trim(),
                new String(pwdClave.getPassword()), rol);
        String error = gestion.registrar(nuevo);
        if (error != null) {
            JOptionPane.showMessageDialog(this, error);
            return;
        }
        JOptionPane.showMessageDialog(this, "Empleado registrado");
        actualizarTabla();
        limpiar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String rol = cmbRol.getSelectedItem().toString();
        String error = gestion.modificar(txtDni.getText().trim(), txtNombres.getText().trim(),
                txtApellidos.getText().trim(), txtUsuario.getText().trim(),
                new String(pwdClave.getPassword()), rol);
        if (error != null) {
            JOptionPane.showMessageDialog(this, error);
            return;
        }
        JOptionPane.showMessageDialog(this, "Empleado modificado");
        actualizarTabla();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String dni = txtDni.getText().trim();
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
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
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
    }//GEN-LAST:event_tblEmpleadosMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwdClave;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
