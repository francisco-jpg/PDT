package com.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.cliente.ClienteProyecto;
import com.cliente.Admin.Admin;
import com.cliente.Expert.Experto;
import com.cliente.Usuario.Voluntario;
import com.entities.Usuario;
import com.exception.ServiciosException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings({ "unused", "serial" })
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private ClienteProyecto p = new ClienteProyecto();
	private static Login frame = new Login();
	private JPasswordField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(125, 83, 109, 20);
		contentPane.add(textUser);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(15, 86, 48, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(15, 117, 76, 14);
		contentPane.add(lblContrasea);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usr;
				String ps = new String(textPass.getPassword());
				try {
					usr = p.Log(textUser.getText(),ps);
					switch(usr.getPermiso()){
					case 1:
						Admin adm = new Admin();
						adm.setLblNusr(usr.getUsuario());
						adm.setUsr(usr);
						adm.setPass(ps);
						adm.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
						break;
				/*	case 2:
						Experto exp = new Experto();
						exp.setPass(ps);
						exp.setUsr(usr);
						exp.setVisible(true);
						frame.setVisible(false);
						break;*/
					case 3:
						Voluntario vol = new Voluntario();
						vol.setPass(ps);
						vol.setUsr(usr);
						vol.setVisible(true);
						frame.setVisible(false);
						break;
				}
				} catch (ServiciosException e1) {
					JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrecto");
				}
			}
		});
		btnLogIn.setBounds(15, 145, 89, 23);
		contentPane.add(btnLogIn);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro reg = new Registro();
				reg.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(132, 145, 102, 23);
		contentPane.add(btnRegistrarse);
		
		textPass = new JPasswordField();
		textPass.setBounds(125, 114, 109, 20);
		contentPane.add(textPass);
	}

}
