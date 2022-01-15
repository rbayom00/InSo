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

import modelo.Game;
import javax.swing.JLabel;
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
	private Game juego;
	/**
	 * Create the frame.
	 */
	public InfoGameWindow(Game juego) {
		this.juego=juego;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GameWindow game= new GameWindow();
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
				setVisible(false);
				ProfileAdmin admin = new ProfileAdmin();
				admin.setVisible(true);
			}
		});
		btnPerfil.setSize(new Dimension(100, 100));
		btnPerfil.setPreferredSize(new Dimension(100, 100));
		btnPerfil.setMinimumSize(new Dimension(100, 100));
		btnPerfil.setMaximumSize(new Dimension(100, 100));
		horizontalBoxPerfil.add(btnPerfil);
		
		Component horizontalStrut = Box.createHorizontalStrut(850);
		horizontalBoxPerfil.add(horizontalStrut);
		
		JLabel lblNombreJuego = new JLabel(juego.getNombreJuego());
		lblNombreJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNombreJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBoxPerfil.add(lblNombreJuego);
		
		Box verticalBox = Box.createVerticalBox();
		scrollPane.setViewportView(verticalBox);
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setText("\r\nPetanca\r\nIr a la navegaci\u00F3nIr a la b\u00FAsqueda\r\na\r\na\r\n\r\na\r\na\r\n\r\na\r\na\r\na\r\na\r\n\r\n\u00CDndice\r\n1\tLa partida\r\n2\tReglas del juego\r\n3\tReferencias\r\n4\tV\u00E9ase tambi\u00E9n\r\n5\tEnlaces externos\r\nLa partida\r\na\r\na\r\na\r\na\r\n\r\nUa\r\na\r\na\r\na\r\n\r\na\r\na\r\na\r\na\r\n\r\na\r\na\r\na\r\n\r\naa\r\na\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\na\r\na\r\na\r\n\r\na\r\na\r\nV\u00E9ase tambi\u00E9n\r\nVer el portal sobre Deporte Portal:Deporte. Contenido relacionado con Deporte.\r\nBochas\r\nBolas criollas\r\nPetanca en los Juegos Mediterr\u00E1neos de 2009\r\nEnlaces externos\r\n Wikimedia Commons alberga una galer\u00EDa multimedia sobre Petanca.\r\nFederaci\u00F3n Espa\u00F1ola de Petanca\r\nFederaci\u00F3n Andaluza de Petanca\r\nFederaci\u00F3n Galega de Petanca\r\nControl de autoridades\t\r\nProyectos WikimediaWd Datos: Q189317Commonscat Multimedia: P\u00E9tanque\r\nIdentificadoresNDL: 00577517AAT: 300222807\r\nCategor\u00EDas: PetancaBolos\r\nMen\u00FA de navegaci\u00F3n\r\nNo has accedido\r\nDiscusi\u00F3n\r\nContribuciones\r\nCrear una cuenta\r\nAcceder\r\nArt\u00EDculoDiscusi\u00F3n\r\nLeerEditarVer historial\r\nBuscar\r\nBuscar en Wikipedia\r\nPortada\r\nPortal de la comunidad\r\nActualidad\r\nCambios recientes\r\nP\u00E1ginas nuevas\r\nP\u00E1gina aleatoria\r\nAyuda\r\nDonaciones\r\nNotificar un error\r\nHerramientas\r\nLo que enlaza aqu\u00ED\r\nCambios en enlazadas\r\nSubir archivo\r\nP\u00E1ginas especiales\r\nEnlace permanente\r\nInformaci\u00F3n de la p\u00E1gina\r\nCitar esta p\u00E1gina\r\nElemento de Wikidata\r\nImprimir/exportar\r\nCrear un libro\r\nDescargar como PDF\r\nVersi\u00F3n para imprimir\r\nEn otros proyectos\r\nWikimedia Commons\r\n\r\nEn otros idiomas\r\n\u0627\u0644\u0639\u0631\u0628\u064A\u0629\r\nAsturianu\r\nCatal\u00E0\r\nEnglish\r\nEuskara\r\nGalego\r\nBahasa Indonesia\r\n\u0420\u0443\u0441\u0441\u043A\u0438\u0439\r\n\u4E2D\u6587\r\n37 m\u00E1s\r\nEditar enlaces\r\nEsta p\u00E1gina se edit\u00F3 por \u00FAltima vez el 5 dic 2021 a las 20:45.\r\na\r\na\r\na\r\n\r\na\r\naa\r\na\r\n\r\naa\r\n\r\na\r\na\r\n\r\na\r\na\r\na\r\na\r\n\r\na\r\na\r\na\r\na\r\n\r\na\r\na\r\na\r\n\r\n\u00CDndice\r\n1\tLa partida\r\n2\tReglas del juego\r\n3\tReferencias\r\n4\tV\u00E9ase tambi\u00E9n\r\n5\tEnlaces externos\r\nLa partida\r\naa\r\na\r\na\r\n\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\n\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\n\r\nEn una tripleta cada uno de los tres jugadores acostumbra a realizar las jugadas de la manera siguiente:\r\n\r\nEl apuntador se especializa a apuntar sus bolas aproxim\u00E1ndose al boliche.\r\nEl medio hace los dos trabajos a la vez de apuntar y picar.\r\nEl tirador o picador ejecuta habitualmente la jugada de echar o picar contra las bolas del adversario.\r\nReferencias\r\n Marco Foyot, Alain Dupuy, Louis Dalmas, P\u00E9tanque - Technique, Tactique, Entrainement, Robert Laffont, 1984.\r\n Reglamento de juego oficial de petanca. Federaci\u00F3n Espa\u00F1ola de Petanca.\r\nhttp://www.fepetanca.com/reglamento-oficial-de-petanca-2021\r\n\r\nV\u00E9ase tambi\u00E9n\r\nVer el portal sobre Deporte Portal:Deporte. Contenido relacionado con Deporte.\r\nBochas\r\nBolas criollas\r\nPetanca en los Juegos Mediterr\u00E1neos de 2009\r\nEnlaces externos\r\n Wikimedia Commons alberga una galer\u00EDa multimedia sobre Petanca.\r\nFederaci\u00F3n Espa\u00F1ola de Petanca\r\nFederaci\u00F3n Andaluza de Petanca\r\nFederaci\u00F3n Galega de Petanca\r\nControl de autoridades\t\r\nProyectos WikimediaWd Datos: Q189317Commonscat Multimedia: P\u00E9tanque\r\nIdentificadoresNDL: 00577517AAT: 300222807\r\nCategor\u00EDas: PetancaBolos\r\nMen\u00FA de navegaci\u00F3n\r\nNo has accedido\r\nDiscusi\u00F3n\r\nContribuciones\r\nCrear una cuenta\r\nAcceder\r\nArt\u00EDculoDiscusi\u00F3n\r\nLeerEditarVer historial\r\nBuscar\r\nBuscar en Wikipedia\r\nPortada\r\nPortal de la comunidad\r\nActualidad\r\nCambios recientes\r\nP\u00E1ginas nuevas\r\nP\u00E1gina aleatoria\r\nAyuda\r\nDonaciones\r\nNotificar un error\r\nHerramientas\r\nLo que enlaza aqu\u00ED\r\nCambios en enlazadas\r\nSubir archivo\r\nP\u00E1ginas especiales\r\nEnlace permanente\r\nInformaci\u00F3n de la p\u00E1gina\r\nCitar esta p\u00E1gina\r\nElemento de Wikidata\r\nImprimir/exportar\r\nCrear un libro\r\nDescargar como PDF\r\nVersi\u00F3n para imprimir\r\nEn otros proyectos\r\nWikimedia Commons\r\n\r\nEn otros idiomas\r\n\u0627\u0644\u0639\u0631\u0628\u064A\u0629\r\nAsturianu\r\nCatal\u00E0\r\nEnglish\r\nEuskara\r\nGalego\r\nBahasa Indonesia\r\n\u0420\u0443\u0441\u0441\u043A\u0438\u0439\r\n\u4E2D\u6587\r\n37 m\u00E1s\r\nEditar enlaces\r\nEsta p\u00E1gina se edit\u00F3 por \u00FAltima vez el 5 dic 2021 a las 20:45.\r\na\r\na\r\na\r\naa\r\n\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\na\r\n");
		textPaneInfo.setEditable(false);
		textPaneInfo.setCaretPosition(0);
		verticalBox.add(textPaneInfo);
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				RankingWindow ranking=new RankingWindow(juego);
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
		btnInscribirse.setSize(new Dimension(200, 80));
		btnInscribirse.setMinimumSize(new Dimension(200, 80));
		btnInscribirse.setMaximumSize(new Dimension(200, 80));
		btnInscribirse.setFont(new Font("Arial", Font.PLAIN, 30));
		horizontalBox.add(btnInscribirse);
		}
}
