package Proyecto1;
import java.util.ArrayList;
public class MezclaEquilibrada {
	
	ManejoArch mane = new ManejoArch();
    LlenarArchivos llenar = new LlenarArchivos();
    ArrayList<Persona> personas1 = new ArrayList<>();
    ArrayList<Persona> personas2 = new ArrayList<>();
    ArrayList<Persona> personas3 = new ArrayList<>();
    
    public void mezclEqui(ArrayList<Persona> personas) {
    	 ManejoArch leerarch1 = new ManejoArch(); 
    	
    	//personas = leerarch1.LecturaArch();    
	//imprimirAtrib(personas);
        int nF1=0,nF2=0;
        mane.createArch("f1.txt");
        mane.createArch("f2.txt");
        mane.createArch("f0.txt");
        
        dividirPersonas(personas,personas1,personas2,nF1,nF2);
    }
    
    public void dividirPersonas(ArrayList<Persona> personas,ArrayList<Persona> personas1,ArrayList<Persona> personas2,int nF1, int nF2) {
        while(personas.size()>0) {
            nF1=cambiodeLista(personas,personas1,nF1);
            if(personas.size()>0) {
                nF2=cambiodeLista(personas,personas2,nF2);
            }
        } 
    }
    public int cambiodeLista(ArrayList<Persona> personas, ArrayList<Persona> personasx, int nF) { //personasx es el destino y personas el origen
        if(personas.size()==1) {
            nF = nF + llenar.LlenarF1(personas,personasx); 

        }else if(personas.size()>1) {
            int i=0;
//            for (int i = 0; i<2; i++ )  
//                nF = nF + llenar.LlenarF1(personas,personasx);
            while(comparacion(personas, personas.size())!=0){
                System.out.println(personas.get(i).getApellidos()+"  "+personas.get(i+1).getApellidos());
                i++;
            }
        }
        return nF;
    }
    
    public int comparacion(ArrayList<Persona> personas, int n) { 
    	for( int i = 0;i<n-1;i++){
            if(personas.get(i).getApellidos().charAt(0)>personas.get(i+1).getApellidos().charAt(0))// no ordenado 
                return 1;
        }
        return 0;
       
    }
    
    

}