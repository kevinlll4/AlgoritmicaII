/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

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
import Modelos.Cuenta;
import Modelos.CuentaCorriente;
import Modelos.generico;
import Modelos.genericoP;
import Modelos.vectorGenericosCuentas;
import Modelos.vectorPersonas;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class DatosCuenta {

    public static boolean registrar(Cuenta cuenta, Connection conexion) {
        boolean estado = false;
        try {
            System.out.println("ID:" + cuenta.getCodigo());
            CallableStatement statement = conexion.prepareCall("{call registrarCuenta(?,?,?,?,?)}");
            statement.setString("codigo", cuenta.getCodigo());
            statement.setString("idCliente", cuenta.getIdcliente());
            statement.setString("contraseña", cuenta.getContraseña());
            statement.setFloat("saldo", cuenta.getSaldo());
            statement.setString("tipo", cuenta.getTipo());

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

        String SQL = "select * from cuentas";
        Statement consulta = null;
        try {
            consulta = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Consulta");
        }
        try {
            ResultSet rs = consulta.executeQuery(SQL);
            while (rs.next()) {
                Cuenta h = null;
                System.out.println("TIpo:" + rs.getString("tipo").equals("Corriente"));
                if (rs.getString("tipo").equals("Corriente")) {
                    h = new CuentaCorriente(rs.getString("id"),
                            rs.getString("idCliente"),
                            rs.getString("contraseña"),
                            rs.getFloat("saldo"),
                            rs.getString("tipo"));
                    x.add(h);

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatosCuenta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return x;
        }

    }

    public static boolean registrarF(Cuenta cuenta) throws IOException {
      boolean k= false;
        try {
            vectorGenericosCuentas x = new vectorGenericosCuentas();
            File arch = new File("Cuentas.obj");
            if(!arch.exists()){
                x.crearArchivoC();
            }
                x.añadir("Cuentas.obj",cuenta);
               k = true;
        }
        catch(IOException e){
            System.out.println("Error entrada en registro");
        }
        finally{
            return k;
        }
    }
      public static ArrayList<Cuenta> getAllF() throws IOException, FileNotFoundException, ClassNotFoundException {
      
          vectorGenericosCuentas x=new vectorGenericosCuentas();
       
          
          return x.recuperarArchivo("Cuentas.obj");
          
    }
}
