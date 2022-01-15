package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Connection;
import modelo.Game;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
	private Box verticalBoxGames;
	private ArrayList<Box> horizontalBoxes=new ArrayList<Box>();
	private ArrayList<JButton> btns=new ArrayList<JButton>();
	private ArrayList<Game> juegos=new ArrayList<Game>();
	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MainWindow main=new MainWindow();
				main.frame.setVisible(true);
				e.getWindow().dispose();
			}
		});
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
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
		btnPerfil.setMaximumSize(new Dimension(100, 100));
		btnPerfil.setSize(new Dimension(100, 100));
		btnPerfil.setPreferredSize(new Dimension(100, 100));
		btnPerfil.setMinimumSize(new Dimension(100, 100));
		horizontalBoxPerfil.add(btnPerfil);
		
		verticalBoxGames = Box.createVerticalBox();
		scrollPane.setViewportView(verticalBoxGames);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBoxGames.add(verticalStrut);
		
		crearBotonesJuegos();
		
		for(int i=0;i<juegos.size();i++) {
			final int final_i=i;
			btns.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					infoGameWindow infoJuego = new infoGameWindow(juegos.get(final_i));
					infoJuego.setVisible(true);
				}
			});
		}
		
		/*btns.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				infoGameWindow infoJuego = new infoGameWindow(1);
				infoJuego.setVisible(true);
			}
		});
		
		btns.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				infoGameWindow infoJuego = new infoGameWindow(2);
				infoJuego.setVisible(true);
			}
		});
		
		btns.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				infoGameWindow infoJuego = new infoGameWindow(3);
				infoJuego.setVisible(true);
			}
		});*/
	}
	
	public void crearBotonesJuegos() {
		Connection n = new Connection();	
		int nJuegos;
		String nombresJuegos;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select numJuegos from SISTEMAJUEGOS;");
			ResultSet result = consulta.executeQuery();
			result.next();
			nJuegos = result.getInt("numJuegos");
			result.close();
			if(nJuegos!=0) {
				for(int i=1;i<=nJuegos;i++) {
					PreparedStatement consulta2 = n.getConnection().prepareStatement("Select nombreJuego from JUEGOS where numeroJuego='"+i+"';");
					ResultSet result2 = consulta2.executeQuery();
					result2.next();
					nombresJuegos = result2.getString("nombreJuego");
					result2.close();
					juegos.add(new Game(nombresJuegos));
				}	
			}					
			n.disconnect();					
		} catch (SQLException error) {
		}
		if(juegos.size()!=0) {			
			for(int i=0;i<juegos.size();i+=2) {
				horizontalBoxes.add(Box.createHorizontalBox());
			}
			for(int i=0;i<juegos.size();i++) {				
				JButton boton=new JButton(juegos.get(i).getNombreJuego());
				boton.setPreferredSize(new Dimension(990, 990));
				boton.setMaximumSize(new Dimension(990, 1100));
				btns.add(boton);
			}
			int aux=0;
			for(int i=0;i<juegos.size();i++) {
				if((i%2)==0) {
					horizontalBoxes.get(aux).add(btns.get(i));
					verticalBoxGames.add(horizontalBoxes.get(aux));
				}else {
					horizontalBoxes.get(aux).add(btns.get(i));
					verticalBoxGames.add(horizontalBoxes.get(aux));
					aux+=1;
				}
			}		
		}		
	}
}