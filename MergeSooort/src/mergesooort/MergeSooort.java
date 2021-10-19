
package mergesooort;


import java.util.ArrayList;

public class MergeSooort {

    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("juan");
        lista.add("pedro");
        lista.add("sandero");
        lista.add("nidea");
        lista.add("david");
        lista.add("bertha");
        System.out.println(lista);
        MergeSort me = new MergeSort();
        me.mergeSort(lista,0,lista.size()-1);
        System.out.println(lista);
        
    }
    
}
