package EDA2Proyecto1;

import java.util.ArrayList;

public class Polifase {

	int n = 20;
	public void polifase(ArrayList<Persona> personas) {
		
		ManejoArch EscribirArch = new ManejoArch();
		EscribirArch.createArch();
		
		EscribirArch.EscribirArchPoli(personas);
	    
	}
	
}
