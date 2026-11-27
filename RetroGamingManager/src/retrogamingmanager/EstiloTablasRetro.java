package retrogamingmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

final class EstiloTablasRetro {
    private static final Color PISTA = new Color(25, 24, 22);
    private static final Color PANEL = new Color(46, 38, 12);
    private static final Color BORDE = new Color(87, 74, 55);
    private static final Color CONTROL = new Color(166, 129, 36);
    private static final Color AMARILLO = new Color(253, 216, 24);
    private static final Color CREMA = new Color(252, 245, 224);

    private EstiloTablasRetro() {
    }

    static void aplicarEncabezado(JTable tabla) {
        var encabezado = tabla.getTableHeader();
        encabezado.setBackground(PANEL);
        encabezado.setForeground(AMARILLO);
        encabezado.setFont(new Font("Poppins Medium", Font.PLAIN, 11));

        DefaultTableCellRenderer celdas = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable origen, Object valor,
                    boolean seleccionado, boolean enfocado, int fila, int columna) {
                super.getTableCellRendererComponent(origen, valor, seleccionado, enfocado, fila, columna);
                setBackground(encabezado.getBackground());
                setForeground(encabezado.getForeground());
                setFont(encabezado.getFont());
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 1, 1, BORDE),
                        BorderFactory.createEmptyBorder(4, 2, 4, 2)));
                return this;
            }
        };
        celdas.setHorizontalAlignment(SwingConstants.CENTER);
        encabezado.setDefaultRenderer(celdas);
    }

    static void aplicarBarras(JScrollPane panel) {
        panel.getHorizontalScrollBar().setUI(new BarraRetro());
        panel.getVerticalScrollBar().setUI(new BarraRetro());
    }

    private static final class BarraRetro extends BasicScrollBarUI {
        @Override
        protected void paintTrack(Graphics g, JComponent componente, Rectangle area) {
            g.setColor(PISTA);
            g.fillRect(area.x, area.y, area.width, area.height);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent componente, Rectangle area) {
            if (area.isEmpty() || !componente.isEnabled()) {
                return;
            }
            g.setColor((isDragging || isThumbRollover()) ? AMARILLO : CONTROL);
            g.fillRoundRect(area.x + 2, area.y + 2, area.width - 4, area.height - 4, 6, 6);
        }

        @Override
        protected JButton createDecreaseButton(int direccion) {
            return crearFlecha(direccion);
        }

        @Override
        protected JButton createIncreaseButton(int direccion) {
            return crearFlecha(direccion);
        }

        private JButton crearFlecha(int direccion) {
            return new BasicArrowButton(direccion, PANEL, BORDE, CREMA, CONTROL);
        }

        @Override
        public Dimension getPreferredSize(JComponent componente) {
            return scrollbar.getOrientation() == SwingConstants.VERTICAL
                    ? new Dimension(16, 48) : new Dimension(48, 16);
        }
    }
}
