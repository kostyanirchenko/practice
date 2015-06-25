
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vitos
 */
public class MassivRandom {
    
     
    public static void main (String [] args){
        
        int massiv [] = new int [10];
        for (int i = 0; i<massiv.length; i++ ){
        massiv [i] =(int) (Math.random()*100);
        
        
        //System.out.println(massiv[i]);
        Arrays.sort(massiv);
        System.out.println(massiv[i]);
        
        
        }
    }
}
