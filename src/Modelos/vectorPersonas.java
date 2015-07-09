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
public class vectorPersonas<T extends Serializable> implements Serializable,Comun{

    ArrayList<T> x;

    public void añadir(genericoP dato) {

        x.add((T) dato);
    }

    public vectorPersonas() {
        x = new ArrayList<>();
    }

    public void crearArchivoU() throws FileNotFoundException, IOException {
        String nombre = "Usuarios.obj";
        ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream(nombre));
        op.close();
    }

    public void crearArchivoC() {
        ObjectOutputStream op = null;
        try {
            String nombre = "Clientes.obj";
            op = new ObjectOutputStream(new FileOutputStream(nombre));
            op.close();
        } catch (IOException ex) {
            Logger.getLogger(vectorPersonas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                op.close();
            } catch (IOException ex) {
                Logger.getLogger(vectorPersonas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void inicialU(String tipo) throws IOException {
        String nombre = "Usuarios.obj";
        File x = new File(nombre);
        if (!x.exists()) {

            crearArchivoU();

        }
       
	genericoP<Usuarios> k = new genericoP<>();
            k.setId("Kevin14023");
            k.setNick("kevinlll4");
            k.setPassword("14200023");
            k.setNombre("kevin");

            añadir(nombre, (T) k);
            
            genericoP<Usuarios> r = new genericoP<>();
            r.setId("Renzo150693");
            r.setNick("Renz");
            r.setPassword("14200026");
            r.setNombre("Renzo");

            añadir(nombre, (T) r);
        
            genericoP<Usuarios> d = new genericoP<>();
            r.setId("Diego001");
            r.setNick("Diego");
            r.setPassword("14200020");
            r.setNombre("Diego");

            añadir(nombre, (T) d);
            
            genericoP<Usuarios> p = new genericoP<>();
            r.setId("Pablo001");
            r.setNick("Pablo");
            r.setPassword("14200169");
            r.setNombre("Pablo");

            añadir(nombre, (T) p);
            
            genericoP<Usuarios> o = new genericoP<>();
            r.setId("Oncoy001");
            r.setNick("Oncoy");
            r.setPassword("14200xxx");
            r.setNombre("Oncoy");

            añadir(nombre, (T) o);

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
            System.out.println("El archivo no existe");
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
