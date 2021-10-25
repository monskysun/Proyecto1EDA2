package proyectoeda1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MezclaEquilibrada {
    
    ManejoArch mane = new ManejoArch();
    Scanner guarda = new Scanner(System.in);
    File archivo1= new File("f1.txt");
    File archivo2 = new File("f2.txt");
    File archivo0= new File("f0.txt");
    ArrayList<ArrayList<Persona>> personas1 = new ArrayList<>();
    ArrayList<ArrayList<Persona>> personas2 = new ArrayList<>();
    ArrayList<Persona> pers1 = new ArrayList<>();
    ArrayList<Persona> pers2 = new ArrayList<>();
    
    public void mezclEqui(ArrayList<Persona> personas) {
	mane.EscribirArch(personas,"f0.txt");
        
        dividir(personas,archivo0,archivo1,archivo2);
        System.out.println("\n\nAl final -----------------------------------------\n"+personas1.toString());    //Pa ver que funcione
        System.out.println("");
        System.out.println(personas2.toString());
    }
    
    public void dividir(ArrayList<Persona> list,File archADividir, File archF1, File archF2){
        int i=0;
        boolean noOrdenado=false,entra=true;
        String inicio = "";
        Persona auxiliar;
        
        while(i<list.size()){
            String valor=list.get(i).getApellidos();
            auxiliar=list.get(i);
            
            if(valor.compareTo(inicio)>0){
                inicio=valor;
                if(!noOrdenado){
                    pers1.add(auxiliar);
                    
                    if(i+1==list.size()){                                   //Condición para la última iteración
                        ArrayList<Persona> pers3 = new ArrayList<>(pers1);  
                        if(!pers3.isEmpty()){
                            personas1.add(pers3);
                            
                        }
                        pers1.clear();
                        
                    }
                }else if(noOrdenado){
                    pers2.add(auxiliar);
                    if(i+1==list.size()){                                   //Condición para la última iteración
                        ArrayList<Persona> pers4 = new ArrayList<>(pers2);
                        if(!pers4.isEmpty()){
                            personas2.add(pers4);
                        }
                        pers2.clear();
                    }
                }

            }else{
                inicio=valor;
                ArrayList<Persona> pers3 = new ArrayList<>(pers1);      //Copia y vaciado de la primera lista
                if(!pers3.isEmpty()){
                    personas1.add(pers3);
                }
                pers1.clear();
                
                
                ArrayList<Persona> pers4 = new ArrayList<>(pers2);      //Copia y vaciado de la segunda lista tras ingresarse a la lista de listas
                if(!pers4.isEmpty()){
                    personas2.add(pers4);
                }
                pers2.clear();
                
                if(!noOrdenado){
                    pers2.add(auxiliar);
                    noOrdenado=entra;
                }else if(noOrdenado){
                    pers1.add(auxiliar);
                    noOrdenado=!entra;
                } 
            }
            i+=1;
            
        }
        if(!personas1.isEmpty()){           //Vaciado de la lista 1 de listas de personas en el archivo 1 (F1)
            if(pers1.size()==0){
                for(int j=0;j<personas1.size();j++){
                    for (int k = 0; k < personas1.get(j).size(); k++) {
                        mane.escribirArch(personas1.get(j).get(k),archivo1);
                    }
                }
            }  
        }
        if(!personas2.isEmpty()){           //Vaciado de la lista 2 de listas de personas en el archivo 2 (F2)
            if(pers2.size()==0){
                for(int j=0;j<personas2.size();j++){
                    for (int k = 0; k < personas2.get(j).size(); k++) {
                        mane.escribirArch(personas2.get(j).get(k),archivo2);
                    }
                }
            }  
        }
        
    }
    
    
    
    //Esto no lo usé
    /*
    public void dividirPersonas(ArrayList<Persona> personas,ArrayList<ArrayList<Persona>> personas1,ArrayList<ArrayList<Persona>> personas2,int nF1, int nF2) {
        while(personas.size()>0) {
            nF1=cambiodeLista(personas,personas1,nF1);
            if(personas.size()>0) {
                nF2=cambiodeLista(personas,personas2,nF2);
            }
        } 
    }
    public int cambiodeLista(ArrayList<Persona> personas, ArrayList<ArrayList<Persona>> personasx, int nF) { //personasx es el destino y personas el origen
        if(personas.size()==1) {
           // nF = nF + llenar.LlenarF1(personas,personasx); 
        }else if(personas.size()>1) {
            int i=0;
//            for (int i = 0; i<2; i++ )  
//                nF = nF + llenar.LlenarF1(personas,personasx);
            while(personas.get(i).getApellidos().compareTo(personas.get(i+1).getApellidos())<0){
                System.out.println(personas.get(i).getApellidos()+"  "+personas.get(i+1).getApellidos());
                i+=1;
            }
        }
        return nF;
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    public void imprimirAtrib(ArrayList<Persona> personas ){	
        for(int i = 0; i<personas.size();i++) {
            System.out.print(personas.get(i).getNombre()+" ");
            System.out.print(personas.get(i).getApellidos()+" ");
            System.out.print(personas.get(i).getClaves()+" \n");
        }
    }
    
}