package com.cliente.Admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.Usuario.*;
import com.entities.Usuario;

@SuppressWarnings("unused")
public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usr = new Usuario();
	private String pass;
	private JLabel lblNusr = new JLabel("Bienvenido");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mi Cuenta");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrMod usrmod = new UsrMod();
				usrmod.setId(usr.getIdUsuario());
				usrmod.setTxtName(usr.getNombre());
				usrmod.setTxtApellido(usr.getApellido());
				usrmod.setTxtEmail(usr.getEmail());
				usrmod.setVisible(true);
			}
		});
		mnNewMenu.add(mntmModificar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cambiar contrase\u00F1a");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrPass usrp= new UsrPass();
				usrp.setPass(pass);
				usrp.setId(usr.getIdUsuario());
				usrp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		mnNewMenu.add(mntmSalir);
		
		JMenu mnNewMenu_1 = new JMenu("Administracion");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntm_ad_user = new JMenuItem("Usuarios");
		mntm_ad_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmUser admu = new AdmUser();
				admu.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntm_ad_user);
		
		JMenuItem mntm_Add_obser = new JMenuItem("Observaci\u00F3n");
		mntm_Add_obser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			AdmObservacion admobs = new AdmObservacion();
			admobs.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntm_Add_obser);
		
		JMenuItem mntm_add_loc = new JMenuItem("Localidad");
		mntm_add_loc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AdmLocalidad admloc = new AdmLocalidad();
				admloc.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntm_add_loc);
		
		JMenuItem mntm_ad_zona = new JMenuItem("Zonas");
		mntm_ad_zona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdmZona admZon = new AdmZona();
			admZon.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntm_ad_zona);
		
		JMenuItem mntm_ad_dep = new JMenuItem("Departamentos");
		mntm_ad_dep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmDepartamento admdep = new AdmDepartamento();
				admdep.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntm_ad_dep);
		
		JMenuItem mntm_ad_fen = new JMenuItem("Fenomenos");
		mntm_ad_fen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdmFen admf = new AdmFen();
			admf.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntm_ad_fen);
		
		JMenu mnNewMenu_2 = new JMenu("Mis observaciones");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntm_add_obs = new JMenuItem("Crear Observaci\u00F3n");
		mntm_add_obs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ObsvAdd admosb = new ObsvAdd();
			admosb.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntm_add_obs);
		
		JMenuItem mntm_listar_obs = new JMenuItem("Listar mis Observaciones");
		mntm_listar_obs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ObsvList admoblist = new ObsvList();
			admoblist.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntm_listar_obs);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblBienvenido.setBounds(134, 11, 173, 50);
		contentPane.add(lblBienvenido);
		
		lblNusr.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		lblNusr.setBounds(134, 72, 173, 50);
		contentPane.add(lblNusr);
	}

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public String getLblNusr() {
		return this.lblNusr.getText();
	}

	public void setLblNusr(String lblNusr) {
		this.lblNusr.setText(lblNusr);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
	