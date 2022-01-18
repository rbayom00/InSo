package controlador;

import java.awt.EventQueue;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.*;

import Vista.MainWindow;
import modelo.Connection;
import modelo.Hashing;

public class Main {
	
	static final Logger logger = LogManager.getLogger(Main.class);
	
	/**
	 * Ejecuta la aplicacion
	 */
	
	public static void main(String[] args) {
		//--------**BORRAR**---TEST---**BORRAR**-----------
			
			//-------TEST DE BASE DE DATOS--------
			//DESCOMENTA CUALQUIERA DE LOS MÉTODOS Y EJECUTA EL MAIN PARA PROBARLOS
			//REVISA LA DOCUMENTACIÓN DE CADA UNO PARA VER LO QUE HACE MÁS ABAJO
		
			//testStatementBBDD();
			//testResultSetBBDD();
			//testCrearUsuario();
		
		//--------**BORRAR**---TEST---**BORRAR**------------
		
		logger.info("Logger iniciado correctamente.");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					logger.info("Ejecución correcta de la interfaz gráfica.");
				} catch (Exception e) {
					logger.error("Error en el arranque de la interfaz gráfica: "+e);
				}
			}
		});
	}
	
	/*
	 * Nos permite hacer un query para ACTUALIZAR/AÑADIR datos
	 * --Usa STATEMENT de JDBC--
	 */
	public static void testStatementBBDD() {	//-**BORRAR**--TEST BBDD--**BORRAR**-
		//Creamos conexión con la base de datos con la clase Connection que ya tenemos programada
		//IMPORTANTE Cerrarla cuando acabemos de hacer cosas con ella
		Connection n = new Connection();
		
		//Creamos un Statement para realizar una query a la BBDD a la que nos hemos conectado,
		//según lo especificado en la clase Connection (te recomiendo mirarla).
		//Nuestro Statement puede fallar, por lo que siempre dentro de un try catch
		//Cualquier error que salga debe llegar a una de las clases de Raúl para que despliegue
		//el error en la GUI
		try {
			Statement stat = n.getConnection().createStatement();
			//Ejemplo para insertar un valor a la tabla "Sistema" en el atributo "nombre"
			stat.executeUpdate("INSERT INTO SISTEMA VALUES ('valormenora36caracteres')");
			JOptionPane.showMessageDialog(null, "No se han lanzado excepciones","testStatementBBDD()",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("\nTodo correcto, revisa la BBDD para ver si se ha añadido la info :)");
			//IMPORTANTE: CERRAR CONEXIÓN Y EL STATEMENT, SI NO HABRÁ PROBLEMAS CON LA BBDD Y DE MEMORIA MÁS ADELANTE
			stat.close();
			n.disconnect();
		} catch (SQLException error) { //El query puede estar mal o la conexión puede ser incorrecta (o mala configuración)
            JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("\nError en la BBDD al realizar un statement. Comprobar conexión, query o tabla.");
			System.out.println("\nSi en la tabla ya existe el valor, debes borrarlo manualmente");
			System.out.println("Mensaje de la excepción: "+error.getMessage());
		}
		
		/*
		 * PARA COMPROBAR QUE SE HA REALIZADO LA INSERCIÓN CORRECTAMENTE, VETE A LA SHELL DE MYSQL
		 * DE TU ORDENADOR Y PON LO SIGUIENTE (o a MYSQL WORKBENCH, que tiene interfaz gráfica):
		 * 											use test;
		 * 											select * from sistema;
		 * SI TE DESPLIEGA UNA TABLA CON EL VALOR "valormenora36caracteres" TO.DO HA SALIDO BIEN
		 * 
		 * PARA BORRAR EL VALOR QUE ACABAS DE AÑADIR, EJECUTA EN LA SHELL DE MYSQL LO SIGUIENTE:
		 * 							use test;
		 * 							delete from sistema where nombre='valormenora36caracteres';
		 */
	}
	
	/*
	 * Obtiene valores de la tabla que le indiques en el PreparedStatement
	 * --Usa PREPAREDSTATEMENT y RESULTSET de JDBC--
	 */
	public static void testResultSetBBDD() {
		//Creamos conexión con la base de datos - IMPORTANTE Cerrarla cuando acabemos de hacer cosas con ella
		testStatementBBDD();	//Método definido arriba que añade un valor a la tabla para consultarlo ahora
		Connection n = new Connection();
		
		//Nuestro PreparedStatement/ResultSet puede fallar, por lo que siempre dentro de un try catch
		//Cualquier error que salga debe llegar a una de las clases de Raúl para que despliegue
		//el error en la GUI
		try {
			//NOTA SOBRE PreparedStatement(): Es igual que Statement, pero permite parámetros y es más rápido
			PreparedStatement consulta = n.getConnection().prepareStatement("SELECT * FROM SISTEMA");
			//ResultSet(): Nos devuelve el resultado de la query que hemos realizado arriba
			ResultSet result = consulta.executeQuery();
			result.next();
			String test = result.getString("nombre");
			JOptionPane.showMessageDialog(null, "Dato obtenido:\n"+test,"testResultSetBBDD() Success",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(test);
			//IMPORTANTE: CERRAR CONEXIÓN Y EL STATEMENT, SI NO HABRÁ PROBLEMAS CON LA BBDD Y DE MEMORIA MÁS ADELANTE
			result.close();
			n.disconnect();					
			} catch (SQLException error) { //El query puede estar mal o la conexión puede ser incorrecta (o mala configuración)
	            JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testResultSetBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
				System.out.println("\nError en la BBDD al realizar un statement. Comprobar conexión, query o tabla.");
				System.out.println("\nSi en la tabla ya existe el valor, debes borrarlo manualmente");
				System.out.println("Mensaje de la excepción: "+error.getMessage());
			}
		/*
		 * PARA COMPROBAR QUE SE HA REALIZADO LA CONSULTA CORRECTAMENTE, COMPRUEBA LA 
		 * CONSOLA O LA VENTANA QUE SE HABRÁ ABIERTO EN EL PROGRAMA 
		 * SI TE APARECE "valormenora36caracteres" en la CONSOLA/VENTANA TO.DO HA SALIDO BIEN
		 * 
		 * PARA BORRAR EL VALOR QUE ACABAS DE AÑADIR, EJECUTA EN LA SHELL DE MYSQL LO SIGUIENTE:
		 * 							use test;
		 * 							delete from sistema where nombre='valormenora36caracteres';
		 */
	}
	
	
	
	//--------**BORRAR**---TEST INICIO SESION---**BORRAR**-----------
	public static void testCrearUsuario() {
		//Creamos conexión con la base de datos con la clase Connection que ya tenemos programada
		//IMPORTANTE Cerrarla cuando acabemos de hacer cosas con ella
		Connection n = new Connection();
			
		//Creamos un Statement para realizar una query a la BBDD a la que nos hemos conectado,
		//según lo especificado en la clase Connection (te recomiendo mirarla).
		//Nuestro Statement puede fallar, por lo que siempre dentro de un try catch
		//Cualquier error que salga debe llegar a una de las clases de Raúl para que despliegue
		//el error en la GUI
		try {
			Statement stat = n.getConnection().createStatement();
			//Ejemplo para insertar un usuario a la tabla "Usuarios"
			stat.executeUpdate("INSERT INTO SISTEMA VALUES ('Raúl');");
			stat.executeUpdate("INSERT INTO USUARIOS (DNI, contrasena, fecha_nacimiento, nombre, apellidos, domicilio) VALUES ('02773491J', 'abejonejo', '2001-06-22', 'Raúl', 'Bayón Martínez', 'C/Colada nº13 1ºC');");			
			JOptionPane.showMessageDialog(null, "No se han lanzado excepciones","testStatementBBDD()",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("\nTodo correcto, revisa la BBDD para ver si se ha añadido la info :)");
			//IMPORTANTE: CERRAR CONEXIÓN Y EL STATEMENT, SI NO HABRÁ PROBLEMAS CON LA BBDD Y DE MEMORIA MÁS ADELANTE
			stat.close();
			n.disconnect();
		} catch (SQLException error) { //El query puede estar mal o la conexión puede ser incorrecta (o mala configuración)
		    JOptionPane.showMessageDialog(null, "Excepción lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("\nError en la BBDD al realizar un statement. Comprobar conexión, query o tabla.");
			System.out.println("\nSi en la tabla ya existe el valor, debes borrarlo manualmente");
			System.out.println("Mensaje de la excepción: "+error.getMessage());
		}
		
		/*
		 * PARA COMPROBAR QUE SE HA REALIZADO LA INSERCIÓN CORRECTAMENTE, VETE A LA SHELL DE MYSQL
		 * DE TU ORDENADOR Y PON LO SIGUIENTE (o a MYSQL WORKBENCH, que tiene interfaz gráfica):
		 * 											use test;
		 * 											select * from sistema,usuarios;
		 * SI TE DESPLIEGA UNA TABLA CON EL VALOR "Raúl, 02773491J, abejonejo, 2001-06-22, Raúl, Bayón Martínez, C/Colada nº13 1ºC" TO.DO HA SALIDO BIEN
		 * 
		 * PARA BORRAR EL VALOR QUE ACABAS DE AÑADIR, EJECUTA EN LA SHELL DE MYSQL LO SIGUIENTE:
		 * 							use test;
		 * 							delete from usuarios where nombre='Raúl';
		 * 							delete from sistema where nombre='Raúl';
		 */
	}
	//--------**BORRAR**---TEST INICIO SESION---**BORRAR**-----------
}