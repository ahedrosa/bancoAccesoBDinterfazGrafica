/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

/**
 *
 * @author LilCucumbah
 */
public class Cliente {
    
    private String DNI;
    private String nombre;
    private String ap1;
    private String ap2;
    private String direccion;
    private String telefono;
    private String email;

    public Cliente(String DNI, String nombre, String ap1, String ap2, 
            String direccion, String telefono, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    
    public static String asignaLetraDNI(String dni){
        int n = 0;
        int nif;
        nif = Integer.parseInt(dni);
        String[] letrasDni = new String[]{"T","R","W","A","G","M","Y",
                                        "F","P","D","X","B","N","J","S",
                                        "Q","V","H","L","C","K","E"}; 
        n = nif%23;
        
        return letrasDni[n];
    }
    
    
}
