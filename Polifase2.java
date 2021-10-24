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

    
    ArrayList<ArrayList<Persona>> aux = new ArrayList<>(Arrays.asList(bloque1aux ,bloque2aux ,bloque3aux ,bloque4aux));
    ArrayList< ArrayList<Persona>> personas0Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas1Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas2Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas3Bloques = new ArrayList< ArrayList<Persona>>();
    
   
    ArrayList< ArrayList<Persona>> BloquesTot1 = new ArrayList< ArrayList<Persona>>(Arrays.asList(bloque1,bloque2,bloque3,bloque4,bloque5));
    ArrayList< ArrayList<Persona>> BloquesTot2 = new ArrayList< ArrayList<Persona>>(Arrays.asList(bloque6,bloque7,bloque8,bloque9,bloque10)); 
    
	public void polifase2(ArrayList<Persona> personas) {
		
		int nF1 =0, nF2 =0, j = 0;
		int numClaves=2;
		
		int[] bloque1, bloque2;
		
		personas =  archivos.LecturaArch("FO.txt");
		
		archivos.createArch("Archivo1.txt");
		archivos.createArch("Archivo2.txt");
		archivos.createArch("Archivo3.txt");
		archivos.createArch("Archivo0.txt");
		imprimePersona.imprimirNom(personas);
		//Divide la lista original en 2 
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
		

		
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///i
		//---------------------------------
		
		bloque1 =bloquesCont(personas0Bloques); 
		lecturaEscritura(personas0Bloques,personas,bloque1,aux,"Archivo0.txt");
		//---------------------------------
		
		
		archivos.EscribirArch2(personas1Bloques,"Archivo1.txt");
				
		DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques , personas3Bloques );

		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		
		while(personas3Bloques.get(0).size()!=9) {
			System.out.println("Size: "+personas3Bloques.get(0).size());
			DividirPersonasx(personas2Bloques,personas3Bloques,personas0Bloques ,personas1Bloques );
			imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
			DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques ,personas3Bloques );
			imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		}
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia

		
		System.out.println(" personas3Bloques :");
		imprimePersona.imprimirNom(personas3Bloques.get(0));
		System.out.println("Size: "+personas3Bloques.get(0).size());
	}
	
	
	public void PasarListasToArch(ArrayList<ArrayList<Persona>> personasxBloques, String Archx) {
		LlenarArchivos llenar = new LlenarArchivos();
		ImprimirPersona imprimePersona = new ImprimirPersona();
		int i = 0;
		while(i<personasxBloques.size()) {
		archivos.EscribirArch(personasxBloques.get(i),Archx);
	   
	    i = i+1;
		}
		
	}
	
	public void lecturaEscritura(ArrayList<ArrayList<Persona>> personasxBloques,ArrayList<Persona> personas,int[] bloque1, ArrayList<ArrayList<Persona>> aux, String nameAchi) {
		ManejoArch archivos = new ManejoArch(); 
		personas.clear();
		bloque1 =bloquesCont(personasxBloques); // cuenta los bloques
		archivos.EscribirArch2(personasxBloques,"Archivo0.txt"); //escribe en arch
		personasxBloques.clear();//borraaaando
		personas =  archivos.LecturaArch(nameAchi); //lee
		reparte(personasxBloques,personas,bloque1,aux); // los vuelve a poner en la lista
		
	}

	public void reparte(ArrayList<ArrayList<Persona>> personasxBloques, ArrayList<Persona> personas,int[] bloque1, ArrayList<ArrayList<Persona>> aux) {
		LlenarArchivos llenar = new LlenarArchivos();
		for (int var = 0; var< 3; var++ )  {
			for (int i = 0; i< bloque1[var]; i++ ) {
					llenar.LlenarF1(personas,aux.get(var)); 
				}
			personasxBloques.add(aux.get(var));
			
			}
		
		
	}
	
	public int[] bloquesCont(ArrayList<ArrayList<Persona>> personasxBloques ) {
		
		int[] bloque1 = new int[personasxBloques .size()];
		
		for(int var = 0; var< personasxBloques .size(); var++)
			bloque1 [var] = personasxBloques .get(var).size();
		

		return bloque1;
	}
	public void imprimeBloquesA(ArrayList<ArrayList<Persona>> personas0Bloques ,ArrayList<ArrayList<Persona>> personas1Bloques,ArrayList<ArrayList<Persona>> personas2Bloques,ArrayList<ArrayList<Persona>> personas3Bloques) {
	
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" );
		System.out.println("Vista bloques: " );
		System.out.println("Personas 0 : "+ personas0Bloques );
		System.out.println("Personas 1 : "+ personas1Bloques );
		System.out.println("Personas 2 : "+ personas2Bloques );
		System.out.println("Personas 3 : "+ personas3Bloques );
		
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB/" );

	}
	public void imprimeLdeBloquesB(ArrayList<ArrayList<Persona>> personas0Bloques ,ArrayList<ArrayList<Persona>> personas1Bloques,ArrayList<ArrayList<Persona>> personas2Bloques,ArrayList<ArrayList<Persona>> personas3Bloques) {
		
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP" );
		System.out.println("Vista personas: " );
		System.out.println("Personas0: ");
		imprimeItera(personas0Bloques);
		System.out.println("Personas1: ");
		imprimeItera(personas1Bloques);
		System.out.println("Personas2: ");
		imprimeItera(personas2Bloques);
		System.out.println("Personas3: ");
		imprimeItera(personas3Bloques);
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP/" );

	}
	
	public void imprimeItera(ArrayList<ArrayList<Persona>> Personasiy ) {
	
		for(int i = 0; i<Personasiy.size(); i++) {
			
			imprimePersona.imprimirNom(Personasiy.get(i));
			}

	}

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

