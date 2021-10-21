package Proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class ManejoArch {
	
	public void createArch(String nameArch) {
		 try {
			  File arch1 = new File(nameArch);//Especifica ruta y nombre del archivo  
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
		      FileWriter myWriter = new FileWriter("/Users/monserratlopez/eclipse-workspace/EDA2/Archivo2.txt");
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
	
	public void EscribirArchPoli(ArrayList<Persona> personas,String nameArch,int n) {
		try { 

			  int i = 0;
		      FileWriter myWriter = new FileWriter(nameArch);
		      while (i<n) {
		    
		      myWriter.write(personas.get(i).getNombre()+",");
		      myWriter.write(personas.get(i).getApellidos()+",");
		      myWriter.write(personas.get(i).getClaves()+",,"+"\n");
		      
		      i = i + 1;
		      }
		      myWriter.close();
		      System.out.println("YA QUEDÓ");
		    } 
			catch (IOException e) 
			{
		      System.out.println("Algo salió mal en la escritura de tu archivo.");
		      e.printStackTrace();
		    }
	  }
	
	  public ArrayList<Persona> LecturaArch() {
			Scanner stdIn = new Scanner(System.in);
			Scanner fileIn;
			String line;
			ArrayList<Persona> personas = new ArrayList<>();
		    String[] cadena;
		  
			try {
		          System.out.print("Introduzca el nombre del archivo:  (Archivo.txt) ");
		          fileIn = new Scanner(new FileReader(stdIn.nextLine()));
		          while (fileIn.hasNextLine()) {
			      line = fileIn.nextLine();
			      cadena=line.split(",");
			      
			      Persona persona = new Persona(cadena[0],cadena[1],cadena[2]);
			      personas.add(persona);
			    }
			    fileIn.close();
			}catch (FileNotFoundException e){
			    System.out.println("Error: " + e.getMessage());
		        }
		        if(personas.isEmpty()){
		            System.out.println("No se han registrado personas");
		        }else{
	    
		        }   
	        	return personas;
	
		    }
	  
	  public void borrarContenido(ArrayList<Persona> personas,String nameArch) {
		  int n = personas.size();
		  int i = 0;
		  
		  try { 

		      FileWriter myWriter = new FileWriter(nameArch);
		      Persona persona = new Persona("","","");
		      while (i<n) {
		      personas.set(i,  persona);
		      myWriter.write(personas.get(i).getNombre());
		      myWriter.write(personas.get(i).getApellidos());
		      myWriter.write(personas.get(i).getClaves()+"\n");
		      i = i + 1;
		      }
		      myWriter.close();
		      System.out.println("YA QUEDÓ");
		      
		    } 
			catch (IOException e) 
			{
		      System.out.println("Algo salió mal borrando el contenido de tu archivo.");
		      e.printStackTrace();
		    }
		  
		  
		

	  }
	  // Tal vez ya no se usa
	 /* public ArrayList<Persona> LecturaPoli() {
			Scanner stdIn = new Scanner(System.in);
			Scanner fileIn;
			String line;
			ArrayList<Persona> personas = new ArrayList<>();
		    String[] cadena;
		    int i = 0;
		  
			try {
		          System.out.print("Introduzca el nombre del archivo:  (Archivo.txt) ");
		          fileIn = new Scanner(new FileReader(stdIn.nextLine()));
		          while (i<20) {
			      line = fileIn.nextLine();
			      cadena=line.split(",");
			      
			      Persona persona = new Persona(cadena[0],cadena[1],cadena[2]);
			      personas.add(persona);
			      i = i+1;
			    }
			    fileIn.close();
			}catch (FileNotFoundException e){
			    System.out.println("Error: " + e.getMessage());
		        }
		        if(personas.isEmpty()){
		            System.out.println("No se han registrado personas");
		        }else{
	    
		        }   
	        	return personas;
	
		    }*/
	

	
}
