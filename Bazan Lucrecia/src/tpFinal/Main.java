package tpFinal;


import java.util.Scanner; 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import JSON.JsonJugadorLucrecia;


public class Main {

	public static void main(String[] args) {
	
		JugadorLucrecia lucrecia = new JugadorLucrecia();
		Juego<JugadorLucrecia> juego = new Juego<JugadorLucrecia>(lucrecia);
		Scanner scan = new Scanner(System.in);
		int opcion=0;
		JSONArray registro = new JSONArray();
		
		//CAPITULO UNO//
		System.out.println(lucrecia.toString());
		System.out.println(lucrecia.capituloUno());
		try {
		opcion = scan.nextInt();
		if (opcion==1) {
			System.out.println(lucrecia.beberPocima());
			} 
		if (opcion==2) {
			System.out.println(lucrecia.tomarElementoAleatoriamente());
			}
		if (opcion==3) {
			System.out.println(lucrecia.desenlaceCapituloUno(opcion));
			lucrecia.aumentarPuntaje(20);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	

	
	
		//CAPITULO DOS//
		lucrecia.limpiar(60);
		System.out.println(lucrecia.toString());
		System.out.println(lucrecia.capituloDos());
		try {
		opcion = scan.nextInt();
		if (opcion==1) {
			System.out.println(lucrecia.disminuirHabilidad("[Bola de fuego]"));
			} 
		if (opcion==2) {
				lucrecia.realizarHechizo();
			}
		if (opcion==3) {
			System.out.println(lucrecia.disminuirHabilidad("[Esclavizar demonio]"));
			}
		System.out.println(lucrecia.desenlaceCapituloDos(opcion));
		juego.anteLasPuertasDeLaMuerte(lucrecia);
		lucrecia.aumentarPuntaje(20);
		} catch (FinDelJuegoException e) {
			e.getMessage();
			try {
				JSONObject jsonObjeto = new JSONObject();
				jsonObjeto.put("Pseudonimo", lucrecia.getPseudonimo());
				jsonObjeto.put("Puntaje", lucrecia.getPuntaje());
				jsonObjeto.put("Nivel de magia", lucrecia.getNivelDeMagia());
				jsonObjeto.put("Nivel de estres", lucrecia.getNivelDeEstres());
				
				JSONArray registroPuntaje = new JSONArray();
				registroPuntaje.put(jsonObjeto);
				JsonJugadorLucrecia.grabar(registroPuntaje);
				} catch (JSONException e2){
					e2.getMessage();
				}
		} catch (Exception e) {
			e.getMessage();
		}
	
		
		
		//CAPITULO TRES//
		lucrecia.limpiar (60);
		System.out.println(lucrecia.capituloTres());
		try {
		opcion = scan.nextInt();
		if (opcion==1) {
			System.out.println(lucrecia.disminuirHabilidad("[Llamada del aquelarre]"));
			} 
		if (opcion==2) {
				System.out.println(lucrecia.aumentarNivelDeEstres(10));
			}
		if (opcion==3) {
			System.out.println(lucrecia.noBuscarLibro());
			}
		System.out.println(lucrecia.desenlaceCapituloTres(opcion));
		juego.anteLasPuertasDeLaMuerte(lucrecia);
		lucrecia.aumentarPuntaje(20);
		registro= lucrecia.guardarJSON();
		JsonJugadorLucrecia.grabar(registro);
		} catch (FinDelJuegoException e) {
			e.getMessage();
			try {
				JSONObject jsonObjeto = new JSONObject();
				jsonObjeto.put("Pseudonimo", lucrecia.getPseudonimo());
				jsonObjeto.put("Puntaje", lucrecia.getPuntaje());
				jsonObjeto.put("Nivel de magia", lucrecia.getNivelDeMagia());
				jsonObjeto.put("Nivel de estres", lucrecia.getNivelDeEstres());
				
				JSONArray registroPuntaje = new JSONArray();
				registroPuntaje.put(jsonObjeto);
				JsonJugadorLucrecia.grabar(registroPuntaje);
				} catch (JSONException e2){
					e2.getMessage();
				}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	
		
		//CAPITULO CUATRO//
		lucrecia.limpiar(60);
		System.out.println(lucrecia.toString());
		int num= lucrecia.tieneElemento();
		System.out.println(lucrecia.capituloCuatro());
		try {
		opcion = scan.nextInt();
		
		if (opcion==1) {
			if (num>0) {
			if (num==1) {
				System.out.println("\nHas usado: Varita magica, que produjo un hechizo poderoso para una situación desesperada.\n");
			}else {
				if (num==2) {
					System.out.println("\nHas usado: Craneo de la suerte. Su suerte te permitio safarte de un gran problema.\n");
				}else {
						System.out.println("\nHas usado: Anteojos hechizados. Te permitieron hacerte invisibles ante tus enemigos.\n");
				}
			}
			} else {
				System.out.print("¡No tienes elementos!");
			}
			
			}
		if (opcion==2) {
			System.out.println(lucrecia.usarMaximoHechizo());
		}
		if (opcion==3) {
			System.out.println(lucrecia.disminuirHabilidad("[Llamada del aquelarre]"));
			}
		System.out.println(lucrecia.desenlaceCapituloCuatro(opcion));
		juego.anteLasPuertasDeLaMuerte(lucrecia);
		lucrecia.aumentarPuntaje(20);
		registro= lucrecia.guardarJSON();
		JsonJugadorLucrecia.grabar(registro);
		} catch (FinDelJuegoException e) {
			e.getMessage();
			try {
				JSONObject jsonObjeto = new JSONObject();
				jsonObjeto.put("Pseudonimo", lucrecia.getPseudonimo());
				jsonObjeto.put("Puntaje", lucrecia.getPuntaje());
				jsonObjeto.put("Nivel de magia", lucrecia.getNivelDeMagia());
				jsonObjeto.put("Nivel de estres", lucrecia.getNivelDeEstres());
				
				JSONArray registroPuntaje = new JSONArray();
				registroPuntaje.put(jsonObjeto);
				JsonJugadorLucrecia.grabar(registroPuntaje);
				} catch (JSONException e2){
					e2.getMessage();
				}
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		 
		 
		
		//CAPITULO CINCO//
		lucrecia.limpiar(60);
		System.out.println(lucrecia.toString());
		System.out.println(lucrecia.capituloCinco());
		lucrecia.aumentarPuntaje(20);
		registro= lucrecia.guardarJSON();
		try {
			JSONObject jsonObjeto = new JSONObject();
			jsonObjeto.put("Pseudonimo", lucrecia.getPseudonimo());
			jsonObjeto.put("Puntaje", lucrecia.getPuntaje());
			jsonObjeto.put("Nivel de magia", lucrecia.getNivelDeMagia());
			jsonObjeto.put("Nivel de estres", lucrecia.getNivelDeEstres());
			
			JSONArray registroPuntaje = new JSONArray();
			registroPuntaje.put(jsonObjeto);
			JsonJugadorLucrecia.grabar(registroPuntaje);
			} catch (JSONException e2){
				e2.getMessage();
			}
		
		scan.close();
	}
}

	



	
		




