/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class MenuPrincipal {

    void mostrar() {
        Scanner ing = new Scanner(System.in);
        ArrayCliente x = new ArrayCliente();
        int op;
        do {
            System.out.println("=============================");
            System.out.println("////////Menu Principal///////");
            System.out.println("=============================");
            System.out.println("1.-Ingresar Clientes");
            System.out.println("2.-Mostrar Clientes");
            System.out.println("3.-Modificar Datos Clientes");
            System.out.println("4.-Salir");
            System.out.println("");
            System.out.println("Elija una opcion");
            op = ing.nextInt();
        } while (op < 0 || op > 4);

        switch (op) {

            case 1:
                x.ingresar();
                break;
            case 2:
                x.mostrar();
                break;
            case 3:x.modificar();
                    break;
            case 4:break;

        }
    }
