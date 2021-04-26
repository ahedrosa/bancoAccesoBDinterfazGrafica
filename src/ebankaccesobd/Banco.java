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
    
    public boolean sqlToBoolean(String res){
        
        if (res.compareTo("1")== 0){
            return true;
        }else if (res.compareTo("0")==0) {
            return false;
        }else{
            System.out.println("Error al transformar \"bloqueada\" de sql a java");
            return false;
        }        
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
    
    public void altaCliente(Cliente cli) throws SQLException{
        //Desde teclado se introducen los atributos de la tarjeta validandolos
        
        PreparedStatement consulta;
        
        consulta = con.prepareStatement("INSERT INTO " + nomTablaClientes + " VALUES "
                + "(?,?,?,?,?,?,?)");
        
        try{
            consulta.setString(1, cli.getDNI());
            consulta.setString(2, cli.getNombre());
            consulta.setString(3, cli.getAp1());
            consulta.setString(4, cli.getAp2());
            consulta.setString(5, cli.getDireccion());
            consulta.setString(6, cli.getTelefono());
            consulta.setString(7, cli.getEmail());
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
    
    public void modificacion(String numTar, String saldo,String PIN, Boolean bloq, String DNI ) throws SQLException{
        String  sBloq;
        
        
        sBloq = booleanToSQL(bloq);
        
        PreparedStatement consulta;
        
        consulta = con.prepareStatement("UPDATE "+nomTablaTarjetas+" SET pin = ? ,"
                + " saldo = ? , bloqueada = ?, dniTitular = ? WHERE numTar = ? ");
        consulta.setString(1, PIN);
        consulta.setString(2, saldo);
        consulta.setString(3, sBloq);
        consulta.setString(4, DNI);
        consulta.setString(5, numTar);
        consulta.execute();
        
    }
    
    public TarjetaCredito devuelveTarjeta(String numTar) throws SQLException{
        TarjetaCredito  tarjeta = null;
        PreparedStatement consulta = con.prepareCall("SELECT * FROM "+nomTablaTarjetas+
                " WHERE numTar = ?");
        
        consulta.setString(1, numTar);
        ResultSet resultado = consulta.executeQuery();
        
        while (resultado.next()) {
            tarjeta = new TarjetaCredito(
                resultado.getString(1),
                resultado.getString(2),
                Double.parseDouble(resultado.getString(3)),
                sqlToBoolean(resultado.getString(4)),
                resultado.getString(5)
                );            
        }
        
        return tarjeta;
    }
    
    public String buscaDNICliente(String dni) throws SQLException{
        String dniConsulta = null;
        PreparedStatement consulta = con.prepareStatement("SELECT DNI FROM "+nomTablaClientes+
                " WHERE DNI = ?");
        consulta.setString(1, dni);
        ResultSet resulado = consulta.executeQuery();
        
        while(resulado.next()){
            dniConsulta = resulado.getString(1);
        }
        return dniConsulta;
    }
    
    public String buscaNtarjeta(String nTar) throws SQLException{
        String numero = null;
        PreparedStatement consulta = con.prepareStatement("SELECT numTar FROM "+nomTablaTarjetas+
                " WHERE numTar = ?");
        consulta.setString(1, nTar);
        ResultSet resulado = consulta.executeQuery();
        
        while(resulado.next()){
            numero = resulado.getString(1);
        }
        return numero;
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
    
    public boolean esEmailValido(String email) throws SQLException{
        PreparedStatement consulta = con.prepareCall("SELECT ? regexp "
                + " '^[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,6}$'");
        consulta.setString(1, email);
        
        ResultSet resultado = consulta.executeQuery();
        boolean valido = false;
        while (resultado.next()) {            
            valido = sqlToBoolean(resultado.getString(1));  
        }
        return valido;
    }
    
    public Cliente recuperaCliente(String dni) throws SQLException{
        Cliente cli = null;
        PreparedStatement consulta = con.prepareCall("SELECT * FROM "+nomTablaClientes+ 
                " WHERE dni = ?");
        consulta.setString(1, dni);
        ResultSet respuesta = consulta.executeQuery();
        
        while (respuesta.next()) {            
            cli = new Cliente(dni,
                    respuesta.getString(2),
                    respuesta.getString(3),
                    respuesta.getString(4),
                    respuesta.getString(5),
                    respuesta.getString(6),
                    respuesta.getString(7));
            
        }
        return cli;
    }
    

    public ArrayList<ClienteAux> obtenerCliDNInom() throws SQLException{
        
//        String[] cliente = new String[2];
        String nom, dni;
        ArrayList<ClienteAux> tabla = new ArrayList<>();
        
        PreparedStatement consulta = con.prepareStatement("SELECT DNI, nombre FROM "+nomTablaClientes+" "
                + " ORDER BY nombre ;");
        ResultSet resultado = consulta.executeQuery();
        
        while (resultado.next()) {
            dni = resultado.getString("DNI");
            nom = resultado.getString("nombre");
            tabla.add(new ClienteAux(dni, nom));            
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
        
        String cad =  "Listado de Clientes con sus respectivas cuentas en eBanco\n";
               cad += "---------------------------------------------------------------------------------\n";
               
        ArrayList <ClienteAux> cliente = obtenerCliDNInom();
        if (!cliente.isEmpty()) {
                    
            for (int i = 0; i < cliente.size(); ++i){

            cad += "Cliente: \n\n";
            cad += "DNI:\t"+ cliente.get(i).getDni()+ "\n";
            cad += "Nombre:\t"+ cliente.get(i).getNombre() +"\n";
            cad += "Cuentas asociadas a este Cliente:\n\n";
            ArrayList<String> cuentas = obtenerCuentasPorCliente(cliente.get(i).getDni());
                if (!cuentas.isEmpty()){
                    for (int j = 0; j < cuentas.size(); j++) {
                        cad +="\t"+ (j+1) + ". " +cuentas.get(j)+"\n";
                    }
                    
                }else{
                    cad += "Este Cliente no tiene asociada ninguna cuenta \n";
                }
            cad += "-----------------------------------------------------------------------\n";
            
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
