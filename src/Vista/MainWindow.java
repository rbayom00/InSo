package Vista;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JLabel;

public class MainWindow {

	public JFrame frame;
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		Component verticalStrut = Box.createVerticalStrut(1800);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		frame.getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		JButton btnLogo = new JButton("Logo");
		btnLogo.setBorder(null);
		btnLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/logo/logo.png")));
		GridBagConstraints gbc_btnLogo = new GridBagConstraints();
		btnLogo.setMinimumSize(new Dimension(490, 260));
		btnLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogo.setSize(new Dimension(95, 23));
		gbc_btnLogo.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogo.gridx = 1;
		gbc_btnLogo.gridy = 1;
		frame.getContentPane().add(btnLogo, gbc_btnLogo);
		
		Component horizontalStrut = Box.createHorizontalStrut(2000);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi�n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LogWindow iniwindow=new LogWindow();
				iniwindow.setVisible(true);
			}
		});
		btnIniciarSesion.setMinimumSize(new Dimension(150, 30));
		btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.setSize(new Dimension(95, 23));
		GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
		gbc_btnIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarSesion.gridx = 1;
		gbc_btnIniciarSesion.gridy = 2;
		frame.getContentPane().add(btnIniciarSesion, gbc_btnIniciarSesion);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(2000);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 2;
		frame.getContentPane().add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 3;
		frame.getContentPane().add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(2000);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 4;
		frame.getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setMinimumSize(new Dimension(150, 30));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RegWindow regwindow=new RegWindow();
				regwindow.setVisible(true);
			}
		});
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegistrarse.setPreferredSize(new Dimension(95, 23));
		GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
		gbc_btnRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistrarse.gridx = 1;
		gbc_btnRegistrarse.gridy = 5;
		frame.getContentPane().add(btnRegistrarse, gbc_btnRegistrarse);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(2000);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 4;
		frame.getContentPane().add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(2000);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 6;
		frame.getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);
	}

}