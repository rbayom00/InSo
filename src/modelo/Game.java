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
	
	public String getNombreJuego() {
		return this.nombreJuego;
	}
}