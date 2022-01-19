package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.Moderator;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import modelo.Admin;
import modelo.Connection;
import modelo.Game;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddGameWindow extends JFrame {
	private JTextField textNombre;
	private JTextField textFieldNombre;
	private JTextField textInfoJuego;
	private JTextField textFieldInfoJuego;
	private JTextField textPrecio;
	private JTextField textFieldPrecio;
	private JTextField textPremio;
	private JTextField textFieldPremio;
	private JTextField textNumeroPlazas;
	private JTextField textFieldNumeroPlazas;
	
	/**
	 * Create the frame.
	 */
	public AddGameWindow(Game game) {
		//game.rellenarAllDatos();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			/*@Override
			public void windowClosing(WindowEvent e) {
				AddGameWindow game = new AddGameWindow(game);
				game.setVisible(true);
				e.getWindow().dispose();
			}*/
		});
		setBounds(100, 100, 450, 300);
		Box verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox, BorderLayout.CENTER);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setText("Nombre:");
		horizontalBox.add(textNombre);
		textNombre.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setText(game.getNombreJuego());
		horizontalBox.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		textInfoJuego = new JTextField();
		textInfoJuego.setEditable(false);
		textInfoJuego.setText("Apellidos:");
		horizontalBox_1.add(textInfoJuego);
		textInfoJuego.setColumns(10);
		
		textFieldInfoJuego = new JTextField();
		textFieldInfoJuego.setText(game.getInfoJuego());
		horizontalBox_1.add(textFieldInfoJuego);
		textFieldInfoJuego.setColumns(10);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		textPrecio = new JTextField();
		textPrecio.setText("Domicilio:");
		textPrecio.setEditable(false);
		horizontalBox_2.add(textPrecio);
		textPrecio.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setText(game.getPrecio());
		horizontalBox_2.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		textPremio = new JTextField();
		textPremio.setText("Fecha de nacimiento:");
		textPremio.setEditable(false);
		horizontalBox_3.add(textPremio);
		textPremio.setColumns(10);
		
		textFieldPremio = new JTextField();
		textFieldPremio.setText(game.getPremio());
		horizontalBox_3.add(textFieldPremio);
		textFieldPremio.setColumns(10);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		textNumeroPlazas = new JTextField();
		textNumeroPlazas.setText("DNI:");
		textNumeroPlazas.setEditable(false);
		horizontalBox_4.add(textNumeroPlazas);
		textNumeroPlazas.setColumns(10);
		
		textFieldNumeroPlazas = new JTextField();
		textFieldNumeroPlazas.setEditable(false);
		textFieldNumeroPlazas.setText(String.valueOf(game.getNumeroPlazas()));
		horizontalBox_4.add(textFieldNumeroPlazas);
		textFieldNumeroPlazas.setColumns(10);
		
		
	}

}