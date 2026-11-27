package retrogamingmanager;

import javax.swing.JOptionPane;

/**
 *
 * @author camila
 */
public class VentanaFacturacion extends javax.swing.JFrame {
    private FacturacionAutomatica facturacion;
    private CuentaVenta cuenta;

    public VentanaFacturacion(FacturacionAutomatica facturacion, CuentaVenta cuenta) {
        this.facturacion = facturacion;
        this.cuenta = cuenta;
        initComponents();

        listaCuenta.setListData(cuenta.obtenerResumenParaPantalla().split("\\R", -1));
        actualizarCamposFactura();
        getRootPane().setDefaultButton(btnEmitir);
        setLocationRelativeTo(null);
    }

    private void actualizarCamposFactura() {
        boolean factura = btnFactura.isSelected();
        lblRuc.setVisible(factura);
        txtRuc.setVisible(factura);
        lblRazonSocial.setVisible(factura);
        txtRazonSocial.setVisible(factura);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoComprobante = new javax.swing.ButtonGroup();
        pnlContenido = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scrCuenta = new javax.swing.JScrollPane();
        listaCuenta = new javax.swing.JList<>();
        listaCuenta.setBackground(new java.awt.Color(25, 24, 22));
        listaCuenta.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        listaCuenta.setForeground(new java.awt.Color(252, 245, 224));
        listaCuenta.setSelectionBackground(new java.awt.Color(253, 216, 24));
        listaCuenta.setSelectionForeground(new java.awt.Color(23, 20, 13));
        btnBoleta = new javax.swing.JRadioButton();
        btnFactura = new javax.swing.JRadioButton();
        lblRuc = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtRuc.setBackground(new java.awt.Color(251, 237, 197));
        txtRuc.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtRuc.setForeground(new java.awt.Color(23, 20, 13));
        lblRazonSocial = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        txtRazonSocial.setBackground(new java.awt.Color(251, 237, 197));
        txtRazonSocial.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtRazonSocial.setForeground(new java.awt.Color(23, 20, 13));
        btnEmitir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setTitle("Facturación");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContenido.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Poppins SemiBold", 0, 23)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(252, 245, 224));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Facturación automática");

        scrCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(scrCuenta);
        scrCuenta.setViewportView(listaCuenta);

        grupoComprobante.add(btnBoleta);
        btnBoleta.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnBoleta.setForeground(new java.awt.Color(252, 245, 224));
        btnBoleta.setOpaque(false);
        btnBoleta.setSelected(true);
        btnBoleta.setText("Boleta");
        btnBoleta.addActionListener(this::actualizarTipoActionPerformed);

        grupoComprobante.add(btnFactura);
        btnFactura.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnFactura.setForeground(new java.awt.Color(252, 245, 224));
        btnFactura.setOpaque(false);
        btnFactura.setText("Factura");
        btnFactura.addActionListener(this::actualizarTipoActionPerformed);

        lblRuc.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblRuc.setForeground(new java.awt.Color(252, 245, 224));
        lblRuc.setLabelFor(txtRuc);
        lblRuc.setText("RUC");

        lblRazonSocial.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblRazonSocial.setForeground(new java.awt.Color(252, 245, 224));
        lblRazonSocial.setLabelFor(txtRazonSocial);
        lblRazonSocial.setText("Razón social");

        btnEmitir.setBackground(new java.awt.Color(253, 216, 24));
        btnEmitir.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnEmitir.setForeground(new java.awt.Color(23, 20, 13));
        btnEmitir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmitir.setContentAreaFilled(false);
        btnEmitir.setOpaque(true);
        btnEmitir.setText("Confirmar pago y emitir");
        btnEmitir.addActionListener(this::emitirActionPerformed);

        btnCerrar.setBackground(new java.awt.Color(46, 38, 12));
        btnCerrar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(253, 216, 24));
        btnCerrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setOpaque(true);
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::cerrarActionPerformed);

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrCuenta, 380, 540, Short.MAX_VALUE)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(btnBoleta)
                        .addGap(18, 18, 18)
                        .addComponent(btnFactura)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRuc)
                            .addComponent(lblRazonSocial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRuc, 150, 220, Short.MAX_VALUE)
                            .addComponent(txtRazonSocial, 150, 220, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmitir))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrCuenta, 180, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBoleta)
                    .addComponent(btnFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuc)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocial)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEmitir))
                .addGap(20, 20, 20))
        );

        getContentPane().add(pnlContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 467));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/facturacion.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTipoActionPerformed
        actualizarCamposFactura();
    }//GEN-LAST:event_actualizarTipoActionPerformed

    private void emitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emitirActionPerformed
        if (facturacion.tieneComprobante(cuenta.numeroOrden)) {
            JOptionPane.showMessageDialog(this, "La orden ya tiene un comprobante.");
            return;
        }
        String mensaje;
        String tipo;
        String datosFactura = "";

        if (btnFactura.isSelected()) {
            String ruc = txtRuc.getText();
            String razonSocial = txtRazonSocial.getText();
            mensaje = facturacion.generarFacturaDePago(cuenta, ruc, razonSocial);
            if (ruc.equals("") || razonSocial.equals("")) {
                JOptionPane.showMessageDialog(this, mensaje);
                return;
            }
            tipo = "Factura";
            datosFactura = "\nRUC: " + ruc + "\nRazón social: " + razonSocial;
        } else {
            mensaje = facturacion.generarBoletaDePago(cuenta);
            tipo = "Boleta";
        }

        String comprobante = tipo + datosFactura + "\n" + mensaje + "\n\n" + cuenta.obtenerResumenParaPantalla();
        listaCuenta.setListData(comprobante.split("\\R", -1));
        btnEmitir.setVisible(false);
        btnBoleta.setVisible(false);
        btnFactura.setVisible(false);
        lblRuc.setVisible(false);
        txtRuc.setVisible(false);
        lblRazonSocial.setVisible(false);
        txtRazonSocial.setVisible(false);
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_emitirActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnBoleta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JRadioButton btnFactura;
    private javax.swing.ButtonGroup grupoComprobante;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listaCuenta;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JScrollPane scrCuenta;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
