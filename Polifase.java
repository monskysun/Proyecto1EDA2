package EDA2Proyecto1;

import java.util.ArrayList;

public class Polifase {

	int n = 20, i =0;
	public void polifase(ArrayList<Persona> personas) {
		
		InsertionSort insertion = new InsertionSort();

		ImprimirPersona imprimePersona = new ImprimirPersona();

		ManejoArch leerarch1 = new ManejoArch(); 

		ManejoArch EscribirArch = new ManejoArch();
		EscribirArch.createArch();
	
		
			personas = leerarch1.LecturaArch();
			
			System.out.println("\nSin ordenar: ");
		    imprimePersona.imprimirNom(personas);
		    System.out.println("\nOrdenado:");
	       	insertion.insertionSort(personas,n);
			
			EscribirArch.EscribirArchPoli(personas);
			
	    
	}
	
}
