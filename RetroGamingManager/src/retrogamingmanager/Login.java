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
public class Login extends javax.swing.JFrame {

    private final GestionPersonal gestionPersonal;
    private final GestionClientes gestionClientes;

    public Login(GestionPersonal gestionPersonal, GestionClientes gestionClientes) {
        this.gestionPersonal = gestionPersonal;
        this.gestionClientes = gestionClientes;
        initComponents();
        getRootPane().setDefaultButton(btnIngresar);
        setLocationRelativeTo(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        pwdClave = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblUsuario.setText("Usuario");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(30, 30, 100, 25);

        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(130, 30, 170, 25);

        lblClave.setText("Contraseña");
        getContentPane().add(lblClave);
        lblClave.setBounds(30, 75, 100, 25);

        getContentPane().add(pwdClave);
        pwdClave.setBounds(130, 75, 170, 25);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(110, 125, 120, 30);

        setSize(new java.awt.Dimension(350, 230));
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

        MenuPrincipal menu = new MenuPrincipal(empleado, gestionPersonal, gestionClientes);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnIngresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwdClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
