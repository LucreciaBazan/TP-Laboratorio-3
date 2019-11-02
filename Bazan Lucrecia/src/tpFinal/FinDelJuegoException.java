package tpFinal;

/**
 * Excepcion para que se utilizará cuando el usuario pierda la partida
 * @author Lautaro, Lucrecia
 *
 */
public class FinDelJuegoException extends Exception {
	private String clave;
	
	public FinDelJuegoException(String clave) {
		super(clave);
		this.clave=clave;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage()+ clave;
	}
}