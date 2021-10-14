
package proyectoeda1;

import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoEDA1 {

    public static void main(String[] args) {
        
        Scanner guarda = new Scanner(System.in);
        RadixExterno rdx=new RadixExterno();
        ArrayList<Persona> personas = new ArrayList<>();
        ManejoArch leerarch1 = new ManejoArch();
        
        leerarch1.LecturaArch(personas);
        
	int opcion=0;

	System.out.println("\t\tBIENVENIDO\n");
		
	//Arch1.createArch();
	//ManejoArch EscribirArch = new ManejoArch();
	//EscribirArch.EscribirArch();
	
	while(opcion!=4){
	    System.out.println("\nSelecciona un algoritmo de ordenamiento externo");
	    System.out.println("1)Polifase  2) Mezcla 3)Radix Sort  4)Salir");
	    opcion=guarda.nextInt();
            
            
	    switch(opcion){ 
		case 1:// Poli
                    break;
		case 2:// Mezcla	
                    break;
		case 3:// Radix	
                    //rdx.radixExtrn(leerarch1);     //Asociar con la lista "claves"
                    break;
		case 4:// salir		
                    break;
		default:
		    System.out.println("\tSELECCIONA UNA OPCIÓN VÁLIDA\n"); 
		             
		}
	}
	System.out.println("\n\tHASTA LUEGO:)\n");
    }
}
