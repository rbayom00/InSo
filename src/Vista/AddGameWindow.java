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
import modelo.Tournament;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddGameWindow extends JFrame {
	private JTextField txtNombreDelJuego;	
	private JTextField textInfoJuego;
	private JTextField textPremio;
	private JTextField textFieldNombreDelJuego;
	private JTextField textFieldInfoJuego;
	private JTextField textFieldPremio;
	private Box horizontalBox_1_2;
	private JTextField txtPrecioDelTorneo;
	private JTextField textFieldPrecio;
	private Box horizontalBox_1_3;
	private JTextField txtPlazasTotales;
	private JTextField textFieldPlazas;
	private Box horizontalBox_1_4;
	private JTextField txtModalidad;
	private JTextField textFieldModalidad;
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
		textInfoJuego.setText("Informacion del torneo:");
		textInfoJuego.setEditable(false);
		textInfoJuego.setColumns(10);
		horizontalBox_1.add(textInfoJuego);
		
		textFieldInfoJuego = new JTextField();
		textFieldInfoJuego.setText((String) null);
		textFieldInfoJuego.setColumns(10);
		horizontalBox_1.add(textFieldInfoJuego);
		
		horizontalBox_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_2);
		
		txtPrecioDelTorneo = new JTextField();
		txtPrecioDelTorneo.setText("Precio de inscripcion:");
		txtPrecioDelTorneo.setEditable(false);
		txtPrecioDelTorneo.setColumns(10);
		horizontalBox_1_2.add(txtPrecioDelTorneo);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setText((String) null);
		textFieldPrecio.setColumns(10);
		horizontalBox_1_2.add(textFieldPrecio);
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1);
		
		textPremio = new JTextField();
		textPremio.setText("Premio:");
		textPremio.setEditable(false);
		textPremio.setColumns(10);
		horizontalBox_1_1.add(textPremio);
		
		textFieldPremio = new JTextField();
		textFieldPremio.setText((String) null);
		textFieldPremio.setColumns(10);
		horizontalBox_1_1.add(textFieldPremio);
		
		horizontalBox_1_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_3);
		
		txtPlazasTotales = new JTextField();
		txtPlazasTotales.setText("Plazas totales:");
		txtPlazasTotales.setEditable(false);
		txtPlazasTotales.setColumns(10);
		horizontalBox_1_3.add(txtPlazasTotales);
		
		textFieldPlazas = new JTextField();
		textFieldPlazas.setText((String) null);
		textFieldPlazas.setColumns(10);
		horizontalBox_1_3.add(textFieldPlazas);
		
		horizontalBox_1_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_4);
		
		txtModalidad = new JTextField();
		txtModalidad.setText("Modalidad:\r\n(F:gratis, P:pago)");
		txtModalidad.setEditable(false);
		txtModalidad.setColumns(10);
		horizontalBox_1_4.add(txtModalidad);
		
		textFieldModalidad = new JTextField();
		textFieldModalidad.setText((String) null);
		textFieldModalidad.setColumns(10);
		horizontalBox_1_4.add(textFieldModalidad);
		
		Box horizontalBox_1_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//COMPRUEBA QUE NINGUN CAMPO ESTE VACIO
				if(textFieldNombreDelJuego.getText().length() == 0 || textFieldInfoJuego.getText().length() == 0 || txtModalidad.getText().length() == 0 || textFieldPrecio.getText().length() == 0 || textFieldPremio.getText().length() == 0 || textFieldPlazas.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Todos los campos deben contener datos", "ERROR",
					        JOptionPane.WARNING_MESSAGE);	
					
				}else {
					String name = textFieldNombreDelJuego.getText();
					String infoJuego = textFieldInfoJuego.getText();
					if(textFieldModalidad.getText().equals("F") || textFieldModalidad.getText().equals("P")) {
						String modality = txtModalidad.getText();
						Tournament juego=new Tournament(name,infoJuego,modality);
						juego.setPrecio(textFieldPrecio.getText());
						juego.setPremio(textFieldPremio.getText());
						// COMPRUEBA QUE LO PASADO EN PLAZAS ES UN NUMERO Y NO TIENE LETRAS (PROBAR)
						if(textFieldPlazas.getText().matches("[+-]?\\d*(\\.\\d+)?")) {

							juego.setNumeroPlazas(Integer.valueOf(textFieldPlazas.getText()));
							juego.anadirJuegos(juego);
							
						}else {
							//SI EL TEXTO ES INCORRECTO, SE BORRA EL CAMPO Y SALTA UN PANEL DE ERROR
							textFieldPlazas.setText(null);
							JOptionPane.showMessageDialog(null, "El campo Plazas Totales requiere un numero", "ERROR",
							        JOptionPane.WARNING_MESSAGE);				
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Modalidad Incorrecta (F:torneos gratuitos, P:torneos de pago)", "ERROR",
						        JOptionPane.WARNING_MESSAGE);	
					}
					
				}
			}
		});
		horizontalBox_1_1_1.add(btnNewButton);
		
		
	}
}