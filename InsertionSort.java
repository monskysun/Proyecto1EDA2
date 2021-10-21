package Proyecto1;

import java.util.ArrayList;

public class InsertionSort {

	
	
	void insertionSort(ArrayList<Persona> b, int n) {
		char index;
		
		ImprimirPersona imprimePersona = new ImprimirPersona();
		Persona personaIndex = new Persona();

				for(int i=1; i<b.size(); i++){
					personaIndex = b.get(i);
					index = b.get(i).getApellidos().charAt(0);
					int j=i-1;
					while ((j > -1) && (b.get(j).getApellidos().charAt(0)>index)){	
						b.set(j+1,  b.get(j));
						j--;
					}  
					b.set(j+1,  personaIndex);
				}
				imprimePersona.imprimirNom(b);
	}
}


