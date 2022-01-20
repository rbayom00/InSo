package modelo;

import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controlador.Main;

public class Tournament {
	
	private String nombreJuego;
	private String infoJuego;
	private String precio;
	private String premio;
	private int numeroPlazas;
	private int personasApuntadas;
	private String modality;
	private int tournamentID;
	private static final Logger logger = LogManager.getLogger(Tournament.class);
	
	public Tournament(String nombreJuego,String infoJuego,String modality) {
		this.nombreJuego=nombreJuego;
		this.infoJuego=infoJuego;	
		this.modality=modality;		
	}
	
	public int getTournamentID(){
		return this.tournamentID;
	}
	
	public void setTournamentID(int tournamentID){
		this.tournamentID=tournamentID;
	}
	
	public void setNombreTorneo(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
	
	public String getNombreTorneo() {
		return this.nombreJuego;
	}
	
	public String getInfoTorneo() {
		return infoJuego;
	}

	public void setInfoTorneo(String infoJuego) {
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
	
	public void getNumTorneos() {
		
	}
	
	public void anadirJuegos(Tournament torneo) {
		Connection n = new Connection();
		int numJuegos = 0;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select GameCount from System_;");
			ResultSet result = consulta.executeQuery();
			result.next();
			numJuegos = result.getInt("GameCount");
			result.close();
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("UPDATE System_ SET GameCount ="+String.valueOf(numJuegos+1)+" where SystemName='VCApp';");
			stat.executeUpdate("INSERT INTO Tournament (TournamentID,TournamentName,GameName,GameDescription,TournamentModality) VALUES ("+String.valueOf(numJuegos+1)+",'"+torneo.getNombreTorneo()+"','"+torneo.getNombreTorneo()+"','"+torneo.getInfoTorneo()+"','"+torneo.getModality()+"');");
			this.tournamentID=numJuegos+1;
			stat.close();
			} catch (SQLException error) {
				 JOptionPane.showMessageDialog(null, "Problema al completar tu petición, inténtalo de nuevo.","BBDD Error",JOptionPane.ERROR_MESSAGE);
				 logger.error("Error SQL: Error al crear el torneo "+torneo.getNombreTorneo()+". Comprobar conexión, query o tabla.");
				 logger.error(error.getMessage());
			}
		n.disconnect();	
	}	
}