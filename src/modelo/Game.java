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
	
	public void anadirJuegos(Game juego) {
		Connection n = new Connection();
		int numJuegos = 0;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select numJuegos from SISTEMA;");
			ResultSet result = consulta.executeQuery();
			result.next();
			numJuegos = result.getInt("numJuegos");
			result.close();
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("UPDATE SISTEMA SET numJuegos ="+String.valueOf(numJuegos+1)+";");	
			stat.executeUpdate("INSERT INTO JUEGOS (numeroJuego,nombreJuego) VALUES ("+String.valueOf(numJuegos+1)+",'"+juego.getNombreJuego()+"');");
			stat.close();
			n.disconnect();					
			} catch (SQLException error) {
				 JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			}
	}	
}