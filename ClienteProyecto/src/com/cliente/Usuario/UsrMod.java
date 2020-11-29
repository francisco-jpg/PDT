package com.cliente.Usuario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.entities.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsrMod extends JDialog {
	private JTextField txtName;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private long id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsrMod dialog = new UsrMod();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public UsrMod() {
		setTitle("Cambiar Datos");
		setBounds(100, 100, 233, 240);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 83, 25);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 47, 83, 25);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 83, 83, 25);
		getContentPane().add(lblEmail);
		
		txtName = new JTextField();
		txtName.setText("");
		txtName.setBounds(103, 13, 96, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("");
		txtApellido.setBounds(103, 49, 96, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setBounds(103, 85, 96, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGuardar.setBounds(10, 157, 89, 23);
		getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(110, 157, 89, 23);
		getContentPane().add(btnCancelar);

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(String Nombre) {
		this.txtName.setText(Nombre);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText( txtEmail);
	}

}
