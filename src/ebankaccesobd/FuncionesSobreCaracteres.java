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
}
