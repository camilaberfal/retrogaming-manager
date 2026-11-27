package retrogamingmanager;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camila
 */
public class VentanaReportes extends javax.swing.JFrame {
    private GestionReportesGerenciales gestion;

    public VentanaReportes(GestionReportesGerenciales gestion) {
        this.gestion = gestion;
        initComponents();

        String hoy = Fecha.hoy().toString();
        txtDesde.setText(hoy);
        txtHasta.setText(hoy);
        mostrarReportes();
        setLocationRelativeTo(null);
    }

    private void mostrarReportes() {
        Fecha desde;
        Fecha hasta;
            desde = leerFecha(txtDesde.getText());
            hasta = leerFecha(txtHasta.getText());

        if (desde.enDias() > hasta.enDias()) {
            JOptionPane.showMessageDialog(this, "La fecha Desde debe ser anterior o igual a Hasta.");
            return;
        }

        mostrarTabla(tablaRotacion, gestion.generarRotacion(desde, hasta));
        mostrarTabla(tablaProductividad, gestion.generarProductividad());
        mostrarTabla(tablaClientes, gestion.generarClientesConMasCompras());
        mostrarTabla(tablaIngresos, gestion.generarIngresos(desde, hasta));
    }

    private Fecha leerFecha(String texto) {
        String[] partes = texto.split("/", -1);
        if (partes.length != 3 || partes[2].length() != 4) {
            throw new IllegalArgumentException();
        }
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);
        return new Fecha(anio, mes, dia);
    }

    private void mostrarTabla(JTable tabla, ReporteGerencial reporte) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setNumRows(0);

        Object[][] filas = reporte.generarFilas();
        for (int i = 0; i < filas.length; i++) {
            Object[] fila = filas[i];
            modelo.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDesde = new javax.swing.JLabel();
        txtDesde = new javax.swing.JTextField();
        txtDesde.setBackground(new java.awt.Color(251, 237, 197));
        txtDesde.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtDesde.setForeground(new java.awt.Color(23, 20, 13));
        lblHasta = new javax.swing.JLabel();
        txtHasta = new javax.swing.JTextField();
        txtHasta.setBackground(new java.awt.Color(251, 237, 197));
        txtHasta.setFont(new java.awt.Font("Poppins Regular", 0, 13)); // NOI18N
        txtHasta.setForeground(new java.awt.Color(23, 20, 13));
        btnGenerar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        scrollReportes = new javax.swing.JScrollPane();
        panelReportes = new javax.swing.JPanel();
        lblRotacion = new javax.swing.JLabel();
        scrollRotacion = new javax.swing.JScrollPane();
        tablaRotacion = new javax.swing.JTable();
        lblProductividad = new javax.swing.JLabel();
        scrollProductividad = new javax.swing.JScrollPane();
        tablaProductividad = new javax.swing.JTable();
        lblClientes = new javax.swing.JLabel();
        scrollClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        lblIngresos = new javax.swing.JLabel();
        scrollIngresos = new javax.swing.JScrollPane();
        tablaIngresos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setTitle("Reportes gerenciales");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDesde.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        lblDesde.setForeground(new java.awt.Color(252, 245, 224));
        lblDesde.setText("Desde (dd/mm/aaaa)");
        getContentPane().add(lblDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 100, 130, 26));
        getContentPane().add(txtDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 100, 26));

        lblHasta.setFont(new java.awt.Font("Poppins Medium", 0, 11)); // NOI18N
        lblHasta.setForeground(new java.awt.Color(252, 245, 224));
        lblHasta.setText("Hasta (dd/mm/aaaa)");
        getContentPane().add(lblHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 100, 130, 26));
        getContentPane().add(txtHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 100, 26));

        btnGenerar.setBackground(new java.awt.Color(253, 216, 24));
        btnGenerar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(23, 20, 13));
        btnGenerar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setOpaque(true);
        btnGenerar.setText("Generar reportes");
        btnGenerar.addActionListener(this::generarActionPerformed);
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 145, 26));

        btnCerrar.setBackground(new java.awt.Color(46, 38, 12));
        btnCerrar.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(253, 216, 24));
        btnCerrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setOpaque(true);
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::cerrarActionPerformed);
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 80, 28));

        panelReportes.setBackground(new java.awt.Color(33, 29, 24));
        panelReportes.setPreferredSize(new java.awt.Dimension(590, 880));
        panelReportes.setLayout(null);

        lblRotacion.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblRotacion.setForeground(new java.awt.Color(253, 216, 24));
        lblRotacion.setText("Rotación por categoría");
        panelReportes.add(lblRotacion);
        lblRotacion.setBounds(10, 10, 570, 25);

        tablaRotacion.setBackground(new java.awt.Color(25, 24, 22));
        tablaRotacion.setFont(new java.awt.Font("Poppins Regular", 0, 12)); // NOI18N
        tablaRotacion.setForeground(new java.awt.Color(252, 245, 224));
        tablaRotacion.setFillsViewportHeight(true);
        tablaRotacion.setGridColor(new java.awt.Color(57, 49, 38));
        tablaRotacion.setRowHeight(24);
        tablaRotacion.setSelectionBackground(new java.awt.Color(253, 216, 24));
        tablaRotacion.setSelectionForeground(new java.awt.Color(23, 20, 13));
        EstiloTablasRetro.aplicarEncabezado(tablaRotacion);
        tablaRotacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría", "Unidades vendidas", "Porcentaje de salida (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRotacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(scrollRotacion);
        scrollRotacion.setViewportView(tablaRotacion);

        panelReportes.add(scrollRotacion);
        scrollRotacion.setBounds(10, 38, 565, 180);

        lblProductividad.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblProductividad.setForeground(new java.awt.Color(253, 216, 24));
        lblProductividad.setText("Productividad del personal");
        panelReportes.add(lblProductividad);
        lblProductividad.setBounds(10, 228, 570, 25);

        tablaProductividad.setBackground(new java.awt.Color(25, 24, 22));
        tablaProductividad.setFont(new java.awt.Font("Poppins Regular", 0, 12)); // NOI18N
        tablaProductividad.setForeground(new java.awt.Color(252, 245, 224));
        tablaProductividad.setFillsViewportHeight(true);
        tablaProductividad.setGridColor(new java.awt.Color(57, 49, 38));
        tablaProductividad.setRowHeight(24);
        tablaProductividad.setSelectionBackground(new java.awt.Color(253, 216, 24));
        tablaProductividad.setSelectionForeground(new java.awt.Color(23, 20, 13));
        EstiloTablasRetro.aplicarEncabezado(tablaProductividad);
        tablaProductividad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empleado", "Rol", "Órdenes registradas", "Paquetes verificados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollProductividad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(scrollProductividad);
        scrollProductividad.setViewportView(tablaProductividad);

        panelReportes.add(scrollProductividad);
        scrollProductividad.setBounds(10, 256, 565, 180);

        lblClientes.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(253, 216, 24));
        lblClientes.setText("Clientes con más compras");
        panelReportes.add(lblClientes);
        lblClientes.setBounds(10, 446, 570, 25);

        tablaClientes.setBackground(new java.awt.Color(25, 24, 22));
        tablaClientes.setFont(new java.awt.Font("Poppins Regular", 0, 12)); // NOI18N
        tablaClientes.setForeground(new java.awt.Color(252, 245, 224));
        tablaClientes.setFillsViewportHeight(true);
        tablaClientes.setGridColor(new java.awt.Color(57, 49, 38));
        tablaClientes.setRowHeight(24);
        tablaClientes.setSelectionBackground(new java.awt.Color(253, 216, 24));
        tablaClientes.setSelectionForeground(new java.awt.Color(23, 20, 13));
        EstiloTablasRetro.aplicarEncabezado(tablaClientes);
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Cliente", "Compras finalizadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(scrollClientes);
        scrollClientes.setViewportView(tablaClientes);

        panelReportes.add(scrollClientes);
        scrollClientes.setBounds(10, 474, 565, 180);

        lblIngresos.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblIngresos.setForeground(new java.awt.Color(253, 216, 24));
        lblIngresos.setText("Ingresos por concepto");
        panelReportes.add(lblIngresos);
        lblIngresos.setBounds(10, 664, 570, 25);

        tablaIngresos.setBackground(new java.awt.Color(25, 24, 22));
        tablaIngresos.setFont(new java.awt.Font("Poppins Regular", 0, 12)); // NOI18N
        tablaIngresos.setForeground(new java.awt.Color(252, 245, 224));
        tablaIngresos.setFillsViewportHeight(true);
        tablaIngresos.setGridColor(new java.awt.Color(57, 49, 38));
        tablaIngresos.setRowHeight(24);
        tablaIngresos.setSelectionBackground(new java.awt.Color(253, 216, 24));
        tablaIngresos.setSelectionForeground(new java.awt.Color(23, 20, 13));
        EstiloTablasRetro.aplicarEncabezado(tablaIngresos);
        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concepto", "Ingreso neto (S/)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollIngresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(scrollIngresos);
        scrollIngresos.setViewportView(tablaIngresos);

        panelReportes.add(scrollIngresos);
        scrollIngresos.setBounds(10, 692, 565, 180);

        scrollReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(87, 74, 55)));
        EstiloTablasRetro.aplicarBarras(scrollReportes);
        scrollReportes.setViewportView(panelReportes);

        getContentPane().add(scrollReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 615, 423));

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 245, 224));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reportes Gerenciales");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 50));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/reportes.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        mostrarReportes();
    }//GEN-LAST:event_generarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblProductividad;
    private javax.swing.JLabel lblRotacion;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollIngresos;
    private javax.swing.JScrollPane scrollProductividad;
    private javax.swing.JScrollPane scrollReportes;
    private javax.swing.JScrollPane scrollRotacion;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaIngresos;
    private javax.swing.JTable tablaProductividad;
    private javax.swing.JTable tablaRotacion;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}
