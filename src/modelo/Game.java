package modelo;

import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Game {
	
	private String nombreJuego;
	private String infoJuego;
	private String precio;
	private String premio;
	private int numeroPlazas;
	private int personasApuntadas;
	private String modality;
	private int tournamentID;
	
	public Game(String nombreJuego,String infoJuego,String modality) {
		this.nombreJuego=nombreJuego;
		this.infoJuego=infoJuego;	
		this.modality=modality;
	}
	
	public int getTournamentID(){
		return this.tournamentID;
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

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
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
	
	public void getNumJuegos() {
		
	}
	
	public void anadirJuegos(Game juego) {
		Connection n = new Connection();
		int numJuegos = 0;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select GameCount from System_;");
			ResultSet result = consulta.executeQuery();
			result.next();
			numJuegos = result.getInt("GameCount");
			result.close();
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("UPDATE System_ SET GameCount ="+String.valueOf(numJuegos+1)+";");
			stat.executeUpdate("INSERT INTO Tournament (TournamentID,TournamentName,GameName,GameDescription,TournamentModality) VALUES ("+String.valueOf(numJuegos+1)+",'"+juego.getNombreJuego()+"','"+juego.getNombreJuego()+"','"+juego.getInfoJuego()+"','"+juego.getModality()+"');");
			this.tournamentID=numJuegos+1;
			stat.close();
			} catch (SQLException error) {
				 JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			}
		n.disconnect();	
	}	
}