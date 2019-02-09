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
import javax.swing.JComboBox;
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
public class FrameIn extends JFrame {

    private JLabel lblPlate, lblWeight, lblType, lblObject, lblParking, Parking;
    private JTextField txtPlate;
    private JSpinner jsWeight;
    private JComboBox comType, comTb, comFr, comVeg;
    private JButton btnAdd;

    public FrameIn(Controller Controller) {
        init(Controller);
    }

    private void init(Controller Controller) {

        setTitle("Parking");        
        setLayout(new BorderLayout());
        setSize(400,200);

        JPanel Lbl = new JPanel();
        Lbl.setLayout(new GridLayout(4, 1));

        JPanel Answ = new JPanel();
        Answ.setLayout(new GridLayout(4, 1));

        JPanel Data = new JPanel();
        Data.setLayout(new GridLayout(1, 2));

        JPanel Btn = new JPanel();
        Btn.setLayout(new FlowLayout());
        
        JPanel Park = new JPanel();
        Park.setLayout(new BorderLayout());

        lblPlate = new JLabel("Placa");
        lblWeight = new JLabel("Peso(kg)");
        lblType = new JLabel("Categoria de almiento");
        lblObject = new JLabel("Alimento");

        Lbl.add(lblPlate);
        Lbl.add(lblWeight);
        Lbl.add(lblType);
        Lbl.add(lblObject);

        txtPlate = new JTextField(10);
        SpinnerModel smWeight = new SpinnerNumberModel(20000, 5000, 100000, 100);
        jsWeight = new JSpinner(smWeight);

        comType = new JComboBox();
        comType.addItem("Tuberculo");
        comType.addItem("Fruta");
        comType.addItem("Vegetal");

        comTb = new JComboBox();
        comTb.addItem("Papa");
        comTb.addItem("Yuca");

        comFr = new JComboBox();
        comFr.addItem("Maracuyá");
        comFr.addItem("Manzana");

        comVeg = new JComboBox();
        comVeg.addItem("Zanahoria");
        comVeg.addItem("Lechuga");

        Answ.add(txtPlate);
        Answ.add(jsWeight);
        Answ.add(comType);
        Answ.add(comTb);

        Data.add(Lbl);
        Data.add(Answ);

        btnAdd = new JButton("Agregar carro");
        btnAdd.setActionCommand("add");
        btnAdd.addActionListener(Controller);
        
        Btn.add(btnAdd);
        
        lblParking = new JLabel("Lugares en el parqueadero disponibles: ");
        Parking = new JLabel();
        
        Park.add(lblParking, BorderLayout.WEST);
        Park.add(Parking, BorderLayout.EAST);
        
        add(Data, BorderLayout.NORTH);
        add(Btn, BorderLayout.CENTER);
        add(Park, BorderLayout.SOUTH);
        
        setVisible(true);
    }
}
