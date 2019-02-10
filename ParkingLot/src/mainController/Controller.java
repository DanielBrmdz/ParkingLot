/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainController;

import mainView.FrameOut;
import mainView.FrameIn;
import mainView.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import parking.*;
import util.utilesVw;

/**
 *
 * @author USER
 */
public class Controller implements ActionListener {

    private MainView main;
    private FrameIn frIn;
    private FrameOut frOut;
    private Product prod;
    private ParkingLot parking;

    public Controller() {
        main = new MainView(this);
        parking = new ParkingLot();
        try {
            parking = new ParkingLot();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        parking.read();
    }

    public void addTotable(ArrayList<Car> listCar) {
        for (int i = 0; i < listCar.size(); i++) {
            Object ob[] = new Object[2];
            ob[0] = listCar.get(i).getPlate();
            ob[1] = listCar.get(i).getWeight();
            ob[2] = listCar.get(i).getDate();
            frOut.addElementsToTable(ob);
        }
    }

    public String ProductView(ArrayList<Product> product, JComboBox combo) {
        String name = "";
        for (int i = 0; i < product.size(); i++) {
            combo.addItem(product.get(i).getName());
            name = product.get(i).getName();
        }
        return name;
    }

    public void addActions() {
        final ItemListener changeType = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (frIn.TypeCom().getSelectedItem().equals("Tuberculo")) {
                    frIn.FoodCom().removeAllItems();
                    ProductView(parking.getTubers(), frIn.FoodCom());
                    frIn.setPrice(0.0);
                }
                if (frIn.TypeCom().getSelectedItem().equals("Fruta")) {
                    frIn.FoodCom().removeAllItems();
                    ProductView(parking.getFruits(), frIn.FoodCom());
                    frIn.setPrice(0.0);
                }
                if (frIn.TypeCom().getSelectedItem().equals("Hortaliza")) {
                    frIn.FoodCom().removeAllItems();
                    ProductView(parking.getVegetables(), frIn.FoodCom());
                    frIn.setPrice(0.0);
                }
            }
        };
        frIn.TypeCom().addItemListener(changeType);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("In")) {
            frIn = new FrameIn(this);
            this.addActions();
        }
        if (e.getActionCommand().equals("Out")) {
            frOut = new FrameOut(this);
        }
        if (e.getActionCommand().equals("report")) {
            parking.generateReport();
            utilesVw.msg("Se genero el Reporte en <<./Report.txt>>");
        }
        if (e.getActionCommand().equals("add")) {
            if (frIn.getPrice() > 0.0 || frIn.getPlate().toString() != "" || frIn.FoodCom().toString() != null) {
                if (frIn.TypeCom().getSelectedItem().equals("Tuberculo")) {
                    parking.addCar(frIn.getWeight(), frIn.getPlate().getName(), parking.getProductTub(frIn.FoodCom().toString()));
                } else if (frIn.TypeCom().getSelectedItem().equals("Fruta")) {
                    parking.addCar(frIn.getWeight(), frIn.getPlate().getName(), parking.getProductFru(frIn.FoodCom().toString()));
                } else if (frIn.TypeCom().getSelectedItem().equals("Hortaliza")) {
                    parking.addCar(frIn.getWeight(), frIn.getPlate().getName(), parking.getProductVeg(frIn.FoodCom().toString()));
                }
            } else {
                utilesVw.msgError("Error de datos");
                System.out.println("Se agregó");
            }
        }
        if (e.getActionCommand().equals("load")) {
            //Cargar carro al ingresar placa
        }
        if (e.getActionCommand().equals("delente")) {
            //Borrar carro al ingresar placa
        }
        if (e.getActionCommand().equals("print")) {
            //Imprimir factura 
        }
        if (e.getActionCommand().equals("price")) {
            if (frIn.TypeCom().getSelectedItem().equals("Tuberculo")) {
                frIn.setPrice(parking.getPriceTubers(frIn.FoodCom().getSelectedItem().toString()));
            } else if (frIn.TypeCom().getSelectedItem().equals("Fruta")) {
                frIn.setPrice(parking.getPriceFruits(frIn.FoodCom().getSelectedItem().toString()));
            } else if (frIn.TypeCom().getSelectedItem().equals("Hortaliza")) {
                frIn.setPrice(parking.getPriceVegetables(frIn.FoodCom().getSelectedItem().toString()));
            }
        }
    }

}
