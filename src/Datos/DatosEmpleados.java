/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Usuarios;
import Modelos.genericoP;

/**
 *
 * @author kevin
 */
public class DatosEmpleados {
    
    public static boolean usuarios(Connection conexion,String usuario,String contraseña){
        
        boolean estado=false;
        String sql="select nombre,contraseña from empleados where nombre=? and contraseña=?";
        try {
            PreparedStatement consulta=conexion.prepareStatement(sql);
            consulta.setString(1, usuario);
            consulta.setString(2,contraseña);
           estado= consulta.execute();
     
        } catch (SQLException ex) {
            Logger.getLogger(DatosEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
    return estado;
    }
        
        
        
    }
     public static boolean usuariosF(ArrayList<genericoP> x,Usuarios m){
        boolean estado=false;
        
          
        for(genericoP aux:x){
            System.out.println(aux.getNick()+aux.getPassword());
              if(m.getNick().equals(aux.getNick()) && m.getPassword().equals(aux.getPassword()))
            {
                estado=true;
            break;}
        }
       
         
            return estado;
        }
}
