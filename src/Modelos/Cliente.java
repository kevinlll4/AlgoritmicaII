/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Cliente<T> extends Persona implements Serializable{

    String id;

    public Cliente(String nombre, int edad, String direccion, String fecha, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.fecha = fecha;
        this.id = id;
    }

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   

}
