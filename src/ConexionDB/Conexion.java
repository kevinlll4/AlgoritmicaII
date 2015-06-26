/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Conexion {

    
    public static Connection conexion(){
        
        Connection conexion = null;
        try{
       String password="teamomuchoR1";
       String usuario="root";
                   String servidor = "jdbc:mysql://localhost/Banco";
        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection(servidor,usuario,password);
        
        }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "No se encontro el driver"+e.getMessage());
                
                }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al entrar al servidor"+e.getMessage());
        }
        catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Otras exepciones"+e.getMessage());

        }
        finally{
            return conexion;
        }
        
        
    }


    
 

}
