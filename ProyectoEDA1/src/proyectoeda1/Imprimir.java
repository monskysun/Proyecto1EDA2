
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

/*



    
    for(i=0;i<list.size();i++){
        int  cont=0;
        while(list.get(i).charAt()<=list.get(i+1).charAt()){
            cont+=1;
        }
        for(j=i;j<(j+cont);j++){
            list.add(j,j+cont)
        }
        

    }


























*/