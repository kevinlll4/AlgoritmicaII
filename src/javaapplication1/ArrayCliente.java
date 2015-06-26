/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
/**
 *
 * @author usuario
 */
public class ArrayCliente {

    int dim;
    ArrayList<Cliente> cliente;
    ArrayCliente() {

        this.dim = 0;
        cliente=new ArrayList<Cliente>();
    }

    void ingresar() {

        Scanner ing = new Scanner(System.in);
        System.out.println("Numero de Clientes a registrar ");
        int num = ing.nextInt();
        String nombre;
        int edad;
        String direccion;
        String fecha;
        String nombreCuenta;
        Cuenta cuenta;
        Cliente aux;
        int id;
        for (int i = dim; i < num + dim; i++) {
            id=i;
            System.out.println("Cliente i+1");
            nombre = ing.next();
            edad = ing.nextInt();
            direccion = ing.next();
            fecha = ing.next();
            nombreCuenta = ing.next();
       aux=new Cliente(nombre,edad,direccion,fecha,nombreCuenta,id);
            if (nombreCuenta.equals("Corriente")) {

                cuenta = new CuentaCorriente();
                 aux.setCuenta(cuenta);
            } else if (nombreCuenta.equals("Ahorros")) {

                cuenta = new CuentaAhorros();
                 aux.setCuenta(cuenta);
            }
           
            cliente.add(aux);
        }

    }
    void leer(){
       
       for(int i=0;i<dim;i++){
           
     cliente.get(i).mostrar();
           
       }
        
    }
}
