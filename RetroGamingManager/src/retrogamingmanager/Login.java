/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retrogamingmanager;

import javax.swing.JOptionPane;

/**
 *
 * @author emmanuel
 */
public class Login extends javax.swing.JFrame {

    private final GestionPersonal gestionPersonal;
    private final GestionClientes gestionClientes;
    private final GestionEstadoOrden gestionEstadoOrden;
    private final GestionJuguetes gestionJuguetes;
    private final GestionServicios gestionServicios;

    public Login(GestionPersonal gestionPersonal, GestionClientes gestionClientes,
            GestionEstadoOrden gestionEstadoOrden, GestionJuguetes gestionJuguetes,
            GestionServicios gestionServicios) {
        this.gestionPersonal = gestionPersonal;
        this.gestionClientes = gestionClientes;
        this.gestionEstadoOrden = gestionEstadoOrden;
        this.gestionJuguetes = gestionJuguetes;
        this.gestionServicios = gestionServicios;
        initComponents();
        getRootPane().setDefaultButton(btnIngresar);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        pwdClave = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(349, 434));
        setMinimumSize(new java.awt.Dimension(349, 434));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(252, 245, 224));
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 25));

        txtUsuario.setBackground(new java.awt.Color(251, 237, 197));
        txtUsuario.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 150, 25));

        lblClave.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblClave.setForeground(new java.awt.Color(252, 245, 224));
        lblClave.setText("Contraseña:");
        getContentPane().add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 110, 25));

        pwdClave.setBackground(new java.awt.Color(251, 237, 197));
        pwdClave.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        getContentPane().add(pwdClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 150, 25));

        btnIngresar.setBackground(new java.awt.Color(253, 216, 24));
        btnIngresar.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(7, 2, 3));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-login-crt.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String usuario = txtUsuario.getText().trim();
        String clave = new String(pwdClave.getPassword());

        if (usuario.equals("") || clave.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña");
            return;
        }

        Empleados empleado = gestionPersonal.validarLogin(usuario, clave);
        if (empleado == null) {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            pwdClave.setText("");
            return;
        }

        MenuPrincipal menu = new MenuPrincipal(empleado, gestionPersonal, gestionClientes,
                gestionEstadoOrden, gestionJuguetes, gestionServicios);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnIngresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwdClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
