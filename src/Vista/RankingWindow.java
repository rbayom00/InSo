package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Admin;
import modelo.Game;
import modelo.Person;
import modelo.Ranking;

import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTable;

public class RankingWindow extends JFrame {

	private JPanel panel;
	private Game juego;
	private Person user;
	private JTable table;
	private Ranking ranking;
	private DefaultTableModel modelo;
	/**
	 * Create the frame.
	 */
	public RankingWindow(Game juego,Person user) {
		this.juego=juego;
		this.user=user;
		this.ranking=new Ranking(this.juego);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				InfoGameWindow infoGame=new InfoGameWindow(juego,user);
				infoGame.setVisible(true);
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
				Admin adminP=new Admin("02773491J","02773491J","2001-06-22","Raúl","Bayón Martínez","C/Colada nº13 1ºC");
				ProfileAdmin admin = new ProfileAdmin(adminP);
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
		
		JLabel lblNombreJuego = new JLabel((String) null);
		lblNombreJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreJuego.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNombreJuego.setAlignmentX(0.5f);
		horizontalBoxPerfil.add(lblNombreJuego);
		
		modelo = new DefaultTableModel() {
			@Override
			 public boolean isCellEditable(int row, int column) {
			       return false;
			 }
		};
		modelo.addColumn("Nº");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Puntuación");
		rellenarTabla();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);			
	}
	
	private void rellenarTabla() {
		ArrayList<Person> personas=this.ranking.getPersonas();
		ArrayList<Integer> puntuaciones=this.ranking.getPuntuaciones();
		for(int i=0;i<personas.size();i++) {
			Object[] fila = new Object[4];
			fila[0]=i+1;
			fila[1]=personas.get(i).getNombre();
			fila[2]=personas.get(i).getApellidos();
			fila[3]=puntuaciones.get(i).toString();
			modelo.addRow(fila);
		}				
	}
}
