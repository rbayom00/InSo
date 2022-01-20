package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Admin;
import modelo.Tournament;
import modelo.Moderator;
import modelo.Person;
import modelo.Ranking;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;

public class InfoGameWindow extends JFrame {
	private Tournament juego;
	private Ranking ranking;
	/**
	 * Create the frame.
	 */
	public InfoGameWindow(Tournament juego,Person user) {
		user.rellenarAllDatos();
		juego.rellenarAllDatos();
		this.juego=juego;
		ranking = new Ranking(this.juego);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GameWindow game= new GameWindow(user);
				game.setVisible(true);
				e.getWindow().dispose();
			}
		});		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane);
		
		Box horizontalBoxPerfil = Box.createHorizontalBox();
		scrollPane.setColumnHeaderView(horizontalBoxPerfil);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userType=user.getUserType();
				if(userType==0) {
					setVisible(false);
					Admin adminP=new Admin(user.getDni(), user.getContrasena(), user.getFechaNac(), user.getNombre(), user.getApellidos(), user.getDomicilio());
					ProfileAdmin admin = new ProfileAdmin(adminP);
					admin.setVisible(true);
				}else if(userType==1) {
					setVisible(false);
					Moderator moderatorP=new Moderator(user.getDni(), user.getContrasena(), user.getFechaNac(), user.getNombre(), user.getApellidos(), user.getDomicilio());
					ProfileModerator moderator = new ProfileModerator(moderatorP);
					moderator.setVisible(true);
				}else if(userType==2) {
					setVisible(false);
					ProfileUser userProfile = new ProfileUser(user);
					userProfile.setVisible(true);
				}
			}
		});
		btnPerfil.setSize(new Dimension(100, 100));
		btnPerfil.setPreferredSize(new Dimension(100, 100));
		btnPerfil.setMinimumSize(new Dimension(100, 100));
		btnPerfil.setMaximumSize(new Dimension(100, 100));
		horizontalBoxPerfil.add(btnPerfil);
		
		Component horizontalStrut = Box.createHorizontalStrut(850);
		horizontalBoxPerfil.add(horizontalStrut);
		
		JLabel lblNombreJuego = new JLabel(juego.getNombreTorneo());
		lblNombreJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNombreJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBoxPerfil.add(lblNombreJuego);
		
		Box verticalBox = Box.createVerticalBox();
		scrollPane.setViewportView(verticalBox);
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setText("Nombre: " + this.juego.getNombreTorneo() + "\r\n\r\nDescripcion: " + this.juego.getInfoTorneo() +" \r\n\r\nPrecio de la Inscripcion: " + this.juego.getPrecio() + "\r\n\r\nPremio: " + this.juego.getPremio() + "\r\n\r\nPlazas totales: " + this.juego.getNumeroPlazas() + "\r\n\r\nPlazas disponibles: " + (this.juego.getNumeroPlazas()-ranking.getPersonas().size()));
		textPaneInfo.setEditable(false);
		textPaneInfo.setCaretPosition(0);
		verticalBox.add(textPaneInfo);
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				RankingWindow ranking=new RankingWindow(juego,user);
				ranking.setVisible(true);
			}
		});
		btnRanking.setSize(new Dimension(200, 80));
		btnRanking.setPreferredSize(new Dimension(200, 80));
		btnRanking.setMinimumSize(new Dimension(200, 80));
		btnRanking.setMaximumSize(new Dimension(200, 80));
		btnRanking.setFont(new Font("Arial", Font.PLAIN, 30));
		horizontalBox.add(btnRanking);
		
		JButton btnInscribirse = new JButton("Apuntarse");
		
		//ACCION DE INSCRIBIRSE
		btnInscribirse.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				//COMPROBACION DE SI EL USUARIO YA ESTA INSCRITO EN EL TORNEO
				if(!user.mayorEdad()&&juego.getModality().equals("P")) {
					JOptionPane.showMessageDialog(null, "Para participar en un torneo de pago has de ser mayor de 18 años.", "ERROR",
					        JOptionPane.WARNING_MESSAGE);
				}else {
					if(ranking.isInscrito(user,juego)) {
						JOptionPane.showMessageDialog(null, "El usuario ya está inscrito en el torneo", "ERROR",
						        JOptionPane.WARNING_MESSAGE);					
					}else {
						ranking.addPersona(user,juego);
						textPaneInfo.setText("Nombre: " + juego.getNombreTorneo() + "\r\n\r\nDescripcion: " + juego.getInfoTorneo() +" \r\n\r\nPrecio de la Inscripcion: " + juego.getPrecio() + "\r\n\r\nPremio: " + juego.getPremio() + "\r\n\r\nPlazas totales: " + juego.getNumeroPlazas() + "\r\n\r\nPlazas disponibles: " + (juego.getNumeroPlazas()-ranking.getPersonas().size()));
						JOptionPane.showMessageDialog(null, "Has sido inscrito en el torneo correctamente");						
					}	
				}							
			}			
		});		
		btnInscribirse.setSize(new Dimension(200, 80));
		btnInscribirse.setMinimumSize(new Dimension(200, 80));
		btnInscribirse.setMaximumSize(new Dimension(200, 80));
		btnInscribirse.setFont(new Font("Arial", Font.PLAIN, 30));
		horizontalBox.add(btnInscribirse);
		}
}
