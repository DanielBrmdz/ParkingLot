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
import java.awt.event.ItemListener;
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

    private JLabel lblPlate, lblWeight, lblType, lblObject, Price, lblParking, Parking;
    private JTextField txtPlate;
    private JSpinner jsWeight;
    private JComboBox comType, comFood;
    private JButton btnAdd, btnPrice;


    public FrameIn(Controller Controller) {
        init(Controller);
    }

    private void init(Controller Controller) {

        setTitle("Parking");        
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(400,250);

        JPanel Lbl = new JPanel();
        Lbl.setLayout(new GridLayout(5, 1));

        JPanel Answ = new JPanel();
        Answ.setLayout(new GridLayout(5, 1));

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
        btnPrice = new JButton("Precio");
        btnPrice.setActionCommand("price");
        btnPrice.addActionListener(Controller);

        Lbl.add(lblPlate);
        Lbl.add(lblWeight);
        Lbl.add(lblType);
        Lbl.add(lblObject);
        Lbl.add(btnPrice);

        txtPlate = new JTextField(10);
        SpinnerModel smWeight = new SpinnerNumberModel(20000, 5000, 100000, 100);
        jsWeight = new JSpinner(smWeight);

        comType = new JComboBox();
        comType.addItem("Seleccione el tipo de alimento");
        comType.addItem("Tuberculo");
        comType.addItem("Fruta");
        comType.addItem("Hortaliza");

        comFood = new JComboBox();
        
        Price = new JLabel("");
        
        Answ.add(txtPlate);
        Answ.add(jsWeight);
        Answ.add(comType);
        Answ.add(comFood);
        Answ.add(Price);
        

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
    
    
    
    public JComboBox TypeCom(){
        return comType;
    }
    public JComboBox FoodCom(){
        return comFood;
    }
    public JTextField getPlate(){
        return txtPlate;
    }
    public Double getWeight(){
        int spinner = (Integer) jsWeight.getValue(); 
        double value = new Double(spinner);
        return value;
    }
    public JComboBox getProduc(){
        return comFood;
    }
    public void setPrice(Double value){        
        Price.setText(value.toString());
    }
    public Double getPrice(){        
        return Double.parseDouble(Price.getText());
    }
}
