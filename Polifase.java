package Proyecto1;

import java.util.ArrayList;

public class Polifase {

	int n = 20, i =0;
	public void polifase(ArrayList<Persona> personas) {
		LlenarArchivos llenar = new LlenarArchivos();
		
		InsertionSort insertion = new InsertionSort();
		
		MergeSort merge = new MergeSort();

		ImprimirPersona imprimePersona = new ImprimirPersona();

		ManejoArch leerarch1 = new ManejoArch(); 

		ManejoArch Arch1 = new ManejoArch();
		
		ManejoArch Arch2= new ManejoArch();
		
		ManejoArch Arch3= new ManejoArch();
		
		ManejoArch leerarchi = new ManejoArch(); 
		
		ArrayList<Persona> personas1 = new ArrayList<>();
		ArrayList<Persona> personas2 = new ArrayList<>();
		
		ArrayList<Persona> personas3 = new ArrayList<>();
		
		int tamList = personas.size();
	 
		int nF1 = 0,nF2 = 0,bloque = 0;
		
		Arch1.createArch("Archivo1.txt");
		Arch2.createArch("Archivo2.txt");
		Arch3.createArch("Archivo3.txt");
		personas = leerarch1.LecturaArch();
		//size 1,2,3
		bloque = bloque * 2;
		// Hacer funcion a la cual le voy a pasar n que es el numero de claves por tomar  2+0; 2+2, 2+4;
		// 50; 50+50; 100+100, 200+200
		DividirPersonas(personas,personas1,personas2,nF1, nF2,Arch1,Arch2);
		
			  
			   leerarchi.borrarContenido(personas,"Archivo.txt");
			   System.out.println("\nOriginal ");
			   imprimePersona.imprimirNom(personas);
		}
	public void DividirPersonas(ArrayList<Persona> personas,ArrayList<Persona> personas1,ArrayList<Persona> personas2,int nF1, int nF2,ManejoArch Arch1, ManejoArch Arch2) {
		LlenarArchivos llenar = new LlenarArchivos();
		ImprimirPersona imprimePersona = new ImprimirPersona();
		
		while(personas.size()>0) {
			//System.out.println("tam personas: "+personas.size());
			if(personas.size()==1) {
				nF1 = nF1 + llenar.LlenarF1(personas,personas1);
				
			}else if(personas.size()>1) {
				//for i = 0; i<2   ///2 =n
				nF1 = nF1 + llenar.LlenarF1(personas,personas1);
				nF1 = nF1 + llenar.LlenarF1(personas,personas1);
			}
			if(personas.size()>0) {
				if(personas.size()==1)
					nF2 = nF2 + llenar.LlenarF2(personas,personas2);
				else if(personas.size()>1) {
					nF2 = nF2 + llenar.LlenarF2(personas,personas2);
					nF2 = nF2 + llenar.LlenarF2(personas,personas2);
				}
			}
		} 
		Arch1.EscribirArchPoli(personas1,"Archivo1.txt",nF1);
		System.out.println("\nOriginal ");
	    imprimePersona.imprimirNom(personas);
	    Arch2.EscribirArchPoli(personas2,"Archivo2.txt",nF2);
		System.out.println("\nOriginal ");
		System.out.println("\n Personas ="+personas.size());
		
		
		System.out.println("personas1");
		  imprimePersona.imprimirNom(personas1);
		System.out.println("personas2");
		  imprimePersona.imprimirNom(personas2);
		
		//personas3.addAll( merge.unir(personas1,personas2));
		
		//imprimePersona.imprimirNom(personas );
	}
		
}
