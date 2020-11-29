package com.cliente.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.cliente.Utils;
import com.entities.Fenomeno;
import com.entities.Localidad;
import com.entities.Observacion;
import com.entities.Usuario;
import com.entities.Zona;
import com.exception.ServiciosException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

public class AdmObservacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtEstado;
	private JTextField txtDescripcion;
	private JTextField txtFecha;
	private JTextField txtGeo;
	private JTextField txtFenomeno;
	private JTextField txtLocalidad;
	private JTextField txtUsuario;
	private JTable table;
	private ClienteProyecto cp = new ClienteProyecto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdmObservacion dialog = new AdmObservacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AdmObservacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 17, 116, 14);
		contentPane.add(lblId);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(154, 11, 96, 20);
		contentPane.add(txtID);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 45, 116, 14);
		contentPane.add(lblEstado);
		
		/*txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(154, 39, 96, 20);
		contentPane.add(txtEstado);*/
		
		JLabel lblDes = new JLabel("Descripcion");
		lblDes.setBounds(10, 211, 116, 14);
		contentPane.add(lblDes);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(154, 67, 96, 20);
		contentPane.add(txtFecha);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 73, 134, 14);
		contentPane.add(lblFecha);
		
		txtGeo = new JTextField();
		txtGeo.setColumns(10);
		txtGeo.setBounds(154, 183, 377, 20);
		contentPane.add(txtGeo);
		
	
		/*private JTextField txtFenomeno;
		private JTextField txtLocalidad;
		private JTextField txtUsuario;*/
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					tableList();
				
			}
		});
		btnActualizar.setBounds(10, 300, 116, 23);
		contentPane.add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 334, 532, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//"ID", "Estado", "Descripcion", "Fecha","Geocalizacion","ID Fenomeno","ID Localidad","ID Usuario"
				int i = table.getSelectedRow();
				txtID.setText( table.getValueAt(i, 0).toString() );
				txtEstado.setText( table.getValueAt(i, 1).toString());
				txtDescripcion.setText(table.getValueAt(i, 2).toString());
				txtFecha.setText(table.getValueAt(i, 3).toString());
				txtGeo.setText(table.getValueAt(i, 4).toString());
				txtFenomeno.setText(table.getValueAt(i, 5).toString());
				txtLocalidad.setText(table.getValueAt(i, 6).toString());
				txtUsuario.setText(table.getValueAt(i, 7).toString());
				
			}
		});
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
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
					"ID", "Estado", "Descripcion", "Fecha","Geocalizacion","ID Fenomeno","ID Localidad","ID Usuario"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(262, 89, 98, 26);
		contentPane.add(btnBorrar);
		
		
		
		JComboBox comboBoxEstado = new JComboBox();
		//COMBOBOX
		try {
			comboBoxEstado.setBounds(154, 39, 96, 20);
			 // using for-each loop for iteration over Map.entrySet() 
	        for (Entry<Integer, String> entry : Utils.getEstados().entrySet())  {
	           // System.out.println("Key = " + entry.getKey() + 
	             //                ", Value = " + entry.getValue()); 
	            comboBoxEstado.addItem(entry.getValue());
	    } 
			contentPane.add(comboBoxEstado);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(260, 49, 98, 26);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a =0;
					//long estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user
					//long id,long estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user
					cp.ModObs(1L,Long.valueOf(Utils.getEstadosin().get(comboBoxEstado.getSelectedItem()) ), txtDescripcion.getText(),
							new Date(txtFecha.getText()), txtGeo.getText(),Long.valueOf(txtFenomeno.getText()) ,Long.valueOf(txtLocalidad.getText()),Long.valueOf(txtUsuario.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro ingresado con exito!");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "A Ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A Ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		contentPane.add(btnModificar);
		
	
		
		JButton btnBuscar = new JButton("Buscar");
		/*btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a =0;
					//long estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user
					cp.AddObs(Long.valueOf(txtEstado.getText()), txtDescripcion.getText(),
							new Date(txtFecha.getText()), txtGeo.getText(),Long.valueOf(txtFenomeno.getText()) ,Long.valueOf(txtLocalidad.getText()),Long.valueOf(txtUsuario.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro ingresado con exito!");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "A Ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A Ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});*/
		btnBuscar.setBounds(260, 11, 98, 26);
		contentPane.add(btnBuscar);
		
		JLabel lblGeo = new JLabel("Geolocalizaci\u00F3n");
		lblGeo.setBounds(10, 186, 72, 14);
		contentPane.add(lblGeo);
		
		JLabel lblIDFen = new JLabel("ID Fen\u00F3meno");
		lblIDFen.setBounds(10, 106, 72, 14);
		JComboBox comboBoxFenomeno = new JComboBox();
		//COMBOBOX
		
		try {
			List<Fenomeno> fenomenoL = cp.FGet();
			comboBoxFenomeno.setBounds(154, 98, 96, 22);
			 // using for-each loop for iteration over Map.entrySet() 
			for (Fenomeno fenomeno : fenomenoL) {
				comboBoxFenomeno.addItem(fenomeno);
			}
			contentPane.add(comboBoxFenomeno);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contentPane.add(lblIDFen);
		
		/*TextField textField = new TextField();
		textField.setBounds(154, 98, 96, 22);
		contentPane.add(textField);*/
		
		JLabel lblIDLoc = new JLabel("ID Localidad");
		lblIDLoc.setBounds(10, 136, 72, 14);
		JComboBox comboBoxLocalidad = new JComboBox();
		//COMBOBOX
		
		try {
			List<Localidad> localidadL = cp.Getloc();
			comboBoxLocalidad.setBounds(154, 126, 96, 22);
			 // using for-each loop for iteration over Map.entrySet() 
			
			//comboBoxLocalidad.addItem(local);
			for (Localidad local : localidadL) {
				comboBoxLocalidad.addItem(local);
			}
			contentPane.add(comboBoxLocalidad);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contentPane.add(lblIDLoc);
		
//		TextField textField_1 = new TextField();
//		textField_1.setBounds(154, 126, 96, 22);
//		contentPane.add(textField_1);
		
		JLabel lblIDUser = new JLabel("ID Usuario");
		lblIDUser.setBounds(10, 161, 72, 14);
		JComboBox comboBoxUsuario = new JComboBox();
		//COMBOBOX
		
		try {
			List<Usuario> usuarioL = cp.Uget();
			comboBoxUsuario.setBounds(154, 153, 96, 22);
			 // using for-each loop for iteration over Map.entrySet() 
			for (Usuario user : usuarioL) {
				comboBoxUsuario.addItem(user);
			}
			contentPane.add(comboBoxUsuario);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contentPane.add(lblIDUser);
		
		/*TextField txtUsuario = new TextField();
		txtUsuario.setBounds(154, 153, 96, 22);
		contentPane.add(txtUsuario);*/
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(153, 211, 378, 112);
		contentPane.add(textField_2);
		
		tableList();
	}
	
	public void tableList() {
		try {
			List<Observacion> userL = cp.GetObs();
			addtolist(userL);
			System.out.println("Se actualizo la lista");
		
		} catch (ServiciosException e1) {
			System.out.println("A ocurrido un error :/r/n "+e1.getMessage());
		}
	}
	
	private void addtolist(List<Observacion> userL) {
		String tab [][] = new String [userL.size()][8];
		for(int i=0;i < userL.size();i++) {
			tab[i][0] = ""+userL.get(i).getIdObservacion();
			tab[i][1] = ""+userL.get(i).getEstado();
			tab[i][2] = ""+userL.get(i).getDescripcion();
			tab[i][3] = ""+userL.get(i).getFecha();
			tab[i][4] = ""+userL.get(i).getGeolocalizacion();
			tab[i][5] = ""+userL.get(i).getFenomeno().getNombre();
			tab[i][6] = ""+userL.get(i).getLocalidad().getNombre();
			tab[i][7] = ""+userL.get(i).getUsuario().getNombre()+" "+userL.get(i).getUsuario().getApellido();
			
		}
		table.setModel(new DefaultTableModel(
				tab,
				new String[] {
						"ID", "Estado", "Descripcion", "Fecha","Geocalizacion","ID Fenomeno","ID Localidad","ID Usuario"
				}
			));
		
	}
}
