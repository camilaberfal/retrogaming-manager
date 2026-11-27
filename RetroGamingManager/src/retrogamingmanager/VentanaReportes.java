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
        try {
            desde = leerFecha(txtDesde.getText());
            hasta = leerFecha(txtHasta.getText());
        } catch (IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, "Escribe fechas válidas en formato dd/mm/aaaa.");
            return;
        }

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
        lblHasta = new javax.swing.JLabel();
        txtHasta = new javax.swing.JTextField();
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

        setTitle("Reportes gerenciales");
        setPreferredSize(new java.awt.Dimension(680, 570));
        setResizable(false);
        getContentPane().setLayout(null);

        lblDesde.setText("Desde (dd/mm/aaaa)");
        getContentPane().add(lblDesde);
        lblDesde.setBounds(20, 16, 115, 26);
        getContentPane().add(txtDesde);
        txtDesde.setBounds(140, 16, 100, 26);

        lblHasta.setText("Hasta (dd/mm/aaaa)");
        getContentPane().add(lblHasta);
        lblHasta.setBounds(255, 16, 115, 26);
        getContentPane().add(txtHasta);
        txtHasta.setBounds(375, 16, 100, 26);

        btnGenerar.setText("Generar reportes");
        btnGenerar.addActionListener(this::generarActionPerformed);
        getContentPane().add(btnGenerar);
        btnGenerar.setBounds(490, 16, 145, 26);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::cerrarActionPerformed);
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(555, 490, 80, 28);

        panelReportes.setPreferredSize(new java.awt.Dimension(590, 880));
        panelReportes.setLayout(null);

        lblRotacion.setText("Rotación por categoría");
        panelReportes.add(lblRotacion);
        lblRotacion.setBounds(10, 10, 570, 25);

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
        scrollRotacion.setViewportView(tablaRotacion);

        panelReportes.add(scrollRotacion);
        scrollRotacion.setBounds(10, 38, 565, 180);

        lblProductividad.setText("Productividad del personal");
        panelReportes.add(lblProductividad);
        lblProductividad.setBounds(10, 228, 570, 25);

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
        scrollProductividad.setViewportView(tablaProductividad);

        panelReportes.add(scrollProductividad);
        scrollProductividad.setBounds(10, 256, 565, 180);

        lblClientes.setText("Clientes con más compras");
        panelReportes.add(lblClientes);
        lblClientes.setBounds(10, 446, 570, 25);

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
        scrollClientes.setViewportView(tablaClientes);

        panelReportes.add(scrollClientes);
        scrollClientes.setBounds(10, 474, 565, 180);

        lblIngresos.setText("Ingresos por concepto");
        panelReportes.add(lblIngresos);
        lblIngresos.setBounds(10, 664, 570, 25);

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
        scrollIngresos.setViewportView(tablaIngresos);

        panelReportes.add(scrollIngresos);
        scrollIngresos.setBounds(10, 692, 565, 180);

        scrollReportes.setViewportView(panelReportes);

        getContentPane().add(scrollReportes);
        scrollReportes.setBounds(20, 54, 615, 423);

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
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblDesde;
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
