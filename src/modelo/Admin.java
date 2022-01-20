package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Clase que implementa la lógica del usuario Administrador
 * @author Carballo
 */

public class Admin extends Person{
	
	private static final Logger logger = LogManager.getLogger(Admin.class);
	
	public Admin(String dni, String contrasena, String fecha_nac, String nombre, String apellidos, String dom) {
		super(dni, contrasena, fecha_nac, nombre, apellidos, dom);
	}
	
	/*
	 * Devuelve una lista con todos los perfiles de la base de datos
	 */
	public ArrayList<Person> getProfileList() {
		ArrayList<Person> profileList = new ArrayList<Person>();
		Connection n = new Connection();
		try {
			PreparedStatement query = n.getConnection().prepareStatement("SELECT * from Users;");
			ResultSet result = query.executeQuery();
			while(result.next()) {
				Person p = new Person(result.getString("DNI"), result.getString("Password"), result.getString("Birth_Date"), result.getString("Name"), result.getString("Surname"), result.getString("Address"));
				profileList.add(p);
			}
			result.close();				
		} catch (SQLException error) {
			logger.error("Error SQL: Obtención de tabla de usuarios fallida. Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
		}
		n.disconnect();
		return profileList;
	}	
	
	/*
	 * Modifica un perfil con la nueva información recibida de dicho perfil
	 */
	public boolean modifyPerson(String personDNI, String attr, String content) {
		Connection n = new Connection();
		boolean d = false;
		try {
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("UPDATE Users SET "+attr+" = '"+content+"' WHERE DNI = '"+personDNI+"';");
			logger.info("Modificación de usuario "+personDNI+" en la base de datos correcto");
			d = true;
		} catch (SQLException error) {
			logger.error("Error SQL: Error al actualizar el usuario "+personDNI+". Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
		}
		n.disconnect();
		return d;
	}
	
	/*
	 * Inserta un nuevo perfil con la información recibida de dicho perfil
	 */
	public boolean addPerson(Person p) {
		Connection n = new Connection();
		boolean d = false;
		try {
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("INSERT INTO Users (DNI, Password, Birth_Date, Name, Surname, Address) VALUES('"+p.getDni()+"', '"+p.getContrasena()
			+"', '"+p.getFechaNac()+"', '"+p.getNombre()+"', '"+p.getApellidos()+"', '"+p.getDomicilio()+"');");
			logger.info("Creación de usuario "+p.getDni()+" en la base de datos correcto");
			d = true;
		} catch (SQLException error) {
			logger.error("Error SQL: Error al crear el usuario "+p.getDni()+". Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
		}
		n.disconnect();
		return d;
	}
	
	/*
	 * Borra el perfil del DNI indicado en el argumento
	 */
	public void removePerson(String personDNI) {
		Connection n = new Connection();
		try {
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("DELETE FROM Users WHERE DNI = '"+personDNI+"';");
			logger.info("Borrado de usuario "+personDNI+" de la base de datos correcto");
		} catch (SQLException error) {
			logger.error("Error SQL: Error al eliminar el usuario "+personDNI+". Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
		}
		n.disconnect();
	}
	
	
	
}