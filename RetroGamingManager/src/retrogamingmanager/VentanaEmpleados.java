/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retrogamingmanager;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emmanuel
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
        txtDni.setBackground(new java.awt.Color(251, 237, 197));
        txtDni.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtDni.setForeground(new java.awt.Color(23, 20, 13));
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtNombres.setBackground(new java.awt.Color(251, 237, 197));
        txtNombres.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(23, 20, 13));
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtApellidos.setBackground(new java.awt.Color(251, 237, 197));
        txtApellidos.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(23, 20, 13));
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtUsuario.setBackground(new java.awt.Color(251, 237, 197));
        txtUsuario.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(23, 20, 13));
        lblClave = new javax.swing.JLabel();
        pwdClave = new javax.swing.JPasswordField();
        pwdClave.setBackground(new java.awt.Color(251, 237, 197));
        pwdClave.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        pwdClave.setForeground(new java.awt.Color(23, 20, 13));
        lblRol = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDni.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblDni.setForeground(new java.awt.Color(252, 245, 224));
        lblDni.setText("DNI:");
        getContentPane().add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 25));
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 200, 25));

        lblNombres.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(252, 245, 224));
        lblNombres.setText("Nombres:");
        getContentPane().add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, 100, 25));
        getContentPane().add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 55, 200, 25));

        lblApellidos.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(252, 245, 224));
        lblApellidos.setText("Apellidos:");
        getContentPane().add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 25));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 200, 25));

        lblUsuario.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(252, 245, 224));
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 100, 25));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 20, 200, 25));

        lblClave.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblClave.setForeground(new java.awt.Color(252, 245, 224));
        lblClave.setText("Contraseña:");
        getContentPane().add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 55, 100, 25));
        getContentPane().add(pwdClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 55, 200, 25));

        lblRol.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblRol.setForeground(new java.awt.Color(252, 245, 224));
        lblRol.setText("Rol:");
        getContentPane().add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 100, 25));

        cmbRol.setBackground(new java.awt.Color(251, 237, 197));
        cmbRol.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        cmbRol.setForeground(new java.awt.Color(23, 20, 13));
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor", "Almacenero" }));
        getContentPane().add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 90, 200, 25));

        btnRegistrar.setBackground(new java.awt.Color(253, 216, 24));
        btnRegistrar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(23, 20, 13));
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setOpaque(true);
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 110, 30));

        btnModificar.setBackground(new java.awt.Color(25, 24, 22));
        btnModificar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(252, 245, 224));
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setContentAreaFilled(false);
        btnModificar.setOpaque(true);
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 135, 110, 30));

        btnEliminar.setBackground(new java.awt.Color(25, 24, 22));
        btnEliminar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(252, 245, 224));
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setOpaque(true);
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 135, 110, 30));

        btnLimpiar.setBackground(new java.awt.Color(25, 24, 22));
        btnLimpiar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(252, 245, 224));
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 135, 110, 30));

        tblEmpleados.setBackground(new java.awt.Color(25, 24, 22));
        tblEmpleados.setFont(new java.awt.Font("Poppins Regular", 0, 12)); // NOI18N
        tblEmpleados.setForeground(new java.awt.Color(252, 245, 224));
        tblEmpleados.setFillsViewportHeight(true);
        tblEmpleados.setGridColor(new java.awt.Color(57, 49, 38));
        tblEmpleados.setRowHeight(24);
        tblEmpleados.setSelectionBackground(new java.awt.Color(253, 216, 24));
        tblEmpleados.setSelectionForeground(new java.awt.Color(23, 20, 13));
        EstiloTablasRetro.aplicarEncabezado(tblEmpleados);
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
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(jScrollPane1);
        jScrollPane1.setViewportView(tblEmpleados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 840, 300));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/empleados-clientes.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
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
    private javax.swing.JLabel lblFondo;
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
