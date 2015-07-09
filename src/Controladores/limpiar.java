/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class limpiar {
    
    public static void limpiarTabla(JTable tabla){
        try{
          DefaultTableModel  temp = (DefaultTableModel) tabla.getModel();
            int a =temp.getRowCount();
            for(int i=0; i<a; i++)
                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void limpiarTxt(JPanel panel){
      Component[] componentes=panel.getComponents();
        
           for(Component x:componentes){
           if(x.getClass().getName().equals("javax.swing.JTextField")){
               
             
                  ((javax.swing.JTextField)x).setText("");
                   
               }
           }
           
       }
        
    }

