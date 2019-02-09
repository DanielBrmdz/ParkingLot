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


/**
 *
 * @author USER
 */
public class Controller implements ActionListener{
    
    private MainView main;
    private FrameIn frIn;
    private FrameOut frOut;
    
    public Controller(){
        main = new MainView(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("In")){
            frIn = new FrameIn(this);
        }
        if(e.getActionCommand().equals("Out")){
            frOut = new FrameOut(this);
        }
        if(e.getActionCommand().equals("report")){
            //Generacion de reporte
        }
        if(e.getActionCommand().equals("add")){
            //Agregar carro
        }
        if(e.getActionCommand().equals("load")){
            //Cargar carro al ingresar placa
        }
        if(e.getActionCommand().equals("delente")){
            //Borrar carro al ingresar placa
        }
        if(e.getActionCommand().equals("print")){
            //Imprimir factura 
        }
    }
   
}
