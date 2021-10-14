
package proyectoeda1;

import java.util.ArrayList;

public class Imprimir {
    
    public void imprimirAtrib(ArrayList<Persona> personas ){
		
        for(int i = 0; i<personas.size();i++) {
            System.out.print(personas.get(i).getNombre()+" ");//metodos siempre con minuscula para que no se confunda con clases o constructores
            System.out.print(personas.get(i).getApellidos()+" ");
            System.out.print(personas.get(i).getClaves()+" \n");
        }
    }
    
    
}
