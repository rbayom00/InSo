package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {

	private String dni, contrasena, fecha_nac, nombre, apellidos, dom;
	
	public Person(String dni,String contrasena) {
		this.dni = dni;
		this.contrasena = contrasena;
	}

	public Person(String dni,String contrasena,String fecha_nac,String nombre,String apellidos,String dom) {
		this.dni = dni;
		this.contrasena = contrasena;
		this.fecha_nac = fecha_nac;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dom = dom;
	}
	
	public boolean registrarUsuario() {
		Connection n = new Connection();
		try {
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("INSERT INTO SISTEMA VALUES ('"+this.nombre+"');");
			stat.executeUpdate("INSERT INTO USUARIOS (DNI, contrasena, fecha_nacimiento, nombre, apellidos, domicilio) VALUES ('"+this.dni+"', '"+this.contrasena+"', '"+this.fecha_nac+"', '"+this.nombre+"', '"+this.apellidos+"', '"+this.dom+"');");	
			stat.close();
			n.disconnect();
		} catch (SQLException error) {
			return false;
		}
		return true;
	}
	
	public boolean consultarInicio() {
		Connection n = new Connection();		
		String contrasenaBD;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select contrasena from usuarios where DNI='"+this.dni+"';");
			ResultSet result = consulta.executeQuery();
			result.next();
			contrasenaBD = result.getString("contrasena");
			result.close();
			n.disconnect();					
			} catch (SQLException error) {
				return false;
			}
		if(this.contrasena.equals(contrasenaBD)) {
			return true;
		}else {
			return false;
		}
	}
}