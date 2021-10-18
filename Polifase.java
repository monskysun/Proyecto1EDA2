package EDA2Proyecto1;

import java.util.ArrayList;

public class Polifase {

	int n = 20, i =0;
	public void polifase(ArrayList<Persona> personas) {
		
		InsertionSort insertion = new InsertionSort();

		ImprimirPersona imprimePersona = new ImprimirPersona();

		ManejoArch leerarch1 = new ManejoArch(); 

		ManejoArch Arch1 = new ManejoArch();
		
		ManejoArch Arch2= new ManejoArch();
		
		ArrayList<Persona> personas1 = new ArrayList<>();
		ArrayList<Persona> personas2 = new ArrayList<>();
		
		int nF1 = 0,nF2 = 0;
		
		Arch1.createArch("Archivo1.txt");
		Arch2.createArch("Archivo2.txt");
		personas = leerarch1.LecturaArch();
		
		
		
			//Agrega a arch 1
			nF1 = nF1+ LenarF1(personas,personas1);// vale 2 claves

			
			 //Agrega a arch 2
			    
			nF2 = nF2 + LenarF2(personas,personas2);
		
			    Arch1.EscribirArchPoli(personas1,"Archivo1.txt",2);
				System.out.println("\nOriginal ");
			    imprimePersona.imprimirNom(personas);
			    Arch2.EscribirArchPoli(personas2,"Archivo2.txt",2);
				System.out.println("\nOriginal ");
				System.out.println("\n Personas ="+personas.size());
			    imprimePersona.imprimirNom(personas);
			    
			}
	public int LenarF1(ArrayList<Persona> personas,ArrayList<Persona> personas1) {
			ImprimirPersona imprimePersona = new ImprimirPersona();
			int j =0;
			//Agrega a arch 1
			for(int i = 0; i<2; i++) {
				personas1.add(personas.get(0));
				j++;
				personas.remove(personas.get(0));
				}
			System.out.println("\nArch 2 sin ordenar: ");
			imprimePersona.imprimirNom(personas1);
		    System.out.println("\nOrdenado:");
			
		   	//insertion.insertionSort(personas1,personas1.size());
		    return j;
  
			}
	
	public int LenarF2(ArrayList<Persona> personas,ArrayList<Persona> personas2) {
		int j =0;
		ImprimirPersona imprimePersona = new ImprimirPersona();
		for(int i = 0; i<2; i++) {
			personas2.add(personas.get(0));
			j++;
			personas.remove(personas.get(0));
				}
	    System.out.println("\nArch 3 sin ordenar: ");
		imprimePersona.imprimirNom(personas2);
	    System.out.println("\nOrdenado:");
	   // insertion.insertionSort(personas2,personas2.size());
	    
	    return j;

		}
		    
		
	
	
}
