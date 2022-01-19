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
	private JTextField txtNombreDelJuego;	
	private JTextField textInfoJuego;
	private JTextField textModality;
	private JTextField textFieldNombreDelJuego;
	private JTextField textFieldInfoJuego;
	private JTextField textFieldModality;
	/**
	 * Create the frame.
	 */
	public AddGameWindow() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		Box verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox, BorderLayout.CENTER);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		txtNombreDelJuego = new JTextField();
		txtNombreDelJuego.setText("Nombre del torneo:");
		txtNombreDelJuego.setEditable(false);
		txtNombreDelJuego.setColumns(10);
		horizontalBox.add(txtNombreDelJuego);
		
		textFieldNombreDelJuego = new JTextField();
		textFieldNombreDelJuego.setText((String) null);
		textFieldNombreDelJuego.setColumns(10);
		horizontalBox.add(textFieldNombreDelJuego);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		textInfoJuego = new JTextField();
		textInfoJuego.setText("Informaci\u00F3n del torneo:");
		textInfoJuego.setEditable(false);
		textInfoJuego.setColumns(10);
		horizontalBox_1.add(textInfoJuego);
		
		textFieldInfoJuego = new JTextField();
		textFieldInfoJuego.setText((String) null);
		textFieldInfoJuego.setColumns(10);
		horizontalBox_1.add(textFieldInfoJuego);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1);
		
		textModality = new JTextField();
		textModality.setText("Modalidad del torneo:");
		textModality.setEditable(false);
		textModality.setColumns(10);
		horizontalBox_1_1.add(textModality);
		
		textFieldModality = new JTextField();
		textFieldModality.setText((String) null);
		textFieldModality.setColumns(10);
		horizontalBox_1_1.add(textFieldModality);
		
		Box horizontalBox_1_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textFieldNombreDelJuego.getText();
				String infoJuego = textFieldInfoJuego.getText();
				String modality = textFieldModality.getText();
				Game juego=new Game(name,infoJuego,modality);
				//juego.setPrecio(textFieldPrecio.getText());
				juego.anadirJuegos(juego);
			}
		});
		horizontalBox_1_1_1.add(btnNewButton);
		
		
	}
}