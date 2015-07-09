/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class vectorGenericosCuentas<T extends Serializable> implements  Serializable,Comun{
  ArrayList<T> x;


    public vectorGenericosCuentas() {
        x = new ArrayList<>();
    }

 
    public void crearArchivoC(){
        String nombre = "Cuentas.obj";
        ObjectOutputStream op = null;
      try {
          op = new ObjectOutputStream(new FileOutputStream(nombre));
      } catch (IOException ex) {
          Logger.getLogger(vectorGenericosCuentas.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          op.close();
      } catch (IOException ex) {
          Logger.getLogger(vectorGenericosCuentas.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    public void añadir(String nombre, T dato) throws IOException {

        try {
            try (MyObjectOutput salida = new MyObjectOutput(
                    new FileOutputStream(
                            nombre, true))) {
                        salida.writeUnshared(dato);
                        salida.close();
                    }
        } catch (IOException e) {
            System.out.println("Error de E/S de archivo");
        }

    }

    public ArrayList<T> recuperarArchivo(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ip = null;
        File y=new File(nombre);
        if(!y.exists()){
        return null;
        }
        else{
        try {


            ip = new ObjectInputStream(new FileInputStream(nombre));

            while (true) {
                        
               
                
                T m = (T) ip.readObject();
               
                x.add(m);
            }
        } catch (IOException io) {

           
        } finally {
            return x;
        }}
    }
}
