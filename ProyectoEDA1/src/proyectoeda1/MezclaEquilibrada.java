
package proyectoeda1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MezclaEquilibrada {
    ImprimirPersona imprimePersona = new ImprimirPersona();
    ManejoArch mane = new ManejoArch();
    Scanner guarda = new Scanner(System.in);
    MergeSort merg = new MergeSort();
    File archivo1= new File("f1.txt");
    File archivo2 = new File("f2.txt");
    File archivo0= new File("f0.txt");
    ArrayList<ArrayList<Persona>> personas1 = new ArrayList<>();
    ArrayList<ArrayList<Persona>> personas2 = new ArrayList<>();
    ArrayList<ArrayList<Persona>> personas3= new ArrayList<>();
    ArrayList<Persona> pers1 = new ArrayList<>();
    ArrayList<Persona> pers2 = new ArrayList<>();
    ArrayList<Persona> pers3 = new ArrayList<>();
    
    public void mezclEqui(ArrayList<Persona> personas) {
	mane.EscribirArch(personas,"f0.txt");
        
        dividir(personas,archivo1,archivo2);
        dividirPersonasx(personas1,personas2,personas3);
        
        imprimePersona.imprimirListList(personas3);
        pers3=mane.LecturaArch("f0.txt");
        
        dividir(pers3,archivo1,archivo2);
        
        dividirPersonasx(personas1,personas2,personas3);
        imprimePersona.imprimirListList(personas3);
        
    }
    
    public void dividir(ArrayList<Persona> list, File archF1, File archF2){
        ManejoArch.borrar("f1.txt");
        ManejoArch.borrar("f2.txt");
        personas1.clear();
        personas2.clear();
        int i=0;
        boolean noOrdenado=false;
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
                
                if(!noOrdenado){ //!true-> false
                    pers2.add(auxiliar);
                    noOrdenado=true;
                }else if(noOrdenado){
                    pers1.add(auxiliar);
                    noOrdenado=false;
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
    
    public void dividirPersonasx(ArrayList< ArrayList<Persona>> Personasix,ArrayList<ArrayList<Persona>> Personasiy,ArrayList<ArrayList<Persona>> Personasfy) {
        ManejoArch.borrar("f0.txt");
        Personasfy.clear();
        while(Personasix.size()>0||Personasiy.size()>0) {

            if(Personasiy.size()>0 && Personasix.size()>0) {
                Personasfy.add(merg.unir(Personasix.get(0),Personasiy.get(0)));
                Personasix.remove(0);
                Personasiy.remove(0);

            }else if(Personasiy.size()==1) {
                Personasfy.add(Personasiy.get(0));
                Personasiy.remove(0);
            }
           
        }
        if(!Personasfy.isEmpty()){           //Vaciado de la lista 1 de listas de personas en el archivo 1 (F1)
            for(int j=0;j<Personasfy.size();j++){
                for (int k = 0; k < Personasfy.get(j).size(); k++) {
                    mane.escribirArch(Personasfy.get(j).get(k),archivo0);
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void imprimirAtrib(ArrayList<Persona> personas ){	
        for(int i = 0; i<personas.size();i++) {
            System.out.print(personas.get(i).getNombre()+" ");
            System.out.print(personas.get(i).getApellidos()+" ");
            System.out.print(personas.get(i).getClaves()+" \n");
        }
    }
    
}
