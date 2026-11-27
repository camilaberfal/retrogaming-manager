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
public class VentanaClientes extends javax.swing.JFrame {

    private final GestionClientes gestion;
    private DefaultTableModel modelo;

    public VentanaClientes(GestionClientes gestion) {
        this.gestion = gestion;
        initComponents();
        modelo = (DefaultTableModel) tblClientes.getModel();
        actualizarTabla();
        setLocationRelativeTo(null);
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
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtTelefono.setBackground(new java.awt.Color(251, 237, 197));
        txtTelefono.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(23, 20, 13));
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtCorreo.setBackground(new java.awt.Color(251, 237, 197));
        txtCorreo.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(23, 20, 13));
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
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

        lblTelefono.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(252, 245, 224));
        lblTelefono.setText("Teléfono:");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 100, 25));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 200, 25));

        lblCorreo.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(252, 245, 224));
        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 55, 100, 25));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 55, 200, 25));

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

        btnCompra.setBackground(new java.awt.Color(25, 24, 22));
        btnCompra.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(252, 245, 224));
        btnCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompra.setContentAreaFilled(false);
        btnCompra.setOpaque(true);
        btnCompra.setText("Registrar compra finalizada");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 135, 220, 30));

        tblClientes.setBackground(new java.awt.Color(25, 24, 22));
        tblClientes.setFont(new java.awt.Font("Poppins Regular", 0, 12)); // NOI18N
        tblClientes.setForeground(new java.awt.Color(252, 245, 224));
        tblClientes.setFillsViewportHeight(true);
        tblClientes.setGridColor(new java.awt.Color(57, 49, 38));
        tblClientes.setRowHeight(24);
        tblClientes.setSelectionBackground(new java.awt.Color(253, 216, 24));
        tblClientes.setSelectionForeground(new java.awt.Color(23, 20, 13));
        EstiloTablasRetro.aplicarEncabezado(tblClientes);
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Teléfono", "Correo", "Tipo", "Compras", "Desc."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(jScrollPane1);
        jScrollPane1.setViewportView(tblClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 840, 300));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/empleados-clientes.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Clientes nuevo = new ClienteRegular(txtDni.getText().trim(), txtNombres.getText().trim(),
                txtApellidos.getText().trim(), txtTelefono.getText().trim(), txtCorreo.getText().trim());
        String error = gestion.registrar(nuevo);
        if (error != null) {
            JOptionPane.showMessageDialog(this, error);
            return;
        }
        JOptionPane.showMessageDialog(this, "Cliente registrado");
        actualizarTabla();
        limpiar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String error = gestion.modificar(txtDni.getText().trim(), txtNombres.getText().trim(),
                txtApellidos.getText().trim(), txtTelefono.getText().trim(), txtCorreo.getText().trim());
        if (error != null) {
            JOptionPane.showMessageDialog(this, error);
            return;
        }
        JOptionPane.showMessageDialog(this, "Cliente modificado");
        actualizarTabla();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String dni = txtDni.getText().trim();
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
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        String dni = txtDni.getText().trim();
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
    }//GEN-LAST:event_btnCompraActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
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
    }//GEN-LAST:event_tblClientesMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
