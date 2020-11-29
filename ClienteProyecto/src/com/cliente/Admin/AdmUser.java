package com.cliente.Admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.entities.Usuario;
import com.exception.ServiciosException;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import javax.swing.JPasswordField;

@SuppressWarnings({ "unused", "serial" ,"rawtypes","unchecked"})
public class AdmUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textID;
	private JTable Usuarios;
	private ClienteProyecto cp = new ClienteProyecto();
	private JTextField textUsuario;
	private JComboBox cbxPermiso = new JComboBox();
	private JPasswordField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdmUser dialog = new AdmUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdmUser() {
		setTitle("Manejo de Usuarios");
		setType(Type.UTILITY);
		
		setBounds(100, 100, 609, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Nombre");
			label.setBounds(10, 40, 48, 14);
			contentPanel.add(label);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(100, 40, 222, 20);
			textNombre.setColumns(10);
			contentPanel.add(textNombre);
		}
		{
			JLabel label = new JLabel("Apellido");
			label.setBounds(10, 68, 48, 14);
			contentPanel.add(label);
		}
		{
			textApellido = new JTextField();
			textApellido.setBounds(100, 68, 222, 20);
			textApellido.setColumns(10);
			contentPanel.add(textApellido);
		}
		{
			JLabel label = new JLabel("Email");
			label.setBounds(10, 116, 48, 14);
			contentPanel.add(label);
		}
		{
			textEmail = new JTextField();
			textEmail.setBounds(100, 116, 222, 20);
			textEmail.setColumns(10);
			contentPanel.add(textEmail);
		}
		{
			JLabel label = new JLabel("Contrase\u00F1a");
			label.setBounds(10, 144, 80, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Permiso");
			label.setBounds(10, 175, 48, 14);
			contentPanel.add(label);
		}
		{
			JButton btnAdd = new JButton("Agregar");
			btnAdd.setToolTipText("Agrega un usuario con los datos ingresados");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ps= new String(textPass.getPassword());
					int i = op("Quieres agregar este usuario?");
					switch(i) {
					case 1:
						try {
							cp.UAdd(textNombre.getText(), textApellido.getText(), textEmail.getText(), textUsuario.getText(), ps, pertoint(cbxPermiso.getSelectedItem().toString()));
							JOptionPane.showMessageDialog(null, "Se añadio el usuario");
						} catch (ServiciosException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "No se añadio el usuario");
						break;
					}
					
				}	
			});
			btnAdd.setBounds(340, 11, 98, 26);
			contentPanel.add(btnAdd);
		}
		{
			JButton btnDel = new JButton("Borrar");
			btnDel.setToolTipText("Borra un usuario.\r\nClick en la columna del usuario que quieras borrar");
			btnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int p  = ToINT(textID.getText());
					int op = op("Seguro que quieres Borrar este usuario?");
					switch(op) {
					case 1:
						try {
							cp.UDel(p);
							JOptionPane.showMessageDialog(null, "Se borro el usuario");
						} catch (ServiciosException e1) {
							JOptionPane.showMessageDialog(null, "A ocurrido un error :" + e1);
						}
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "No se borro el usuario");
						break;
					}
										
				}
			});
			btnDel.setBounds(340, 49, 98, 26);
			contentPanel.add(btnDel);
		}
		{
			JLabel label = new JLabel("ID");
			label.setBounds(10, 11, 48, 14);
			contentPanel.add(label);
		}
		{
			textID = new JTextField();
			textID.setBounds(100, 11, 222, 20);
			textID.setEditable(false);
			textID.setColumns(10);
			contentPanel.add(textID);
		}
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(12, 212, 98, 23);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				List<Usuario> userL  =	cp.Uget();
				addtolist(userL);
			} catch (ServiciosException e1) {
				e1.printStackTrace();
			}
			}

		});
		contentPanel.add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 581, 154);
		contentPanel.add(scrollPane);
		
		Usuarios = new JTable();
		Usuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = Usuarios.getSelectedRow();
				int f;
				textID.setText(Usuarios.getValueAt(i, 0).toString());
				textNombre.setText(Usuarios.getValueAt(i, 1).toString());
				textApellido.setText(Usuarios.getValueAt(i, 2).toString());
				textEmail.setText(Usuarios.getValueAt(i, 3).toString());
				textUsuario.setText(Usuarios.getValueAt(i, 4).toString());
				textPass.setText(Usuarios.getValueAt(i, 5).toString());
				cbxPermiso.setSelectedIndex( f = Integer.parseInt(Usuarios.getValueAt(i, 6).toString()) -1);
				cbxPermiso.updateUI();
			}
		});
		Usuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(Usuarios);
		Usuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Apellido", "Email", "Usuario", "Contrase\u00F1a", "Permiso"
			}
		));
		{
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(10, 93, 48, 14);
			contentPanel.add(lblUsuario);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setColumns(10);
			textUsuario.setBounds(100, 93, 222, 20);
			contentPanel.add(textUsuario);
		}
		{
			cbxPermiso.setToolTipText("few");
			cbxPermiso.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Experto", "Usuario"}));
			cbxPermiso.setMaximumRowCount(3);
			cbxPermiso.setBounds(100, 175, 222, 22);
			contentPanel.add(cbxPermiso);
		}
		{
			JLabel lblIDD = new JLabel("");
			lblIDD.setBounds(340, 143, 55, 16);
			contentPanel.add(lblIDD);
		}
		{
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setToolTipText("Modifica el Permiso de un usuario\r\nClick en el usuario que quieres modificar el permiso");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = Integer.parseInt(textID.getText()); 
					int per = pertoint(cbxPermiso.getSelectedItem().toString());
					int op = op("Seguro que quieres Modificar el permiso del usuario");
					switch(op) {
					case 1:
						try {
							cp.Umod(id,per);
							JOptionPane.showMessageDialog(null, "Se modifico el usuario");
						} catch (ServiciosException e1) {
							e1.printStackTrace();
						}
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "No se modifico el usuario");
						break;
					}
					
				}
			});
			btnModificar.setBounds(340, 88, 98, 26);
			contentPanel.add(btnModificar);
		}
		{
			JButton btnNewButton = new JButton("Salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(10, 411, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			textPass = new JPasswordField();
			textPass.setBounds(100, 141, 222, 20);
			contentPanel.add(textPass);
		}
	}

	private String pertostring(int perm) {
		String per ="";
		switch(perm){
			case 1:
				per ="Administrador";
				break;
			case 2:
				per ="Experto";
				break;
			case 3:
				per ="Voluntario";
				break;
		}
		return per;
	}
	

	private int pertoint(String i) {
		int per = 0;
		switch(i) {
		case "Administrador":
			per=1;
			break;
		case "Experto":
			per=2;
			break;
		case "Voluntario":
		    per= 3;
		    break;
		}
		
		return per;
	}
	private void addtolist(List<Usuario> userL) {
		String tab [][] = new String [userL.size()][7];
		for(int i=0;i<userL.size();i++) {
			tab[i][0] = ""+userL.get(i).getIdUsuario();
			tab[i][1] = ""+userL.get(i).getNombre();
			tab[i][2] = ""+userL.get(i).getApellido();
			tab[i][3] = ""+userL.get(i).getEmail();
			tab[i][4] = ""+userL.get(i).getUsuario();
			tab[i][5] = ""+userL.get(i).getContraseña();
			tab[i][6] = ""+pertostring(userL.get(i).getPermiso());
		}
		Usuarios.setModel(new DefaultTableModel(
				tab,
				new String[] {
					"ID", "Nombre", "Apellido", "Email", "Usuario", "Contrase\u00F1a", "Permiso"
				}
			));
		
	}
	public int ToINT(String a) {
		int b = Integer.parseInt(a);
		return b;
	}
	
	public int op(String msg) {
		JDialog.setDefaultLookAndFeelDecorated(true);
	    int response = JOptionPane.showConfirmDialog(null, msg, "Confirmar",
	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    int rep = 0;
	    if (response == JOptionPane.NO_OPTION) {
	      rep = 0;
	    } else if (response == JOptionPane.YES_OPTION) {
	    	rep = 1;
	    } else if (response == JOptionPane.CLOSED_OPTION) {
	    	rep = 0;
	    }
		return rep;
	}
}
