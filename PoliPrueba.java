package proyectoeda1;

import java.util.ArrayList;

import java.util.Arrays;

public class PoliPrueba {
	
	ManejoArch leerarch1 = new ManejoArch(); 
	
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
   
   
	public void poliprueba(ArrayList<Persona> personas) {
		int nF =0,nF1 =0, nF2 =0, j = 0, k;
		int numClaves=2;
		personas = leerarch1.LecturaArch("Archivo0.txt");    
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
				//bloque1gen.remove(0);
			}

		}
	
		System.out.println("B0 ");
		for(int i = 0; i<personas0Bloques.size(); i++) {
			imprimePersona.imprimirNom(personas0Bloques.get(i));
			}
		System.out.println("B1 ");
		for(int i = 0; i<personas1Bloques.size(); i++) {
			
			imprimePersona.imprimirNom(personas1Bloques.get(i));
			}
	
		DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques , personas3Bloques );
		
		System.out.println("B0 :"+personas0Bloques);
		System.out.println("B1 :"+personas1Bloques);
		System.out.println("Personas 2 :"+ personas2Bloques );
		System.out.println("Personas 3 :"+ personas3Bloques );
		
		
		while(personas0Bloques.get(0).size()!=10) {
			DividirPersonasx(personas2Bloques,personas3Bloques,personas0Bloques ,personas1Bloques );
			DividirPersonasx(personas0Bloques,personas1Bloques,personas2Bloques ,personas3Bloques );
		
		}
		
		//System.out.println( personas0Bloques );
		//for(int i = 0;i <personas.size();i++)
		//	System.out.println( personas0Bloques .get(i));
		
		System.out.println("B0 :"+ personas2Bloques );
		System.out.println("B1 :"+ personas3Bloques );
		System.out.println("Personas 0 :"+ personas0Bloques );
		System.out.println("Personas 1 :"+ personas1Bloques );
		
		System.out.println(" personas3Bloques :");
		
		imprimePersona.imprimirNom(personas3Bloques.get(0));
		System.out.println("Size: "+personas3Bloques.get(0).size());
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
	
