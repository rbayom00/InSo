package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ranking {
	
	private Game game;
	private ArrayList<Person> personas;
	private ArrayList<Integer> puntuaciones;
	private int numParticipantes;
	
	public Ranking(Game game) {
		this.game=game;
		rellenarPersonas();
	}
	
	public ArrayList<Person> getPersonas(){
		return personas;
	}
	
	public ArrayList<Integer> getPuntuaciones(){
		return puntuaciones;
	}
	
	private void rellenarPersonas() {
		Connection n = new Connection();
		this.personas=new ArrayList<Person>();
		this.puntuaciones=new ArrayList<Integer>();
		Person persona = null;
		int puntuacion = 0;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select u.DNI,u.Name,u.Surname,r.Score from Users as u,Ranking as r, Tournament as t where u.DNI=r.PlayerDNI AND t.TournamentID=r.TournamentID;");
			ResultSet result = consulta.executeQuery();
			result.next();
			persona=new Person(result.getString("DNI"),result.getString("Name"),result.getString("Surname"));			
			puntuacion=result.getInt("Score");
			result.close();								
			} catch (SQLException error) {				
			}
		n.disconnect();
		puntuaciones.add(puntuacion);
		personas.add(persona);
	}	
	
	public boolean isInscrito(Person persona,Game juego) {
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
		}catch(SQLException error) {}
		n.disconnect();
	}
}
