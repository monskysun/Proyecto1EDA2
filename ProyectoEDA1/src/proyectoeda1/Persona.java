/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeda1;

/**
 *
 * @author David
 */
public class Persona {
    private String nombres;
    private String apellidos;
    private String claves;
    
    public Persona( String nombres,String apellidos, String claves){ // Constructor 
    	this.nombres= nombres;
    	this.apellidos = apellidos;
    	this.claves = claves;
    }
    public Persona(){ // Constructor 

    }
      
    public void setNombre(String nombres) {
    	this.nombres= nombres;
    	
    }
    
    public void setApellido(String apellidos) {
    	this.apellidos= apellidos;
    	
    }
    public void setClaves(String claves) {
    	this.claves= claves;
    	
    }
    
    public String getNombre() {
    	return nombres;
    }
    
    public String getApellidos() {
    	return apellidos;
    }
    public String getClaves() {
    	return claves;
    }
    
    /*public String getApellidos(int i) {
    	a = apellidos.charAt(0);
    	System.out.println(apellidos.charAt(1));
    	return a;
    }*/

}