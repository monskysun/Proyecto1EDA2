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
		
		Arch1.createArch("Archivo1.txt");
		Arch2.createArch("Archivo2.txt");
		personas = leerarch1.LecturaArch();
		
		//-------------------------------------------------
			
			for(int i = 0; i<20; i++) {
				personas1.add(personas.get(0));
				personas.remove(personas.get(0));
				
				}
			
			System.out.println("\nArch 2 sin ordenar: ");
			imprimePersona.imprimirNom(personas1);
		    System.out.println("\nOrdenado:");
			
	       	insertion.insertionSort(personas1,personas1.size());
			Arch1.EscribirArchPoli(personas1,"Archivo1.txt");
			
			System.out.println("\nOriginal ");
		    imprimePersona.imprimirNom(personas);
		    
		  //-------------------------------------------------
		    
		    
		    for(int i = 0; i<20; i++) {
		    	//System.out.println("Tomadas:");
				personas2.add(personas.get(0));
				//imprimePersona.imprimirNom(personas2);
		    	//System.out.println("Tomando:");
		    	//imprimePersona.imprimirNom(personas);
				personas.remove(personas.get(0));
				
				
				}
			
			
		    
		 
			
		    System.out.println("\nArch 3 sin ordenar: ");
			imprimePersona.imprimirNom(personas2);
		    System.out.println("\nOrdenado:");
			
		    insertion.insertionSort(personas2,personas2.size());
			Arch2.EscribirArchPoli(personas2,"Archivo2.txt");
			
			System.out.println("\nOriginal ");
		    imprimePersona.imprimirNom(personas);
		    
		    
		  
	}
	
}
