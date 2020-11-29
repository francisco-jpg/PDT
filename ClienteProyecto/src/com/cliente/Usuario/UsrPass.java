package com.cliente.Usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.ClienteProyecto;
import com.exception.ServiciosException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UsrPass extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCambiar;
	private JButton btnCancelar;
	private long id;
	private String pass;
	private ClienteProyecto cp = new ClienteProyecto();
	private JPasswordField pfPa;
	private JPasswordField pfPn;
	private JPasswordField pfPr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UsrPass dialog = new UsrPass();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UsrPass() {
		setTitle("Cambiar Contrase\u00F1a");
		setBounds(100, 100, 286, 214);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblContrseaActual = new JLabel("Contrse\u00F1a Actual");
		lblContrseaActual.setBounds(31, 10, 111, 20);
		contentPanel.add(lblContrseaActual);
		
		JLabel label = new JLabel("Nueva Contrase\u00F1a");
		label.setBounds(31, 41, 111, 20);
		contentPanel.add(label);
		
		JLabel lblRepitaContrasea = new JLabel("Repita Contrase\u00F1a");
		lblRepitaContrasea.setBounds(31, 72, 111, 20);
		contentPanel.add(lblRepitaContrasea);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pA = new String(pfPa.getPassword());
				String pN = new String(pfPn.getPassword());
				String pR = new String(pfPr.getPassword());
				String Ap = pass;
				System.out.println(pass);
				System.out.println(pA);
				System.out.println(pN);
				System.out.println(pR);
				if(pA.equals(Ap) && pN.equals(pR)) {
					int i = op("Seguro que quieres Cambiar tu contraseña");
					switch(i) {
					case 1:
						try {
							cp.ModMyUsr(id, pN);
						} catch (ServiciosException e1) {
							JOptionPane.showMessageDialog(null, "A ocurrido un error :"+e1.getMessage());
						}
						JOptionPane.showMessageDialog(null, "Se Cambio su contraseña");
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "No se Cambio su contraseña");
						break;
					}
				}
				else  {
					JOptionPane.showMessageDialog(null, "Las Contraseña ingresada no coincide");
				}
					
			}
		});
		btnCambiar.setBounds(31, 131, 89, 23);
		contentPanel.add(btnCambiar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(167, 131, 89, 23);
		contentPanel.add(btnCancelar);
		
		pfPa = new JPasswordField();
		pfPa.setBounds(160, 10, 96, 20);
		contentPanel.add(pfPa);
		
		pfPn = new JPasswordField();
		pfPn.setBounds(160, 41, 96, 20);
		contentPanel.add(pfPn);
		
		pfPr = new JPasswordField();
		pfPr.setBounds(160, 72, 96, 20);
		contentPanel.add(pfPr);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
