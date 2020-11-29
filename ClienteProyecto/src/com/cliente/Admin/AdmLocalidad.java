package com.cliente.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.entities.Departamento;
import com.entities.Fenomeno;
import com.entities.Localidad;
import com.entities.Zona;
import com.exception.ServiciosException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdmLocalidad extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtGeo;
	private JTextField txtIDDep;
	private JTable table;
	private ClienteProyecto cp = new ClienteProyecto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmLocalidad frame = new AdmLocalidad();
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
	public AdmLocalidad() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 17, 116, 14);
		contentPane.add(lblId);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(144, 11, 96, 20);
		contentPane.add(txtID);
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 45, 116, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(144, 39, 96, 20);
		contentPane.add(txtNombre);
		
		JLabel lblGeo = new JLabel("Geolocalizaci\u00F3n");
		lblGeo.setBounds(20, 73, 116, 14);
		contentPane.add(lblGeo);
		
		txtGeo = new JTextField();
		txtGeo.setColumns(10);
		txtGeo.setBounds(144, 67, 96, 20);
		contentPane.add(txtGeo);
		
		JLabel lblIdDepartamento = new JLabel("ID Departamento");
		lblIdDepartamento.setBounds(20, 98, 134, 14);
		contentPane.add(lblIdDepartamento);
		
		JComboBox comboBox = new JComboBox();
		//COMBOBOX
		try {
			
			comboBox.setBounds(144, 98, 134, 14);
			//Busco listaa de zonas
			List<Departamento> userL = cp.DeptoGet();
			for (Departamento depto : userL) {
				comboBox.addItem(depto);
			}
			contentPane.add(comboBox);
		} catch (ServiciosException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 524, 205);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				int f;
				txtID.setText(table.getValueAt(i, 0).toString());
				txtNombre.setText(table.getValueAt(i, 1).toString());
				txtGeo.setText(table.getValueAt(i, 2).toString());
				
				
				comboBox.setSelectedIndex( f = Integer.parseInt(table.getValueAt(i, 3).toString()) -1);
				comboBox.updateUI();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Geolocalizacion","Departamento"
			}
		));
		scrollPane.setViewportView(table);
		/*txtIDDep = new JTextField();
		txtIDDep.setColumns(10);
		txtIDDep.setBounds(144, 95, 96, 20);
		contentPane.add(txtIDDep);*/
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					tableList();
					System.out.println("Se actualizo la lista localidades");
				
				
			}
		});
		btnActualizar.setBounds(350, 140, 116, 23);
		contentPane.add(btnActualizar);
		
		
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(350, 89, 98, 26);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.LocDel(Integer.parseInt(txtID.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro eliminado con exito!");
				} catch (NumberFormatException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}

			}
		});
		contentPane.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//cp.LocMod(Long.valueOf(txtID.getText()), txtNombre.getText(), txtGeo.getText(),((Departamento)comboBox.getSelectedItem()).getIdDepartamento());
					cp.LocMod(Long.valueOf(txtID.getText()), txtNombre.getText(), txtGeo.getText());
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro actualizado con exito!");
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		btnModificar.setBounds(350, 49, 98, 26);
		contentPane.add(btnModificar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a =0;
					
					cp.LocAdd(txtNombre.getText(), txtGeo.getText(), ((Departamento)comboBox.getSelectedItem()).getIdDepartamento());
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro ingresado con exito!");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "A Ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A Ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		btnAgregar.setBounds(350, 11, 98, 26);
		contentPane.add(btnAgregar);
	}
	
	public void tableList() {
		try {
			List<Localidad> userL = cp.Getloc();
			addtolist(userL);
			System.out.println("Se actualizo la lista");
			//System.out.println(""+userL.get(0).getNombre());
		} catch (ServiciosException e1) {
			System.out.println("A ocurrido un error :/r/n "+e1.getMessage());
		}
	}
	
	private void addtolist(List<Localidad> userL) {
		String tab [][] = new String [userL.size()][4];
		for(int i=0;i < userL.size();i++) {
			tab[i][0] = ""+userL.get(i).getIdLoc();
			tab[i][1] = ""+userL.get(i).getNombre();
			tab[i][2] = ""+userL.get(i).getGeolocalizacion();
			tab[i][3] = ""+userL.get(i).getDepartamento().getNombre();
		
			
		}
		
		table.setModel(new DefaultTableModel(
				tab,
				new String[] {
						"ID", "Nombre", "Geolocalizacion","Departamento"
				}
			));
		
}
}
