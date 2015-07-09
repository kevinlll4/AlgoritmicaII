/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Datos.DatosCliente;
import Datos.DatosCuenta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import Modelos.vectorGenericosCuentas;
import Modelos.vectorPersonas;

/**
 *
 * @author kevin
 */
public class Codigo {

    public static String CodNombre(String nombre, Connection conexion) {
        int dim;
        ArrayList a = DatosCliente.getAll(conexion);
        if(a==null){
            
            dim=0;
        }
        else{
        dim=a.size();
        }
        String var = Codigo(dim, nombre);

        return var;
    }

    public static String CodCuenta(String nombre, Connection conexion) {
        int dim;
        ArrayList a = DatosCuenta.getAll(conexion);
        
         if(a==null){
            
            dim=0;
        }
        else{
        dim=a.size();
        }
  
        String var = Codigo(dim, nombre);


        return var;

    }
   public static String CodigoNombreF(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException{
       int dim;
       vectorPersonas x=new vectorPersonas();
       ArrayList m=x.recuperarArchivo("Clientes.obj");
       if(m==null){
           
           dim=0;
       }
       else{
           dim=m.size();
       }
       return Codigo(dim,nombre);
   }

   public static String CodigoCuentaF(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException{
       int dim;
       vectorGenericosCuentas x=new vectorGenericosCuentas();
       ArrayList m=x.recuperarArchivo("Cuentas.obj");
       if(m==null){
           
           dim=0;
       }
       else{
           dim=m.size();
       }
       return Codigo(dim,nombre);
   }
    public static String Codigo(int dim, String nombre) {
       //kevin    cad=kev0000003  kev0000013 
        String cad = "";
    
            for (int i = 0; i < 3; i++) {
                cad = cad + nombre.charAt(i);
            }
         
            for (int i = 7 - MetodosBase.contarCifras(dim); i > 0; i--) {

                cad = cad + "0";
            }
            cad = cad + Integer.toString(dim+1);
            

  
        return cad;
    }
}
