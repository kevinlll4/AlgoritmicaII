/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

/**
 *
 * @author kevin
 */
public class MetodosBase {
    
    
    public static int contarCifras(int num){
        int cont=0;
        if(num==0){
            
            return 1;
        }
        while(num!=0){
           
                num=num/10;
                cont++;
            
        }
        
        return cont;
    }
}
