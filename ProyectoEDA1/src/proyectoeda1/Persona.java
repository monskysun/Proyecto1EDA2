
package proyectoeda1;
/*Se declara una clase de objetos llamada persona con sus atributos, los cuales seran, nombre, apellido, claves*/
public class Persona {
    private String nombres;
    private String apellidos;
    private String claves;
    /*atributos del objeto*/
    public Persona( String nombres,String apellidos, String claves){ // Constructor 
    	this.nombres= nombres;
    	this.apellidos = apellidos;
    	this.claves = claves;
    }
    public Persona(){ // Constructor 

    }
     /*Los metodos set permiten modificar al elemento, en este caso los set se realizan por atributo*/
    public void setNombre(String nombres) {
    	this.nombres= nombres;
    	
    }
    
    public void setApellido(String apellidos) {
    	this.apellidos= apellidos;
    	
    }
    public void setClaves(String claves) {
    	this.claves= claves;
    	
    }
    /* Los metodos get permiten visusalizar al elemento, en este caso los get se realizan por atributo */
    public String getNombre() {
    	return nombres;
    }
    
    public String getApellidos() {
    	return apellidos;
    }
    public String getClaves() {
    	return claves;
    }

    @Override /* El sigiente metodo es para poder llamar al objeto con todos sus atributos*/
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", claves=" + claves + '}'+" \n";
    }
    


}
