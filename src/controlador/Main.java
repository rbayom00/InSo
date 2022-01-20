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
		logger.info("Logger iniciado correctamente.");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					logger.info("Ejecución correcta de la interfaz gráfica.");
				} catch (Exception e) {
					logger.error("Error en el arranque de la interfaz gráfica: "+e.getMessage());
				}
			}
		});
	}
}