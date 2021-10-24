/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeda1;
import java.util.ArrayList;
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

    public void EscribirArch(ArrayList<Persona> personas,String nameArch,int n) {
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
        }catch (IOException e){
            System.out.println("Algo salió mal en la escritura de tu archivo.");
            e.printStackTrace();
        }
    }
    public void EscribirArchRep(ArrayList<Persona> personas,String nameArch,int n) {
        try { 
            int i = 0;
            FileWriter myWriter = new FileWriter(nameArch,true);
            while (i<n) {

                myWriter.write(personas.get(i).getNombre()+",");
                myWriter.write(personas.get(i).getApellidos()+",");
                myWriter.write(personas.get(i).getClaves()+",,"+"\n");

            i = i + 1;
            }
            myWriter.close();
            System.out.println("YA QUEDÓ");
        }catch (IOException e){
            System.out.println("Algo salió mal en la escritura de tu archivo.");
            e.printStackTrace();
        }
    }
    

      public ArrayList<Persona> LecturaArch(String nombreArch) {
                    Scanner stdIn = new Scanner(System.in);
                    Scanner fileIn;
                    String line;
                    ArrayList<Persona> personas = new ArrayList<>();
                String[] cadena;

                    try {
                      
                      fileIn = new Scanner(new FileReader(nombreArch));
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
    public void escribirArch(Persona personas,File archColas) {
        try {
            FileWriter escribir = new FileWriter(archColas,true);        //True permite añadir en la última posición
                escribir.write(personas.getNombre()+",");
                escribir.write(personas.getApellidos()+",");
                escribir.write(personas.getClaves()+",,"+"\n");
                escribir.close();
        }catch (IOException e){
            System.out.println("Algo salió mal en la escritura de tu archivo.");
            e.printStackTrace();
        }
    }
    public Persona lectura(File archivo,int i,ArrayList<Persona> persLect) {
        Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;
        String line;
        String[] cadena;
        Persona persona=new Persona("","","");
        try {
            fileIn = new Scanner(new FileReader(archivo));
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                cadena=line.split(",");

                persona = new Persona(cadena[0],cadena[1],cadena[2]);
                persLect.add(persona);
            }
            fileIn.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: " );
        } 
        return persLect.get(i);

    }
      
    public static long tamanioArchivo(File archivoAMedir){
        long tam=0;
        try {
            FileReader fr = new FileReader(archivoAMedir);
            BufferedReader bf = new BufferedReader(fr);
            tam=bf.lines().count();
        } catch (FileNotFoundException ex) {
            System.out.println("No se registró una cola de tal número");
        }
       
        return tam;
    }
      
    public static void borrar(String archAVaciar){
        try {
            PrintWriter pw = new PrintWriter(archAVaciar);
            pw.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo borrar");
        }        
    }
	
    
    
    //Releer archivo final e intercambiar sus atributos de la Persona
    public void escribirArchFinal(Persona personas,File arch) {    //Final
        try {
            FileWriter escribir = new FileWriter(arch,true);        //True permite añadir en la última posición
                
                escribir.write(personas.getClaves()+",");
                escribir.write(personas.getApellidos()+",");
                escribir.write(personas.getNombre()+",,"+"\n");
                  
                escribir.close();
        }catch (IOException e){
            System.out.println("Algo salió mal en la escritura de tu archivo.");
            e.printStackTrace();
        }
    }
}