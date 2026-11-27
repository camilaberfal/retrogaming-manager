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
        lblTitulo = new javax.swing.JLabel();
        scrCuenta = new javax.swing.JScrollPane();
        listaCuenta = new javax.swing.JList<>();
        btnBoleta = new javax.swing.JRadioButton();
        btnFactura = new javax.swing.JRadioButton();
        lblRuc = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        lblRazonSocial = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        btnEmitir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setTitle("Facturación");

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Facturación automática");

        scrCuenta.setViewportView(listaCuenta);

        grupoComprobante.add(btnBoleta);
        btnBoleta.setSelected(true);
        btnBoleta.setText("Boleta");
        btnBoleta.addActionListener(this::actualizarTipoActionPerformed);

        grupoComprobante.add(btnFactura);
        btnFactura.setText("Factura");
        btnFactura.addActionListener(this::actualizarTipoActionPerformed);

        lblRuc.setLabelFor(txtRuc);
        lblRuc.setText("RUC");

        lblRazonSocial.setLabelFor(txtRazonSocial);
        lblRazonSocial.setText("Razón social");

        btnEmitir.setText("Confirmar pago y emitir");
        btnEmitir.addActionListener(this::emitirActionPerformed);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::cerrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrCuenta, 380, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBoleta)
                        .addGap(18, 18, 18)
                        .addComponent(btnFactura)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRuc)
                            .addComponent(lblRazonSocial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRuc, 150, 220, Short.MAX_VALUE)
                            .addComponent(txtRazonSocial, 150, 220, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmitir))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrCuenta, 180, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBoleta)
                    .addComponent(btnFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuc)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocial)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEmitir))
                .addGap(20, 20, 20))
        );

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
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listaCuenta;
    private javax.swing.JScrollPane scrCuenta;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
