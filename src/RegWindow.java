import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class RegWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private final JTextField textApellidos = new JTextField();
	private final JTextField textNombre = new JTextField();
	private JTextField textFieldApellidos;
	private JTextField textDomicilio;
	private JTextField textFechaNac;
	private JTextField textDni;
	private JTextField textFieldDomicilio;
	private JTextField textFieldFechaNac;
	private JTextField textFieldDni;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
		//carbaputooooooooooooooo
	/**
	 * Create the panel.
	 */
	public RegWindow() {
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
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		/*verticalStrut = Box.createVerticalStrut(2000);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		getContentPane().add(verticalStrut, gbc_verticalStrut);*/
		
		horizontalStrut = Box.createHorizontalStrut(200);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(200);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 2;
		getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		/*verticalStrut_1 = Box.createVerticalStrut(2000);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 6;
		getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);*/
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setMinimumSize(new Dimension(100, 20));
		textFieldDomicilio.setColumns(10);
		GridBagConstraints gbc_textFieldDomicilio = new GridBagConstraints();
		gbc_textFieldDomicilio.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDomicilio.gridx = 2;
		gbc_textFieldDomicilio.gridy = 3;
		getContentPane().add(textFieldDomicilio, gbc_textFieldDomicilio);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setMinimumSize(new Dimension(100, 20));
		textFieldFechaNac.setColumns(10);
		GridBagConstraints gbc_textFieldFechaNac = new GridBagConstraints();
		gbc_textFieldFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaNac.gridx = 2;
		gbc_textFieldFechaNac.gridy = 4;
		getContentPane().add(textFieldFechaNac, gbc_textFieldFechaNac);
		
		textDni = new JTextField();
		textDni.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDni.setMinimumSize(new Dimension(110, 20));
		textDni.setText("DNI:");
		textDni.setEditable(false);
		textDni.setColumns(10);
		GridBagConstraints gbc_textDni = new GridBagConstraints();
		gbc_textDni.insets = new Insets(0, 0, 5, 5);
		gbc_textDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDni.gridx = 1;
		gbc_textDni.gridy = 5;
		getContentPane().add(textDni, gbc_textDni);
		
		textFechaNac = new JTextField();
		textFechaNac.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFechaNac.setMinimumSize(new Dimension(110, 20));
		textFechaNac.setText("Fecha de nacimiento:");
		textFechaNac.setEditable(false);
		textFechaNac.setColumns(10);
		GridBagConstraints gbc_textFechaNac = new GridBagConstraints();
		gbc_textFechaNac.insets = new Insets(0, 0, 5, 5);
		gbc_textFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFechaNac.gridx = 1;
		gbc_textFechaNac.gridy = 4;
		getContentPane().add(textFechaNac, gbc_textFechaNac);
		
		textDomicilio = new JTextField();
		textDomicilio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDomicilio.setMinimumSize(new Dimension(110, 20));
		textDomicilio.setText("Domicilio:");
		textDomicilio.setEditable(false);
		textDomicilio.setColumns(10);
		GridBagConstraints gbc_textDomicilio = new GridBagConstraints();
		gbc_textDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_textDomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDomicilio.gridx = 1;
		gbc_textDomicilio.gridy = 3;
		getContentPane().add(textDomicilio, gbc_textDomicilio);
		
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.gridx = 1;
		gbc_textApellidos.gridy = 2;
		textApellidos.setMinimumSize(new Dimension(110, 20));
		textApellidos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textApellidos.setBounds(new Rectangle(0, 0, 500, 500));
		textApellidos.setSize(new Dimension(500, 500));
		textApellidos.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(textApellidos, gbc_textApellidos);
		textApellidos.setText("Apellidos:");
		textApellidos.setEditable(false);
		textApellidos.setColumns(10);
		
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 1;
		textNombre.setMinimumSize(new Dimension(110, 20));
		textNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textNombre.setBounds(new Rectangle(0, 0, 500, 500));
		textNombre.setSize(new Dimension(500, 500));
		textNombre.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setText("Nombre:");
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setMinimumSize(new Dimension(100, 20));
		textFieldApellidos.setColumns(10);
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.gridx = 2;
		gbc_textFieldApellidos.gridy = 2;
		getContentPane().add(textFieldApellidos, gbc_textFieldApellidos);
		
		textFieldDni = new JTextField();
		textFieldDni.setMinimumSize(new Dimension(100, 20));
		textFieldDni.setColumns(10);
		GridBagConstraints gbc_textFieldDni = new GridBagConstraints();
		gbc_textFieldDni.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDni.gridx = 2;
		gbc_textFieldDni.gridy = 5;
		getContentPane().add(textFieldDni, gbc_textFieldDni);
		
	}

}