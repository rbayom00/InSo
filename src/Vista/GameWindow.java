package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
	private int numBtns=0;
	private Box verticalBoxGames;
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
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBoxGames.add(horizontalBox_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setPreferredSize(new Dimension(990, 400));
		btnNewButton.setMinimumSize(new Dimension(990, 1100));
		btnNewButton.setMaximumSize(new Dimension(990, 1100));
		horizontalBox_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setPreferredSize(new Dimension(990, 400));
		btnNewButton_1.setMaximumSize(new Dimension(990, 1100));
		horizontalBox_2.add(btnNewButton_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBoxGames.add(horizontalBox);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setPreferredSize(new Dimension(990, 990));
		btnNewButton_2.setMaximumSize(new Dimension(990, 1100));
		horizontalBox.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setPreferredSize(new Dimension(990, 990));
		btnNewButton_3.setMaximumSize(new Dimension(990, 1100));
		horizontalBox.add(btnNewButton_3);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBoxGames.add(horizontalBox_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setPreferredSize(new Dimension(990, 990));
		btnNewButton_2_1.setMaximumSize(new Dimension(990, 1100));
		horizontalBox_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		btnNewButton_3_1.setPreferredSize(new Dimension(990, 990));
		btnNewButton_3_1.setMaximumSize(new Dimension(990, 1100));
		horizontalBox_1.add(btnNewButton_3_1);
		
	}
	
	public void anadirJuego() {
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBoxGames.add(horizontalBox_4);
		JButton btnNewButton_4_1 = new JButton("Botón prueba");
		btnNewButton_4_1.setPreferredSize(new Dimension(990, 990));
		btnNewButton_4_1.setMaximumSize(new Dimension(990, 1100));
		horizontalBox_4.add(btnNewButton_4_1);
	}

}