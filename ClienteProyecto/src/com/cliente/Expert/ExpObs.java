package com.cliente.Expert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ExpObs extends JFrame {

	private JPanel contentPane;
	private JTextField textDescripcion;
	private JTextField textGeolocalizacion;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpObs frame = new ExpObs();
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
	public ExpObs() {
		setTitle("Crear Observacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Descripcion = new JLabel("Descripcion");
		Descripcion.setBounds(33, 36, 71, 14);
		contentPane.add(Descripcion);
		
		JLabel Geolocalizacion = new JLabel("Geolocalizacion");
		Geolocalizacion.setBounds(33, 73, 89, 14);
		contentPane.add(Geolocalizacion);
		
		JLabel lblNewLabel_2 = new JLabel("Fenomeno");
		lblNewLabel_2.setBounds(33, 108, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Localidad");
		lblNewLabel.setBounds(33, 145, 58, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Imagen");
		lblNewLabel_1.setBounds(33, 182, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(132, 33, 184, 20);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textGeolocalizacion = new JTextField();
		textGeolocalizacion.setBounds(132, 70, 184, 20);
		contentPane.add(textGeolocalizacion);
		textGeolocalizacion.setColumns(10);
		
		JComboBox cbxFen = new JComboBox();
		cbxFen.setMaximumRowCount(4);
		cbxFen.setBounds(132, 105, 184, 25);
		contentPane.add(cbxFen);
		
		JComboBox cbxLoc = new JComboBox();
		cbxLoc.setBounds(132, 142, 184, 25);
		contentPane.add(cbxLoc);
		
		textField = new JTextField();
		textField.setText("");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(132, 189, 227, 20);
		contentPane.add(textField);
		
		JLabel lblImge = new JLabel("");
		lblImge.setBounds(132, 220, 357, 296);
		contentPane.add(lblImge);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(364, 69, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(400, 188, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.setBounds(132, 584, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnGuardarImagenEn = new JButton("Guardar imagen en Bd");
		btnGuardarImagenEn.setBounds(289, 584, 168, 26);
		contentPane.add(btnGuardarImagenEn);
	}
}
