package Proyecto1;

import java.util.ArrayList;

public class PoliPrueba {
	ManejoArch leerarch1 = new ManejoArch(); 
	
    ArrayList<Persona> bloque1 = new ArrayList<>();
    ArrayList<Persona> bloque2 = new ArrayList<>();
    ImprimirPersona imprimePersona = new ImprimirPersona();
    
	public void poliprueba(ArrayList<Persona> personas) {
		personas = leerarch1.LecturaArch("Archivo0.txt");    
		imprimePersona.imprimirNom(personas);
	}

}
