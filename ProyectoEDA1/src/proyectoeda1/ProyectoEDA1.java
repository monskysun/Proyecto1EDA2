
package proyectoeda1;
import java.util.ArrayList;
import java.util.Scanner;
public class ProyectoEDA1 {
	
    public static void main(String[] args){
	Scanner guarda = new Scanner(System.in);
	ArrayList<Persona> personas = new ArrayList<>();
        
	ManejoArch leerarch1 = new ManejoArch();
        Polifase poli = new Polifase();
        RadixExterno rdx=new RadixExterno();
        MezclaEquilibrada mezc = new MezclaEquilibrada();
        
        
        
        int opcion=0;	
        System.out.println("\t\tBIENVENIDO\n");
        System.out.print("Introduzca el nombre del archivo:  (Archivo.txt) "); 
        String nombreArchivo=guarda.nextLine();                                  
        
        //poli.polifase2(personas);
        
        mezc.mezclEqui(leerarch1.LecturaArch(nombreArchivo));
        //rdx.radixExtrn(leerarch1.LecturaArch(nombreArchivo));
                
	//while(opcion!=4){
//          System.out.println("\nSelecciona un algoritmo de ordenamiento externo");
//          System.out.println("1)Polifase  2) Mezcla 3)Radix Sort  4)Salir");
//		//opcion=guarda.nextInt();
//		   
//		        
//          switch(opcion){ 
//			case 1:// Poli
//		                break;
//			case 2:// Mezcla
//                                mezc.mezclEqui(leerarch1.LecturaArch(nombreArchivo));
//		                break;
//			case 3:// Radix	
//		            rdx.radixExtrn(leerarch1.LecturaArch(nombreArchivo));
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