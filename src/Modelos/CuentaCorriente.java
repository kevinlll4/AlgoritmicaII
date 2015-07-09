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
public class CuentaCorriente<T> extends Cuenta{

    public CuentaCorriente(String codigo,
            String cliente,
            String contraseña,
            float saldo, String tipo) {

        this.codigo = codigo;
        this.idcliente = cliente;
        this.contraseña = contraseña;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    CuentaCorriente() {
    }

}
