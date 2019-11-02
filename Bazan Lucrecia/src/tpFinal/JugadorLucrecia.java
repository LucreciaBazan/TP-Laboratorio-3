package tpFinal;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;
import java.util.Scanner;

	/**
	 * Clase para la creación del personaje "Lucrecia". Sirve para crear el objeto y contiene todas las implementaciones que el personaje puede realizar
	 * @author Lucrecia Bazan  
	 */
public class JugadorLucrecia extends Jugador implements IHistoria{

	private int nivelDeMagia; //de 0-100
	private int nivelDeEstres; //de 0-100
	private String pseudonimo;
	private int puntaje;
	
	

	/**
	 * Constructor que inicializa un objeto (el personaje) con los valores necesarios para el comienzo del juego
	 * @author Lucrecia Bazan
	 */
	public JugadorLucrecia (){
		super("Hechicera oscura", "Escoba", "ElementoExtra", "[Esclavizar demonio]", "[Bola de fuego]" , "[Llamada del aquelarre]");
		setNivelDeMagia(0);
		setNivelDeEstres(0);
		
	}


	// METODOS GET - SET //
	public int getNivelDeMagia() {
		return nivelDeMagia;
	}
	private void setNivelDeMagia(int nivelDeMagiaR) {
		nivelDeMagia = nivelDeMagiaR;
	}
	public int getNivelDeEstres() {
		return nivelDeEstres;
	}

	private void setNivelDeEstres(int nivelDeEstresR) {
		nivelDeEstres= nivelDeEstresR;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public int getPuntaje() {
		return nivelDeMagia;
	}
	private void setPuntaje(int puntajeR) {
		puntaje = puntajeR;
	}
	
	
	/**
	 * Aumenta el puntaje del jugador 
	 * @param puntajeR es la cant de puntaje a incrementar
	 */
	public void aumentarPuntaje (int puntajeR) {
		int total = getPuntaje()+puntajeR;
		setPuntaje(total);
	}

	/**
	 *Suma lo ingresado por parametro al nivel de estres actual 
	 * @author Lucrecia Bazan
	 * @param nivelDeEstresR es la cantidad en que se quiere aumentar el nivel de estres 
	 * @return mensaje avisandole al usuario lo sucedido
	 */
	public String aumentarNivelDeEstres(int nivelDeEstresR) {
		String respuesta="";
		int total= getNivelDeEstres()+ nivelDeEstresR;
		setNivelDeEstres(total);
		respuesta= "\n¡Ha aumentado tu estres! Tu nuevo nivel es: "+getNivelDeEstres();
		return respuesta;
	}

	/**
	 *Resta lo ingresado por parametro al nivel de estres actual 
	 * @author Lucrecia Bazan
	 * @param numR es la cant en que se quiere disminuir el nivel de estres 
	 * @return mensaje avisandole al usuario lo sucedido
	 */
	public String disminuirNivelDeEstres(int numR) {
		String respuesta="";
		int total= getNivelDeEstres()- numR;
		setNivelDeEstres(total);
		respuesta= "\n¡Ha disminuido tu estres! Tu nuevo nivel es: "+getNivelDeEstres();
		return respuesta;
	}

	/**
	 *Suma lo ingresado por parametro al nivel de magia actual 
	 * @author Lucrecia Bazan
	 * @param nivelDeMagiaR es la cantidad en que se quiere aumentar el nivel de magia
	 * @return mensaje avisandole al usuario lo sucedido
	 */
	private String aumentarNivelDeMagia(int nivelDeMagiaR) {
		String respuesta="";
		int total= getNivelDeMagia() + nivelDeMagiaR;
		setNivelDeMagia(total);
		respuesta= "\n¡Ha aumentado tu magia! Tu nuevo nivel es: "+getNivelDeMagia();
		return respuesta;
	}

	/**
	 *Resta lo ingresado por parametro al nivel de magia actual 
	 * @author Lucrecia Bazan
	 * @param numR es la cantidad en que se quiere disminuir el nivel de magia
	 * @return mensaje avisandole al usuario lo sucedido
	 */
	private String disminuirNivelDeMagia (int numR) {
		String respuesta="";
		int total= getNivelDeMagia() - numR;
		setNivelDeMagia(total);
		respuesta= "\n¡Ha disminuido tu magia! Tu nuevo nivel es: "+ getNivelDeMagia();
		return respuesta;
	}


	//metodos de usuario

	/**
	 * Aumenta el nivel de magia a 99 (su maximo) y le sube 5 al nivel de estres
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario lo sucedido
	 */
	public String beberPocima (){
		setNivelDeMagia(99);
		aumentarNivelDeEstres(5);
		return "Has aumentado tu magia en su totalidad";
	}
	
	/**
	 * obtiene un elemento de forma random entre 1 2 y 3, en donde 1 es varita magica, 2 es craneo de la suerte y 3 es anteojos hechizados
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario que elemento le ha tocado y para que sirve el mismo.
	 */
	public String tomarElementoAleatoriamente () {
		String respuesta="";
		int numRandom=0;
		Random  random = new Random();
		numRandom= (int)(random.nextDouble() * 3 + 0);
		if (numRandom==1) {
			setItems("ElementoExtra", 1);
			respuesta= "Has tomado: Varita magica. Produce un hechizo poderoso para una situación desesperada.";
		} else {
			if (numRandom==2) {
				setItems("ElementoExtra", 2);
				respuesta= "Has tomado: Craneo de la suerte. Su suerte te permitira safarte de un gran problema.";
			} else {
				setItems("ElementoExtra", 3);
				respuesta="Has tomado: Anteojos hechizados. Te permitiran hacerte invisibles ante tus enemigos.";
			}
		}
		return respuesta;
	}

	/**
	 * atrapa el elemento elegido por el usuario, en donde 1 es varita magica, 2 es craneo de la suerte y 3 es anteojos hechizados
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario que elemento tiene y para que sirve el mismo.
	 */
	public String tomarElementoElegido () {
		String respuesta="";
		int opcion=-1;
		Scanner scan = new Scanner(System.in);
		opcion = scan.nextInt();
		if (opcion==1) {
			setItems("ElementoExtra", 1);
			respuesta= "Has tomado: Varita magica. Produce un hechizo poderoso para una situación desesperada.";
		} else {
			if (opcion==2) {
				setItems("ElementoExtra", 2);
				respuesta= "Has tomado: Craneo de la suerte. Su suerte te permitira safarte de un gran problema.";
			} else {
				setItems("ElementoExtra", 3);
				respuesta="Has tomado: Anteojos hechizados. Te permitiran hacerte invisibles ante tus enemigos.";
			}
		}
		scan.close();
		return respuesta;
	}

	/**
	 * reduce el nivel de magia en 10 cada vez que se llame para realizar un hechizo
	 * @author Lucrecia Bazan
	 */
	public void realizarHechizo () {
			disminuirNivelDeMagia(10);
	}

	/**
	 * Reduce el nivel de magia a la mitad del nivel que se tenia actualmente 
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario lo sucedido y los niveles que le han quedado
	 */
	public String noBuscarLibro () {
		int respuesta=0;
		respuesta= getNivelDeMagia()/2;
		setNivelDeMagia(respuesta);
		return "¡Ha disminuido tu nivel de magia a la mitad! Ahora tienes: " + getNivelDeMagia();
	}

	/**
	 * Quita de magia el 90% de los niveles que se tenian en nivel de magia
	 * @author Lucrecia Bazan
	 * @return mesaje avisandole al usuario lo sucedido y los niveles que le han quedado
	 */
	public String usarMaximoHechizo () {
		int total=0;
		float porcentaje=0;
		porcentaje= (getNivelDeMagia()*90)/100;
		total= (int) (getNivelDeMagia()-porcentaje);
		setNivelDeMagia(total);
		return "\n¡Se ha disminuido casi por completo tu magia! Ahora tienes: " + getNivelDeMagia();
	}

	/**
	 * Aumenta el nivel de Estres en 30 y disminuye el nivel de magia en 30
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario lo sucedido y los niveles que le han quedado
	 */
	public String aplicarEmbrujoDeEmergencia () {
		aumentarNivelDeEstres(30);
		disminuirNivelDeMagia(30);
		return "\n¡Tus niveles de magia y estres han cambiado! Los nueves niveles son: Magia= "+getNivelDeMagia()+" Estres: "+getNivelDeEstres();
	}

	/**
	 * Aumenta el nivel de Estres en 20 y aumenta el nivel de Magia en 10
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario lo sucedido y los niveles que le han quedado
	 */
	public String adoptarTroll () {
		aumentarNivelDeEstres(20);
		aumentarNivelDeMagia(10);
		return "\n¡Tus niveles de magia y estres han cambiado! Los nueves niveles son: Magia= "+getNivelDeMagia()+" Estres: "+getNivelDeEstres();
	}

	/**
	 * Aumenta el nivel de Estres en 50
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario lo sucedido y los niveles que le han quedado
	 */
	public String huir () {
		aumentarNivelDeEstres(50);
		return "¡Has huido como una cobarde! Tu nuevo nivel de estres es: "+getNivelDeEstres();
	}
	
	
	
	//Metodos sobreescritos de la clase abstracta
	/**
	 * Permite cargar un item si es que no se lo tiene. Cada item tiene un solo uso.
	 * @param item que se desea cargar
	 * @author Lucrecia Bazan
	 * @return mensaje avisando al usuario que el item se ha cargado correctamente
	 */
	@Override
	public String aumentarItem(String itemR) {
		String respuesta= "";
		setItems(itemR, 1);
		respuesta= "\nItem cargado";
		return respuesta;
	}
	
	/**
	 * Permite cargar en 3 unidades la habilidad que se le envia, si es que no tiene cargas. 
	 * @param habilidad que se desea cargar
	 * @author Lucrecia Bazan
	 * @return mensaje avisando al usuario que la habilidad esta cargada correctamente.
	 */
	@Override
	public String aumentarHabilidad(String habilidadR) {
		String respuesta= "";
			setHabilidades(habilidadR,3);
			respuesta= "\nHabilidad cargada";
		return respuesta;
	}
	
	/**
	 * Elimina el item una vez que es utilizado, ya que tiene un solo uso.
	 * @param item que se desea utilizar
	 * @author Lucrecia Bazan
	 * @return mensaje avisando al usuario que el item ha sido utilizado.
	 */
	@Override
	public String disminuirItem(String itemR) {
	 String respuesta= "";
	 if (getItems().get(itemR)>0) {
		 getItems().remove(itemR); //lo elimino porque mis items solo pueden tenerse o no tenerse. 
		 respuesta= "\nItem utilizado";
	 }
	 return respuesta;
	}
	
	/**
	 * Disminuye en 1 la habilidad si es que tiene cargas, y si ha utilizado la ultima lo elimina.
	 * @param habilidad que se desea disminuir
	 * @author Lucrecia Bazan
	 * @return mensaje avisandole al usuario lo sucedido
	 */
	@Override
	public String disminuirHabilidad(String habilidadR) {
	 String respuesta= "";
	 int cant = 0;
	 if (getHabilidades().get(habilidadR)>0) {
		 cant = getHabilidades().get(habilidadR);
		 setHabilidades(habilidadR, cant--);
		 if (getHabilidades().get(habilidadR)== 0) {
			 getHabilidades().remove(habilidadR);//lo elimino porque se acabaron
			 respuesta= "\n¡Has acabado tu habilidad: " + habilidadR;
		 }
		 respuesta= "\nHabilidad utilizada";
	 }
	 return respuesta;
	}
	

	
	
	
	//Sobreescritura de metodos de interfaz
	@Override
		public String capituloUno() {
			return "\n\nOtra mañana de neblina en el bosque…\n" + 
					"Despierto una vez más.\n" + 
					"No se escucha un solo sonido, “Que extraño” pensé. \n" + 
					"Parecía ser un estupendo día libre de trabajo.\n" + 
					"Esperen….\n" + 
					"ES HOY\n" + 
					"\nYa es tarde, demasiado tarde, no puedo permitirlo. Deberé volar en mi escoba. Quizás necesite algo más…\n" + 
					"\tOpción 1: Beber pócima (aumenta por completo el nivel de magia+5 stress)\n" + 
					"\tOpción 2: Tomar un elemento al azar (permite llevar un elemento + stress)\n" + 
					"\tOpción 3: Irse rápidamente sin tomar nada (avanza rápidamente + 0 stress)\n";
		}
	
	@Override
		public String capituloDos() {
			return "\n\n\t\t***ALERTA***   ***ALERTA***   ***ALERTA***   ***ALERTA***\n" + 
					"Has notado que dos gigantes te persiguen. Se acercan rápidamente y debes zafarte de ellos. ¿Qué estrategia decides usar?\n" + 
					"\tOpción 1: Usar [Bola de fuego] en las bestias\n" + 
					"\tOpción 2: Aplicar hechizo en las bestias\n" + 
					"\tOpción 3: Usar [Esclavizar demonio] (consume una carga)\n" ;
		}
	
	@Override
		public String capituloTres() {
		return "\n\nVamos… ya casi llegas. Esto de repente se ha tornado muy tranquilo, y ligero. Espera un momento…\n" + 
				"¡Oh no! Has perdido tu libro de hechizos, el cual contiene tus más oscuros conjuros. Es importante que nadie lo tome y haga mal uso de él. Debes decidir rápido…\n" + 
				"\tOpción 1: Usar [Llamada del aquelarre] para pedir ayuda (consume una carga). \n" + 
				"\tOpción 2: Recorrer todo el bosque en búsqueda de tu libro  (+10stress)\n" + 
				"\tOpción 3: Decides no buscarlo por tener poco tiempo. Esto reducirá tu nivel de magia a la mitad por ser una bruja irresponsable.\n";
		}
	
	@Override
		public String capituloCuatro() {
			return "\n\n-¿Qué es ese ruido?... Oh mier** \n" + 
					"Eres emboscada por un grupo de cazadores de brujas que rápidamente consiguen acorralarte. ¿Qué deseas hacer?\n" + 
					"\tOpción 1: Utilizar elemento extra (si los tiene)\n" + 
					"\tOpción 2: Utilizar “máximo hechizo” (gasta casi  por completo el nivel de magia)\n" + 
					"\tOpción 3: Usar [Llamada del aquelarre] para pedir ayuda (consume una carga).\n";
			
		}
	
	@Override
		public String capituloCinco() {
			return "\n\n-Gracias al señor oscuro, por fin he llegado.\n" +
					"Este es el gran día, en que por fin voy a entregar mi tp final\n" +
					"Profesor benoffi, ¿Qué nota ha decidido?\n" ;
		}
	
	@Override
		public String elementoExtra() {
			return  "1: - Varita mágica -\n" + 
					"2: - Cráneo de la suerte -\n" + 
					"3: - Anteojos hechizados -\n";
		}
	
	@Override
		public String desenlaceCapituloUno(int opcionR) {
			String respuesta="";
			if (opcionR==1) {
				respuesta= "\nHas completado tus niveles de magia\n";
			} 
			else {
				if (opcionR==2) {
					respuesta = mostrarElemento();
				} 
				else {
					respuesta = "\nNo tengo tiempo, ya debo irme…\n";
				}
			}
			return respuesta;
		}
	
	@Override
		public String desenlaceCapituloDos(int opcionR) {
			String respuesta = "";
			if (opcionR==1) {
				respuesta= "Tanto tu atacante como tu escoba arden pero tu logras no morir en la caída, stress +10";
			}
			else {
				if (opcionR==2) {
					respuesta = "El cielo se torna oscuro y los gigantes se paralizan. Se miran a los ojos, y comienzan a atacarse entre si mismos. Logras escapar mientras ellos se distraen";
				}
				else {
					respuesta = "Has invocado un espiritu demoniaco que seduce a las bestias las cuales dejan de perseguirte +15 stress)";
				}
			}
			return respuesta;
		}
			
	@Override
		public String desenlaceCapituloTres(int opcionR) {
			String respuesta = "";
			if (opcionR==1) {
				respuesta ="Te han ayudado pero se han burlado de ti (+20 stress)";
			}
			else {
				if (opcionR==2) {
					respuesta = "Has encontrado tu libro!";
				}
				else {
					respuesta = "";
				}
			}
			return respuesta;
		}
	
	@Override
		public String desenlaceCapituloCuatro(int opcionR) {
			String respuesta= "";
			if (opcionR==1) {
				respuesta ="\nUf, eso estuvo cerca…”";
			}
			else {
				if (opcionR==2) {
					respuesta = "\nEsto me ha dejado agotada. Necesito llegar pronto";
				}
				else {
					respuesta = "\nQue sea una pelea justa, ¿verdad?";
				}
			}
			return respuesta;
		}
		
	
	
	
	
	/**
	 * Sobreescrituta del metodo ToString para mostrarle al usuario los niveles de su personaje
	 */
	@Override
		public String toString() {
			return super.toString() + "\n\tNivel de magia: "+ getNivelDeMagia() + "\n\tNivel de estres: " + getNivelDeEstres();
		}
	
	//metodos json
	
	public JSONArray guardarJSON() 
	{
		try {
		JSONObject jsonObjeto = new JSONObject();
		jsonObjeto.put("Pseudonimo", getPseudonimo());
		jsonObjeto.put("Puntaje",getPuntaje());
		jsonObjeto.put("Nivel de magia",getNivelDeMagia());
		jsonObjeto.put("Nivel de estres",getNivelDeEstres());
		
		JSONArray registroPuntaje = new JSONArray();
		registroPuntaje.put(jsonObjeto);
		
		return registroPuntaje;
		
		} catch (JSONException e){
			e.getMessage();
		}
		return null;
		
	}
	
	
} 