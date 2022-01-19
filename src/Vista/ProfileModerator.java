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

public class ProfileModerator extends JFrame {
	private JTextField textNombre;
	private JTextField textFieldNombre;
	private JTextField textApellidos;
	private JTextField textFieldApellidos;
	private JTextField textDomicilio;
	private JTextField textFieldDomicilio;
	private JTextField textFechaNac;
	private JTextField textFieldFechaNac;
	private JTextField textDni;
	private JTextField textFieldDni;
	private JTextField textContrasena;
	private JTextField textFieldContrasena;
	
	/**
	 * Create the frame.
	 */
	public ProfileModerator(Moderator mod) {
		mod.rellenarAllDatos();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GameWindow game=new GameWindow(mod);
				game.setVisible(true);
				e.getWindow().dispose();
			}
		});
		setBounds(100, 100, 450, 300);
		Box verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox, BorderLayout.CENTER);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setText("NombrePITO:");
		horizontalBox.add(textNombre);
		textNombre.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setText(mod.getNombre());
		horizontalBox.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setText("Apellidos:");
		horizontalBox_1.add(textApellidos);
		textApellidos.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setText(mod.getApellidos());
		horizontalBox_1.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		textDomicilio = new JTextField();
		textDomicilio.setText("Domicilio:");
		textDomicilio.setEditable(false);
		horizontalBox_2.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setText(mod.getDomicilio());
		horizontalBox_2.add(textFieldDomicilio);
		textFieldDomicilio.setColumns(10);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		textFechaNac = new JTextField();
		textFechaNac.setText("Fecha de nacimiento:");
		textFechaNac.setEditable(false);
		horizontalBox_3.add(textFechaNac);
		textFechaNac.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setText(mod.getFechaNac());
		horizontalBox_3.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		textDni = new JTextField();
		textDni.setText("DNI:");
		textDni.setEditable(false);
		horizontalBox_4.add(textDni);
		textDni.setColumns(10);
		
		textFieldDni = new JTextField();
		textFieldDni.setEditable(false);
		textFieldDni.setText(mod.getDni());
		horizontalBox_4.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);
		
		textContrasena = new JTextField();
		textContrasena.setText("Contraseña:");
		textContrasena.setEditable(false);
		horizontalBox_5.add(textContrasena);
		textContrasena.setColumns(10);
		
		textFieldContrasena = new JTextField();
		horizontalBox_5.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);
		
		JButton btnAnadirJuego = new JButton("Añadir Juego");
		btnAnadirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog("Por favor introduzca el nombre del juego.");
				String infoJuego = JOptionPane.showInputDialog("Por favor introduzca información sobre el juego.");
				String modality = JOptionPane.showInputDialog("Por favor introduzca F para torneo gratis o P para torneo de pago.");
				Game juego=new Game(name,infoJuego,modality);
				juego.anadirJuegos(juego);
			}
		});
		horizontalBox_6.add(btnAnadirJuego);
		
		JButton btnModificarPerfil = new JButton("Modificar Perfil");
		btnModificarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mod.editarPerfil(textFieldContrasena.getText(),textFieldFechaNac.getText(),textFieldNombre.getText(),textFieldApellidos.getText(),textFieldDomicilio.getText());
			}
		});
		horizontalBox_6.add(btnModificarPerfil);			
	}

}