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

public class GameWindow extends JFrame {
	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		Box horizontalBoxPerfil = Box.createHorizontalBox();
		scrollPane.setColumnHeaderView(horizontalBoxPerfil);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setMaximumSize(new Dimension(100, 100));
		btnPerfil.setSize(new Dimension(100, 100));
		btnPerfil.setPreferredSize(new Dimension(100, 100));
		btnPerfil.setMinimumSize(new Dimension(100, 100));
		horizontalBoxPerfil.add(btnPerfil);
		
		Box verticalBoxGames = Box.createVerticalBox();
		scrollPane.setViewportView(verticalBoxGames);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBoxGames.add(verticalStrut);
		
		Box horizontalBoxGames = Box.createHorizontalBox();
		verticalBoxGames.add(horizontalBoxGames);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setPreferredSize(new Dimension(990, 400));
		btnNewButton.setMinimumSize(new Dimension(990, 1100));
		btnNewButton.setMaximumSize(new Dimension(990, 1100));
		horizontalBoxGames.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setPreferredSize(new Dimension(990, 400));
		btnNewButton_1.setMaximumSize(new Dimension(990, 1100));
		horizontalBoxGames.add(btnNewButton_1);
		
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

}
