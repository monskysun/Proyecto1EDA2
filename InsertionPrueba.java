package EDA2Proyecto1;


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class InsertionPrueba {
	
	
	 
		
	public static void insertionSort(char apellidos []) {  
		
		
        int n = apellidos.length;  
        for (int i = 1; i < n; i++) {  
            char key = apellidos[i];  
            int j = i-1;  
            while ( (j > -1) && ( apellidos [j] > key ) ) {  
            	apellidos [j+1] = apellidos [j];  
                j--;  
            }  
            apellidos[j+1] = key;  
        }  
 
       
	}
	
	
	
	public static void imprime(char apellidos []) {  
		
		for (int j = 0; j < apellidos.length; j++) 
			System.out.println("Ape: "+apellidos [j]);
        }  
}
