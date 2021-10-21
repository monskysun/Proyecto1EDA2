package Proyecto1;

import java.util.ArrayList;

public class MergeSort {
	ImprimirPersona imprimePersona = new ImprimirPersona();
    public void mergeSort(ArrayList<Persona> list,int p, int r){    //p= inicio, r= tam lista, q valor de enmedio
        int q;
        if(p<r){
            q = (p+r)/2;

            //ordenamiento recursivo
            mergeSort(list, p,q); //inicia en p, termina en la mitad
            System.out.println("Entro y salio de mergeSort 1\n");
        	System.out.println("-----------------------------\n");

            mergeSort(list,q+1,r); //inicia en la mitad + 1, termina al final 
            System.out.println("Entro y salio de mergeSort 2\n");

            System.out.println("-----------------------------\n");
            //union
            merge(list,p,q,r);
            System.out.println("Entro y salio de merge \n ");
            
            System.out.println("-----------------------------\n");
        }
    }

    public void merge(ArrayList<Persona> list, int p, int q, int r) { //p= inicio, r= tam lista, q valor de enmedio
        int i;
        int j;
        i=p; // i = inicio
        j=q+1; // j = mitad + 1
        ArrayList<Persona> list2 = new ArrayList<>();
        System.out.println("Lista 1\n");
        imprimePersona.imprimirNom(list);
        System.out.println("Lista 2\n");
        imprimePersona.imprimirNom(list2);
        while (i <= q && j<=r) {
            if  (list.get(j).getApellidos().compareTo(list.get(i).getApellidos()) > 0) {
                list2.add(list.get(i++));
            } else {
                list2.add(list.get(j++));
            }
        }
        System.out.println("Lista 2\n");
        imprimePersona.imprimirNom(list2);
        while (i <= q ) {
            list2.add(list.get(i++));
        }
        System.out.println("Lista 2\n");
        imprimePersona.imprimirNom(list2);
        while (j <= r ) {
            list2.add(list.get(j++));
        }
        System.out.println("Lista 2\n"); 
        imprimePersona.imprimirNom(list2);
        i=p;
        for (Persona var:list2) {
            list.set(i++, var);
        }
        System.out.println("Lista 1\n");
        imprimePersona.imprimirNom(list);
    }
    
    // List<String> resultList3;
    //(resultList3 = new ArrayList<String>(list1)).addAll(list2);
    //ArrayList<Persona> personas1 = new ArrayList<>()
    
    public ArrayList<Persona> unir(ArrayList<Persona> personas1,ArrayList<Persona> personas2) {

    	ArrayList<Persona> personas3;
    	(personas3=  new ArrayList<>(personas1)).addAll(personas2);
    	imprimePersona.imprimirNom(personas3);
    	return personas3;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}