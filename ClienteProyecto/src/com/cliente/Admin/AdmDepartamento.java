package com.cliente.Admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.cliente.Utils;
import com.entities.Departamento;
import com.entities.Fenomeno;
import com.entities.Zona;
import com.exception.ServiciosException;

@SuppressWarnings("serial")
public class AdmDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTable table;
	private ClienteProyecto cp = new ClienteProyecto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdmDepartamento dialog = new AdmDepartamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdmDepartamento() {
		
		setBounds(100, 100, 452, 415);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Departamento");
		lblNombre.setBounds(10, 39, 64, 14);
		contentPanel.add(lblNombre);
		
	/*	JComboBox comboBoxDpto = new JComboBox();
		//COMBOBOX
		try {
			comboBoxDpto.setBounds(84, 36, 153, 20);
			 // using for-each loop for iteration over Map.entrySet() 
	        for (Entry<Integer, String> entry : Utils.getDtptos().entrySet())  {
	           // System.out.println("Key = " + entry.getKey() + 
	             //                ", Value = " + entry.getValue()); 
	        	comboBoxDpto.addItem(entry.getValue());
	    } 
	        contentPanel.add(comboBoxDpto);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		
		JLabel lblZona = new JLabel("Zona");
		lblZona.setBounds(10, 68, 64, 14);
		contentPanel.add(lblZona);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(10, 11, 64, 14);
		contentPanel.add(lblID);
		
		txtId = new JTextField();
		txtId.setText("ID");
		txtId.setBounds(84, 8, 153, 20);
		contentPanel.add(txtId);
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("Depatamento");
		txtNombre.setBounds(84, 36, 153, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		//COMBOBOX
		try {
			
			comboBox.setBounds(84, 64, 153, 22);
			//Busco listaa de zonas
			List<Zona> userL = cp.GetZonas();
			for (Zona zona : userL) {
				comboBox.addItem(zona);
			}
			contentPanel.add(comboBox);
		} catch (ServiciosException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 422, 144);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtId.setText( table.getValueAt(i, 0).toString() );
//				textNombre.setText( table.getValueAt(i, 1).toString() );
//				textDescripcion.setText( table.getValueAt(i, 2).toString() );
//				textTelef.setText( table.getValueAt(i, 3).toString() );
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
				"ID", "Nombre", "Zona"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableList() ;
				System.out.println("Se actualizo la lista");
			}
		});
		btnActualizar.setBounds(10, 112, 89, 23);
		contentPanel.add(btnActualizar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a =0;
					
				//	System.out.println("add epartamnt->"+comboBoxDpto.getSelectedItem()+((Zona)comboBox.getSelectedItem()).getIdZona());
				//	cp.DeptoAdd( (Utils.getDtptosin().get(comboBoxDpto.getSelectedItem())),((Zona)comboBox.getSelectedItem()).getIdZona());
					cp.DeptoAdd( txtNombre.getText(),((Zona)comboBox.getSelectedItem()).getIdZona());
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro ingresado con exito!");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "A Ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A Ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		
		btnAgregar.setBounds(247, 5, 98, 26);
		contentPanel.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.DeptoDel(Long.valueOf(txtId.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro eliminado con exito!");
				} catch (NumberFormatException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}

			}
		});
		btnBorrar.setBounds(247, 76, 98, 26);
		contentPanel.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modificar");
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.DeptoMod(Integer.valueOf(txtId.getText()), txtNombre.getText());
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro actualizado con exito!");
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		btnModificar.setBounds(247, 39, 98, 26);
		contentPanel.add(btnModificar);
		
		
		
		
		
	}
	
	public void tableList() {
		try {
			List<Departamento> userL = cp.DeptoGet();
			addtolist(userL);
			System.out.println("Se actualizo la lista");
			System.out.println(""+userL.get(0).getNombre());
		} catch (ServiciosException e1) {
			System.out.println("A ocurrido un error :/r/n "+e1.getMessage());
		}
	}
	
	private void addtolist(List<Departamento> userL) {
		String tab [][] = new String [userL.size()][4];
		for(int i=0;i < userL.size();i++) {
			tab[i][0] = ""+userL.get(i).getIdDepartamento();
			tab[i][1] = ""+userL.get(i).getNombre();
			tab[i][2] = ""+userL.get(i).getZona().getNombre();
		
			
		}
		
		table.setModel(new DefaultTableModel(
				tab,
				new String[] {
						"ID", "Nombre", "Zona"
				}
			));
		
}
}