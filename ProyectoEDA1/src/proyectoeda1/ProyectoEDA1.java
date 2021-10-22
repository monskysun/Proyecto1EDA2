
package proyectoeda1;
import java.util.ArrayList;
import java.util.Scanner;
public class ProyectoEDA1 {
	
		public static void main(String[] args) 
		{
		Scanner guarda = new Scanner(System.in);
	    RadixExterno rdx=new RadixExterno();
	    ArrayList<Persona> personas = new ArrayList<>();
             Scanner sc = new Scanner(System.in);

	    int opcion=0;
	    System.out.println("\t\tBIENVENIDO\n");
            System.out.print("Introduzca el nombre del archivo:  (Archivo.txt) ");  ////////
            String nombreArchivo=sc.nextLine();                                     ///////
		ManejoArch leerarch1 = new ManejoArch(); 
                
                Polifase poli = new Polifase();
                //poli.polifase(personas);
                rdx.radixExtrn(leerarch1.LecturaArch(nombreArchivo));                   ///////
        	
		//while(opcion!=4){
//		    System.out.println("\nSelecciona un algoritmo de ordenamiento externo");
//		    System.out.println("1)Polifase  2) Mezcla 3)Radix Sort  4)Salir");
//		    //opcion=guarda.nextInt();
//		   
//		        
//		    switch(opcion){ 
//			case 1:// Poli
//		                break;
//			case 2:// Mezcla	
//		                break;
//			case 3:// Radix	
//		            
//		                break;
//			case 4:// salir		
//		                break;
//			default:
//			    System.out.println("\tSELECCIONA UNA OPCIÓN VÁLIDA\n"); 
//			             
//			}
		//}
		System.out.println("\n\tHASTA LUEGO:)\n");
			}
}