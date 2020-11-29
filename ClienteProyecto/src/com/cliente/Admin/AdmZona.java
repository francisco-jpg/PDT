package com.cliente.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.entities.Fenomeno;
import com.entities.Zona;
import com.exception.ServiciosException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class AdmZona extends JFrame {

	private JPanel contentPane;

	private JTextField txtIDZona;
	private JTextField txtNombre;
	private JTable Zonas;
	private ClienteProyecto cp = new ClienteProyecto();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmZona frame = new AdmZona();
					
					
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
	public AdmZona() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDZona = new JLabel("ID Zona");
		lblIDZona.setBounds(31, 47, 46, 14);
		contentPane.add(lblIDZona);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 91, 46, 14);
		contentPane.add(lblNombre);
		
		txtIDZona = new JTextField();
		txtIDZona.setBounds(131, 41, 110, 20);
		contentPane.add(txtIDZona);
		txtIDZona.setColumns(10);
		txtIDZona.setEditable(false);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(131, 85, 110, 20);
		contentPane.add(txtNombre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 175, 524, 157);
		contentPane.add(scrollPane);
		
		Zonas = new JTable();
		Zonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = Zonas.getSelectedRow();
				txtIDZona.setText( Zonas.getValueAt(i, 0).toString() );
				txtNombre.setText( Zonas.getValueAt(i, 1).toString() );
			
			}
		});
		Zonas.setFillsViewportHeight(true);
		Zonas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nombre"
			}
		));
		scrollPane.setViewportView(Zonas);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(271, 40, 98, 26);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//inserto la zona
				try {
					cp.AddZona(txtNombre.getText());
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro ingresado con exito!");
				} catch (ServiciosException e1) {
					System.out.println("no se pudo crear la obsv");
					e1.printStackTrace();
				}
			}
		});
		
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.ModZona(Integer.parseInt(txtIDZona.getText()), txtNombre.getText());
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro actualizado con exito!");
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		btnModificar.setBounds(271, 78, 98, 26);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.DelZona(Integer.parseInt(txtIDZona.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro eliminado con exito!");
				} catch (NumberFormatException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}

			}
		});
		
		btnBorrar.setBounds(273, 118, 98, 26);
		contentPane.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(31, 145, 116, 23);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					tableList();
				
				} catch (NumberFormatException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				} 
			}
		});
		contentPane.add(btnActualizar);
		
		/*ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 203, 414, 148);
		contentPane.add(scrollPane);*/
	}
	
	public void tableList() {
		try {
			List<Zona> userL = cp.GetZonas();
			addtolist(userL);
			System.out.println("Se actualizo la lista");
			System.out.println(""+userL.get(0).getNombre());
		} catch (ServiciosException e1) {
			System.out.println("A ocurrido un error :/r/n "+e1.getMessage());
		}
	}
	
	private void addtolist(List<Zona> userL) {
		String tab [][] = new String [userL.size()][4];
		for(int i=0;i < userL.size();i++) {
			tab[i][0] = ""+userL.get(i).getIdZona();
			tab[i][1] = ""+userL.get(i).getNombre();
		
			
		}
		Zonas.setModel(new DefaultTableModel(
				tab,
				new String[] {
						"ID", "Nombre"
				}
			));
		
	}
}
