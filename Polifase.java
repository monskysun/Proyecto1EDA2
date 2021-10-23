package Proyecto1;
import java.util.ArrayList;
public class Polifase {
        
       MergeSort merg = new MergeSort();
       
       ImprimirPersona imprimePersona = new ImprimirPersona();

       ManejoArch Arch1 = new ManejoArch();
		
       ManejoArch Arch2= new ManejoArch();
		
       ManejoArch Arch3= new ManejoArch();
       
       LlenarArchivos llenar = new LlenarArchivos();
       
       ManejoArch leerarch1 = new ManejoArch(); 
       
       ArrayList<Persona> personas1 = new ArrayList<>();
       ArrayList<Persona> personas2 = new ArrayList<>();
       ArrayList<Persona> personas3 = new ArrayList<>();
       ArrayList<Persona> personas4 = new ArrayList<>();
       
       public void polifase(ArrayList<Persona> personas) {


		int nF1 = 0,nF2 = 0, numClaves = 0, bloques = 0, numIteracion= 0;
		
		Arch1.createArch("Archivo1.txt");
		Arch2.createArch("Archivo2.txt");
		Arch3.createArch("Archivo3.txt");
		personas = leerarch1.LecturaArch();             
	
		DividirPersonas(personas,personas1,personas2,nF1, nF2,Arch1,Arch2);
		
		//leerarch1.borrarContenido(personas,"Archivo.txt");
		//System.out.println("\nOriginal ");
		//imprimePersona.imprimirNom(personas);
		nF1 = 0;
		nF2 = 0;
		while(personas1.size()>0 || personas2.size()>0) {
			
			
			/*if(personas.size()==1) {
				nF = nF + llenar.LlenarF1(personas,personasx);// f1 no es un file es una lista 
				
			}else if(personas.size()>1) {
				for (int i = 0; i<2; i++ )  
				nF = nF + llenar.LlenarF1(personas,personasy);
			}*/
			if(personas1.size()>0) {
				nF1=cambiodeLista(personas1,personas3,nF1);
				
			}
			if(personas2.size()>0) {
				nF2=cambiodeLista(personas2,personas4,nF1);	
			}
			if(personas1.size()>0) {
				nF1=cambiodeLista(personas1,personas3,nF2);
				}
				if(personas2.size()>0) {
					nF2=cambiodeLista(personas2,personas4,nF2);	
				}
			
		}
		System.out.println("\n--------\nPersonas1: ");
		imprimePersona.imprimirNom(personas1);
		System.out.println("\nPersonas2: ");
		imprimePersona.imprimirNom(personas2);
		System.out.println("\n-------- ");
		
		/*LlenarArchivos llenar = new LlenarArchivos();
		ImprimirPersona imprimePersona = new ImprimirPersona();
		Arch1.EscribirArchPoli(personas1,Archx,nF1);
		System.out.println("\nOriginal ");
	    imprimePersona.imprimirNom(personas);
	    Arch2.EscribirArchPoli(personas2,Archy,nF2);
		System.out.println("personas1");
		imprimePersona.imprimirNom(personas1);
		System.out.println("personas2");
		imprimePersona.imprimirNom(personas2);
		merg.unir(personas1, personas2);
		imprimePersona.imprimirNom(personas );*/
		
		
	}
	
	public void DividirPersonas(ArrayList<Persona> personas,ArrayList<Persona> personas1,ArrayList<Persona> personas2,int nF1, int nF2,ManejoArch Arch1, ManejoArch Arch2) {
		while(personas.size()>0) {
			nF1=cambiodeLista(personas,personas1,nF1);
			if(personas.size()>0) {
				nF2=cambiodeLista(personas,personas2,nF2);
			}
		} 
		PasarListasToArch(personas,personas1,personas2, nF1,nF2,"Archivo1.txt","Archivo2.txt");
		
	}
	public int cambiodeLista(ArrayList<Persona> personas, ArrayList<Persona> personasx, int nF) { //personasx es el destino y personas el origen
		if(personas.size()==1) {
			nF = nF + llenar.LlenarF1(personas,personasx);// f1 no es un file es una lista 
			
		}else if(personas.size()>1) {
			for (int i = 0; i<2; i++ )  
			nF = nF + llenar.LlenarF1(personas,personasx);
		}
		return nF;
	}
	
	public void PasarListasToArch(ArrayList<Persona> personas, ArrayList<Persona> personas1, ArrayList<Persona> personas2, int nF1, int nF2, String Archx,String Archy) {
		LlenarArchivos llenar = new LlenarArchivos();
		ImprimirPersona imprimePersona = new ImprimirPersona();
		Arch1.EscribirArchPoli(personas1,Archx,nF1);
		System.out.println("\nOriginal ");
	    imprimePersona.imprimirNom(personas);
	    Arch2.EscribirArchPoli(personas2,Archy,nF2);
		System.out.println("personas1");
		imprimePersona.imprimirNom(personas1);
		System.out.println("personas2");
		imprimePersona.imprimirNom(personas2);
		merg.unir(personas1, personas2);
		imprimePersona.imprimirNom(personas );
		
	}

}
