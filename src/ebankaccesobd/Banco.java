/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class Banco implements Serializable{
    
    // Constante publicas de clase
    public final static int LIMITE_REINTEGRO = 600;
    public final static int LIMITE_INGRESO = 1000;
    
    private String nomBD;
    private String nomTablaClientes;
    private String nomTablaTarjetas;
    private Connection con;
    
//    private TarjetaCredito[] tTarjetas;

    public Banco(String nomBD, String nomTablaCli, String nomTablaTar, Connection con) throws SQLException, ClassNotFoundException {
        this.nomBD = nomBD;
        nomTablaClientes = nomTablaCli;
        nomTablaTarjetas = nomTablaTar;
        con = obtener(nomBD);
    }
    
        
    public Connection obtener(String nomBD) throws SQLException, ClassNotFoundException {
      
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/" + nomBD, "root", "root");
            System.out.println("Conexion exitosa");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      
     return con;
    }
    
    public void cerrar() throws SQLException {
      if (con != null) {
         con.close();
          System.out.println("Conexión cerrada con éxito");
      }
   }

    public String booleanToSQL(boolean valor){
        String vOf;
        if (valor) {
            vOf = "1";
        }else{
            vOf = "0";
        }
    return vOf;
    }
    
    public void alta(TarjetaCredito tar) throws SQLException{
        //Desde teclado se introducen los atributos de la tarjeta validandolos
        
        PreparedStatement consulta;
        
        consulta = con.prepareStatement(" INSERT INTO " + nomTablaTarjetas + " VALUES "
                + "(?,?,?,?,?)");
        
        try{
            consulta.setString(1, tar.getNumTarjeta());
            consulta.setString(2, tar.getPin());
            consulta.setString(3, String.valueOf(tar.getSaldo()));
            consulta.setString(4, booleanToSQL(tar.isBloqueada()));
            consulta.setString(5, tar.getDniTitular());
            consulta.execute();
        }catch(SQLException ex){
        throw new SQLException(ex);
        }        
    }
    
    public void baja(String numTar) throws SQLException{
        
        PreparedStatement consulta;
        
        consulta = con.prepareStatement("DELETE FROM " +nomTablaTarjetas+ " WHERE "
                + " numTarjeta = (?)");
        consulta.setString(1, numTar);
        consulta.execute();
        
        
    }
    
    public void modificacion(int posTar, Double saldo,String PIN, Boolean bloq ){
        
        tTarjetas[posTar].setSaldo(saldo);
        tTarjetas[posTar].setPin(PIN);
        tTarjetas[posTar].setBloqueada(bloq);
    }
    
    
    
    
    
    @Override
    public String toString(){
        boolean hayCuentas = false;
        String cad =  "Banco\n";
               cad += "-----\n";
               for (int i = 0; i < tTarjetas.length; ++i){
                   if (tTarjetas[i].getNumTarjeta().length() != 0){
                       cad += tTarjetas[i] + "\n";
                       hayCuentas = true;
                   }
               }
        if (!hayCuentas){
            cad += "Banco sin cuentas\n";
        }
        return cad;
    }
    
    public int buscaPosicion(String numTarjeta){
        // Busca la posición de numTarjeta en el array tTarjetas,
        // si no está devuelve -1
        
        for (int i = 0; i < tTarjetas.length; ++i){
            if (numTarjeta.compareTo(tTarjetas[i].getNumTarjeta()) == 0){
                return i;
            }
        }
        
        return -1;
    }
    
    
    
}