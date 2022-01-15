package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ranking {
	
	private Game game;
	private ArrayList<Person> personas;
	private int numParticipantes;
	
	public Ranking(Game game) {
		this.game=game;
		rellenarPersonas();
	}
	
	public ArrayList<Person> getPersonas(){
		return personas;
	}
	
	private void rellenarPersonas() {
		Connection n = new Connection();
		Person p;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select u.nombre,u.apellidos from usuarios as u,ranking as r where u.DNI=r.DNI;");
			ResultSet result = consulta.executeQuery();
			result.next();
			p=new Person(result.getString("dni"),result.getString("nombre"),result.getString("apellidos"));
			personas.add(p);
			result.close();
			n.disconnect();					
			} catch (SQLException error) {				
			}
	}
}
