package retrogamingmanager;

import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camila
 */
public class VentanaGestionEstadoOrden extends javax.swing.JFrame {
    private final GestionEstadoOrden gestion;
    private final Empleados empleado;

    public VentanaGestionEstadoOrden(GestionEstadoOrden gestion, Empleados empleado) {
        this.gestion = gestion;
        this.empleado = empleado;
        initComponents();

        actualizarAcciones();
        mostrarOrdenes();
        setLocationRelativeTo(null);
    }

    private void actualizarAcciones() {
        boolean vendedor = "Vendedor".equals(empleado.getRol());
        boolean almacenero = "Almacenero".equals(empleado.getRol());

        btnAdelanto.setVisible(vendedor);
        btnCancelacion.setVisible(vendedor);
        btnVerificar.setVisible(almacenero);
        btnFinalizacion.setVisible(almacenero);
        btnHistorial.setVisible(true);
        btnEjecutar.setEnabled(true);
    }

    private void mostrarOrdenes() {
        scrEstadoOrden.setViewportView(tblOrdenes);
        DefaultTableModel modelo = (DefaultTableModel) tblOrdenes.getModel();
        modelo.setNumRows(0);

        for (int i = 0; i < gestion.getContador(); i++) {
            OrdenVenta orden = gestion.obtener(i);
            Object[] fila = {
                orden.getNumero(),
                orden.getEstado(),
                orden.getEstadoJuguetes(),
                orden.getFechaEntrega(),
                orden.getHoraEntrega(),
                String.format("%.2f", orden.getTotal()),
                String.format("%.2f", orden.getAdelanto()),
                orden.getResultadoAdelanto()
            };
            modelo.addRow(fila);
        }
    }

    private void mostrarHistorial(int numero) {
        scrEstadoOrden.setViewportView(tblHistorial);
        DefaultTableModel modelo = (DefaultTableModel) tblHistorial.getModel();
        modelo.setNumRows(0);

        modelo.addRow(new Object[] {numero, "Pendiente", "", ""});
        Cambio[] cambios = gestion.verHistorial(numero);
        for (int i = 0; i < cambios.length; i++) {
            Object[] fila = {
                numero,
                cambios[i].getEstado(),
                cambios[i].getEmpleado(),
                cambios[i].getAccion()
            };
            modelo.addRow(fila);
        }
    }

    private void ejecutar() {
        int numero = Integer.parseInt(txtNumeroCorrelativo.getText());

        int indice = gestion.buscar(numero);
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "No se encontró la orden.");
            return;
        }

        if (btnHistorial.isSelected()) {
            mostrarHistorial(numero);
            return;
        }
        if (btnCancelacion.isSelected()) {
            cancelar(gestion.obtener(indice));
            return;
        }

        String mensaje;
        if (btnAdelanto.isSelected()) {
            mensaje = gestion.confirmarAdelanto(numero, empleado);
        } else if (btnVerificar.isSelected()) {
            mensaje = gestion.verificarProducto(numero, empleado);
        } else if (btnFinalizacion.isSelected()) {
            finalizarYFacturar(gestion.obtener(indice));
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una acción.");
            return;
        }

        mostrarOrdenes();
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void finalizarYFacturar(OrdenVenta orden) {
        if (!"Almacenero".equals(empleado.getRol())) {
            return;
        }
        if (!"Finalizada".equals(orden.getEstado())) {
            String mensaje = gestion.registrarFinalizacion(orden.getNumero(), empleado);
            if (!"Finalizada".equals(orden.getEstado())) {
                JOptionPane.showMessageDialog(this, mensaje);
                return;
            }
        }

        mostrarOrdenes();
        FacturacionAutomatica facturacion = gestion.getFacturacion();
        if (facturacion.tieneComprobante(orden.getNumero())) {
            JOptionPane.showMessageDialog(this, "La orden ya tiene un comprobante.");
            return;
        }
        CuentaVenta cuenta = facturacion.calcularCuentaDePrueba(orden);
        new VentanaFacturacion(facturacion, cuenta).setVisible(true);
    }

    private void cancelar(OrdenVenta orden) {
        if (orden.getEstado().equals("Cancelada") || orden.getEstado().equals("Finalizada")) {
            JOptionPane.showMessageDialog(this, "La orden ya está cerrada.");
            return;
        }

        Calendar ahora = Calendar.getInstance();
        Fecha fecha = new Fecha(ahora.get(Calendar.YEAR), ahora.get(Calendar.MONTH) + 1,
                ahora.get(Calendar.DAY_OF_MONTH));
        Hora hora = new Hora(ahora.get(Calendar.HOUR_OF_DAY), ahora.get(Calendar.MINUTE));
        String mensaje = gestion.registrarCancelacion(orden.getNumero(), empleado, fecha, hora);
        mostrarOrdenes();
        JOptionPane.showMessageDialog(this, mensaje, "Cancelación", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tblHistorial = new javax.swing.JTable();
        pnlOrdenes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlTabla = new javax.swing.JPanel();
        scrEstadoOrden = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();
        pnlFormulario = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JRadioButton();
        btnFinalizacion = new javax.swing.JRadioButton();
        btnHistorial = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEjecutar = new javax.swing.JButton();
        txtNumeroCorrelativo = new javax.swing.JTextField();
        btnAdelanto = new javax.swing.JRadioButton();
        btnCancelacion = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"N.º", "Estado", "Empleado", "Acción"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tblHistorial.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión del estado de la orden");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión del estado de la orden");

        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N.º", "Estado", "Estado de juguetes", "Fecha de entrega", "Hora", "Total (S/)", "Adelanto (S/)", "Situación del adelanto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdenes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrEstadoOrden.setViewportView(tblOrdenes);
        if (tblOrdenes.getColumnModel().getColumnCount() > 0) {
            tblOrdenes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblOrdenes.getColumnModel().getColumn(1).setPreferredWidth(105);
            tblOrdenes.getColumnModel().getColumn(2).setPreferredWidth(115);
            tblOrdenes.getColumnModel().getColumn(3).setPreferredWidth(105);
            tblOrdenes.getColumnModel().getColumn(4).setPreferredWidth(55);
            tblOrdenes.getColumnModel().getColumn(5).setPreferredWidth(80);
            tblOrdenes.getColumnModel().getColumn(6).setPreferredWidth(95);
            tblOrdenes.getColumnModel().getColumn(7).setPreferredWidth(360);
        }

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(scrEstadoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrEstadoOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("¿Qué realizarás?");

        buttonGroup1.add(btnVerificar);
        btnVerificar.setText("Verificar el producto");
        btnVerificar.addActionListener(this::btnVerificarActionPerformed);

        buttonGroup1.add(btnFinalizacion);
        btnFinalizacion.setText("Registrar finalización");
        btnFinalizacion.addActionListener(this::btnFinalizacionActionPerformed);

        buttonGroup1.add(btnHistorial);
        btnHistorial.setText("Ver historial de cambios");
        btnHistorial.setToolTipText("");

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(this::btnEjecutarActionPerformed);

        buttonGroup1.add(btnAdelanto);
        btnAdelanto.setText("Confirmar adelanto");
        btnAdelanto.setToolTipText("");
        btnAdelanto.addActionListener(this::btnAdelantoActionPerformed);

        buttonGroup1.add(btnCancelacion);
        btnCancelacion.setText("Registrar cancelación");
        btnCancelacion.setToolTipText("");
        btnCancelacion.addActionListener(this::btnCancelacionActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Número correlativo");

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(2, 2, 2))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(btnAdelanto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEjecutar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(txtNumeroCorrelativo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdelanto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelacion)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEjecutar)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        btnVolver.setText("<-- Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout pnlOrdenesLayout = new javax.swing.GroupLayout(pnlOrdenes);
        pnlOrdenes.setLayout(pnlOrdenesLayout);
        pnlOrdenesLayout.setHorizontalGroup(
            pnlOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrdenesLayout.createSequentialGroup()
                .addGroup(pnlOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlOrdenesLayout.createSequentialGroup()
                        .addGroup(pnlOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOrdenesLayout.createSequentialGroup()
                                .addGap(0, 29, Short.MAX_VALUE)
                                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(pnlOrdenesLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnVolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        pnlOrdenesLayout.setVerticalGroup(
            pnlOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrdenesLayout.createSequentialGroup()
                        .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlOrdenesLayout.createSequentialGroup()
                        .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        mostrarOrdenes();
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnFinalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizacionActionPerformed
        mostrarOrdenes();
    }//GEN-LAST:event_btnFinalizacionActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        ejecutar();
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnAdelantoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelantoActionPerformed
        mostrarOrdenes();
    }//GEN-LAST:event_btnAdelantoActionPerformed

    private void btnCancelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelacionActionPerformed
        mostrarOrdenes();
    }//GEN-LAST:event_btnCancelacionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAdelanto;
    private javax.swing.JRadioButton btnCancelacion;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JRadioButton btnFinalizacion;
    private javax.swing.JRadioButton btnHistorial;
    private javax.swing.JRadioButton btnVerificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlOrdenes;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JScrollPane scrEstadoOrden;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTable tblOrdenes;
    private javax.swing.JTextField txtNumeroCorrelativo;
    // End of variables declaration//GEN-END:variables
}
