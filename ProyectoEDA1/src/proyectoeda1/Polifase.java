package proyectoeda1;

import java.util.ArrayList;
import java.util.Arrays;

public class Polifase {
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
    ArrayList< ArrayList<Persona>> personas0Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas1Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas2Bloques = new ArrayList< ArrayList<Persona>>();
    ArrayList< ArrayList<Persona>> personas3Bloques = new ArrayList< ArrayList<Persona>>();
   
    ArrayList< ArrayList<Persona>> BloquesTot1 = new ArrayList< ArrayList<Persona>>(Arrays.asList(bloque1,bloque2,bloque3,bloque4,bloque5));
    ArrayList< ArrayList<Persona>> BloquesTot2 = new ArrayList< ArrayList<Persona>>(Arrays.asList(bloque6,bloque7,bloque8,bloque9,bloque10)); 
    
	public void polifase2(ArrayList<Persona> personas) {
		
		int nF =0,nF1 =0, nF2 =0, j = 0, k;
		int numClaves=20;
		personas =  archivos.LecturaArch("Archivo0.txt");
		
		archivos.createArch("Archivo1.txt");
		archivos.createArch("Archivo2.txt");
		archivos.createArch("Archivo3.txt");
		archivos.createArch("ArchivoF.txt");
		imprimePersona.imprimirNom(personas);
		
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
	
		//imprimeLdeBloquesB(personas0Bloques,personas1Bloques); ///ib
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		
		DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques , personas3Bloques );

		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		//PasarListasToArch(personas2Bloques,"Archivo1.txt") ;
		
		//PasarListasToArch(personas3Bloques,"Archivo2.txt") ;
		while(personas3Bloques.get(0).size()!=100) {
			
			System.out.println("Size: "+personas3Bloques.get(0).size());
			DividirPersonasx(personas2Bloques,personas3Bloques,personas0Bloques ,personas1Bloques );
			imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
			DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques ,personas3Bloques );
			imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		
		}
		
		//System.out.println( personas0Bloques );
		//for(int i = 0;i <personas.size();i++)
		//	System.out.println( personas0Bloques .get(i));
		
		imprimeBloquesA(personas0Bloques,personas1Bloques,personas2Bloques,personas3Bloques); ///ia
		
		System.out.println(" personas3Bloques :");
		
		imprimePersona.imprimirNom(personas3Bloques.get(0));
		System.out.println("Size: "+personas3Bloques.get(0).size());
	}


	public void imprimeBloquesA(ArrayList<ArrayList<Persona>> personas0Bloques ,ArrayList<ArrayList<Persona>> personas1Bloques,ArrayList<ArrayList<Persona>> personas2Bloques,ArrayList<ArrayList<Persona>> personas3Bloques) {
	
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" );
		System.out.println("Vista bloques: " );
		System.out.println("Personas 0 :\n"+ personas0Bloques );
		System.out.println("Personas 1 :\n"+ personas1Bloques );
		System.out.println("Personas 2  :\n"+ personas2Bloques );
		System.out.println("Personas 3 :\n"+ personas3Bloques );
		
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB/" );

	}
	public void imprimeLdeBloquesB(ArrayList< ArrayList<Persona>> Personasix,ArrayList<ArrayList<Persona>> Personasiy) {
		
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP" );
		System.out.println("Vista personas: " );
		System.out.println("Personasix: ");
		for(int i = 0; i<Personasix.size(); i++) {
			imprimePersona.imprimirNom(Personasix.get(i));
			}
		System.out.println("Personasiy: ");
		for(int i = 0; i<Personasiy.size(); i++) {
			
			imprimePersona.imprimirNom(Personasiy.get(i));
			}
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP/" );

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
	
	public void PasarListasToArch(ArrayList<ArrayList<Persona>> personas0Bloques,String Archx) {
		LlenarArchivos llenar = new LlenarArchivos();
		int i = 0;
		ImprimirPersona imprimePersona = new ImprimirPersona();
		
		while (i<personas0Bloques.size()) {
		
		archivos.EscribirArch(personas0Bloques.get(0),Archx);
		i=i+1;
		}
		System.out.println("+++++++++++++++++++++++++");
		System.out.println("personas x");
	
		for(int j = 0; j<personas0Bloques.size(); j++) {
			imprimePersona.imprimirNom(personas0Bloques.get(j));
			}
		System.out.println("personas y");
		
	
		System.out.println("++++++++++++++++++++++++++");
		
	}

}