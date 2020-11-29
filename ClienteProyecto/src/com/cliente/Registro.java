package com.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.cliente.ClienteProyecto;
import com.exception.ServiciosException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Registro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 14, 48, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Apellido");
		label_1.setBounds(10, 42, 48, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("E-mail");
		label_2.setBounds(10, 70, 48, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Usuario");
		label_3.setBounds(10, 98, 48, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Contrase\u00F1a");
		label_4.setBounds(10, 126, 63, 14);
		contentPane.add(label_4);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(86, 11, 96, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(86, 39, 96, 20);
		contentPane.add(txtApellido);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(86, 67, 96, 20);
		contentPane.add(txtEmail);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(86, 95, 96, 20);
		contentPane.add(txtUsuario);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(86, 123, 96, 20);
		contentPane.add(txtContraseña);
		
		JButton button = new JButton("Registrarse");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ps = new String(txtContraseña.getPassword());
				ClienteProyecto cp = new ClienteProyecto();
					try {
						cp.UAdd(txtNombre.getText(), txtApellido.getText(), txtEmail.getText(), txtUsuario.getText(), ps, 1);
						JOptionPane.showMessageDialog(null, "Registro ingresado con exito");
						limpiarform();
					} catch (ServiciosException e1) {
						JOptionPane.showMessageDialog(null, "a ocurrido un error"+e1.getMessage());
					}
				
			}

			private void limpiarform() {
				txtNombre.setText("");
				txtApellido.setText("");
				txtEmail.setText("");
				txtUsuario.setText("");
				txtContraseña.setText("");
				
			}
		});
		button.setBounds(10, 181, 102, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(124, 181, 102, 23);
		contentPane.add(button_1);
	}

}
