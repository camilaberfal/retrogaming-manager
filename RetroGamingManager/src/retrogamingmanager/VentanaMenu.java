package retrogamingmanager;

/**
 *
 * @author camila
 */
public class VentanaMenu extends javax.swing.JFrame {
    private GestionEmpleados gestionEmpleados;
    private VentanaEmpleados ventanaEmpleados;

    public VentanaMenu(GestionEmpleados gestionEmpleados, Empleado empleado) {
        initComponents();
        this.gestionEmpleados = gestionEmpleados;

        String rol = empleado.getRol();
        lblBienvenida.setText("¡Bienvenido/a, " + empleado.getNombres() + "!");
        lblRol.setText("Rol: " + rol);

        boolean administrador = "Administrador".equals(rol);
        boolean vendedor = "Vendedor".equals(rol);
        boolean almacenero = "Almacenero".equals(rol);

        btnEmpleados.setVisible(administrador);
        btnCatalogo.setVisible(administrador);
        btnServiciosPaquetes.setVisible(administrador);
        btnReportes.setVisible(administrador);

        btnClientes.setVisible(vendedor);
        btnNuevaOrden.setVisible(vendedor);
        btnSeguimientoOrdenes.setVisible(vendedor);

        btnPreparacionEntrega.setVisible(almacenero);
        jButton9.setVisible(almacenero);

        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        pnlAcciones = new javax.swing.JPanel();
        btnEmpleados = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();
        btnServiciosPaquetes = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnNuevaOrden = new javax.swing.JButton();
        btnSeguimientoOrdenes = new javax.swing.JButton();
        btnPreparacionEntrega = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        lblPregunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("¡Bienvenido/a, ...!");
        lblBienvenida.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblRol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("Rol:...");
        lblRol.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnEmpleados.setText("Gestionar empleados");
        btnEmpleados.addActionListener(this::btnEmpleadosActionPerformed);
        pnlAcciones.add(btnEmpleados);

        btnCatalogo.setText("Catálogo");
        pnlAcciones.add(btnCatalogo);

        btnServiciosPaquetes.setText("Servicios y paquetes");
        pnlAcciones.add(btnServiciosPaquetes);

        btnReportes.setText("Reportes");
        pnlAcciones.add(btnReportes);

        btnClientes.setText("Gestionar clientes");
        btnClientes.addActionListener(this::btnClientesActionPerformed);
        pnlAcciones.add(btnClientes);

        btnNuevaOrden.setText("Nueva orden");
        pnlAcciones.add(btnNuevaOrden);

        btnSeguimientoOrdenes.setText("Seguimiento de órdenes");
        pnlAcciones.add(btnSeguimientoOrdenes);

        btnPreparacionEntrega.setText("Preparación y entrega");
        pnlAcciones.add(btnPreparacionEntrega);

        jButton9.setText("Consultar stock");
        pnlAcciones.add(jButton9);

        lblPregunta.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("¿En qué trabajarás hoy?");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(lblBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol)
                .addGap(54, 54, 54)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        if (ventanaEmpleados == null) {
            ventanaEmpleados = new VentanaEmpleados(gestionEmpleados);
        }
        ventanaEmpleados.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientesActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnNuevaOrden;
    private javax.swing.JButton btnPreparacionEntrega;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSeguimientoOrdenes;
    private javax.swing.JButton btnServiciosPaquetes;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblRol;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
