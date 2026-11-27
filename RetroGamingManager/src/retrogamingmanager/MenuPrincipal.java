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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú principal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBienvenida.setFont(new java.awt.Font("Poppins SemiBold", 0, 21)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(252, 245, 224));
        lblBienvenida.setText("Bienvenido");
        getContentPane().add(lblBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 20, 405, 32));

        lblRol.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblRol.setForeground(new java.awt.Color(253, 216, 24));
        lblRol.setText("Rol");
        getContentPane().add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 54, 405, 22));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));

        btnEmpleados.setBackground(new java.awt.Color(25, 24, 22));
        btnEmpleados.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(252, 245, 224));
        btnEmpleados.setText("Gestión de empleados");
        btnEmpleados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.setOpaque(true);
        btnEmpleados.setPreferredSize(new java.awt.Dimension(196, 38));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEmpleados);

        btnClientes.setBackground(new java.awt.Color(25, 24, 22));
        btnClientes.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(252, 245, 224));
        btnClientes.setText("Gestión de clientes");
        btnClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClientes.setContentAreaFilled(false);
        btnClientes.setOpaque(true);
        btnClientes.setPreferredSize(new java.awt.Dimension(196, 38));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes);

        btnJuguetes.setBackground(new java.awt.Color(25, 24, 22));
        btnJuguetes.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnJuguetes.setForeground(new java.awt.Color(252, 245, 224));
        btnJuguetes.setText("Juguetes");
        btnJuguetes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnJuguetes.setContentAreaFilled(false);
        btnJuguetes.setOpaque(true);
        btnJuguetes.setPreferredSize(new java.awt.Dimension(196, 38));
        btnJuguetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuguetesActionPerformed(evt);
            }
        });
        jPanel1.add(btnJuguetes);

        btnServicios.setBackground(new java.awt.Color(25, 24, 22));
        btnServicios.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnServicios.setForeground(new java.awt.Color(252, 245, 224));
        btnServicios.setText("Servicios adicionales");
        btnServicios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnServicios.setContentAreaFilled(false);
        btnServicios.setOpaque(true);
        btnServicios.setPreferredSize(new java.awt.Dimension(196, 38));
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });
        jPanel1.add(btnServicios);

        btnNuevaOrden.setBackground(new java.awt.Color(25, 24, 22));
        btnNuevaOrden.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnNuevaOrden.setForeground(new java.awt.Color(252, 245, 224));
        btnNuevaOrden.setText("Nueva orden");
        btnNuevaOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevaOrden.setContentAreaFilled(false);
        btnNuevaOrden.setOpaque(true);
        btnNuevaOrden.setPreferredSize(new java.awt.Dimension(196, 38));
        btnNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaOrden);

        btnInventario.setBackground(new java.awt.Color(25, 24, 22));
        btnInventario.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(252, 245, 224));
        btnInventario.setText("Consulta de inventario");
        btnInventario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInventario.setContentAreaFilled(false);
        btnInventario.setOpaque(true);
        btnInventario.setPreferredSize(new java.awt.Dimension(196, 38));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnInventario);

        btnSeguimiento.setBackground(new java.awt.Color(25, 24, 22));
        btnSeguimiento.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnSeguimiento.setForeground(new java.awt.Color(252, 245, 224));
        btnSeguimiento.setText("Seguimiento de órdenes");
        btnSeguimiento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeguimiento.setContentAreaFilled(false);
        btnSeguimiento.setOpaque(true);
        btnSeguimiento.setPreferredSize(new java.awt.Dimension(196, 38));
        jPanel1.add(btnSeguimiento);

        btnPreparacion.setBackground(new java.awt.Color(25, 24, 22));
        btnPreparacion.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnPreparacion.setForeground(new java.awt.Color(252, 245, 224));
        btnPreparacion.setText("Preparación y entrega");
        btnPreparacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPreparacion.setContentAreaFilled(false);
        btnPreparacion.setOpaque(true);
        btnPreparacion.setPreferredSize(new java.awt.Dimension(196, 38));
        jPanel1.add(btnPreparacion);

        btnReportes.setBackground(new java.awt.Color(25, 24, 22));
        btnReportes.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(252, 245, 224));
        btnReportes.setText("Reportes");
        btnReportes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReportes.setContentAreaFilled(false);
        btnReportes.setOpaque(true);
        btnReportes.setPreferredSize(new java.awt.Dimension(196, 38));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes);

        btnCerrarSesion.setBackground(new java.awt.Color(46, 38, 12));
        btnCerrarSesion.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(253, 216, 24));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setOpaque(true);
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(196, 38));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 416, 238));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bg-pequeno.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}
