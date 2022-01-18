package modelo;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controlador.Main;

/*
 * Clase encargada de realizar la conexión con la base de datos del proyecto.
 * @author Carballo
 */

public class Connection {
	private static final Logger logger = LogManager.getLogger(Main.class);
	public static final String user = "VCApp";
    public static final String pass = "vc@PPV@1d3fR5n0";
    public static final String host = "localhost";
    public static final String port = "3306";
    public static final String db = "test";
    //Url a la conexión de la base de datos con respecto a las vars anteriores
    public static final String url= "jdbc:mysql://"+host+":"+port+"/"+db;
    
    public java.sql.Connection conn;

    public Connection() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		this.conn = DriverManager.getConnection(url, user, pass);
    	} catch(ClassNotFoundException err) {
    		logger.error("Error en la conexión: Clase no encontrada (Driver MySQL). Comprueba las librerías");
    		logger.error(err);
    	} catch(SQLException err) {
    		logger.error("Error en la conexión: Error SQL, comprueba BBDD, Login o Servicio");
    		logger.error(err.getMessage());
    	}
    }
    
    public java.sql.Connection getConnection() {
    	return this.conn;
    }
    
    public void disconnect() {
    	this.conn = null;
    }
}