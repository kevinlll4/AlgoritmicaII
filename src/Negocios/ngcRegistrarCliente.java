/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import ConexionDB.Conexion;
import Datos.DatosCliente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import Modelos.Cliente;
import Modelos.generico;
import Modelos.genericoP;
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
    public static boolean RegistrarCF(Cliente cliente) throws IOException{
         boolean estado=false;
        
           
        estado= DatosCliente.registrarF(cliente);  
      
        
        
             return estado;
       
    }
    
}
