/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retrogamingmanager;

import javax.swing.JOptionPane;

/**
 *
 * @author grupo 13
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final Empleados empleado;
    private final GestionPersonal gestionPersonal;
    private final GestionClientes gestionClientes;

    public MenuPrincipal(Empleados empleado, GestionPersonal gestionPersonal, GestionClientes gestionClientes) {
        this.empleado = empleado;
        this.gestionPersonal = gestionPersonal;
        this.gestionClientes = gestionClientes;
        initComponents();

        lblBienvenida.setText("Bienvenido, " + empleado.getNombres() + " " + empleado.getApellidos());
        lblRol.setText("Rol: " + empleado.getRol());

        // Cada rol ve solo sus botones
        String rol = empleado.getRol();
        if (!rol.equals("Administrador")) {
            btnEmpleados.setVisible(false);
            btnReportes.setVisible(false);
        }
        if (rol.equals("Almacenero")) {
            btnClientes.setVisible(false);
            btnServicios.setVisible(false);
            btnNuevaOrden.setVisible(false);
            btnSeguimiento.setVisible(false);
        }
        if (rol.equals("Vendedor")) {
            btnPreparacion.setVisible(false);
        }

        setLocationRelativeTo(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        btnEmpleados = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnJuguetes = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnNuevaOrden = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnSeguimiento = new javax.swing.JButton();
        btnPreparacion = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblBienvenida.setText("Bienvenido");
        getContentPane().add(lblBienvenida);
        lblBienvenida.setBounds(20, 15, 420, 25);

        lblRol.setText("Rol");
        getContentPane().add(lblRol);
        lblRol.setBounds(20, 40, 420, 25);

        btnEmpleados.setText("Gestión de empleados");
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmpleados);
        btnEmpleados.setBounds(20, 80, 200, 40);

        btnClientes.setText("Gestión de clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes);
        btnClientes.setBounds(240, 80, 200, 40);

        btnJuguetes.setText("Juguetes");
        btnJuguetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnJuguetes);
        btnJuguetes.setBounds(20, 130, 200, 40);

        btnServicios.setText("Servicios y paquetes");
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnServicios);
        btnServicios.setBounds(240, 130, 200, 40);

        btnNuevaOrden.setText("Nueva orden");
        btnNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevaOrden);
        btnNuevaOrden.setBounds(20, 180, 200, 40);

        btnInventario.setText("Consulta de inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnInventario);
        btnInventario.setBounds(240, 180, 200, 40);

        btnSeguimiento.setText("Seguimiento de órdenes");
        btnSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeguimiento);
        btnSeguimiento.setBounds(20, 230, 200, 40);

        btnPreparacion.setText("Preparación y entrega");
        btnPreparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnPreparacion);
        btnPreparacion.setBounds(240, 230, 200, 40);

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportes);
        btnReportes.setBounds(20, 280, 200, 40);

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.setBounds(240, 280, 200, 40);

        setSize(new java.awt.Dimension(470, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        VentanaEmpleados ventana = new VentanaEmpleados(gestionPersonal, empleado);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        VentanaClientes ventana = new VentanaClientes(gestionClientes);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendienteActionPerformed
        // Botones de las partes 2 y 3 (se conectan en la integración)
        JOptionPane.showMessageDialog(this, "Disponible en la integración");
    }//GEN-LAST:event_btnPendienteActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
        Login login = new Login(gestionPersonal, gestionClientes);
        login.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnJuguetes;
    private javax.swing.JButton btnNuevaOrden;
    private javax.swing.JButton btnPreparacion;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSeguimiento;
    private javax.swing.JButton btnServicios;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}
