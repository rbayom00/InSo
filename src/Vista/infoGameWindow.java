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

public class infoGameWindow extends JFrame {
	private Game juego;
	/**
	 * Create the frame.
	 */
	public infoGameWindow(Game juego) {
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
		
		JLabel lblNombreJuego = new JLabel(juego.getNombreJuego());
		lblNombreJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		horizontalBoxPerfil.add(lblNombreJuego);
		
		Box verticalBox = Box.createVerticalBox();
		scrollPane.setViewportView(verticalBox);
		
		JTextPane textPaneInfo = new JTextPane();
		textPaneInfo.setText("\r\nPetanca\r\nIr a la navegaci\u00F3nIr a la b\u00FAsqueda\r\nLa petanca es un deporte/juego en el que el objetivo es lanzar bolas tan cerca del boliche, lanzada anteriormente por un jugador, con ambos pies en el suelo y en posici\u00F3n est\u00E1tica desde una determinada zona.\r\n\r\n\r\nEl deporte en su forma actual surgi\u00F3 en 1907 en la Provenza francesa, aunque los antiguos ya jugaban una versi\u00F3n primitiva con bolas de piedra, que fue llevada a Provenza por soldados y marineros romanos. Su nombre procede de la expresi\u00F3n \"p\u00E8(s) tancats\" (\"pies juntos\") en lengua provenzal.1\u200B Las federaciones regulan las competiciones oficiales de este deporte.\r\n\r\nEl deporte se puede practicar en todo tipo de terreno, aunque normalmente se hace en zonas llanas, arenosas. Las pistas son rectangulares con un largo de 15 m y un ancho de 4 m para competiciones nacionales e internacionales, aunque pueden tener unas dimensiones m\u00EDnimas de 16 m x 5 m para otras competiciones.\r\n\r\n\r\nEl boliche (a la izquierda) y la bola (a la derecha).\r\nLas bolas usadas son met\u00E1licas (no deben contener plomo ni arena en su interior). Su di\u00E1metro debe medir entre 70,05 mm y 80,0 mm, mientras que su peso oscila entre los 650 y los 800 g. El boliche es de madera o de material sint\u00E9tico y debe tener un di\u00E1metro de 30 mm.2\u200B\r\n\r\n\r\n\u00CDndice\r\n1\tLa partida\r\n2\tReglas del juego\r\n3\tReferencias\r\n4\tV\u00E9ase tambi\u00E9n\r\n5\tEnlaces externos\r\nLa partida\r\nAl comenzar la partida se lanza el boliche desde una circunferencia de entre 35 y 50mm de di\u00E1metro lanzamiento que debe colocarse como m\u00EDnimo a 1 m de cualquier obst\u00E1culo. Para que dicho lanzamiento sea v\u00E1lido, el boliche debe quedar a una distancia de 1 m  de la circunferencia de lanzamiento y al menos a 1 m de cualquier obst\u00E1culo. Despu\u00E9s, cada deportista lanza, por turno, tres bolas en la modalidad individual y en dupletas (dos equipos de dos deportistas) y dos si la partida es por tripletas (dos equipos de tres deportistas). Los lanzamientos pueden ser de tres tipos: de aproximaci\u00F3n al boliche; de \"tiro\" (al tiro perfecto se le llama carro seco, en el cual la bola tirada queda en el mismo lugar que la bola a la que se ha lanzado), para intentar alejar una bola de un jugador contrario golpe\u00E1ndola; y de \"apoyo\", haciendo rodar la bola para acercar m\u00E1s una propia al boliche o para alejar una contraria.\r\n\r\nUna vez concluida la partida, las bolas que se encuentre m\u00E1s cerca del boliche que las de los adversarios se apunta un punto por cada bola. Gana el deportista o el equipo que llegue antes a trece puntos.\r\n\r\n\r\nPartida de la petanca\r\nReglas del juego\r\nAparentemente es muy simple. Se trata de lanzar una bola lo m\u00E1s cerca posible de un objetivo llamado boliche o mingo (y al Rossell\u00F3 nano). Los adversarios pueden ser uno contra uno (individuales o jefe-y-jefe) o por equipos de dos contra dos (dobletes) o tres contra tres (tripletes). Las partidas suelen jugarse a 13 puntos en terreno libre o bien dentro de una pista delimitada (la dimensi\u00F3n oficial es un rect\u00E1ngulo de 15 m x 4 m).\r\n\r\nEl punto pertenece a la bola m\u00E1s pr\u00F3xima al boliche. El adversario tiene que continuar jugando sus bolas hasta que recupere el punto, es decir, colocar su bola m\u00E1s cerca del boliche.\r\n\r\nCada bola de un mismo equipo, si ninguna bola del equipo contrario es m\u00E1s cerca del objetivo, cuenta como un punto, y estos puntos se cuentan a finales de cada ronda, es decir, cuando se han jugado o lanzado todas las bolas.\r\n\r\nLas bolas tienen que ser met\u00E1licas, con un di\u00E1metro comprendido entre los 7\u201905 cm y los 8 cm y un peso de 650 g como m\u00EDnimo y 800 g como m\u00E1ximo.\r\n\r\nEl boliche tiene que ser de madera y su di\u00E1metro tiene que estar comprendido entre 25 mm y 35 mm.\r\n\r\nHay dos maneras de lanzar las bolas y son muy diferentes:\r\n\r\n1) Apuntar es lanzar la bola con cuidado, tratando de acercarse el m\u00E1ximo posible al boliche.\r\n\r\n2) Echar o picar es lanzar la bola con una cierta fuerza para herir y pues apartar la bola del contrario, en el supuesto de que esta haga el punto. Cuando despu\u00E9s de haber lanzado la bola esta permanece en el mismo lugar que la bola que hab\u00EDa antes, se denomina carro. Es la perfecci\u00F3n en la jugada del tiro. El nombre de \"carro\" proviene del franc\u00E9s \"carreau\", que significa baldosa. Los franceses dicen que se hace jugada de \"carreau\" cuando la bola lanzada permanece en la misma posici\u00F3n que ten\u00EDa anteriormente la bola tocada, del mismo modo que se cambia una baldosa echada a perder por una baldosa nueva.\r\n\r\n3) Estrucar es herir con una abullona otra del juego. hacer toque es de herirse dos bolas. Toque y palmo es la jugada en que un jugador toca con la suya abullona la de otro y adem\u00E1s las dos bolas restan a una distancia no superior a un palmo, cosa que a\u00F1ade m\u00E9rito a la jugada.\r\n\r\nEn una tripleta cada uno de los tres jugadores acostumbra a realizar las jugadas de la manera siguiente:\r\n\r\nEl apuntador se especializa a apuntar sus bolas aproxim\u00E1ndose al boliche.\r\nEl medio hace los dos trabajos a la vez de apuntar y picar.\r\nEl tirador o picador ejecuta habitualmente la jugada de echar o picar contra las bolas del adversario.\r\nReferencias\r\n Marco Foyot, Alain Dupuy, Louis Dalmas, P\u00E9tanque - Technique, Tactique, Entrainement, Robert Laffont, 1984.\r\n Reglamento de juego oficial de petanca. Federaci\u00F3n Espa\u00F1ola de Petanca.\r\nhttp://www.fepetanca.com/reglamento-oficial-de-petanca-2021\r\n\r\nV\u00E9ase tambi\u00E9n\r\nVer el portal sobre Deporte Portal:Deporte. Contenido relacionado con Deporte.\r\nBochas\r\nBolas criollas\r\nPetanca en los Juegos Mediterr\u00E1neos de 2009\r\nEnlaces externos\r\n Wikimedia Commons alberga una galer\u00EDa multimedia sobre Petanca.\r\nFederaci\u00F3n Espa\u00F1ola de Petanca\r\nFederaci\u00F3n Andaluza de Petanca\r\nFederaci\u00F3n Galega de Petanca\r\nControl de autoridades\t\r\nProyectos WikimediaWd Datos: Q189317Commonscat Multimedia: P\u00E9tanque\r\nIdentificadoresNDL: 00577517AAT: 300222807\r\nCategor\u00EDas: PetancaBolos\r\nMen\u00FA de navegaci\u00F3n\r\nNo has accedido\r\nDiscusi\u00F3n\r\nContribuciones\r\nCrear una cuenta\r\nAcceder\r\nArt\u00EDculoDiscusi\u00F3n\r\nLeerEditarVer historial\r\nBuscar\r\nBuscar en Wikipedia\r\nPortada\r\nPortal de la comunidad\r\nActualidad\r\nCambios recientes\r\nP\u00E1ginas nuevas\r\nP\u00E1gina aleatoria\r\nAyuda\r\nDonaciones\r\nNotificar un error\r\nHerramientas\r\nLo que enlaza aqu\u00ED\r\nCambios en enlazadas\r\nSubir archivo\r\nP\u00E1ginas especiales\r\nEnlace permanente\r\nInformaci\u00F3n de la p\u00E1gina\r\nCitar esta p\u00E1gina\r\nElemento de Wikidata\r\nImprimir/exportar\r\nCrear un libro\r\nDescargar como PDF\r\nVersi\u00F3n para imprimir\r\nEn otros proyectos\r\nWikimedia Commons\r\n\r\nEn otros idiomas\r\n\u0627\u0644\u0639\u0631\u0628\u064A\u0629\r\nAsturianu\r\nCatal\u00E0\r\nEnglish\r\nEuskara\r\nGalego\r\nBahasa Indonesia\r\n\u0420\u0443\u0441\u0441\u043A\u0438\u0439\r\n\u4E2D\u6587\r\n37 m\u00E1s\r\nEditar enlaces\r\nEsta p\u00E1gina se edit\u00F3 por \u00FAltima vez el 5 dic 2021 a las 20:45.\r\nEl texto est\u00E1 disponible bajo la Licencia Creative Commons Atribuci\u00F3n Compartir Igual 3.0; pueden aplicarse cl\u00E1usulas adicionales. Al usar este sitio, usted acepta nuestros t\u00E9rminos de uso y nuestra pol\u00EDtica de privacidad.\r\nWikipedia\u00AE es una marca registrada de la Fundaci\u00F3n Wikimedia, Inc., una organizaci\u00F3n sin \u00E1nimo de lucro.\r\nPol\u00EDtica de privacidadAcerca de WikipediaLimitaci\u00F3n de responsabilidadVersi\u00F3n para m\u00F3vilesDesarrolladoresEstad\u00EDsticasDeclaraci\u00F3n de cookiesWikimedia FoundationPowered by MediaWiki\r\n\r\nPetanca\r\nIr a la navegaci\u00F3nIr a la b\u00FAsqueda\r\nLa petanca es un deporte/juego en el que el objetivo es lanzar bolas tan cerca del boliche, lanzada anteriormente por un jugador, con ambos pies en el suelo y en posici\u00F3n est\u00E1tica desde una determinada zona.\r\n\r\n\r\nEl deporte en su forma actual surgi\u00F3 en 1907 en la Provenza francesa, aunque los antiguos ya jugaban una versi\u00F3n primitiva con bolas de piedra, que fue llevada a Provenza por soldados y marineros romanos. Su nombre procede de la expresi\u00F3n \"p\u00E8(s) tancats\" (\"pies juntos\") en lengua provenzal.1\u200B Las federaciones regulan las competiciones oficiales de este deporte.\r\n\r\nEl deporte se puede practicar en todo tipo de terreno, aunque normalmente se hace en zonas llanas, arenosas. Las pistas son rectangulares con un largo de 15 m y un ancho de 4 m para competiciones nacionales e internacionales, aunque pueden tener unas dimensiones m\u00EDnimas de 16 m x 5 m para otras competiciones.\r\n\r\n\r\nEl boliche (a la izquierda) y la bola (a la derecha).\r\nLas bolas usadas son met\u00E1licas (no deben contener plomo ni arena en su interior). Su di\u00E1metro debe medir entre 70,05 mm y 80,0 mm, mientras que su peso oscila entre los 650 y los 800 g. El boliche es de madera o de material sint\u00E9tico y debe tener un di\u00E1metro de 30 mm.2\u200B\r\n\r\n\r\n\u00CDndice\r\n1\tLa partida\r\n2\tReglas del juego\r\n3\tReferencias\r\n4\tV\u00E9ase tambi\u00E9n\r\n5\tEnlaces externos\r\nLa partida\r\nAl comenzar la partida se lanza el boliche desde una circunferencia de entre 35 y 50mm de di\u00E1metro lanzamiento que debe colocarse como m\u00EDnimo a 1 m de cualquier obst\u00E1culo. Para que dicho lanzamiento sea v\u00E1lido, el boliche debe quedar a una distancia de 1 m  de la circunferencia de lanzamiento y al menos a 1 m de cualquier obst\u00E1culo. Despu\u00E9s, cada deportista lanza, por turno, tres bolas en la modalidad individual y en dupletas (dos equipos de dos deportistas) y dos si la partida es por tripletas (dos equipos de tres deportistas). Los lanzamientos pueden ser de tres tipos: de aproximaci\u00F3n al boliche; de \"tiro\" (al tiro perfecto se le llama carro seco, en el cual la bola tirada queda en el mismo lugar que la bola a la que se ha lanzado), para intentar alejar una bola de un jugador contrario golpe\u00E1ndola; y de \"apoyo\", haciendo rodar la bola para acercar m\u00E1s una propia al boliche o para alejar una contraria.\r\n\r\nUna vez concluida la partida, las bolas que se encuentre m\u00E1s cerca del boliche que las de los adversarios se apunta un punto por cada bola. Gana el deportista o el equipo que llegue antes a trece puntos.\r\n\r\n\r\nPartida de la petanca\r\nReglas del juego\r\nAparentemente es muy simple. Se trata de lanzar una bola lo m\u00E1s cerca posible de un objetivo llamado boliche o mingo (y al Rossell\u00F3 nano). Los adversarios pueden ser uno contra uno (individuales o jefe-y-jefe) o por equipos de dos contra dos (dobletes) o tres contra tres (tripletes). Las partidas suelen jugarse a 13 puntos en terreno libre o bien dentro de una pista delimitada (la dimensi\u00F3n oficial es un rect\u00E1ngulo de 15 m x 4 m).\r\n\r\nEl punto pertenece a la bola m\u00E1s pr\u00F3xima al boliche. El adversario tiene que continuar jugando sus bolas hasta que recupere el punto, es decir, colocar su bola m\u00E1s cerca del boliche.\r\n\r\nCada bola de un mismo equipo, si ninguna bola del equipo contrario es m\u00E1s cerca del objetivo, cuenta como un punto, y estos puntos se cuentan a finales de cada ronda, es decir, cuando se han jugado o lanzado todas las bolas.\r\n\r\nLas bolas tienen que ser met\u00E1licas, con un di\u00E1metro comprendido entre los 7\u201905 cm y los 8 cm y un peso de 650 g como m\u00EDnimo y 800 g como m\u00E1ximo.\r\n\r\nEl boliche tiene que ser de madera y su di\u00E1metro tiene que estar comprendido entre 25 mm y 35 mm.\r\n\r\nHay dos maneras de lanzar las bolas y son muy diferentes:\r\n\r\n1) Apuntar es lanzar la bola con cuidado, tratando de acercarse el m\u00E1ximo posible al boliche.\r\n\r\n2) Echar o picar es lanzar la bola con una cierta fuerza para herir y pues apartar la bola del contrario, en el supuesto de que esta haga el punto. Cuando despu\u00E9s de haber lanzado la bola esta permanece en el mismo lugar que la bola que hab\u00EDa antes, se denomina carro. Es la perfecci\u00F3n en la jugada del tiro. El nombre de \"carro\" proviene del franc\u00E9s \"carreau\", que significa baldosa. Los franceses dicen que se hace jugada de \"carreau\" cuando la bola lanzada permanece en la misma posici\u00F3n que ten\u00EDa anteriormente la bola tocada, del mismo modo que se cambia una baldosa echada a perder por una baldosa nueva.\r\n\r\n3) Estrucar es herir con una abullona otra del juego. hacer toque es de herirse dos bolas. Toque y palmo es la jugada en que un jugador toca con la suya abullona la de otro y adem\u00E1s las dos bolas restan a una distancia no superior a un palmo, cosa que a\u00F1ade m\u00E9rito a la jugada.\r\n\r\nEn una tripleta cada uno de los tres jugadores acostumbra a realizar las jugadas de la manera siguiente:\r\n\r\nEl apuntador se especializa a apuntar sus bolas aproxim\u00E1ndose al boliche.\r\nEl medio hace los dos trabajos a la vez de apuntar y picar.\r\nEl tirador o picador ejecuta habitualmente la jugada de echar o picar contra las bolas del adversario.\r\nReferencias\r\n Marco Foyot, Alain Dupuy, Louis Dalmas, P\u00E9tanque - Technique, Tactique, Entrainement, Robert Laffont, 1984.\r\n Reglamento de juego oficial de petanca. Federaci\u00F3n Espa\u00F1ola de Petanca.\r\nhttp://www.fepetanca.com/reglamento-oficial-de-petanca-2021\r\n\r\nV\u00E9ase tambi\u00E9n\r\nVer el portal sobre Deporte Portal:Deporte. Contenido relacionado con Deporte.\r\nBochas\r\nBolas criollas\r\nPetanca en los Juegos Mediterr\u00E1neos de 2009\r\nEnlaces externos\r\n Wikimedia Commons alberga una galer\u00EDa multimedia sobre Petanca.\r\nFederaci\u00F3n Espa\u00F1ola de Petanca\r\nFederaci\u00F3n Andaluza de Petanca\r\nFederaci\u00F3n Galega de Petanca\r\nControl de autoridades\t\r\nProyectos WikimediaWd Datos: Q189317Commonscat Multimedia: P\u00E9tanque\r\nIdentificadoresNDL: 00577517AAT: 300222807\r\nCategor\u00EDas: PetancaBolos\r\nMen\u00FA de navegaci\u00F3n\r\nNo has accedido\r\nDiscusi\u00F3n\r\nContribuciones\r\nCrear una cuenta\r\nAcceder\r\nArt\u00EDculoDiscusi\u00F3n\r\nLeerEditarVer historial\r\nBuscar\r\nBuscar en Wikipedia\r\nPortada\r\nPortal de la comunidad\r\nActualidad\r\nCambios recientes\r\nP\u00E1ginas nuevas\r\nP\u00E1gina aleatoria\r\nAyuda\r\nDonaciones\r\nNotificar un error\r\nHerramientas\r\nLo que enlaza aqu\u00ED\r\nCambios en enlazadas\r\nSubir archivo\r\nP\u00E1ginas especiales\r\nEnlace permanente\r\nInformaci\u00F3n de la p\u00E1gina\r\nCitar esta p\u00E1gina\r\nElemento de Wikidata\r\nImprimir/exportar\r\nCrear un libro\r\nDescargar como PDF\r\nVersi\u00F3n para imprimir\r\nEn otros proyectos\r\nWikimedia Commons\r\n\r\nEn otros idiomas\r\n\u0627\u0644\u0639\u0631\u0628\u064A\u0629\r\nAsturianu\r\nCatal\u00E0\r\nEnglish\r\nEuskara\r\nGalego\r\nBahasa Indonesia\r\n\u0420\u0443\u0441\u0441\u043A\u0438\u0439\r\n\u4E2D\u6587\r\n37 m\u00E1s\r\nEditar enlaces\r\nEsta p\u00E1gina se edit\u00F3 por \u00FAltima vez el 5 dic 2021 a las 20:45.\r\nEl texto est\u00E1 disponible bajo la Licencia Creative Commons Atribuci\u00F3n Compartir Igual 3.0; pueden aplicarse cl\u00E1usulas adicionales. Al usar este sitio, usted acepta nuestros t\u00E9rminos de uso y nuestra pol\u00EDtica de privacidad.\r\nWikipedia\u00AE es una marca registrada de la Fundaci\u00F3n Wikimedia, Inc., una organizaci\u00F3n sin \u00E1nimo de lucro.\r\nPol\u00EDtica de privacidadAcerca de WikipediaLimitaci\u00F3n de responsabilidadVersi\u00F3n para m\u00F3vilesDesarrolladoresEstad\u00EDsticasDeclaraci\u00F3n de cookiesWikimedia FoundationPowered by MediaWiki");
		textPaneInfo.setEditable(false);
		verticalBox.add(textPaneInfo);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JButton btnRanking = new JButton("Ranking");
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
