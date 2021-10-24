/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeda1;
import java.util.ArrayList;


public class ImprimirPersona {
	
	
    public void imprimirNom(ArrayList<Persona> personas ){

        for(int i = 0; i<personas.size();i++) {

            System.out.print(personas.get(i).getNombre()+" ");
            System.out.print(personas.get(i).getApellidos()+" ");
            System.out.print(personas.get(i).getClaves()+" \n");

        }
    }
    
    public void imprimirListList(ArrayList<ArrayList<Persona>> personasLisLis ){
        System.out.println("***************************");
        for (int i = 0; i < personasLisLis.size(); i++) {
            imprimirNom(personasLisLis.get(i));
            System.out.println("");
        }
    }


}