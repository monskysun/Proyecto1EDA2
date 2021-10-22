/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeda1;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class LlenarArchivos {
    public int LlenarF1(ArrayList<Persona> personas,ArrayList<Persona> personas1) {
			ImprimirPersona imprimePersona = new ImprimirPersona();
			int j =0;
			//Agrega a arch 1
			
			personas1.add(personas.get(0));
			j=j+1;
			personas.remove(personas.get(0));
				
			System.out.println("\nArch 2 sin ordenar: ");
			imprimePersona.imprimirNom(personas1);
		    System.out.println("\nOrdenado personas 1:");
			
		    return j;
	
			}
	
	public int LlenarF2(ArrayList<Persona> personas,ArrayList<Persona> personas2) {
		int j =0;
		ImprimirPersona imprimePersona = new ImprimirPersona();
		
		personas2.add(personas.get(0));
		j= j+1;
		personas.remove(personas.get(0));
				
	    System.out.println("\nArch 3 sin ordenar: ");
		imprimePersona.imprimirNom(personas2);
	    System.out.println("\nOrdenado personas 2:");
	    
	    return j;
	
		}
}
