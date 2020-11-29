package com.cliente.Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entities.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Voluntario extends JFrame {

	private JPanel contentPane;
	private Usuario usr = new Usuario();
	private String pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voluntario frame = new Voluntario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param usr 
	 */
	public Voluntario() {
		setTitle("Bienvenido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMyCuenta = new JMenu("Mi Cuenta");
		menuBar.add(mnMyCuenta);
		
		JMenuItem mntmDatosPersonale = new JMenuItem("Datos Personales");
		mntmDatosPersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrMod usrmod = new UsrMod();
				usrmod.setId(usr.getIdUsuario());
				usrmod.setTxtName(usr.getNombre());
				usrmod.setTxtApellido(usr.getApellido());
				usrmod.setTxtEmail(usr.getEmail());
				usrmod.setVisible(true);
			}
		});
		mnMyCuenta.add(mntmDatosPersonale);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrPass usrp= new UsrPass();
				usrp.setPass(pass);
				usrp.setId(usr.getIdUsuario());
				usrp.setVisible(true);
			}
		});
		mnMyCuenta.add(mntmCambiarContrasea);
		
		JMenuItem menuItem = new JMenuItem("Salir");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMyCuenta.add(menuItem);
		
		JMenu mnObservaciones = new JMenu("Observaciones");
		menuBar.add(mnObservaciones);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObsvAdd obs = new ObsvAdd();
				Usuario usr = new Usuario();
			}
		});
		mnObservaciones.add(mntmCrear);
		
		JMenuItem mntmVerModificar = new JMenuItem("Ver & Modificar");
		mnObservaciones.add(mntmVerModificar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
