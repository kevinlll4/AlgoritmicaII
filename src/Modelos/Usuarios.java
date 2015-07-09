/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

/**
 *
 * @author kevin
 */
public class Usuarios extends Persona {

    String id;
    String password;
    String nick;

    public Usuarios(String id, String nombre, String password, String nick) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.nick = nick;
    }
    public Usuarios(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void crear() throws IOException {

        File x = new File("Usuarios.obj");
        ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(x));
        ob.writeObject(this);
        ob.close();
    }
    public  Usuarios recuperar() throws IOException, ClassNotFoundException{
        File x = new File("Usuarios.obj");
        ObjectInputStream ob = new ObjectInputStream(new FileInputStream(x));
        Usuarios us=(Usuarios) ob.readObject();
        us.mostrar();
           ob.close();
        return us;
    }
    public void mostrar(){
        System.out.println("ID:"+id);
        System.out.println("Password"+password);
        System.out.println("Nombre"+nombre);
        System.out.println("nick"+nick);
        
    }
    public void añadir() throws IOException {
        MyObjectOutput op = new MyObjectOutput(new FileOutputStream(nombre));
        op.writeUnshared(this);
        op.close();

    }

}
