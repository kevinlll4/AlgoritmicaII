/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import Modelos.Cliente;
import Modelos.Cuenta;

/**
 *
 * @author kevin
 */
public class Comparar {
    
    
    public static boolean compararCli(ArrayList<Cliente> x,String y){
       boolean estado=false;
        for(Cliente aux:x){
            
            if(aux.getId().equals(y)){
                return true;
            }
        }
        return estado;
    }
     public static boolean compararCuen(ArrayList<Cuenta> x,String y){
       boolean estado=false;
        for(Cuenta aux:x){
            
            if(aux.getCodigo().equals(y)){
                return true;
            }
        }
        return estado;
    }
}
