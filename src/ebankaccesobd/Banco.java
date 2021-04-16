/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Banco{
    
    // Constante publicas de clase
    public final static int LIMITE_REINTEGRO = 600;
    public final static int LIMITE_INGRESO = 1000;
    
    private String nomBD;
    private String nomTablaClientes;
    private String nomTablaTarjetas;
    private Connection con;
    
//    private TarjetaCredito[] tTarjetas;

    public Banco(String nomBD, String nomTablaCli, String nomTablaTar) throws SQLException, ClassNotFoundException {
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
                + " numTar = (?)");
        consulta.setString(1, numTar);
        consulta.execute();
        
        
    }
    
    public void modificacion(String numTar, Double saldo,String PIN, Boolean bloq ) throws SQLException{
        String sSaldo, sBloq;
        
        sSaldo = String.valueOf(saldo);
        sBloq = booleanToSQL(bloq);
        
        PreparedStatement consulta;
        
        consulta = con.prepareStatement("UPDATE "+nomTablaTarjetas+" SET pin = ? ,"
                + " saldo = ? , bloqueada = ? WHERE numTar = ? ");
        consulta.setString(1, PIN);
        consulta.setString(1, sSaldo);
        consulta.setString(1, sBloq);
        consulta.setString(1, numTar);
        consulta.execute();
        
    }
    
    public ArrayList <TarjetaCredito> recuperarTodasCuentas() throws SQLException{
      ArrayList <TarjetaCredito> arrayListTarjetasCredito= new ArrayList();
      try{
        PreparedStatement consulta = con.prepareStatement("SELECT numTar, pin, saldo"
                + ", dniTitular FROM " + nomTablaTarjetas + " ORDER BY numTar");
        ResultSet resultado = consulta.executeQuery();
         
        while(resultado.next()){
            arrayListTarjetasCredito.add(new TarjetaCredito(resultado.getString("numTar"),
                    resultado.getString("pin"), Double.parseDouble(resultado.getString("saldo")),
                    resultado.getString("dniTitular")));
        }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return arrayListTarjetasCredito;
   }   
    
    
    

    public ArrayList<String[]> obtenerCliDNInom() throws SQLException{
        
        String[] cliente = new String[2];
        ArrayList<String[]> tabla = new ArrayList<>();
        
        PreparedStatement consulta = con.prepareStatement("SELECT DNI, nombre FROM "+nomTablaClientes+" "
                + " ORDER BY nombre ;");
        ResultSet resultado = consulta.executeQuery();
        
        while (resultado.next()) {
            cliente[0] = resultado.getString("DNI");
            cliente[1] = resultado.getString("nombre");
            tabla.add(cliente);            
        }
                
        return tabla;
    }
    
    public ArrayList<String> obtenerCuentasPorCliente(String dniCli) throws SQLException{
        ArrayList<String> cuentas = new ArrayList<>();
        
        PreparedStatement consulta = con.prepareStatement("SELECT numTar FROM "+nomTablaTarjetas
                + " WHERE dniTitular = ?;" );
            consulta.setString(1, dniCli);
        ResultSet resultado = consulta.executeQuery();
        
        while (resultado.next()) {
            cuentas.add(resultado.getString("numTar"));            
        }
                
        return cuentas;
    }
    
    
    
    public String listadoCliCuentas() throws SQLException{
        boolean hayCuentas = false;
        boolean tieneCuentas = false;
        String cad =  "Listado de Clientes con sus respectivas cuentas en eBanco\n";
               cad += "------------------------------------------------------------------------\n";
               
        ArrayList <String[]> cliente = obtenerCliDNInom();
        if (!cliente.isEmpty()) {
                    
            for (int i = 0; i < cliente.size(); ++i){

            cad += "Cliente: \n\n";
            cad += "DNI:\t"+ cliente.get(i)[0]+ "\n";
            cad += "Nombre:\t"+ cliente.get(i)[1]+ "\n";
            cad += "Cuentas asociadas a este Cliente:\n\n";
            ArrayList<String> cuentas = obtenerCuentasPorCliente(cliente.get(i)[0]);
                if (!cuentas.isEmpty()){
                    for (int j = 0; j < cuentas.size(); j++) {
                        cad +="\t"+ (j+1) + ". " +cuentas.get(j)+"\n";
                    }
                    
                }else{
                    cad += "Este Cliente no tiene asociada ninguna cuenta \n";
                }
            cad += "------------------------------------------------------------------\n";
            
            }
        }else{
            cad += "Banco sin cuentas\n";
        }
        return cad;
    }
    
    public String listadoCuentas() throws SQLException{
        boolean hayCuentas = false;
        String cad =  "Listado de cuentas en Banco\n";
               cad += "------------------------------\n";
               
        ArrayList <TarjetaCredito> listado = recuperarTodasCuentas();
               for (int i = 0; i < listado.size(); ++i){
                   
                cad += (listado.get(i).getNumTarjeta()+"\n");
                cad += "------------------------------\n";
                hayCuentas = true;
                  
               }
        if (!hayCuentas){
            cad += "Banco sin cuentas\n";
        }
        return cad;
    }
    
    
    
    
    
}
