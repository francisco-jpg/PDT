package com.cliente.Expert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.img;
import com.cliente.Usuario.UsrMod;
import com.entities.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Experto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
					Experto frame = new Experto();
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
	public Experto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mi cuenta");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem menuItem = new JMenuItem("Modificar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpMod usrmod = new ExpMod();
				/*usrmod.setId(usr.getIdUsuario());
				usrmod.setTxtName(usr.getNombre());
				usrmod.setTxtApellido(usr.getApellido());
				usrmod.setTxtEmail(usr.getEmail());*/
				usrmod.setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Cambiar contrase\u00F1a");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExpPass usrmod = new ExpPass();
				
				usrmod.setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_1);
		mnNewMenu.add(mntmSalir);
		
		JMenu mnNewMenu_2 = new JMenu("Revision");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmObservaciones = new JMenuItem("Observaciones");
		mntmObservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpObservacion expobs = new ExpObservacion();
				img img = new img();
				img.setVisible(true);
				
				expobs.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmObservaciones);
		
		JMenu mnNewMenu_1 = new JMenu("Mis Observaciones");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ExpObs expobs = new ExpObs();
				
				expobs.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmCrear);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnNewMenu_1.add(mntmModificar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
