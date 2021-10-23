
package proyectoeda1;

/**
 *
 * @author David
 */

public class Persona {
    /* Clase Persona de tipo objetos que tiene como atributos nombres, apellidos y claves */ 
    private String nombres;
    private String apellidos;
    private String claves;
    
    /* Constructor cuyo objetivo es obligar a y controlar cómo se inicializa una instancia de una determinada clase en este caso tiene el construcor recibe el mismo nombre de la clase*/
    public Persona( String nombres,String apellidos, String claves){ //Constructor con parametros 
    	this.nombres= nombres;
    	this.apellidos = apellidos;
    	this.claves = claves;
    }
    public Persona(){ // Constructor sin parametos 

    }
    /* Los metodos set### permiten modificar el valor de uno de los atributos del objeto */  
    public void setNombre(String nombres) {
    	this.nombres= nombres;
    	
    }
    
    public void setApellido(String apellidos) {
    	this.apellidos= apellidos;
    	
    }
    public void setClaves(String claves) {
    	this.claves= claves;
    	
    }
    /* Los metodos get### permiten acceder al valor, en el programa son muy usados para su visualisación*/
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
