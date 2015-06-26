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
import javaapplication1.Cuenta;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class DatosCuenta {
    
    public static boolean registrar(Cuenta cuenta,Connection conexion){
        boolean estado=false;
        try{
        CallableStatement statement=conexion.prepareCall("{call registrarCuenta(?,?)}");
        statement.setString("Contraseña", cuenta.getContraseña());
        statement.setFloat("Saldo",cuenta.getSaldo());
        statement.setString("idcliente",cuenta.getCliente());
        
           statement.executeQuery();
           estado=true;     
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally{
            
            return estado;
        }
    }
}
