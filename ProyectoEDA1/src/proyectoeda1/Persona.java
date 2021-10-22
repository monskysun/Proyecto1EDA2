
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
    


}