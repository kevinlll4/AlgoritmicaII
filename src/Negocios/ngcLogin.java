/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import ConexionDB.Conexion;
import Datos.DatosEmpleados;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class ngcLogin {
    
    
    public static boolean ConsultarLogin(String usuario,String contraseña){
        Connection conexion=null;
        conexion=Conexion.conexion();
        boolean op=false;
        op=DatosEmpleados.usuarios(conexion,usuario,contraseña);
        
        return op;
        
        
    }
}
