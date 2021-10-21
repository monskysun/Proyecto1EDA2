package Proyecto1;

import java.util.ArrayList;


public class ImprimirPersona {
	
	
	public void imprimirNom(ArrayList<Persona> personas ){
		
		for(int i = 0; i<personas.size();i++) {
			
			System.out.print(personas.get(i).getNombre()+" ");
			System.out.print(personas.get(i).getApellidos()+" ");
			System.out.print(personas.get(i).getClaves()+" \n");
	
    	}
    }


}
