package Proyecto1;

import java.util.ArrayList;
	
	public class LlenarArchivos {
		
		public int LlenarF1(ArrayList<Persona> personas,ArrayList<Persona> personasx) {
			ImprimirPersona imprimePersona = new ImprimirPersona();
			int j =0;
			//Agrega a arch 1
			
			personasx.add(personas.get(0));
			j=j+1;
			personas.remove(personas.get(0));
				
			System.out.println("\nArch 2 sin ordenar: ");
			imprimePersona.imprimirNom(personasx);
		    System.out.println("\nOrdenado personas 1:");
			
		   	//insertion.insertionSort(personas1,personas1.size());
		    return j;
	
			}
	
	public int LlenarF2(ArrayList<Persona> personas,ArrayList<Persona> personasx) {
		int j =0;
		ImprimirPersona imprimePersona = new ImprimirPersona();
		
		personasx.add(personas.get(0));
		j= j+1;
		personas.remove(personas.get(0));
				
	    System.out.println("\nArch 3 sin ordenar: ");
		imprimePersona.imprimirNom(personasx);
	    System.out.println("\nOrdenado personas 2:");
	   // insertion.insertionSort(personas2,personas2.size());
	    
	    return j;
	
		}

}
