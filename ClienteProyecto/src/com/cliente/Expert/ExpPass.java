package com.cliente.Expert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ExpPass extends JFrame {

	private JPanel contentPane;
	private JTextField textContrasenaAnterior;
	private JTextField textNuevaContrasena;
	private JTextField textRepitaContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpPass frame = new ExpPass();
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
	public ExpPass() {
		setTitle("Modificar Contrase\u00F1a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a Anterior");
		lblNewLabel.setBounds(43, 53, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nueva Contrase\u00F1a");
		lblNewLabel_1.setBounds(43, 98, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Repita Contrase\u00F1a");
		lblNewLabel_2.setBounds(43, 148, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		textContrasenaAnterior = new JTextField();
		textContrasenaAnterior.setBounds(170, 50, 192, 20);
		contentPane.add(textContrasenaAnterior);
		textContrasenaAnterior.setColumns(10);
		
		textNuevaContrasena = new JTextField();
		textNuevaContrasena.setBounds(170, 95, 192, 20);
		contentPane.add(textNuevaContrasena);
		textNuevaContrasena.setColumns(10);
		
		textRepitaContrasena = new JTextField();
		textRepitaContrasena.setBounds(170, 145, 192, 20);
		contentPane.add(textRepitaContrasena);
		textRepitaContrasena.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(71, 207, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(238, 207, 89, 23);
		contentPane.add(btnCancelar);
	}

}
