package Proyecto1;
import java.util.ArrayList;
public class MezclaEquilibrada {
	
	public void MezclaEquilibrada(ArrayList<Persona> personas) {
			
			InsertionSort insertion = new InsertionSort();
			
			LlenarArchivos llenar = new LlenarArchivos();
	
			ImprimirPersona imprimePersona = new ImprimirPersona();
	
			ManejoArch leerarch1 = new ManejoArch(); 
	
			ManejoArch Arch1 = new ManejoArch();
			
			ManejoArch Arch2= new ManejoArch();
			
			ArrayList<Persona> personas1 = new ArrayList<>();
			ArrayList<Persona> personas2 = new ArrayList<>();
			int tamList = personas.size();
			
			int nF1 = 0,nF2 = 0,bloque = 0;
			
			Arch1.createArch("Archivo1.txt");
			Arch2.createArch("Archivo2.txt");
			personas = leerarch1.LecturaArch();
			
			System.out.println("Sin ordenar: \n");
			
			imprimePersona.imprimirNom(personas );
			
			MergeSort merge = new MergeSort();
			System.out.println("Ordenado: \n");
			
			merge.mergeSort(personas, 0, personas.size()-1);
			
			imprimePersona.imprimirNom(personas );
	}
}