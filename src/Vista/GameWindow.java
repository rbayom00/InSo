package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Admin;
import modelo.Connection;
import modelo.Tournament;
import modelo.Moderator;
import modelo.Person;

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
	private ArrayList<Tournament> juegos=new ArrayList<Tournament>();
	private Person user;
	/**
	 * Create the frame.
	 */
	public GameWindow(Person user) {
		this.user=user;
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
			juegos.get(i).setTournamentID(i+1);;
			btns.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					InfoGameWindow infoJuego = new InfoGameWindow(juegos.get(final_i),user);
					infoJuego.setVisible(true);
				}
			});
		}
	}
	
	public void crearBotonesJuegos() {
		Connection n = new Connection();	
		int nJuegos;
		String nombresJuegos;
		String infoJuegos;
		String modalities;
		try {
			PreparedStatement consulta = n.getConnection().prepareStatement("Select GameCount from System_;");
			ResultSet result = consulta.executeQuery();
			result.next();
			nJuegos = result.getInt("GameCount");
			result.close();
			if(nJuegos!=0) {
				for(int i=1;i<=nJuegos;i++) {
					PreparedStatement consulta2 = n.getConnection().prepareStatement("Select GameName,GameDescription,TournamentModality from Tournament where TournamentID='"+i+"';");
					ResultSet result2 = consulta2.executeQuery();
					result2.next();
					nombresJuegos = result2.getString("GameName");
					infoJuegos = result2.getString("GameDescription");
					modalities=result2.getString("TournamentModality");
					result2.close();
					juegos.add(new Tournament(nombresJuegos,infoJuegos,modalities));
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
				JButton boton=new JButton(juegos.get(i).getNombreTorneo());
				boton.setPreferredSize(new Dimension(958, 400));
				boton.setMaximumSize(new Dimension(958, 400));
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