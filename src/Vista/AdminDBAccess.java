package Vista;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Admin;
import modelo.Person;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AdminDBAccess extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Person> profileList;
	private DefaultTableModel tableModel;

	public AdminDBAccess(Admin admin) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ProfileAdmin pAdmin=new ProfileAdmin(admin);
				pAdmin.setVisible(true);
				e.getWindow().dispose();
			}
		});		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox, BorderLayout.NORTH);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JButton newProfileBtn = new JButton("Nuevo Perfil");
		newProfileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String DNI, name, surname, address, password, birth_date;
				DNI = requestData("el DNI");
				name = requestData("el nombre");
				surname = requestData("los apellidos");
				address = requestData("la dirección");
				password = requestData("clave");
				birth_date = requestData("fecha de nacimiento (Formato: \"2001-06-22\")");
				if(DNI != null && name != null && surname != null && address != null && password != null && birth_date != null) {
					boolean res = admin.addPerson(new Person(DNI, password, birth_date, name, surname, address));
					if(!res) {
						JOptionPane.showMessageDialog(null, "Problema al completar tu petición, inténtalo de nuevo.","BBDD Error",JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Completa todos los datos y verifica que sean válidos.","Input Error",JOptionPane.ERROR_MESSAGE);
				}
				refreshProfileListTable(admin);
			}
		});
		horizontalBox.add(newProfileBtn);
		
		JButton removeProfileBtn = new JButton("Eliminar Perfil");
		removeProfileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a;
				if((a = requestData("el DNI")) != null) {
					boolean res = admin.removePerson(a);
					if(!res) {
						JOptionPane.showMessageDialog(null, "Problema al completar tu petición, inténtalo de nuevo.","BBDD Error",JOptionPane.ERROR_MESSAGE);
					}
					refreshProfileListTable(admin);
				}
			}
		});
		horizontalBox.add(removeProfileBtn);
		
		JButton editProfileBtn = new JButton("Editar Perfil");
		editProfileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String DNI = requestData("el DNI");
				String attr = JOptionPane.showInputDialog("Especifique atributo del perfil a modificar:\n"
						+ "Opciones: DNI, Password, Birth_Date, Name, Surname, Address.");
				if(attr != null && (attr.equals("DNI")||attr.equals("Password")||attr.equals("Birth_Date")||attr.equals("Name")||attr.equals("Surname")||attr.equals("Address"))) {
					String content = JOptionPane.showInputDialog("Indique valor de \""+attr+"\":");
					if(DNI != null) {
						boolean res = admin.modifyPerson(DNI, attr, content);
						if(!res) {
							JOptionPane.showMessageDialog(null, "Problema al completar tu petición, inténtalo de nuevo.","BBDD Error",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Completa todos los datos y verifica que sean válidos","Input Error",JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Valor de atributo incorrecto, vuelve a intentarlo.","Input Error",JOptionPane.ERROR_MESSAGE);
				}
				refreshProfileListTable(admin);
			}
		});
		horizontalBox.add(editProfileBtn);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		tableModel = new DefaultTableModel() {
			@Override
			 public boolean isCellEditable(int row, int column) {
			       return false;
			 }
		};		
		profileList = admin.getProfileList();
		Person p = null;
		try {
			p = profileList.get(0);
		} catch(NullPointerException err) {
			System.out.println(err.getMessage());
		}
		tableModel.addColumn(0, new Object[]{});
		while(profileList.size() > 0) {
			tableModel.insertRow(0, new Object[]{p.toString()});
			profileList.remove(0);
			try {
				p = profileList.get(0);
			} catch(IndexOutOfBoundsException err) {break;}
		}
		
		JLabel profileTableLabel = new JLabel("Perfiles de la Base de Datos");
		horizontalBox_1.add(profileTableLabel);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		table = new JTable(tableModel);
		horizontalBox_2.add(table);
	}
	
	public String requestData(String data) {
		return JOptionPane.showInputDialog("Especifique "+data+" del perfil a modificar:");
	}
	public void refreshProfileListTable(Admin admin) {
		profileList = admin.getProfileList();
		Person p = null;
		try {
			p = profileList.get(0);
		} catch(NullPointerException err) {
			System.out.println(err.getMessage());
		}
		tableModel.setRowCount(0);
		while(profileList.size() > 0) {
			tableModel.insertRow(0, new Object[]{p.toString()});
			profileList.remove(0);
			try {
				p = profileList.get(0);
			} catch(IndexOutOfBoundsException err) {break;}
		}
		tableModel.fireTableDataChanged();
	}
}
