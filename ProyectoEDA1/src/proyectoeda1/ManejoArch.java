/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeda1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class ManejoArch {
    
    public void LecturaArch(ArrayList<Persona> personas) {
        Scanner sc = new Scanner(System.in);
        Imprimir imprimePersona = new Imprimir();   //Objeto auxiliar para impresiones
        
        Scanner entrada;
        String line;

        //***************************************************
        
        String[] cadena;

            try {
                System.out.print("Introduzca el nombre del archivo:  (Archivo.txt) ");
                entrada = new Scanner(new FileReader(sc.nextLine()));
                while (entrada.hasNextLine()) {
                    line = entrada.nextLine();
                    //System.out.println(line);
                    cadena=line.split(",");
//                    for(int i = 0; i<cadena.length;i++)
//                        System.out.println("Cadena"+i+":"+cadena[i]);
                    
                Persona persona = new Persona(cadena[0],cadena[1],cadena[2]);
                
                //System.out.println(persona.getClaves()); 
                personas.add(persona);

                //  personas.set(1, persona);

                }
                entrada.close();
            }catch (FileNotFoundException e){
                System.out.println("Error: " + e.getMessage());
            }
            //Parte auxiliar para comprobar que los elementos de la lista "nombres" estén llenos
            if(personas.isEmpty()){
                System.out.println("No se han registrado personas");
            }else{
                
            }   
        
        imprimePersona.imprimirAtrib(personas);     //Impresiones de atributos, quitar al final

        RadixExterno rdx = new RadixExterno();
        rdx.radixExtrn(personas);
       
        imprimePersona.imprimirAtrib(personas);     //Impresiones de atributos, quitar al final
        //++++++++++++++++++++++++
        //InsertionSort insertion = new InsertionSort();
        //insertion.insertionSort(personas,personas.size());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
                    System.out.println("Excepción encontrada en el archivo");
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
        catch (IOException e){
            System.out.println("Algo salió mal en la escritura de tu archivo.");
            e.printStackTrace();
        }
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
