package EDA2Proyecto1;

import java.util.ArrayList;

public class InsertionSort {

	
	
	void insertionSort(ArrayList<Persona> b, int n) {
		int i,j,k;
		char aux;
		char index;
			
			
			    for(i = 0; i<n;i++) {
			    	System.out.println(b.get(i).getApellidos());
			    	System.out.println(b.get(i).getApellidos().charAt(0));
			    	//System.out.println(b.get(i));
			    	
			    	}
			    
				for(i=1; i<n; i++){
					index = b.get(i).getApellidos().charAt(0);
					j=i-1;
					System.out.println("index: "+index);
					
		
				while (j>0 && b.get(j).getApellidos().charAt(0)>index){	
					System.out.println("b.(j+1):"+b.get(j+1).getApellidos());
						j--;
				}  
				
				 b.set(j+1,  b.get(i));

				}
				
			    
				
				System.out.println("------------------Ordenado---------------------");
				 for(i = 0; i<n;i++) {
				    	System.out.println(b.get(i).getApellidos());
				    	System.out.println(b.get(i).getApellidos().charAt(0));
				    	//System.out.println(b.get(i));
				    	}
	}
}

