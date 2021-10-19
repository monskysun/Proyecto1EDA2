
package mergesooort;

import java.util.ArrayList;

public class MergeSort {
    
    public void mergeSort(ArrayList<String> list,int p, int r){   
        
        int q;
        
        if(p<r){
            q = (p+r)/2;
            mergeSort(list, p,q);
            mergeSort(list,q+1,r);
 
            merge(list,p,q,r);
        }
    }
    
    public void merge(ArrayList<String> list, int p, int q, int r) {
        int i;
        int j;
        i=p;
        j=q+1;
        ArrayList<String> list2 = new ArrayList<>();
        
        while (i <= q && j<=r) {
            if  (list.get(j).compareTo(list.get(i)) > 0) {
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
        for (String var:list2) {
            list.set(i++, var);
        }
    }
    
}

