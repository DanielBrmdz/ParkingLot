/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RA301
 */
public class JPTableElements extends JPanel {

    private DefaultTableModel dtmElements;
    private JTable jtElements;
    private JScrollPane jsTable;

    public JPTableElements() {
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.decode("#30373D"));
        String[] headers = {"PLACA", "PESO", "FECHA"};
        dtmElements = new DefaultTableModel();
        dtmElements.setColumnIdentifiers(headers);

        Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 14);

        jtElements = new JTable();
        jtElements.setModel(dtmElements);
        jtElements.getTableHeader().setReorderingAllowed(false);
        jtElements.getTableHeader().setBackground(Color.decode("#282E33"));
        jtElements.getTableHeader().setForeground(Color.white);
        jtElements.getTableHeader().setFont(fontHeader);
        jtElements.setBackground(Color.white);
        jtElements.setFillsViewportHeight(true);
        jtElements.setBorder(null);

        jsTable = new JScrollPane(jtElements);
        jsTable.setForeground(Color.white);
        jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
        jsTable.setBorder(null);
        this.add(jsTable, BorderLayout.PAGE_END);
        this.setBorder(null);
    }

    public void addElementsToTable(Object[] vector) {
        dtmElements.addRow(vector);
    }

    public void cleanTable() {
        for (int i = 0; i < jtElements.getRowCount(); i++) {
            dtmElements.removeRow(i);
            i -= 1;
        }
    }
}
