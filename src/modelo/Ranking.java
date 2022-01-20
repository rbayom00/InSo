package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ranking {
	
	private Tournament tournament;
	private int tournamentID;
	private ArrayList<Person> personas;
	private ArrayList<Integer> puntuaciones;
	private int numParticipantes;
	private static final Logger logger = LogManager.getLogger(Ranking.class);
	
	public Ranking(Tournament tournament) {
		this.tournament=tournament;
		this.tournamentID=tournament.getTournamentID();
		rellenarPersonas(tournament.getTournamentID());
	}
	
	public Ranking(String tournamentID) {
		this.tournamentID=Integer.parseInt(tournamentID);
		rellenarPersonas(this.tournamentID);
	}
	
	public ArrayList<Person> getPersonas(){
		return personas;
	}
	
	public ArrayList<Integer> getPuntuaciones(){
		return puntuaciones;
	}
	
	private void rellenarPersonas(int tournamentID) {
		Connection n = new Connection();
		this.personas=new ArrayList<Person>();
		this.puntuaciones=new ArrayList<Integer>();
		Person persona = null;
		int puntuacion = 0;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select u.DNI,u.Name,u.Surname,r.Score from Users as u,Ranking as r, Tournament as t where u.DNI=r.PlayerDNI AND t.TournamentID='"+tournamentID+"' AND r.TournamentID='"+tournamentID+"';");			
			ResultSet result = consulta.executeQuery();
			result.next();
			String dni=result.getString("DNI");
			String name=result.getString("Name");
			String surname=result.getString("Surname");
			persona=new Person(result.getString("DNI"),result.getString("Name"),result.getString("Surname"));			
			puntuacion=result.getInt("r.Score");
			puntuaciones.add(puntuacion);
			personas.add(persona);
			result.close();								
		} catch (SQLException error) {
			logger.error("Error SQL: Error al rellenar persona en Ranking. Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
		}
		n.disconnect();		
	}	
	
	public boolean isInscrito(Person persona,Tournament juego) {
		boolean inscrito = false;
		Connection n = new Connection();
		try {
			//TODO meter consulta que busque si la persona esta en la tabla ranking (COMPROBAR)
			PreparedStatement consulta = n.getConnection().prepareStatement("Select PlayerDNI from Players Where PlayerDNI = "+persona.getDni()+" and TournamentID="+juego.getTournamentID()+";");
			ResultSet result = consulta.executeQuery();
			result.next();
			inscrito = true;
			result.close();
		}catch (SQLException error) {
			inscrito = false;			
		}
		n.disconnect();
		return inscrito;
	}
	
	//METODO QUE AÑADE A UNA PERSONA AL RANKING(BASE DE DATOS Y ARRAYLIST)
	public void addPersona(Person persona) {
		//Se añaden los datos al ArrayList, al añadirlos a la vez, la posicion en el ArrayList de la persona y su puntuacion es la misma
		this.personas.add(persona);
		this.puntuaciones.add(0);
		Connection n = new Connection();
		try {
			//TODO consulta que introduce a la persona (COMPROBAR)
			PreparedStatement consulta = n.getConnection().prepareStatement("INSERT INTO Ranking (DNI, Password, Birth_Date, Name, Surname, Address) VALUES(" + persona.getDni() +"," + persona.getContrasena() +"," + persona.getFechaNac() +"," + persona.getNombre() +"," + persona.getApellidos() +","+ persona.getDomicilio() +")");
			ResultSet result = consulta.executeQuery();
			result.next();
			result.close();			
		} catch(SQLException error) {
			logger.error("Error SQL: Error al añadir persona "+persona.getDni()+". Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
		}
		n.disconnect();
	}
	
	public boolean actualizarRanking(String dni,String puntuacion) {
		int pos=-1;
		for(int i=0;i<personas.size();i++) {
			if(personas.get(i).getDni().equals(dni)) {
				pos=i;
			}
		}
		if(pos==-1) {
			return false;
		}else {
			puntuaciones.set(pos, Integer.parseInt(puntuacion));
			Connection n = new Connection();
			try {
				Statement stat = n.getConnection().createStatement();
				stat.executeUpdate("update Ranking set Score="+Integer.parseInt(puntuacion)+" where PlayerDNI='"+dni+"' and TournamentID='"+this.tournamentID+"';");	
				stat.close();			
			} catch (SQLException error) {
				 JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
				 logger.error("Error SQL: Actualización de puntuación de ranking fallida. Comprobar conexión, query o tabla.");
				 logger.error(error.getMessage());
				return false;
			}
			n.disconnect();
			return true;
		}
	}
}
