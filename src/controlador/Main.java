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
			//DESCOMENTA CUALQUIERA DE LOS M�TODOS Y EJECUTA EL MAIN PARA PROBARLOS
			//REVISA LA DOCUMENTACI�N DE CADA UNO PARA VER LO QUE HACE M�S ABAJO
		
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
					logger.info("Ejecuci�n correcta de la interfaz gr�fica.");
				} catch (Exception e) {
					logger.error("Error en el arranque de la interfaz gr�fica: "+e);
				}
			}
		});
	}
	
	/*
	 * Nos permite hacer un query para ACTUALIZAR/A�ADIR datos
	 * --Usa STATEMENT de JDBC--
	 */
	public static void testStatementBBDD() {	//-**BORRAR**--TEST BBDD--**BORRAR**-
		//Creamos conexi�n con la base de datos con la clase Connection que ya tenemos programada
		//IMPORTANTE Cerrarla cuando acabemos de hacer cosas con ella
		Connection n = new Connection();
		
		//Creamos un Statement para realizar una query a la BBDD a la que nos hemos conectado,
		//seg�n lo especificado en la clase Connection (te recomiendo mirarla).
		//Nuestro Statement puede fallar, por lo que siempre dentro de un try catch
		//Cualquier error que salga debe llegar a una de las clases de Ra�l para que despliegue
		//el error en la GUI
		try {
			Statement stat = n.getConnection().createStatement();
			//Ejemplo para insertar un valor a la tabla "Sistema" en el atributo "nombre"
			stat.executeUpdate("INSERT INTO SISTEMA VALUES ('valormenora36caracteres')");
			JOptionPane.showMessageDialog(null, "No se han lanzado excepciones","testStatementBBDD()",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("\nTodo correcto, revisa la BBDD para ver si se ha a�adido la info :)");
			//IMPORTANTE: CERRAR CONEXI�N Y EL STATEMENT, SI NO HABR� PROBLEMAS CON LA BBDD Y DE MEMORIA M�S ADELANTE
			stat.close();
			n.disconnect();
		} catch (SQLException error) { //El query puede estar mal o la conexi�n puede ser incorrecta (o mala configuraci�n)
            JOptionPane.showMessageDialog(null, "Excepci�n lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("\nError en la BBDD al realizar un statement. Comprobar conexi�n, query o tabla.");
			System.out.println("\nSi en la tabla ya existe el valor, debes borrarlo manualmente");
			System.out.println("Mensaje de la excepci�n: "+error.getMessage());
		}
		
		/*
		 * PARA COMPROBAR QUE SE HA REALIZADO LA INSERCI�N CORRECTAMENTE, VETE A LA SHELL DE MYSQL
		 * DE TU ORDENADOR Y PON LO SIGUIENTE (o a MYSQL WORKBENCH, que tiene interfaz gr�fica):
		 * 											use test;
		 * 											select * from sistema;
		 * SI TE DESPLIEGA UNA TABLA CON EL VALOR "valormenora36caracteres" TO.DO HA SALIDO BIEN
		 * 
		 * PARA BORRAR EL VALOR QUE ACABAS DE A�ADIR, EJECUTA EN LA SHELL DE MYSQL LO SIGUIENTE:
		 * 							use test;
		 * 							delete from sistema where nombre='valormenora36caracteres';
		 */
	}
	
	/*
	 * Obtiene valores de la tabla que le indiques en el PreparedStatement
	 * --Usa PREPAREDSTATEMENT y RESULTSET de JDBC--
	 */
	public static void testResultSetBBDD() {
		//Creamos conexi�n con la base de datos - IMPORTANTE Cerrarla cuando acabemos de hacer cosas con ella
		testStatementBBDD();	//M�todo definido arriba que a�ade un valor a la tabla para consultarlo ahora
		Connection n = new Connection();
		
		//Nuestro PreparedStatement/ResultSet puede fallar, por lo que siempre dentro de un try catch
		//Cualquier error que salga debe llegar a una de las clases de Ra�l para que despliegue
		//el error en la GUI
		try {
			//NOTA SOBRE PreparedStatement(): Es igual que Statement, pero permite par�metros y es m�s r�pido
			PreparedStatement consulta = n.getConnection().prepareStatement("SELECT * FROM SISTEMA");
			//ResultSet(): Nos devuelve el resultado de la query que hemos realizado arriba
			ResultSet result = consulta.executeQuery();
			result.next();
			String test = result.getString("nombre");
			JOptionPane.showMessageDialog(null, "Dato obtenido:\n"+test,"testResultSetBBDD() Success",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(test);
			//IMPORTANTE: CERRAR CONEXI�N Y EL STATEMENT, SI NO HABR� PROBLEMAS CON LA BBDD Y DE MEMORIA M�S ADELANTE
			result.close();
			n.disconnect();					
			} catch (SQLException error) { //El query puede estar mal o la conexi�n puede ser incorrecta (o mala configuraci�n)
	            JOptionPane.showMessageDialog(null, "Excepci�n lanzada.\nComprueba consola para + info","testResultSetBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
				System.out.println("\nError en la BBDD al realizar un statement. Comprobar conexi�n, query o tabla.");
				System.out.println("\nSi en la tabla ya existe el valor, debes borrarlo manualmente");
				System.out.println("Mensaje de la excepci�n: "+error.getMessage());
			}
		/*
		 * PARA COMPROBAR QUE SE HA REALIZADO LA CONSULTA CORRECTAMENTE, COMPRUEBA LA 
		 * CONSOLA O LA VENTANA QUE SE HABR� ABIERTO EN EL PROGRAMA 
		 * SI TE APARECE "valormenora36caracteres" en la CONSOLA/VENTANA TO.DO HA SALIDO BIEN
		 * 
		 * PARA BORRAR EL VALOR QUE ACABAS DE A�ADIR, EJECUTA EN LA SHELL DE MYSQL LO SIGUIENTE:
		 * 							use test;
		 * 							delete from sistema where nombre='valormenora36caracteres';
		 */
	}
	
	
	
	//--------**BORRAR**---TEST INICIO SESION---**BORRAR**-----------
	public static void testCrearUsuario() {
		//Creamos conexi�n con la base de datos con la clase Connection que ya tenemos programada
		//IMPORTANTE Cerrarla cuando acabemos de hacer cosas con ella
		Connection n = new Connection();
			
		//Creamos un Statement para realizar una query a la BBDD a la que nos hemos conectado,
		//seg�n lo especificado en la clase Connection (te recomiendo mirarla).
		//Nuestro Statement puede fallar, por lo que siempre dentro de un try catch
		//Cualquier error que salga debe llegar a una de las clases de Ra�l para que despliegue
		//el error en la GUI
		try {
			Statement stat = n.getConnection().createStatement();
			//Ejemplo para insertar un usuario a la tabla "Usuarios"
			stat.executeUpdate("INSERT INTO SISTEMA VALUES ('Ra�l');");
			stat.executeUpdate("INSERT INTO USUARIOS (DNI, contrasena, fecha_nacimiento, nombre, apellidos, domicilio) VALUES ('02773491J', 'abejonejo', '2001-06-22', 'Ra�l', 'Bay�n Mart�nez', 'C/Colada n�13 1�C');");			
			JOptionPane.showMessageDialog(null, "No se han lanzado excepciones","testStatementBBDD()",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("\nTodo correcto, revisa la BBDD para ver si se ha a�adido la info :)");
			//IMPORTANTE: CERRAR CONEXI�N Y EL STATEMENT, SI NO HABR� PROBLEMAS CON LA BBDD Y DE MEMORIA M�S ADELANTE
			stat.close();
			n.disconnect();
		} catch (SQLException error) { //El query puede estar mal o la conexi�n puede ser incorrecta (o mala configuraci�n)
		    JOptionPane.showMessageDialog(null, "Excepci�n lanzada.\nComprueba consola para + info","testStatementBBDD() ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("\nError en la BBDD al realizar un statement. Comprobar conexi�n, query o tabla.");
			System.out.println("\nSi en la tabla ya existe el valor, debes borrarlo manualmente");
			System.out.println("Mensaje de la excepci�n: "+error.getMessage());
		}
		
		/*
		 * PARA COMPROBAR QUE SE HA REALIZADO LA INSERCI�N CORRECTAMENTE, VETE A LA SHELL DE MYSQL
		 * DE TU ORDENADOR Y PON LO SIGUIENTE (o a MYSQL WORKBENCH, que tiene interfaz gr�fica):
		 * 											use test;
		 * 											select * from sistema,usuarios;
		 * SI TE DESPLIEGA UNA TABLA CON EL VALOR "Ra�l, 02773491J, abejonejo, 2001-06-22, Ra�l, Bay�n Mart�nez, C/Colada n�13 1�C" TO.DO HA SALIDO BIEN
		 * 
		 * PARA BORRAR EL VALOR QUE ACABAS DE A�ADIR, EJECUTA EN LA SHELL DE MYSQL LO SIGUIENTE:
		 * 							use test;
		 * 							delete from usuarios where nombre='Ra�l';
		 * 							delete from sistema where nombre='Ra�l';
		 */
	}
	//--------**BORRAR**---TEST INICIO SESION---**BORRAR**-----------
}