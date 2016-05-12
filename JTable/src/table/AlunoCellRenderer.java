package table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AlunoCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (row % 2 == 0) {
            setBackground(Color.decode("#EEE9E9"));
        } else {
            setBackground(null);
        }

        if (isSelected) {
            setBackground(Color.decode("#7EC0EE"));
        }

        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(400);
        table.getColumnModel().getColumn(2).setMaxWidth(500);
        table.getColumnModel().getColumn(3).setMaxWidth(200);

        return this;
    }
}
