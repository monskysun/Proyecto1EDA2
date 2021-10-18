package EDA2Proyecto1;

import java.util.ArrayList;

public class Polifase {

	int n = 20, i =0;
	public void polifase(ArrayList<Persona> personas) {
		
		InsertionSort insertion = new InsertionSort();

		ImprimirPersona imprimePersona = new ImprimirPersona();

		ManejoArch leerarch1 = new ManejoArch(); 

		ManejoArch Arch2 = new ManejoArch();
		
		ManejoArch Arch3 = new ManejoArch();
		
		ArrayList<Persona> personas2 = new ArrayList<>();
		
		Arch2.createArch();
		Arch3.createArch();
		
		
		
			personas = leerarch1.LecturaArch();
			
			for(int i = 0; i<20; i++) {
				personas2.add(personas.get(i));
				personas.remove(personas.get(0));
				
				}
			
			System.out.println("\nArch 2 sin ordenar: ");
			imprimePersona.imprimirNom(personas2);
		    System.out.println("\nOrdenado:");
			
	       	insertion.insertionSort(personas2,personas2.size());
			Arch2.EscribirArchPoli(personas2);
			
			
			System.out.println("\nOriginal ");
		    imprimePersona.imprimirNom(personas);

		    personas.remove(personas.get(1));
		
		    
		  
	}
	
}
