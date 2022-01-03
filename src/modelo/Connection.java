package modelo;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Clase encargada de realizar la conexión con la base de datos del proyecto.
 * @author Carballo
 */

public class Connection {
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
    		err.printStackTrace();
    		System.out.println("Connection Error: Class Not Found (MySQL Driver). Check libraries.");
    	} catch(SQLException err) {
    		err.printStackTrace();
    		System.out.println("Connection Error: SQL Error. Check db, login or service.");
    	}
    }
    
    public java.sql.Connection getConnection() {
    	return this.conn;
    }
    
    public void disconnect() {
    	this.conn = null;
    }
}