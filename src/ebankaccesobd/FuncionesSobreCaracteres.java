/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

/**
 *
 * @author Alberto
 */
public class FuncionesSobreCaracteres {
    
    
    public static boolean esNumeroValido(char car){
        return car >= '0' && car <= '9';
     
    }
    
    public static boolean esCaracterAlfabetico(char car){  // Character.isLetter(car)
        
        if (car >= 'A' && car <= 'Z'){
            return true;
        }
        return car >= 'a' && car <= 'z';
    }
    
    public static boolean esLetraValidaParaMatricula(char letra){
        char[] letrasValidasParaMatriculas = new char[]{'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 
                                                        'N', 'P', 'R', 'S', 'T', 'V', 'W', 'X', 'Y' , 'Z'};
        letra = Character.toUpperCase(letra);
        
        for (int i = 0; i < letrasValidasParaMatriculas.length; ++i){
            if (letrasValidasParaMatriculas[i] == letra){
                 return true;   
            }
        }
        return false;
    }
    
    public static boolean esDNIValido(String dni){
        String ndni="";
        char DNIletra, letraValidacion=' ';
        int nLetra;
        for (int i = 0; i < 8; i++) {
            ndni += dni.charAt(i);
        }
        DNIletra = dni.charAt(8);
        nLetra = Integer.parseInt(ndni)%23;
        
        switch(nLetra){
            case 0: letraValidacion = 'T';
                break;
            case 1: letraValidacion = 'R';
                break;
            case 2: letraValidacion = 'W';
                break;
            case 3: letraValidacion = 'A';
                break;
            case 4: letraValidacion = 'G';
                break;
            case 5: letraValidacion = 'M';
                break; 
            case 6: letraValidacion = 'Y';
                break;
            case 7: letraValidacion = 'F';
                break;
            case 8: letraValidacion = 'P';
                break;
            case 9: letraValidacion = 'D';
                break;
            case 10: letraValidacion = 'X';
                break;
            case 11: letraValidacion = 'B';
                break;
            case 12: letraValidacion = 'N';
                break;
            case 13: letraValidacion = 'J';
                break;
            case 14: letraValidacion = 'S'; 
                break;
            case 15: letraValidacion = 'Q';
                break;
            case 16: letraValidacion = 'V';
                break;
            case 17: letraValidacion = 'H';
                break;
            case 18: letraValidacion = 'L';
                break;
            case 19: letraValidacion = 'C';
                break;
            case 20: letraValidacion = 'K';
                break;
            case 21: letraValidacion = 'K';
                break;
            case 22: letraValidacion = 'E';
                break;
        }
        return DNIletra == letraValidacion;
    }
}
