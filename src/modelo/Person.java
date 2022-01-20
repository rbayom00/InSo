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
	
	public String getContrasena() {
		return this.contrasena;
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
			stat.executeUpdate("INSERT INTO Users (DNI, Name, Surname, Birth_Date, Address, Password) VALUES ('"+this.dni+"', '"+this.nombre+"', '"+this.apellidos+"', '"+this.fecha_nac+"', '"+this.dom+"', '"+this.contrasena+"');");	
			stat.close();
			
		} catch (SQLException error) {
			 JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			 logger.error("Error SQL: Registro de usuario fallido. Comprobar conexión, query o tabla.");
			 logger.error(error.getMessage());
			return false;
		}
		n.disconnect();
		logger.info("Registro de usuario "+this.dni+" correcto.");
		return true;
	}
	
	public boolean consultarInicio() {
		Connection n = new Connection();		
		String contrasenaBD;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select Password from Users where DNI='"+this.dni+"';");
			ResultSet result = consulta.executeQuery();
			result.next();
			contrasenaBD = result.getString("Password");
			result.close();							
			} catch (SQLException error) {
				logger.error("Error SQL: Login de usuario "+this.dni+" incorrecto. Comprobar conexión, query o tabla.");
				logger.error(error.getMessage());
				return false;
			}
		n.disconnect();	
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
			stat.executeUpdate("UPDATE Users SET Password = '"+this.contrasena+"', Birth_Date='"+this.fecha_nac+"', Name='"+this.nombre+"', Surname='"+this.apellidos+"', Address='"+this.dom+"' WHERE DNI = '"+this.dni+"';");	
			stat.close();
			
			} catch (SQLException error) {
			}
		n.disconnect();
	}
	
	public int getUserType() {
		Connection n = new Connection();		
		int userType = 2;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select UserType from Users where DNI='"+this.dni+"';");
			ResultSet result = consulta.executeQuery();
			result.next();
			userType = result.getInt("UserType");
			result.close();
							
			} catch (SQLException error) {
				logger.error("Error SQL: Verificación de usuario "+this.dni+" incorrecto. Comprobar conexión, query o tabla.");
				logger.error(error.getMessage());
			}
		n.disconnect();	
		return userType;	
	}
	
	public void rellenarAllDatos() {
		String fecha_nac;
		String nombre;
		String apellidos;
		String dom;
		Connection n = new Connection();	
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select Birth_Date,Name,Surname,Address from Users where DNI='"+this.dni+"';");
			ResultSet result = consulta.executeQuery();
			result.next();
			fecha_nac = result.getString("Birth_Date");
			nombre = result.getString("Name");
			apellidos = result.getString("Surname");
			dom = result.getString("Address");
			result.close();			
			this.fecha_nac=fecha_nac;
			this.nombre=nombre;
			this.apellidos=apellidos;
			this.dom=dom;
			} catch (SQLException error) {
				logger.error("Error SQL: Extracción de los datos de usuario "+this.dni+" incorrecta. Comprobar conexión, query o tabla.");
				logger.error(error.getMessage());
			}
		n.disconnect();	
	}
	
	public String toString() {
		return "DNI: "+this.dni+", "+this.nombre+" "+this.apellidos;
	}
	
	/*public boolean mayorEdad() {
		Connection n = new Connection();
		int edadUser;

		try {
			PreparedStatement consulta = n.getConnection()
					.prepareStatement("Select Age from Users where DNI='" + this.dni + "';");
			ResultSet result = consulta.executeQuery();
			result.next();
			edadUser = result.getInt("Age");
			result.close();
			n.disconnect();
		} catch (SQLException error) {
			logger.error("Error SQL: Login de usuario " + this.dni + " incorrecto. Comprobar conexión, query o tabla.");
			logger.error(error.getMessage());
			return false;
		}

		if (edadUser >= 18) {
			logger.info("Usuario de edad" + edadUser + " es mayor de edad.");
			return true;
		} else {
			logger.info("El usuario es menor de edad");
			return false;
		}
	}/*
	
	/*public boolean validarDNI() {
		String letraMayuscula = "";

		if (dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false) {
			return false;
		}

		letraMayuscula = (this.dni.substring(8).toUpperCase());

		if (soloNumerosDNI() == true && letraDNI().equals(letraMayuscula)) {
			return true;
		}

		else {
			return false;
		}
	}
	
	private boolean soloNumerosDNI() {

		String numero = "";
		String DNI = "";
		String[] unoNueve = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (int i = 0; i < this.dni.length() - 1; i++) {
			numero = this.dni.substring(i, i + 1);

			for (int j = 0; j < unoNueve.length; j++) {
				if (numero.equals(unoNueve[j])) {
					DNI += unoNueve[j];
				}
			}
		}
		if (DNI.length() != 8) {
			return false;
		} else {
			return true;
		}
	}
	
	private String letraDNI() {
		int DNI = Integer.parseInt(this.dni.substring(0,8));
		int resto = 0;
		String letra = "";
		String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		
		resto = DNI % 23;
		
		letra = asignacionLetra[resto];
		
		return letra;
	}*/
	
}