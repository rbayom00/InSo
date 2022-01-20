package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Admin;
import modelo.Person;
import modelo.Ranking;
import modelo.Tournament;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modifyRankingWindow extends JFrame {
	private JTable table;
	private Ranking ranking;
	private DefaultTableModel modelo;
	/**
	 * Create the frame.
	 */
	public modifyRankingWindow(String tournamentID,Admin admin) {		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ProfileAdmin pAdmin=new ProfileAdmin(admin);
				pAdmin.setVisible(true);
				e.getWindow().dispose();
			}
		});	
		this.ranking=new Ranking(tournamentID);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		modelo = new DefaultTableModel(){
			@Override
			 public boolean isCellEditable(int row, int column) {
			       return false;
			 }
		};
		modelo.addColumn("Nº");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Puntuación");
		modelo.addColumn("DNI");
		rellenarTabla();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);		
		
		JButton btnActualizarRanking = new JButton("Actualizar Ranking");
		btnActualizarRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = JOptionPane.showInputDialog("Introduzca el dni para actualizar su puntuación.");
				String puntuacion = JOptionPane.showInputDialog("Introduzca la nueva puntuación.");
				if(ranking.actualizarRanking(dni,puntuacion)) {					
					modelo = new DefaultTableModel(){
						@Override
						 public boolean isCellEditable(int row, int column) {
						       return false;
						 }
					};
					modelo.addColumn("Nº");
					modelo.addColumn("Nombre");
					modelo.addColumn("Apellidos");
					modelo.addColumn("Puntuación");
					modelo.addColumn("DNI");
					rellenarTabla();
					table = new JTable(modelo);
					scrollPane.setViewportView(table);						
					JOptionPane.showMessageDialog(null,"Ranking actualizado con exito.");
				}else {
					JOptionPane.showMessageDialog(null,"Has introducido un dni erroneo o la persona no se encuentra en este ranking, intentelo de nuevo");
				}
			}
		});
		getContentPane().add(btnActualizarRanking);
	}
	
	private void rellenarTabla() {
		ArrayList<Person> personas=this.ranking.getPersonas();
		ArrayList<Integer> puntuaciones=this.ranking.getPuntuaciones();
		for(int i=0;i<personas.size();i++) {
			Object[] fila = new Object[5];
			fila[0]=i+1;
			fila[1]=personas.get(i).getNombre();
			fila[2]=personas.get(i).getApellidos();
			fila[3]=puntuaciones.get(i).toString();
			fila[4]=personas.get(i).getDni();
			modelo.addRow(fila);
		}				
	}
}
