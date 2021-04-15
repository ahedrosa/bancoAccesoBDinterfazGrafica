/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import java.io.Serializable;

/**
 *
 * @author Alberto
 */
public class TarjetaCredito implements Serializable{
    
    private String  numTarjeta;  //Se controla que se introducen 16 dígitos
    private String  pin; //Se controlan que sean 4 digitos numericos
    private double  saldo;
    private boolean bloqueada;
    private String  dniTitular;
    

    public TarjetaCredito() {
        numTarjeta = "";
        pin = "";
        bloqueada = false;
        saldo = 0.0;
    }
    
    public TarjetaCredito(String numTarjeta, String pin, double saldo, String dniTitular){
        this.numTarjeta = numTarjeta;
        this.pin = pin;
        this.bloqueada = false;
        this.saldo = saldo;
        this.dniTitular = dniTitular;
        
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setDniTitular(String dniTitular) {
        this.dniTitular = dniTitular;
    }

    public String getDniTitular() {
        return dniTitular;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "numTarjeta=" + formateaNumeroTarjeta() + ", pin=" + pin + ", bloqueada=" + bloqueada + ", saldo=" + saldo + '}';
    }
    
    
    public static boolean esNumTarjetaValido(String numTarj){
        //Un numero de tarjeta es valido si consta de 16 dítitos
        if (numTarj.length() != 16){
            return false;
        }
        
        for (int i = 0; i < numTarj.length(); ++i){
            if (!FuncionesSobreCaracteres.esNumeroValido(numTarj.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean esPinValido(String p){
        //Un numero de tarjeta es valido si consta de 16 dítitos
        if (p.length() != 4){
            return false;
        }
        
        for (int i = 0; i < p.length(); ++i){
            if (!FuncionesSobreCaracteres.esNumeroValido(p.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    
    public String formateaNumeroTarjeta(){
        
        String cad = "";
        for (int i = 0; i < numTarjeta.length(); ++i){
            if (i % 4 == 0 && i != 0){
                cad += "-" + numTarjeta.charAt(i);
            }else{
                cad += numTarjeta.charAt(i);
            }
        }
        
        return cad;
    }
    
    //Estas operaciones se podran realizar siempre que la tarjeta no esta bloqueada
    
    public int reintegro(double cantidadDinero){
                       
            if (cantidadDinero < 0 ){
                return 1;
            }else if(cantidadDinero > saldo){                                    
                return 2;
            } else if (cantidadDinero > Banco.LIMITE_REINTEGRO){
                return 3;
            }else{
                saldo = saldo - cantidadDinero; 
                return 4;
            }
            
    }
    
    public int ingreso(double cantidadDinero){
        
        if (cantidadDinero < 0){
            return 1;
        } else if (cantidadDinero >  Banco.LIMITE_INGRESO){
            return 2;//("Error, no se puede ingresar mas de " + Banco.LIMITE_INGRESO);
        }else{       
            saldo = saldo + cantidadDinero;
            return 3;
        }
        //System.out.println("Su nuevo saldo:" + saldo);
                
        
    }
    
    public int transferencia(double cantidadDinero, int pos, Banco banco){
        
       if (cantidadDinero < 0 ){
                return 1;
            }else if(cantidadDinero > saldo){                                    
                return 2;
            } else if (cantidadDinero > Banco.LIMITE_REINTEGRO){
                return 3;
            } else{
            banco.gettTarjetas()[pos].setSaldo(banco.gettTarjetas()[pos].getSaldo() + cantidadDinero);
            saldo = saldo - cantidadDinero;            
            return 4;   //System.out.println("Nuevo saldo de la cta final:" + banco.gettTarjetas()[pos].formateaNumeroTarjeta() +" : " + banco.gettTarjetas()[pos].getSaldo());
                        // System.out.println("Nuevo saldo de la cta incial: " + this.formateaNumeroTarjeta() + " : " + saldo );
            
        }
        
    }
    
    public void limpiarTarjeta(){
        numTarjeta = "";
        pin = "";
        bloqueada = false;
        saldo = 0.0;
    }
    
   
    
    
    
    public static void main(String[] args){
        
//        Banco eBanco = new Banco(3);
//        
//        eBanco.gettTarjetas()[0].setNumTarjeta("0000111122223333");
//        eBanco.gettTarjetas()[0].setSaldo(100);
//        eBanco.gettTarjetas()[0].setPin("1234");
//        
//        eBanco.gettTarjetas()[1].setNumTarjeta("4444111122223333");
//        eBanco.gettTarjetas()[1].setSaldo(200);
//        eBanco.gettTarjetas()[1].setPin("1111");
//        
//        eBanco.gettTarjetas()[2].setNumTarjeta("5555111122223333");
//        eBanco.gettTarjetas()[2].setSaldo(300);
//        eBanco.gettTarjetas()[2].setPin("2222");
//        
//        
//        System.out.println(eBanco);
//        System.out.println("Reintegro");
//        System.out.println(eBanco.gettTarjetas()[0].getNumTarjeta());
//        eBanco.gettTarjetas()[0].reintegro();
//        
//        System.out.println(eBanco);
//        
//        
//        System.out.println("Ingreso");
//        System.out.println(eBanco.gettTarjetas()[1].getNumTarjeta());
//        eBanco.gettTarjetas()[1].ingreso();
//        
//     
//        System.out.println(eBanco);
//        
//        System.out.println("Transferencia");
//        System.out.println(eBanco.gettTarjetas()[2].getNumTarjeta());
//         
//        eBanco.gettTarjetas()[2].transferencia(eBanco);
//        System.out.println(eBanco);
        
        
        
        
        
        
        
    }
     
}
