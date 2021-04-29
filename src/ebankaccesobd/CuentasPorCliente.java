/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import java.util.ArrayList;
/**
 *
 * @author Nocturno
 */
public class CuentasPorCliente {
    
    private Cliente cliente;
    private ArrayList<TarjetaCredito> tTarjetas;

    public CuentasPorCliente(Cliente cliente, ArrayList<TarjetaCredito> tTarjetas) {
        this.cliente = cliente;
        this.tTarjetas = tTarjetas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<TarjetaCredito> gettTarjetas() {
        return tTarjetas;
    }    
    
}
