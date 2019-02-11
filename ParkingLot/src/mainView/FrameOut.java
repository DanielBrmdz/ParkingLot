/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainView;

import mainController.Controller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author USER
 */
public class FrameOut extends JFrame {

    private JPTableElements table;
    private JLabel lblPlate, lblWeightIn, WeightIn, lblWeightOut, lblType, Type, lblObject, Object;
    private JTextField txtPlate;
    private JSpinner jsWeightOut;
    private JButton btnlLoad, btnDelente, btnPrint;

    public FrameOut(Controller Controller) {
        super("Salida de vehículos");
        setSize(700, 700);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel Lbl = new JPanel();
        Lbl.setLayout(new GridLayout(5, 1, 10, 10));

        JPanel Answ = new JPanel();
        Answ.setLayout(new GridLayout(5, 1, 8, 8));

        JPanel Btns = new JPanel();
        Btns.setLayout(new GridLayout(4, 1, 10, 10));

        JPanel Data = new JPanel();
        Data.setLayout(new FlowLayout());

        JPanel Print = new JPanel();
        Print.setLayout(new FlowLayout());

        table = new JPTableElements();

        lblPlate = new JLabel("Placa: ");
        lblWeightIn = new JLabel("Peso(kg) de entrada: ");
        lblWeightOut = new JLabel("Peso(kg) de salida: ");
        lblType = new JLabel("Categoria de almiento: ");
        lblObject = new JLabel("Alimento: ");

        Lbl.add(lblPlate);
        Lbl.add(lblWeightIn);
        Lbl.add(lblWeightOut);
        Lbl.add(lblType);
        Lbl.add(lblObject);

        txtPlate = new JTextField(10);
        WeightIn = new JLabel();
        SpinnerModel smWeight = new SpinnerNumberModel(20000, 5000, 100000, 100);
        jsWeightOut = new JSpinner(smWeight);
        Type = new JLabel();
        Object = new JLabel();

        Answ.add(txtPlate);
        Answ.add(WeightIn);
        Answ.add(jsWeightOut);
        Answ.add(Type);
        Answ.add(Object);

        btnlLoad = new JButton("Cargar");
        btnlLoad.setActionCommand("load");
        btnlLoad.addActionListener(Controller);

        btnDelente = new JButton("Borrar");
        btnDelente.setActionCommand("delente");
        btnDelente.addActionListener(Controller);

        Btns.add(btnlLoad);
        Btns.add(btnDelente);

        Data.add(Lbl);
        Data.add(Answ);
        Data.add(Btns);

        btnPrint = new JButton("Imprimir factura");
        btnPrint.setActionCommand("print");
        btnPrint.addActionListener(Controller);

        Print.add(btnPrint);

        add(table, BorderLayout.NORTH);
        add(Data, BorderLayout.CENTER);
        add(Print, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void addElementsToTable(Object[] vector) {
        table.addElementsToTable(vector);
    }

    public void clearTableList() {
        table.cleanTable();
    }
}
