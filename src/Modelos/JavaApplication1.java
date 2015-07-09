/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /* vectorPersonas x = new vectorPersonas();
        //x.inicialU("Usuarios");
        ArrayList a = x.recuperarArchivo("Usuarios.obj");
        System.out.println(a.size());
        vectorPersonas k = new vectorPersonas();
        if (k == null) {
        System.out.println("000000");
        } else {
        ArrayList d = k.recuperarArchivo("Clientes.obj");
        System.out.println("Dimension clientes.obj" + d.size());
        }
        vectorGenericosCuentas caca=new vectorGenericosCuentas();
        ArrayList e=caca.recuperarArchivo("Cuentas.obj");
        System.out.println("DImension cuentas"+e.size());*/ 

  
        new ScreenSplash().animar();                        
 
    }

}
