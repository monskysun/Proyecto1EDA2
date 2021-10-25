package proyectoeda1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Polifase2 {
	
	ManejoArch archivos = new ManejoArch(); 
	
	LlenarArchivos llenar = new LlenarArchivos();
	
	ImprimirPersona imprimePersona = new ImprimirPersona();
	
	MergeSort merg = new MergeSort();
	
	Persona vacio = new Persona();
	
	ArrayList<Persona> pAux = new ArrayList<>();
	ArrayList<Persona> p = new ArrayList<>();
	
    ArrayList<Persona> bloque1 = new ArrayList<>();
    ArrayList<Persona> bloque2 = new ArrayList<>();
    ArrayList<Persona> bloque3 = new ArrayList<>();
    ArrayList<Persona> bloque4 = new ArrayList<>();
    ArrayList<Persona> bloque5 = new ArrayList<>();
    ArrayList<Persona> bloque6 = new ArrayList<>();
    ArrayList<Persona> bloque7 = new ArrayList<>();
    ArrayList<Persona> bloque8 = new ArrayList<>();
    ArrayList<Persona> bloque9 = new ArrayList<>();
    ArrayList<Persona> bloque10 = new ArrayList<>();
    
    ArrayList<Persona> bloque1aux = new ArrayList<>();
    ArrayList<Persona> bloque2aux = new ArrayList<>();
    ArrayList<Persona> bloque3aux = new ArrayList<>();
    ArrayList<Persona> bloque4aux= new ArrayList<>();
    
    ArrayList<Persona> bloque5aux = new ArrayList<>();
    ArrayList<Persona> bloque6aux = new ArrayList<>();
    ArrayList<Persona> bloque7aux = new ArrayList<>();
    ArrayList<Persona> bloque8aux= new ArrayList<>();

    
    ArrayList<ArrayList<Persona>> aux = new ArrayList<>(Arrays.asList(bloque1aux ,bloque2aux ,bloque3aux ,bloque4aux));
    ArrayList<ArrayList<Persona>> aux1 = new ArrayList<>(Arrays.asList(bloque5aux ,bloque6aux ,bloque7aux ,bloque8aux));
    
    ArrayList< ArrayList<Persona>> personas0Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas1Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas2Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas3Bloques = new ArrayList< ArrayList<Persona>>();
    
   
    ArrayList< ArrayList<Persona>> BloquesTot1 = new ArrayList< ArrayList<Persona>>(Arrays.asList(bloque1,bloque2,bloque3,bloque4,bloque5));
    ArrayList< ArrayList<Persona>> BloquesTot2 = new ArrayList< ArrayList<Persona>>(Arrays.asList(bloque6,bloque7,bloque8,bloque9,bloque10)); 
    
	public void polifase2(ArrayList<Persona> personas) {
		personas =  archivos.LecturaArch("FO.txt");
		int nF1 =0, nF2 =0, j = 0;
		int numClaves; // Es el numero de claves que va a leer por bloque
		
		if(personas.size()%2!= 0)
			numClaves=(personas.size()/5)+1;
		else
			numClaves=(personas.size()/5);
		
		int[] bloque1; // para contar los bloques de una lista de personas
		
		
		// Se crean los archivos para polifase
		archivos.createArch("Archivo1.txt");
		archivos.createArch("Archivo2.txt");
		archivos.createArch("Archivo3.txt");
		archivos.createArch("Archivo0.txt");
		archivos.createArch("ArchivoFinal.txt");
		
		//Divide la lista original en 2 listas
		while(personas.size()>0) {
			if(personas.size()>0) {
				cambiodeLista(personas,BloquesTot1.get(j),nF1,numClaves);
				personas0Bloques.add(BloquesTot1.get(j));
			}
			j++;
			if(personas.size()>0) {
				cambiodeLista(personas,BloquesTot2.get(j),nF2,numClaves);
				personas1Bloques.add(BloquesTot2.get(j));
			}
		}
		
		//imprime todas las listas de personas
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///i
		
		// A continuación se pasan los datos del archivo original a los acchivos auxiliares
		//---------------------------------
		
		bloque1 =bloquesCont(personas0Bloques); 
		pAux=lecturaEscritura(personas0Bloques,personas,bloque1,aux,"Archivo0.txt");
		//archivos.borrarContenido(pAux,"Archivo0.txt");
		
	
		bloque1 =bloquesCont(personas1Bloques); 
		pAux=lecturaEscritura(personas1Bloques,personas,bloque1,aux1,"Archivo1.txt");
		archivos.borrarContenido(pAux,"Archivo1.txt");
		
		
		//imprime todas las listas de personas
		//---------------------------------
		// Se pasan mediante merge los bloques de P0 y P1 a P2 y P3 de forma alternada
		DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques , personas3Bloques );
	
		
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		
		//mientras la lista final no tenga un bloque del tamaño de las claves totales realiza merge de archivos e imprime el resultado
		
		while(personas3Bloques.get(0).size()!=9) { 
			System.out.println("Size: "+personas3Bloques.get(0).size());
			DividirPersonasx(personas2Bloques,personas3Bloques,personas0Bloques ,personas1Bloques );
			imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
			DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques ,personas3Bloques );
			imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		}
		//imprime todas las listas de personas
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		int i = 0;
		
		//Se pasan los resultados al archivo final
		while(i<personas3Bloques.size()) {
			archivos.EscribirArch(personas3Bloques.get(i),"ArchivoFinal.txt");
		   
		    i = i+1;
			}
		
		//Se imprime en patalla el resultado final 
		System.out.println(" personas3Bloques :");
		imprimePersona.apellidos(personas3Bloques.get(0));
	
	}
	//La siguiente funcion e sun conjutno de otras con la cual se escribe en un archivo, se lee, se pasa a listas y se borra su contenido
	public void dos(ArrayList<ArrayList<Persona>> personasxBloques, String Archx,int[] bloque1,ArrayList<Persona> personas,ArrayList<ArrayList<Persona>> personasyBloques, String Archy,int[] bloque2,ArrayList<ArrayList<Persona>> aux,ArrayList<ArrayList<Persona>> aux1) {
		
		bloque1 =bloquesCont(personasxBloques); 
		pAux=lecturaEscritura(personasxBloques,personas,bloque1,aux,"Archivo0.txt");
		archivos.borrarContenido(pAux,"Archivo0.txt");
		
		bloque2 =bloquesCont(personasyBloques); 
		pAux=lecturaEscritura(personasyBloques,personas,bloque2,aux1,"Archivo1.txt");
		archivos.borrarContenido(pAux,"Archivo1.txt");
		
	}
	
	//La siguiente funcion sirve para pasar bloques de personas un archivo
	
	public void PasarListasToArch(ArrayList<ArrayList<Persona>> personasxBloques, String Archx) {
		LlenarArchivos llenar = new LlenarArchivos();
		ImprimirPersona imprimePersona = new ImprimirPersona();
		int i = 0;
		while(i<personasxBloques.size()) {
		archivos.EscribirArch(personasxBloques.get(i),Archx);
	   
	    i = i+1;
		}
		
	}
	//La siguiente funcion sirve para escribir en un archivo, leerlo y poner los elementos en listas
	
	public ArrayList<Persona>  lecturaEscritura(ArrayList<ArrayList<Persona>> personasxBloques,ArrayList<Persona> personas,int[] bloque1, ArrayList<ArrayList<Persona>> auxi, String nameAchi) {
		ManejoArch archivos = new ManejoArch(); 
		ArrayList<Persona> paux = new ArrayList<>();
		personas.clear();
		bloque1 =bloquesCont(personasxBloques); // cuenta los bloques
		archivos.EscribirArch2(personasxBloques,nameAchi); //escribe en arch
		personasxBloques.clear();//borraaaando
		personas =  archivos.LecturaArch(nameAchi); //lee
		paux=reparte(personasxBloques,personas,bloque1,auxi); // los vuelve a poner en la list
		
		
		return paux;
	}
	//La siguiente funcion sirve para volver a poner los bloques de personas en una lista 
	public ArrayList<Persona>  reparte(ArrayList<ArrayList<Persona>> personasxBloques, ArrayList<Persona> personas,int[] bloquex, ArrayList<ArrayList<Persona>> aux) {
		LlenarArchivos llenar = new LlenarArchivos();
		ArrayList<Persona> pAux = new ArrayList<>(personas);
		for (int var = 0; var<bloquex.length; var++ )  {
			for (int i = 0; i< bloquex[var]; i++ ) {
					llenar.LlenarF1(personas,aux.get(var)); 
				}
			personasxBloques.add(aux.get(var));
			
			}
		
		return pAux;
		
	}
	
	// La sigueinte funcion cuenta cuantos bloques tiene una lista
	public int[] bloquesCont(ArrayList<ArrayList<Persona>> personasxBloques ) {
		
		int[] bloque1 = new int[personasxBloques .size()];
		
		for(int var = 0; var< personasxBloques .size(); var++)
			bloque1 [var] = personasxBloques .get(var).size();
		

		return bloque1;
	}
	// La sigueinte funcion imprime los bloques de la lista
	public void imprimeBloquesA(ArrayList<ArrayList<Persona>> personas0Bloques ,ArrayList<ArrayList<Persona>> personas1Bloques,ArrayList<ArrayList<Persona>> personas2Bloques,ArrayList<ArrayList<Persona>> personas3Bloques) {
	
		System.out.println("------------------------------------" );
		System.out.println("Vista bloques: " );
		System.out.println("Personas 0 : "+ personas0Bloques );
		System.out.println("Personas 1 : "+ personas1Bloques );
		System.out.println("Personas 2 : "+ personas2Bloques );
		System.out.println("Personas 3 : "+ personas3Bloques );
		
		System.out.println("------------------------------------/" );

	}
	
	// La sigueinte funcion sirve  para imprimir un elemento de una lista de listas de personas.
	public void imprimeLdeBloquesB(ArrayList<ArrayList<Persona>> personas0Bloques ,ArrayList<ArrayList<Persona>> personas1Bloques,ArrayList<ArrayList<Persona>> personas2Bloques,ArrayList<ArrayList<Persona>> personas3Bloques) {
		
		System.out.println("------------------------------------" );
		System.out.println("Vista personas: " );
		System.out.println("Personas0: ");
		imprimeItera(personas0Bloques);
		System.out.println("Personas1: ");
		imprimeItera(personas1Bloques);
		System.out.println("Personas2: ");
		imprimeItera(personas2Bloques);
		System.out.println("Personas3: ");
		imprimeItera(personas3Bloques);
		System.out.println("------------------------------------/" );

	}
	// La sigueinte funcion sirve de complemento para imprimir un elemento de una lista de listas de personas.
	
	public void imprimeItera(ArrayList<ArrayList<Persona>> Personasiy ) {
	
		for(int i = 0; i<Personasiy.size(); i++) {
			
			imprimePersona.imprimirNom(Personasiy.get(i));
			}

	}

	//esta funcion es para hacer merge entre las personas 
	public void DividirPersonasx(ArrayList< ArrayList<Persona>> Personasix,ArrayList<ArrayList<Persona>> Personasiy,ArrayList<ArrayList<Persona>> Personasfx,ArrayList<ArrayList<Persona>> Personasfy) {
		MergeSort merg = new MergeSort();
		while(Personasix.size()>0||Personasiy.size()>0) {
			
			if(Personasiy.size()>0 && Personasix.size()>0) {
				Personasfy.add(merg.unir(Personasix.get(0),Personasiy.get(0)));
				Personasix.remove(0);
				Personasiy.remove(0);
			}
			else if(Personasiy.size()==1) {
				Personasfy.add(Personasiy.get(0));
				Personasiy.remove(0);
				}
			if(Personasiy.size()>0 && Personasix.size()>0) {
				Personasfx.add(merg.unir(Personasix.get(0),Personasiy.get(0)));
				Personasix.remove(0);
				Personasiy.remove(0);
				}
			else if(Personasix.size()==1) { 
				Personasfx.add(Personasix.get(0));
				Personasix.remove(0);
			}
		
		}

	}

	// Esta funcion sirve para cambiar de una lista personas a una lista x.
	public int cambiodeLista(ArrayList<Persona> personas, ArrayList<Persona> personasx, int nF,int numClaves) { //personasx es el destino y personas el origen
		if(personas.size()==1) { 
			nF = nF + llenar.LlenarF1(personas,personasx);// f1 no es un file es una lista 
		}
		else if(personas.size()>1) {
			for (int i = 0; i<numClaves; i++ )  {
				nF = nF + llenar.LlenarF1(personas,personasx); 
			
			}
		}
		return nF;
	}
	
}	

