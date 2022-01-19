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
}
