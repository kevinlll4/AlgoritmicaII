/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Cliente;
import Modelos.generico;
import Modelos.genericoP;
import Modelos.vectorPersonas;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class DatosCliente {

    public static boolean registrar(Cliente cliente, Connection conexion) {
        boolean estado = false;
        try {
            CallableStatement statement = conexion.prepareCall("{call registrarCliente(?,?,?,?,?)}");
            statement.setString("nombre", cliente.getNombre());
            statement.setString("id", cliente.getId());

            statement.setString("nombre", cliente.getNombre());
            statement.setInt("edad", cliente.getEdad());
            statement.setString("direccion", cliente.getDireccion());
            statement.setString("fecha", cliente.getFecha());

            statement.executeQuery();
            estado = true;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            return estado;
        }
    }

    public static ArrayList getAll(Connection conexion) {
        ArrayList x = new ArrayList();

        String SQL = "select * from clientes";
        Statement consulta = null;
        try {
            consulta = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatosCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs = consulta.executeQuery(SQL);
            while (rs.next()) {
                Cliente h = new Cliente(rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("direccion"),
                        rs.getString("fecha"),
                        rs.getString("id")
                );

                x.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatosCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return x;
        }

    }

    public static boolean registrarF(Cliente cliente) throws IOException {
        boolean k= false;
        try {
            vectorPersonas x = new vectorPersonas();
            File arch = new File("Clientes.obj");
            if(!arch.exists()){
                x.crearArchivoC();
            }
 
                x.añadir("Clientes.obj",cliente);
               k = true;
        }
        catch(IOException e){
            System.out.println("Error entrada en registro");
        }
        finally{
            return k;
        }
    }
    
      public static ArrayList<Cliente> getAllF() throws IOException, FileNotFoundException, ClassNotFoundException {
      
          vectorPersonas x=new vectorPersonas();
       
          
          return x.recuperarArchivo("Clientes.obj");
          
    }

    public static ArrayList<Cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
