/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javaapplication1.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class DatosCliente {
    
    public static boolean registrar(Cliente cliente,Connection conexion){
        boolean estado=false;
        try{
        CallableStatement statement=conexion.prepareCall("{call registrarCliente(?,?,?,?)}");
        statement.setString("nombre", cliente.getNombre());
        statement.setInt("edad",cliente.getEdad());
        statement.setString("direccion", cliente.getDireccion());
        statement.setString("fecha",cliente.getFecha());
        
           statement.executeQuery();
           estado=true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally{
            
            return estado;
        }
    }
    public static boolean buscarCliente(Connection conexion,String dato){
    }
    }
    
}
