package proyectoeda1;

import java.util.ArrayList;
public class Polifase {
       MergeSort merg = new MergeSort();
       
       ImprimirPersona imprimePersona = new ImprimirPersona();

       ManejoArch Arch1 = new ManejoArch();
	
       LlenarArchivos llenar = new LlenarArchivos();
       
       ManejoArch leerarch1 = new ManejoArch(); 
       
       ArrayList<Persona> personas1 = new ArrayList<>();
       ArrayList<Persona> personas2 = new ArrayList<>();
       ArrayList<Persona> personas3 = new ArrayList<>();
       ArrayList<Persona> personas4 = new ArrayList<>();
       ArrayList<Persona> personas5 = new ArrayList<>();
       
       ArrayList<Persona> personasF = new ArrayList<>();
       
       public void polifase(ArrayList<Persona> personas) {


		int nF1 = 0,nF2 = 0, numClaves = 2, bloques = 0, numIteracion= 0;
		
		Arch1.createArch("Archivo1.txt");
		Arch1.createArch("Archivo2.txt");
		Arch1.createArch("Archivo3.txt");
		Arch1.createArch("ArchivoF.txt");
		
		
		personas = leerarch1.LecturaArch("Archivo.txt");       
		
		DividirPersonas(personas,personas1,personas2,nF1, nF2,numClaves);
		
		nF1 = 0;
		nF2 = 0;
		
		//System.out.println("\n--------\nPersonas3: ");
		leerarch1.borrarContenido(personas,"Archivo.txt");
		leerarch1.borrarContenido(personas,"Archivo3.txt");
	
		Dividir2Personas2(personas1,personas2,personas3, personas4, nF1,nF2,numClaves,"Archivo.txt","Archivo3.txt");
		System.out.println("\n--------\nPersonas3: ");
		imprimePersona.imprimirNom(personas3);
		System.out.println("\nPersonas4: ");
		imprimePersona.imprimirNom(personas4);
		System.out.println("\n-------- ");
		leerarch1.borrarContenido(personas,"Archivo1.txt");
		leerarch1.borrarContenido(personas,"Archivo2.txt");
		numClaves= numClaves*2;
		Dividir2Personas2(personas3,personas4,personas1, personas2, nF1,nF2,numClaves,"Archivo1.txt","Archivo2.txt");
	
		
	}
      
    public void Dividir2Personas2(ArrayList<Persona> personas1,ArrayList<Persona> personas2,ArrayList<Persona> personas3,ArrayList<Persona> personas4, int nF1,int nF2,int numClaves,String arch,String arch2) {//1 y 2 origen; 3 y 4 destino
    	while(personas1.size()>0 || personas2.size()>0) {
			if(personas1.size()>0) {
				nF1=cambiodeLista(personas1,personas3,nF1,numClaves);
				
			}
			if(personas2.size()>0) {
				nF1=cambiodeLista(personas2,personas3,nF1,numClaves);	
			}
			if(personas1.size()>0) {
				nF2=cambiodeLista(personas1,personas4,nF2,numClaves);
				}
				if(personas2.size()>0) {
					nF2=cambiodeLista(personas2,personas4,nF2,numClaves);	
				}
		}
    	PasarListasToArch(personas3,personas4,nF1, nF2,arch,arch2) ;

   	}
       
	public void DividirPersonas(ArrayList<Persona> personas,ArrayList<Persona> personas1,ArrayList<Persona> personas2,int nF1, int nF2, int numClaves) {
		while(personas.size()>0) {
			nF1=cambiodeLista(personas,personas1,nF1,numClaves);
			if(personas.size()>0) {
				nF2=cambiodeLista(personas,personas2,nF2,numClaves);
			}
		}
		PasarListasToArch(personas1,personas2, nF1,nF2,"Archivo1.txt","Archivo2.txt");
	}
	
	public int cambiodeLista(ArrayList<Persona> personas, ArrayList<Persona> personasx, int nF,int numClaves) { //personasx es el destino y personas el origen
		if(personas.size()==1) { 
			nF = nF + llenar.LlenarF1(personas,personasx);// f1 no es un file es una lista 
		}else if(personas.size()>1) {
			for (int i = 0; i<numClaves; i++ )  {
			nF = nF + llenar.LlenarF1(personas,personasx); 
			if(personas.size()==0)
				i=numClaves;
			}
		}
		return nF;
	}
	
	public void PasarListasToArch(ArrayList<Persona> personas1, ArrayList<Persona> personas2, int nF1, int nF2, String Archx,String Archy) {
		LlenarArchivos llenar = new LlenarArchivos();
		ImprimirPersona imprimePersona = new ImprimirPersona();
		Arch1.EscribirArch(personas1,Archx);
	    Arch1.EscribirArch(personas2,Archy);
		System.out.println("personas1");
		imprimePersona.imprimirNom(personas1);
		System.out.println("personas2");
		imprimePersona.imprimirNom(personas2);
		merg.unir(personas1, personas2);
	
		
	}

}
