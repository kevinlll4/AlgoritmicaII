/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import ConexionDB.Conexion;
import Datos.DatosCliente;
import java.sql.Connection;
import java.sql.SQLException;
import javaapplication1.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ngcRegistrarCliente {
    
    public static boolean RegistrarC(Cliente cliente) throws SQLException{
              Connection conexion=Conexion.conexion();
        boolean estado=false;
        try{
            conexion.setAutoCommit(false);
        estado= DatosCliente.registrar(cliente,conexion);  
         conexion.setAutoCommit(true);
        
        }catch(SQLException e){
            conexion.rollback();
            JOptionPane.showMessageDialog(null, "Cliente no encontrado"+e.getMessage());
            
        }
        finally{
             return estado;
        }
        
        
       
    }
    
}
