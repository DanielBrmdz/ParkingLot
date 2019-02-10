/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JOptionPane;

/**
 *
 * @author tetes
 */
public class utilesVw {
   
    
    public static int inputInt(String mensaje){
        int dato = 0;
        try{
            dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        }catch(Exception ex){
            utilesVw.msgError("Dato Incorrecto");
            dato = utilesVw.inputInt(mensaje);
        }        
        return dato;
    }
    
    public static String inputString(String mensaje){
        String dato;
        dato = JOptionPane.showInputDialog(mensaje);
        return dato;
    }
    
    public static double inputDouble(String mensaje){
        double dato = 0.0;
        try{
            dato = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
        }catch(Exception ex){
            utilesVw.msgError("Dato Incorrecto");
            dato = utilesVw.inputDouble(mensaje);
        }
        return dato;
    }
    
    public static void msg(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);        
    }
    
    public static void msgError(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    public static Object inputWithList(String mensaje,Object[] lista){
        Object objeto;
        
        objeto = JOptionPane.showInputDialog(null,mensaje,"Selección",JOptionPane.OK_OPTION,null,lista,"Selecciones");
        
        return objeto;
    }
}
