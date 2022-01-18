package modelo;

public class Game {
	
	private String nombreJuego;
	private String infoJuego;
	private String precio;
	private String premio;
	private int numeroPlazas;
	private int personasApuntadas;
	
	public Game(String nombreJuego) {		
		this.nombreJuego=nombreJuego;
	}
	
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
	
	public String getInfoJuego() {
		return infoJuego;
	}

	public void setInfoJuego(String infoJuego) {
		this.infoJuego = infoJuego;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	public int getPersonasApuntadas() {
		return personasApuntadas;
	}

	public void setPersonasApuntadas(int personasApuntadas) {
		this.personasApuntadas = personasApuntadas;
	}

	public String getNombreJuego() {
		return this.nombreJuego;
	}
	
}