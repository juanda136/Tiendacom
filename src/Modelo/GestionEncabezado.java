package Modelo;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HP
 */
public class GestionEncabezado implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JComponent encabez = null;
        encabez = new JLabel((String) value);

        ((JLabel) encabez).setHorizontalAlignment(SwingConstants.CENTER); // centrar los títulos de los encabezados
        encabez.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(180, 180, 180))); // Cambié el color del borde a 180, 180, 180 (un gris más suave)
        encabez.setForeground(new java.awt.Color(70, 70, 70)); // Cambié el color del texto a 70, 70, 70 (un gris oscuro)
        encabez.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // Cambié el tipo de letra a "Tahoma", el tamaño de la letra a 14 y el estilo a "Bold" (negrita)
        return encabez;
    }
}
