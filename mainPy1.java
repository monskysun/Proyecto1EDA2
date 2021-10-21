package EDA2Proyecto1;
import java.io.File; //Para trabajar con archivos
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter; // Para escribir en archivos
import java.io.IOException; //Para arrojar errores
public class mainPy1 {
	
		public static void main(String[] args) 
		{
		Scanner guarda = new Scanner(System.in);
	    RadixExterno rdx=new RadixExterno();
	    ArrayList<Persona> personas = new ArrayList<>();

	    int opcion=0;

	    System.out.println("\t\tBIENVENIDO\n");

		ManejoArch leerarch1 = new ManejoArch(); 


       	//Polifase poli = new Polifase();
       	//poli.polifase(personas);
		
		MezclaEquilibrada  mezcla = new MezclaEquilibrada();
		mezcla.MezclaEquilibrada(personas);
		
		
      
        	
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
