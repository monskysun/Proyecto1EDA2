package proyectoeda1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

public class Comparacion {
	
	public void comparacion() {
	
		List<Integer> list = new ArrayList<>();
	    List<Integer> list1 = new ArrayList<>();
	    List<Integer> list11 = new ArrayList<>();
	    List<List<Integer>> list2 = new ArrayList<>();
	    List<List<Integer>> list3 = new ArrayList<>();
	    
	    int i=0,j=0;
	    int auxiliar=0;
	    boolean verd=true;
	    
	    list.add(12);
	    list.add(234);
	    list.add(133);
	    list.add(16);
	    list.add(43);
	    list.add(57);
	    list.add(5);
	  
	    while(i++<list.size()-1 && list.get(i++)<list.get((i++)+1)){
	    		System.out.println(list.get(j)+"<"+list.get(j+1));
	    	
	    }
	 
	}
}
