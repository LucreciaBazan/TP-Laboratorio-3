package tpFinal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Jugador extends Personaje {
	private String descripcionJugador;
	private HashMap<String, Integer> items;
	private HashMap<String, Integer> habilidades; 


	/**
	 * Constructor para el Jugador Lucrecia que inicializa sus atributos con los valores pasados por parametro y realiza una llamada al super en donde se le asignando su nombre
	 * @param descripcionR: breve descripcion del personaje
	 * @param item1: primer item
	 * @param descripcion1: estado del primer item
	 * @param item2: segundo item
	 * @param descripcion2: estado del segundo item
	 * @param habilidad1: primer habilidad
	 * @param descripcionHabilidad1: estado de la primer habilidad
	 * @param habilidad2: segunda habilidad
	 * @param descripcionHabilidad2: estado de la segunda habilidad
	 * @param habilidad3: tercer habilidad
	 * @param descripcionHabilidad3: estado de la tercer habilidad
	 */
	public Jugador (String descripcionR, String item1, String item2, String habilidad1, String habilidad2, String habilidad3) {
		super("Lucrecia Denise Bazan");
		descripcionJugador=descripcionR;
		items= new HashMap<String, Integer>();
		habilidades= new HashMap<String, Integer>();
		setItems(item1, 0);
		setItems(item2, 0);
		setHabilidades(habilidad1, 3);
		setHabilidades(habilidad2, 3);
		setHabilidades(habilidad3, -1);
	}


	public void setItems(String itemR, int descripcionR) {
		items.put(itemR, descripcionR);
	}
	public void setHabilidades(String habilidadR, int descripcionR) {
		habilidades.put(habilidadR, descripcionR);
	}
	public HashMap<String, Integer> getItems() {
		return items;
	}
	public HashMap<String, Integer> getHabilidades() {
		return habilidades;
	}
	public String getDescripcionJugador() {
		return descripcionJugador;
	}
	
	/**
	 * Imprime lineas en blanco como una forma forzosa de "limpiar" la pantalla
	 * @param cant de lineas que se desean imprimir en blanco
	 */
	public void limpiar(int lineas) {
		for (int i=0; i < lineas; i++) {
			System.out.println("");
		}
	}

	//todos estos metodos son para sobreescritura en donde cada personaje podrá darle su implementación//

	//public abstract String avanzar (int cantR) ; //parte de quimey para el contador que avanza en la historia

	public abstract String aumentarItem (String itemR); 

	public abstract String disminuirItem (String itemR); 

	public abstract String aumentarHabilidad (String habilidadR); 

	public abstract String disminuirHabilidad (String habilidadR);
	
	/**
	 * Comprueba si tiene el item "Elementos extra" y cual de ellos tiene
	 * @return retorna el num del elemento extra
	 * @author Lucrecia Bazan
	 */
	public int tieneElemento() {
		int rta=0;
		if (getItems().containsKey("ElemetoExtra")) {
			
			if (getItems().get("ElementoExtra")==1) {
				rta= 1;
			}
			if (getItems().get("ElementoExtra")==2) {
				rta= 2;
			}
			if (getItems().get("ElementoExtra")==3) {
				rta= 3;
			}
		}
		
		return rta;
	}
	
	/**
	 * comprueba si se tiene el item "Escoba"
	 * @author Lucrecia Bazan
	 * @return retorna "si" si se tiene, y "no" si no se lo tiene
	 */
	private String mostrarEscoba () {
		String respuesta= "";
		if (getItems().containsKey("Escoba")) {
			respuesta= "Si";
		}
		else {
			respuesta = "No";
		}
		return respuesta;
	}
	
	
	/**
	 * comprueba si se tiene el item "ElementoExtra"
	 * @author Lucrecia Bazan
	 * @return retorna que elemento tiene (si es que lo tiene) o un mensaje avisando que no se tiene elementos
	 */
	public String mostrarElemento () {
		String respuesta = "";
		if (getItems().containsKey("ElemetoExtra")) {
			
			if (getItems().get("ElementoExtra")==1) {
				respuesta= "-Varita magica-";
			}
			if (getItems().get("ElementoExtra")==2) {
				respuesta= "-Craneo de la suerte-";
			}
			if (getItems().get("ElementoExtra")==3) {
				respuesta= "-Anteojos hechizados-";
			}
		}
		else {
			respuesta= "-No tienes elementos-";
		}
		return respuesta;
	}
	
	/**
	 * Comprueba si se tiene la habilidad "[Esclavizar demonio]"
	 * @author Lucrecia Bazan
	 * @return muestra las cargas que tiene (si es que la tiene) o 0 si es que ya no se tiene esa habilidad.
	 */
	private String mostrarEsclavizarDemonio () {
		String respuesta= "";
		if (getHabilidades().containsKey("[Esclavizar demonio]")) {
			respuesta= "\t[Esclavizar demonio] = " + getItems().get("[Esclavizar demonio]");
		} 
		else {
			respuesta= "\t[Esclavizar demonio] = 0";
		}
		return respuesta;
	}
	
	/**
	 * Comprueba si se tiene la habilidad "[Bola de fuego]"
	 * @author Lucrecia Bazan
	 * @return muestra las cargas que tiene (si es que la tiene) o 0 si es que ya no se tiene esa habilidad.
	 */
	private String mostrarBolaDeFuego() {
		String respuesta= "";
		if (getHabilidades().containsKey("[Bola de fuego]")) {
			respuesta= "\t[Bola de fuego] = " + getItems().get("[Bola de fuego]");
		} 
		else {
			respuesta = "\t[Bola de fuego] = 0";
		}
		return respuesta;
	}
	
	/**
	 * Comprueba si se tiene la habilidad "[Llamada del aquelarre]"
	 * @author Lucrecia Bazan
	 * @return muestra las cargas que tiene (si es que la tiene) o 0 si es que ya no se tiene esa habilidad.
	 */
	private String mostrarLlamadaAquelare() {
		String respuesta= "";
		if (getHabilidades().containsKey("[Llamada del aquelarre]")){
			respuesta= "\t[Llamada del aquelarre] = " + getItems().get("[Llamada del aquelarre]");
		} 
		else {
			respuesta = "\t[Llamada del aquelarre] = 0";
		}
		return respuesta;
	} 
	
	/**
	 * Sobreescrituta del metodo ToString para mostrarle al usuario los niveles de su personaje
	 */
	/*
	@Override
	public String toString() {
		return "\n\tEscoba: " + mostrarEscoba() + "\tElemento: "+ mostrarElemento() + "\t\tHabilidades: "+ mostrarEsclavizarDemonio() + mostrarBolaDeFuego() + mostrarLlamadaAquelare() ;
	}
	*/
	public String toString() {
		StringBuilder resumen = new StringBuilder();
		resumen.append("\nDescripcion: "+getDescripcionJugador());
		Iterator recorredor;
		resumen.append("\nItems:");
		recorredor= items.entrySet().iterator();
		if (!items.isEmpty()){
			if (items.get("ElementoExtra")==0) {
				resumen.append("No tienes elementos extra\n");
			}
			if (items.get("ElementoExtra")==1) {
				resumen.append("Varita magica\n");
			}	
			if (items.get("ElementoExtra")==2){
				resumen.append("Craneo de la suerte\n");
			}
			if (items.get("ElementoExtra")==3){
				resumen.append("anteojos hechizados\n");
			}
			if (items.get("Escoba")==0) {
				resumen.append("No tienes la escoba\n");
			}
			if (items.get("Escoba")==1) {
				resumen.append("Llevas la escoba\n");
			}
		}
		resumen.append("\nhabilidades:");
		if (!habilidades.isEmpty()){
			recorredor= habilidades.entrySet().iterator();
			while (recorredor.hasNext()){
				Map.Entry me= (Map.Entry) recorredor.next();
				if (0>(int)me.getValue()){
					resumen.append("\n"+me.getKey()+"\n\tUsos restantes: Infinitos");
				}else{
					resumen.append("\n"+me.getKey()+"\n\tUsos restantes: "+me.getValue());
				}
			}
		}else{
			resumen.append("No se tienen habilidades");
		}
		return resumen.toString();
}
}
