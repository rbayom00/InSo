package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	public GameWindow game;
	
	/**
	 * Create the frame.
	 */
	public ProfileModerator() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				game.setVisible(true);
				e.getWindow().dispose();
			}
		});
		setBounds(100, 100, 450, 300);
		
		game= new GameWindow();
				
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
		horizontalBox_4.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);
		
		textContrasena = new JTextField();
		textContrasena.setText("Contrase\u00F1a:");
		textContrasena.setEditable(false);
		horizontalBox_5.add(textContrasena);
		textContrasena.setColumns(10);
		
		textFieldContrasena = new JTextField();
		horizontalBox_5.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);
		
		JButton btnModificarPerfil = new JButton("Modificar Perfil");
		horizontalBox_6.add(btnModificarPerfil);
		
		JButton btnAnadirJuego = new JButton("A\u00F1adir Juego");
		btnAnadirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.anadirJuego();
			}
		});
		horizontalBox_6.add(btnAnadirJuego);		
	}

}
