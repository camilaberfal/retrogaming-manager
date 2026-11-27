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
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

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

        lblTelefono.setText("Teléfono:");
        getContentPane().add(lblTelefono);
        lblTelefono.setBounds(400, 20, 100, 25);

        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(480, 20, 200, 25);

        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo);
        lblCorreo.setBounds(400, 55, 100, 25);

        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(480, 55, 200, 25);

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

        btnCompra.setText("Registrar compra finalizada");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCompra);
        btnCompra.setBounds(500, 135, 220, 30);

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
        jScrollPane1.setViewportView(tblClientes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 185, 840, 300);

        setSize(new java.awt.Dimension(900, 550));
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
