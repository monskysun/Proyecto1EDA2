package EDA2Proyecto1;//p y m= A


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class ManejoArch {
	
	public void createArch() {
		 try {
			  File arch1 = new File("Archivo2.txt");//Especifica ruta y nombre del archivo  
			  if (arch1.createNewFile()) {
			      System.out.println("Archivo creado: " + arch1.getName());
			  
			  } 
			  else {
			       System.out.println("El archivo ya existe.");
			       }  
			  } 
		 	  catch (IOException e) {
		 		  System.out.println("Algo salió mal en la creación de tu archivo.");
		 		  e.printStackTrace();
		 	  }
    }
	public void EscribirArch() {
		try {
		      FileWriter myWriter = new FileWriter("/Users/monserratlopez/Desktop/ArchivosPy1EDA2/Archivo2.txt");
		      myWriter.write("Exito");
		      myWriter.close();
		      System.out.println("YA QUEDÓ");
		    } 
			catch (IOException e) 
			{
		      System.out.println("Algo salió mal en la escritura de tu archivo.");
		      e.printStackTrace();
		    }
	  }
	
	  public void LecturaArch() {
			Scanner stdIn = new Scanner(System.in);
			Scanner fileIn;
			String line;
			
			//***************************************************
			ArrayList<Persona> personas = new ArrayList<>();
	
		        String[] cadena;
		  
			try {
		            System.out.print("Introduzca el nombre del archivo:  (Archivo.txt) ");
			    fileIn = new Scanner(new FileReader(stdIn.nextLine()));
			    while (fileIn.hasNextLine()) {
			        line = fileIn.nextLine();
			        //System.out.println(line);
			        cadena=line.split(",");
			        for(int i = 0; i<cadena.length;i++)
			        	System.out.println("Cadena"+i+":"+cadena[i]);
			        	
			        	
			      Persona persona = new Persona(cadena[0],cadena[1],cadena[2]);
			        //persona.ImprimirAp();
			        //System.out.println(persona.getClaves()); 
			      personas.add(persona);
			        
			      //  personas.set(1, persona);
			      
			    }
			    fileIn.close();
			}catch (FileNotFoundException e){
			    System.out.println("Error: " + e.getMessage());
		        }
		        //Parte auxiliar para comprobar que los elementos de la lista "nombres" estén llenos
		        if(personas.isEmpty()){
		            System.out.println("No se han registrado personas");
		        }else{
		      
		        	
		            
		        }   
		       ImprimirPersona imprimePersona = new ImprimirPersona();
		       imprimePersona.imprimirNom(personas);
		       
		       
		       RadixExterno rdx=new RadixExterno();
	           rdx.radixExtrn(personas);
		       
		        //++++++++++++++++++++++++
	        	//InsertionSort insertion = new InsertionSort();
	        	//insertion.insertionSort(personas,personas.size());
	        	
	        	
	        	
	        	
	        	
		    }
	
	public void AccesoParteArch() {
		int i = 0;
	  	Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;
        String line;
        try {
            System.out.print("Introduzca el nombre del archivo: ");
            fileIn = new Scanner(new FileReader(stdIn.nextLine()));
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                System.out.println(line);
                i++;
                
            }
            fileIn.close();
            System.out.println(i+"\n");
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }   
}
	
}
