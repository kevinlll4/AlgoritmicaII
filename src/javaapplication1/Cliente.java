/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author usuario
 */
public class Cliente extends Persona {
    int id;
Cuenta cuenta;
String nombreCuenta;
    public Cliente(String nombre,int edad,String direccion,String fecha,String nombreCuenta,int id) {
   this.nombre=nombre;
   this.edad=edad;
   this.direccion=direccion;
   this.fecha=fecha;
   this.nombreCuenta=nombreCuenta;
   this.id=id;
    }
    public Cliente(){};
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    void mostrar(){
        
        System.out.println("ID="+id);
        System.out.println("Nombre="+nombre);
        System.out.println("Edad="+edad);
        System.out.println("Fecha="+fecha);
        System.out.println("Direccion="+direccion);
        System.out.println("Nombre Cuenta="+nombreCuenta);
        
    }

}
