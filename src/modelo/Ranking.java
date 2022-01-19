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
			PreparedStatement consulta = n.getConnection().prepareStatement("Select u.DNI,u.Name,u.Surname,r.Score from Users as u,ranking as r, juegos as j where u.DNI=r.DNI AND j.TournamentID=r.TournamentID;");
			ResultSet result = consulta.executeQuery();
			result.next();
			persona=new Person(result.getString("DNI"),result.getString("Name"),result.getString("Surname"));			
			puntuacion=result.getInt("Score");
			result.close();
			n.disconnect();					
			} catch (SQLException error) {				
			}
		puntuaciones.add(puntuacion);
		personas.add(persona);
	}
	
	public boolean isInscrito(Person persona) {
		boolean inscrito = false;
		Connection n = new Connection();
		try {
			//TODO meter consulta que busque si la persona esta en la tabla ranking (COMPROBAR)
			PreparedStatement consulta = n.getConnection().prepareStatement("Select u.DNI from Ranking Where u.DNI = " + persona.getDni());
			ResultSet result = consulta.executeQuery();
			result.next();
			inscrito = true;
			result.close();
			n.disconnect();
		}catch (SQLException error) {
			inscrito = false;
			n.disconnect();
		}
		return inscrito;
	}
	
	//METODO QUE A�ADE A UNA PERSONA AL RANKING(BASE DE DATOS Y ARRAYLIST)
	public void addPersona(Person persona) {
		//Se a�aden los datos al ArrayList, al a�adirlos a la vez, la posicion en el ArrayList de la persona y su puntuacion es la misma
		this.personas.add(persona);
		this.puntuaciones.add(0);
		Connection n = new Connection();
		try {
			//TODO consulta que inserte a la persona en ranking (INSERT)
			PreparedStatement consulta = n.getConnection().prepareStatement(null);
			ResultSet result = consulta.executeQuery();
			result.next();
			result.close();
			n.disconnect();
			
		}catch(SQLException error) {}
		
	}
}
