/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retrogamingmanager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author emmanuel
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final Empleados empleado;
    private final GestionPersonal gestionPersonal;
    private final GestionClientes gestionClientes;
    private final GestionEstadoOrden gestionEstadoOrden;
    private final GestionJuguetes gestionJuguetes;
    private final GestionServicios gestionServicios;

    public MenuPrincipal(Empleados empleado, GestionPersonal gestionPersonal, GestionClientes gestionClientes,
            GestionEstadoOrden gestionEstadoOrden, GestionJuguetes gestionJuguetes,
            GestionServicios gestionServicios) {
        this.empleado = empleado;
        this.gestionPersonal = gestionPersonal;
        this.gestionClientes = gestionClientes;
        this.gestionEstadoOrden = gestionEstadoOrden;
        this.gestionJuguetes = gestionJuguetes;
        this.gestionServicios = gestionServicios;
        initComponents();

        lblBienvenida.setText("Bienvenido, " + empleado.getNombres() + " " + empleado.getApellidos());
        lblRol.setText("Rol: " + empleado.getRol());

        // Cada rol ve solo sus botones
        String rol = empleado.getRol();
        btnSeguimiento.setVisible(rol.equals("Vendedor"));
        btnPreparacion.setVisible(rol.equals("Almacenero"));
        if (!rol.equals("Administrador")) {
            btnEmpleados.setVisible(false);
            btnReportes.setVisible(false);
            btnJuguetes.setVisible(false);
            btnServicios.setVisible(false);
        }
        if (rol.equals("Almacenero")) {
            btnClientes.setVisible(false);
            btnNuevaOrden.setVisible(false);
        }

        btnSeguimiento.addActionListener(evt -> abrirGestionEstadoOrden());
        btnPreparacion.addActionListener(evt -> abrirGestionEstadoOrden());
        setLocationRelativeTo(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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
        setSize(new java.awt.Dimension(470, 420));

        lblBienvenida.setText("Bienvenido");

        lblRol.setText("Rol");

        jPanel1.setPreferredSize(new java.awt.Dimension(420, 250));

        btnEmpleados.setText("Gestión de empleados");
        btnEmpleados.setPreferredSize(new java.awt.Dimension(200, 40));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleados);

        btnClientes.setText("Gestión de clientes");
        btnClientes.setPreferredSize(new java.awt.Dimension(200, 40));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes);

        btnJuguetes.setText("Juguetes");
        btnJuguetes.setPreferredSize(new java.awt.Dimension(200, 40));
        btnJuguetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuguetesActionPerformed(evt);
            }
        });
        jPanel1.add(btnJuguetes);

        btnServicios.setText("Servicios adicionales");
        btnServicios.setPreferredSize(new java.awt.Dimension(200, 40));
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicios);

        btnNuevaOrden.setText("Nueva orden");
        btnNuevaOrden.setPreferredSize(new java.awt.Dimension(200, 40));
        btnNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaOrden);

        btnInventario.setText("Consulta de inventario");
        btnInventario.setPreferredSize(new java.awt.Dimension(200, 40));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInventario);

        btnSeguimiento.setText("Seguimiento de órdenes");
        btnSeguimiento.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(btnSeguimiento);

        btnPreparacion.setText("Preparación y entrega");
        btnPreparacion.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(btnPreparacion);

        btnReportes.setText("Reportes");
        btnReportes.setPreferredSize(new java.awt.Dimension(200, 40));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes);

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(200, 40));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        VentanaEmpleados ventana = new VentanaEmpleados(gestionPersonal, empleado);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        VentanaClientes ventana = new VentanaClientes(gestionClientes);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnJuguetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuguetesActionPerformed
        abrirVentana(new VentanaJuguetes(gestionJuguetes));
    }//GEN-LAST:event_btnJuguetesActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        abrirVentana(new VentanaServicios(gestionServicios));
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        abrirVentana(new VentanaListaJuguetes(gestionJuguetes));
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendienteActionPerformed
        JOptionPane.showMessageDialog(this, "Disponible en la integración");
    }//GEN-LAST:event_btnPendienteActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        if ("Administrador".equals(empleado.getRol())) {
            GestionReportesGerenciales gestion = new GestionReportesGerenciales(gestionEstadoOrden, gestionPersonal, gestionClientes);
            new VentanaReportes(gestion).setVisible(true);
        }
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
        Login login = new Login(gestionPersonal, gestionClientes, gestionEstadoOrden,
                gestionJuguetes, gestionServicios);
        login.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void abrirGestionEstadoOrden() {
        abrirVentana(new VentanaGestionEstadoOrden(gestionEstadoOrden, empleado));
    }

    private void abrirVentana(JFrame ventana) {
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evento) {
                setVisible(true);
            }
        });
        setVisible(false);
        ventana.setVisible(true);
    }



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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}
