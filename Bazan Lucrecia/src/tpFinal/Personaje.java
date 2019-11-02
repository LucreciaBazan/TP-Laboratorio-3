package tpFinal;

public class Personaje {

private String nombreCompleto;

	public Personaje(String nombreR) {
		setNombreCompleto(nombreR);
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Override
		public String toString() {
			return "\nNombre: " +getNombreCompleto();
		}
}