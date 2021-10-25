
package proyectoeda1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MezclaEquilibrada {
    ImprimirPersona imprimePersona = new ImprimirPersona();
    ManejoArch mane = new ManejoArch();
    Scanner guarda = new Scanner(System.in);
    MergeSort merg = new MergeSort();
    File archivo1= new File("f1.txt"); //archivo auxiliar 1
    File archivo2 = new File("f2.txt"); //archivo auxiliar 2
    File archivo0= new File("f0.txt"); //archivo que sustituira al original para que el usario pueda visualizar el cambio
    ArrayList<ArrayList<Persona>> personas1 = new ArrayList<>(); // listas de listas para poder hacer las fusiones con las posiciones correctas (lista prinicipal)
    ArrayList<ArrayList<Persona>> personas2 = new ArrayList<>();
    ArrayList<ArrayList<Persona>> personas3= new ArrayList<>(); 
    ArrayList<Persona> pers1 = new ArrayList<>(); // la lista de lista (lista secundaria)
    ArrayList<Persona> pers2 = new ArrayList<>();
    ArrayList<Persona> pers3 = new ArrayList<>();
	
    public void mezclEqui(ArrayList<Persona> personas) { // metodo que manda llamar todos los metodos abajo descritos, por el momento solo realiza dos iteraciones
        int  i=0;
	mane.EscribirArch(personas,"f0.txt");
        
        dividir(personas,archivo1,archivo2);
        dividirPersonasx(personas1,personas2,personas3);
        
        imprimePersona.imprimirListList(personas3);
        
        pers3=mane.LecturaArch("f0.txt");
        while(i<pers3.size()){
            dividir(pers3,archivo1,archivo2);
            dividirPersonasx(personas1,personas2,personas3);
            i+=1;
        }
        imprimePersona.imprimirListList(personas3);
    }
    
    
    public void dividir(ArrayList<Persona> list, File archF1, File archF2){
	/* Realiza el encapsualamiento de los bloques ordenados e intercala entre un archivo y otro */
        ManejoArch.borrar("f1.txt"); //como se trabara con archivos auxiliares en cada iteración deben ser borrados o vaciados 
        ManejoArch.borrar("f2.txt");
        personas1.clear(); // al igual que las listas deben estar vacías para evitar sobreescribir
        personas2.clear();
        int i=0;
        boolean noOrdenado=false; //metodo que nos permitira validar si estan ordenados o no, 
	/* Tiene una función importante ya que funciona como un apagador, dependiendo de si es true o false, será el archivo donde se almacenaran los bloques */ 
        String inicio = ""; //se trabajara con cadenas por ello es necesario inicializar la variable string con una cadena vacía 
        Persona auxiliar; // todo un objeto sera almacenado en auxiliar
        
        while(i<list.size()){ //mientras la lista sea menor a el tamaño de la lista 
            String valor=list.get(i).getApellidos(); // valor sera igual al apellido (atributo del objeto)
            auxiliar=list.get(i); //auxiliar guarda al objeto completo
            
            if(valor.compareTo(inicio)>0){ //compara el valor con el inicio, por ejemplo si nuestro objeto 0 es Muñoz entonces Muños es mayor que 0?
		    /* como la respuesta es afirmativa entra en este if */
                inicio=valor; //modifica el valor del incio por lo que ahora inicio es igual a muñoz
                if(!noOrdenado){ //si esta ordenado entonces 
                    pers1.add(auxiliar); // agrega la persona completa a la persona 1
                    /*Condicion que solo se cumple con el ultimo elemento*/
                    if(i+1==list.size()){                                   //Condición para la última iteración
                        ArrayList<Persona> pers3 = new ArrayList<>(pers1); 
                        if(!pers3.isEmpty()){
                            personas1.add(pers3); 
                        }
                        pers1.clear();
                    }/*Fin condicion*/
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
            }else{ // si el valor evaluado no es mayor entonces 
                inicio=valor; // modifica el valor de inicio
                ArrayList<Persona> pers3 = new ArrayList<>(pers1);      //Copia y vaciado de la primera lista
                if(!pers3.isEmpty()){ //si no enta vacía entonces 
                    personas1.add(pers3); //añade a la lista de listas el elemento 
                }
                pers1.clear(); //limpia la lista principal 
                /*Realiza lo mismo que en el if pero esta se utiliza para el segundo archivo */
                ArrayList<Persona> pers4 = new ArrayList<>(pers2);      //Copia y vaciado de la segunda lista tras ingresarse a la lista de listas
                if(!pers4.isEmpty()){
                    personas2.add(pers4);
                }
                pers2.clear();
                /* permite intercalar los archivos */
                if(!noOrdenado){ //!true-> false
                    pers2.add(auxiliar);
                    noOrdenado=true;
                }else if(noOrdenado){
                    pers1.add(auxiliar);
                    noOrdenado=false;
                } 
            }
            i+=1; // iterador para avanzar de objeto en objeto
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
	    /* Metodo que permite fusionar las listas de listas*/
	    /* Se usaron listas de listas para que los bloques sean ordenados con su igual es decir la lista de listas 1 en la posicion 0 se fusionara con la lista de listas 2 
	    en la posicion 0*/
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
