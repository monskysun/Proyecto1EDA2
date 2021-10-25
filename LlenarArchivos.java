package proyectoeda1;
import java.util.ArrayList;
	
	public class LlenarArchivos {
		
		public int LlenarF1(ArrayList<Persona> personas,ArrayList<Persona> personasx) {
			ImprimirPersona imprimePersona = new ImprimirPersona();
			int j =0;
			personasx.add(personas.get(0));
			j=j+1;
			personas.remove(personas.get(0));	
		    return j;
			}
	
		public int LlenarF2(ArrayList<Persona> personas,ArrayList<Persona> personasx) {
			int j =0;
			ImprimirPersona imprimePersona = new ImprimirPersona();
			personasx.add(personas.get(0));
			j= j+1;
			personas.remove(personas.get(0));	
		    return j;
			}
}
