package tpFinal;

/**
 * Clase generica la cual solo puede recibir clases hijas de Jugadores
 * @author Lautaro, Lucrecia
 *
 * @param <T>
 */

public class Juego <T extends Jugador>{

	
		private T heroe;
		//private ArrayList<Enemigo> enemigos;
		
		public Juego(T persoanjeElegido){
			heroe= persoanjeElegido;
			//enemigos= new ArrayList<Enemigo>();
		}
	
	
	/**
	 * Metodo generico que lanzará una exception de tipo FinDelJuegoException si el jugador pierde
	 * @param heroeR jugador seleccionado
	 * @throws FinDelJuegoException
	 */
	public <T> void anteLasPuertasDeLaMuerte (T heroeR) throws FinDelJuegoException {
	/*	if (heroeR instanceof JugadorLautaro) {
			if (((JugadorLautaro) heroeR).getVitalidad()<=0) {
				if (((JugadorLautaro) heroeR).getItems().containsKey("Medicina")) {
					((JugadorLautaro) heroeR).setVitalidad((int)((JugadorLautaro) heroeR).getMaxVitalidad()/2);
					((JugadorLautaro) heroeR).disminuirItem("Medicina");
				}else {
					if (!((JugadorLautaro) heroeR).getHabilidades().isEmpty()){
						((JugadorLautaro) heroeR).setVitalidad(25);
						((JugadorLautaro) heroeR).disminuirHabilidad("[Engañar a la muerte]");
					}else {
						throw new FinDelJuegoException(((JugadorLautaro) heroeR).getPseudonimo()+" a muerto");
					}
				}
			}
		}else {*/
			if (heroeR instanceof JugadorLucrecia) {
				if ((((JugadorLucrecia) heroeR).getNivelDeEstres()>=100)){
					throw new FinDelJuegoException(((JugadorLucrecia) heroeR).getPseudonimo()+" no pudo aguantar la presion y sufrio un ataque al corazon");
				}
				if (((JugadorLucrecia) heroeR).getNivelDeMagia()<=0){
					throw new FinDelJuegoException(((JugadorLucrecia) heroeR).getPseudonimo()+" sin magia restante se desmalla, nunca mas se supo de ella");
				}
				if (((JugadorLucrecia) heroeR).getNivelDeMagia()>=100){
					throw new FinDelJuegoException(((JugadorLucrecia) heroeR).getPseudonimo()+", cargada con mas magia de la que su cuerpo resistia estalla cual globo de viceras, sangre y magia");
				}
			}
		}
}

