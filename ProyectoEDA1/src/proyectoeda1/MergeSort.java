
package proyectoeda1;
import java.util.ArrayList;
/* El algoritmo de ordenamiento interno merge sort esta basado en el paradigma divide y venceras, este divide la lista en dos sublistas y repite la particion hasta que los 
elementos quedan individualmente, una vez que se ha hecho esto ordena y junta de la mismo forma que los separo, hasta llegar a la lista original pero ordenada, en esta ocasion 
el algoritmo es capaz de trabajar con objetos especificamente con carcateres.*/
public class MergeSort {
    ImprimirPersona imprimePersona = new ImprimirPersona();
    
    public ArrayList<Persona> unir(ArrayList<Persona> personas1,ArrayList<Persona> personas2) {

    	ArrayList<Persona> personas3;
    	(personas3=  new ArrayList<>(personas1)).addAll(personas2);
        System.out.println("\n--------------------------------------");
    	
        mergeSort(personas3,0, personas3.size()-1);
        imprimePersona.imprimirNom(personas3);
        
    	return personas3;
    	
    }
    public void mergeSort(ArrayList<Persona> list,int p, int r){   
        char index;
        int q;
        
        if(p<r){
            q = (p+r)/2;
            mergeSort(list, p,q);
            mergeSort(list,q+1,r);
 
            merge(list,p,q,r);
        }
    }
    
    public void merge(ArrayList<Persona> list, int p, int q, int r) {
        int i;
        int j;
        i=p;
        j=q+1;
        ArrayList<Persona> list2 = new ArrayList<>();
        
        while (i <= q && j<=r) {
            if  (list.get(j).getApellidos().compareTo(list.get(i).getApellidos()) > 0) {
                list2.add(list.get(i++));
            } else {
                list2.add(list.get(j++));
            }
        }
        
        while (i <= q ) {
            list2.add(list.get(i++));
        }
        while (j <= r ) {
            list2.add(list.get(j++));
        }
        i=p;
        for (Persona var:list2) {
            list.set(i++, var);
        }
    }
    
}

