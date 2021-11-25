import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class IniWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDni;
	private JTextField textFieldContrasena;
	private JTextField textContrasena;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private JButton btnFinalizar;
	private String dni;	
	private String contrasena;
	/**
	 * Create the panel.
	 */
	public IniWindow() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MainWindow main=new MainWindow();
				main.frame.setVisible(true);
				e.getWindow().dispose();
			}
		});
		setBounds(100, 100, 470, 450);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		verticalStrut = Box.createVerticalStrut(2000);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		horizontalStrut = Box.createHorizontalStrut(200);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(200);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 2;
		getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textFieldDni.getText().equals("")) {
					if(!textFieldContrasena.getText().equals("")) {
						dni=textFieldDni.getText();
						contrasena=textFieldContrasena.getText();
						textFieldDni.setText("");
						textFieldContrasena.setText("");
						textFieldDni.setText("");
						textFieldContrasena.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Introduzca una contrase�a.");
					}									
				}else {
					JOptionPane.showMessageDialog(null, "Introduzca su dni.");
				}							
			}
		});
		btnFinalizar.setMinimumSize(new Dimension(220, 23));
		btnFinalizar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFinalizar.gridx = 1;
		gbc_btnFinalizar.gridy = 3;
		gbc_btnFinalizar.gridwidth = 2;
		getContentPane().add(btnFinalizar, gbc_btnFinalizar);
		
		verticalStrut_1 = Box.createVerticalStrut(2000);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 4;
		getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);
		
		JTextField textDni = new JTextField();
		textDni.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDni.setMinimumSize(new Dimension(110, 20));
		textDni.setText("DNI:");
		textDni.setEditable(false);
		textDni.setColumns(10);
		GridBagConstraints gbc_textDni = new GridBagConstraints();
		gbc_textDni.insets = new Insets(0, 0, 5, 5);
		gbc_textDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDni.gridx = 1;
		gbc_textDni.gridy = 1;
		getContentPane().add(textDni, gbc_textDni);
		
		textContrasena = new JTextField();
		textContrasena.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textContrasena.setMinimumSize(new Dimension(110, 20));
		textContrasena.setText("Contrase�a:");
		textContrasena.setEditable(false);
		textContrasena.setColumns(10);
		GridBagConstraints gbc_textContrasena = new GridBagConstraints();
		gbc_textContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_textContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_textContrasena.gridx = 1;
		gbc_textContrasena.gridy = 2;
		getContentPane().add(textContrasena, gbc_textContrasena);
		
		textFieldDni = new JTextField();
		textFieldDni.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textFieldDni = new GridBagConstraints();
		gbc_textFieldDni.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDni.gridx = 2;
		gbc_textFieldDni.gridy = 1;
		getContentPane().add(textFieldDni, gbc_textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setMinimumSize(new Dimension(100, 20));
		textFieldContrasena.setColumns(10);
		GridBagConstraints gbc_textFieldContrasena = new GridBagConstraints();
		gbc_textFieldContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContrasena.gridx = 2;
		gbc_textFieldContrasena.gridy = 2;
		getContentPane().add(textFieldContrasena, gbc_textFieldContrasena);
		
	}
	private JPanel contentPane;
}
