package com.cliente.Expert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ExpMod extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpMod frame = new ExpMod();
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
	public ExpMod() {
		setTitle("Modificar Cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(36, 54, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(36, 104, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E Mail");
		lblNewLabel_2.setBounds(36, 158, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(92, 51, 161, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(92, 101, 161, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(92, 155, 161, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(63, 210, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(162, 210, 89, 23);
		contentPane.add(btnCancelar);
	}
}
