/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import ConexionDB.Conexion;
import Datos.DatosCliente;
import Datos.DatosCuenta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import Modelos.Cliente;
import Modelos.Cuenta;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ngcRegistrarCuenta {
      public static boolean RegistrarC(Cuenta cuenta) throws SQLException{
              Connection conexion=Conexion.conexion();
        boolean estado=false;
       
        try{
            conexion.setAutoCommit(false);
        estado= DatosCuenta.registrar(cuenta,conexion);
            System.out.println("Estado dentro cuenta"+estado);
         conexion.setAutoCommit(true);
        
        }catch(SQLException e){
            conexion.rollback();
            JOptionPane.showMessageDialog(null, "Cuenta no registrada"+e.getMessage());
            
        }
        finally{
             return estado;
        }
      }
     public static boolean RegistrarCF(Cuenta cliente) throws IOException{
         boolean estado=false;
        
           
        estado= DatosCuenta.registrarF(cliente);  
      
        
        
             return estado;
       
    }
}
