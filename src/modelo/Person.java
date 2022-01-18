package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controlador.Main;

import javax.swing.JOptionPane;

import java.security.NoSuchAlgorithmException;

public class Person {

	private static final Logger logger = LogManager.getLogger(Main.class);
	private String dni, contrasena, fecha_nac, nombre, apellidos, dom;
	
	public Person(String dni,String nombre,String apellidos) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
	}
	
	public Person(String dni,String contrasena) {
		this.dni = dni;
		try{
			this.contrasena = Hashing.toString(Hashing.getSHA(contrasena));
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error interno (Hashing): "+e.getMessage());
		}
	}

	public Person(String dni,String contrasena,String fecha_nac,String nombre,String apellidos,String dom) {
		this.dni = dni;
		try{
			this.contrasena = Hashing.toString(Hashing.getSHA(contrasena));
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error interno (Hashing): "+e.getMessage());
		}
		this.fecha_nac = fecha_nac;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dom = dom;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public String getDomicilio() {
		return this.dom;
	}
	
	public String getFechaNac() {
		return this.fecha_nac;
	}
	
	public String getDni() {
		return this.dni;
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
			 JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			 logger.error("Error SQL: Registro de usuario fallido. Comprobar conexión, query o tabla.");
			 logger.error(error.getMessage());
			return false;
		}
		logger.info("Registro de usuario "+this.dni+" correcto.");
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
				logger.error("Error SQL: Login de usuario "+this.dni+" incorrecto. Comprobar conexión, query o tabla.");
				logger.error(error.getMessage());
				return false;
			}
		if(this.contrasena.equals(contrasenaBD)) {
			logger.info("Login de usuario "+this.dni+" correcto.");
			return true;
		} else {
			logger.info("Login de usuario "+this.dni+" incorrecto (clave incorrecta).");
			return false;
		}
	}
	
	public void editarPerfil(String contrasena,String fecha_nac,String nombre,String apellidos,String dom) {
		try{
			this.contrasena = Hashing.toString(Hashing.getSHA(contrasena));
		} catch (NoSuchAlgorithmException e) {}
		this.fecha_nac=fecha_nac;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dom=dom;
		Connection n = new Connection();
		try {
			Statement stat = n.getConnection().createStatement();
			stat.executeUpdate("UPDATE USUARIOS SET Contrasena = '"+this.contrasena+"', fecha_nacimiento='"+this.fecha_nac+"', nombre='"+this.nombre+"', apellidos='"+this.apellidos+"', domicilio='"+this.apellidos+"' WHERE DNI = '"+this.dni+"';");	
			stat.close();
			n.disconnect();
			} catch (SQLException error) {
			}
	}
	
	/*public boolean mayorEdad() {
		boolean mayorEdad = false;
		Calendar c1 = Calendar.getInstance();
		
		if(Connection.user.get)
		return mayorEdad;
	}*/
}