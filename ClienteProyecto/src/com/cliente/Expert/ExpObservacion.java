package com.cliente.Expert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ExpObservacion extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textEstado;
	private JTextField textGeolocalizacion;
	private JTextField textFecha;
	private JTextField textFenomeno;
	private JTextField textLocalidad;
	private JTextField textUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpObservacion frame = new ExpObservacion();
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
	public ExpObservacion() {
		setTitle("Revisar Observacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estado");
		lblNewLabel_1.setBounds(10, 68, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha");
		lblNewLabel_2.setBounds(10, 103, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Fenomeno");
		lblNewLabel_3.setBounds(10, 143, 75, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID Localidad");
		lblNewLabel_4.setBounds(10, 185, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID Usuario");
		lblNewLabel_5.setBounds(10, 231, 75, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Geolocalizacion");
		lblNewLabel_6.setBounds(10, 274, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Descripcion");
		lblNewLabel_7.setBounds(10, 317, 75, 14);
		contentPane.add(lblNewLabel_7);
		
		TextField textFDescripcion = new TextField();
		textFDescripcion.setBounds(86, 317, 378, 112);
		contentPane.add(textFDescripcion);
		
		textID = new JTextField();
		textID.setBounds(96, 28, 152, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(96, 65, 152, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		textGeolocalizacion = new JTextField();
		textGeolocalizacion.setBounds(95, 271, 369, 20);
		contentPane.add(textGeolocalizacion);
		textGeolocalizacion.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(96, 100, 152, 20);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		textFenomeno = new JTextField();
		textFenomeno.setBounds(95, 140, 153, 20);
		contentPane.add(textFenomeno);
		textFenomeno.setColumns(10);
		
		textLocalidad = new JTextField();
		textLocalidad.setBounds(96, 182, 152, 20);
		contentPane.add(textLocalidad);
		textLocalidad.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(95, 228, 153, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(296, 27, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(296, 64, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(296, 99, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(86, 442, 89, 23);
		contentPane.add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 486, 455, 199);
		contentPane.add(scrollPane);
	}
}
