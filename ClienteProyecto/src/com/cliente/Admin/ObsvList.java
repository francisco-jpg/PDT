package com.cliente.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import com.entities.Fenomeno;
import com.entities.Observacion;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.cliente.ClienteProyecto;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;

public class ObsvList extends JDialog {
	private JTextField txtId;
	private JTextField txtFenom;
	private JTextField txtForm;
	private JTable Observaciones;
	private JTextField txtDesc;
	private JComboBox CBXFen = new JComboBox();
	private ClienteProyecto cp = new ClienteProyecto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObsvList dialog = new ObsvList();
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
	public ObsvList() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 703);
		getContentPane().setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("ID Usuario");
		lblIdUsuario.setBounds(10, 11, 75, 23);
		getContentPane().add(lblIdUsuario);
		
		txtId = new JTextField();
		txtId.setText("id");
		txtId.setBounds(95, 12, 104, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtFenom = new JTextField();
		txtFenom.setText("fenom");
		txtFenom.setBounds(95, 40, 104, 20);
		getContentPane().add(txtFenom);
		txtFenom.setColumns(10);
		
		JLabel lblFenomeno = new JLabel("Fenomeno");
		lblFenomeno.setBounds(10, 39, 75, 23);
		getContentPane().add(lblFenomeno);
		
		txtForm = new JTextField();
		txtForm.setText("form");
		txtForm.setColumns(10);
		txtForm.setBounds(95, 73, 104, 20);
		getContentPane().add(txtForm);
		
		JLabel lblFormato = new JLabel("Formato");
		lblFormato.setBounds(10, 72, 75, 23);
		getContentPane().add(lblFormato);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 369, 595, 297);
		getContentPane().add(scrollPane_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\fabia\\eclipse-workspace\\ClienteProyecto0.2\\resources\\a.jpg"));
		scrollPane_1.setViewportView(label);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_3 = new JButton("<");
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Actualizar");
		panel_1.add(button_4);
		
		JButton button_5 = new JButton(">");
		panel_1.add(button_5);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(211, 95, 98, 30);
		getContentPane().add(btnBorrar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 196, 595, 160);
		getContentPane().add(scrollPane_2);
		
		Observaciones = new JTable();
		scrollPane_2.setViewportView(Observaciones);
		Observaciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Descripcion", "Fecha", "Geolocalizacion", "ID_Fenomeno","ID_Localidad","ID_Usuario"
			}
		));
		Observaciones.setFillsViewportHeight(true);
		
		JPanel panel = new JPanel();
		scrollPane_2.setColumnHeaderView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("<");
		panel.add(button);
		
		JButton button_1 = new JButton("Actualizar");
		panel.add(button_1);
		
		JButton button_2 = new JButton(">");
		panel.add(button_2);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(12, 168, 91, 16);
		getContentPane().add(lblObservaciones);
		
		JButton btnActualizar_1 = new JButton("Actualizar");
		btnActualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Observacion> obsL = cp.GetObs();
					addtolist(obsL);
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnActualizar_1.setBounds(101, 158, 98, 26);
		getContentPane().add(btnActualizar_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(211, 53, 98, 30);
		getContentPane().add(btnModificar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(211, 11, 98, 30);
		getContentPane().add(btnCrear);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 107, 75, 16);
		getContentPane().add(lblDescripcion);
		
		txtDesc = new JTextField();
		txtDesc.setText("desc");
		txtDesc.setBounds(95, 105, 104, 20);
		getContentPane().add(txtDesc);
		txtDesc.setColumns(10);
		

		CBXFen.setModel(new DefaultComboBoxModel(new String[] {"REEEEEE", "RE", "REEEEEEEEEEEEEEEEE"}));
		CBXFen.setBounds(211, 160, 132, 23);
		getContentPane().add(CBXFen);
		
		JLabel lblNewLabel = new JLabel("Filtrar por Fenomeno");
		lblNewLabel.setBounds(221, 136, 132, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					List<Observacion> obsL;
				
						try {
							obsL = cp.Getfilt(CBXFen.getSelectedIndex()+1);
						} catch (ServiciosException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						
			}
		});
		btnFiltrar.setBounds(351, 160, 89, 23);
		getContentPane().add(btnFiltrar);
		
		JButton btnACTFEN = new JButton("Actualizar");
		btnACTFEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fillCBX();
				} catch (ServiciosException e1) {
					System.out.println("no se pudo llenar el combobox");
				}
			}
		});
		btnACTFEN.setBounds(351, 132, 89, 23);
		getContentPane().add(btnACTFEN);
		
		

	}
	
	//Intento Conseguir todos los Fenómenos y ponerlos en una Lista
	
	public List<Fenomeno> GetFen() throws ServiciosException  { 
		List<Fenomeno> ph = cp.FGet();
		System.out.println(ph.get(0).getNombre());
			return ph;
			
	}
	
	public void fillCBX() throws ServiciosException {
		List<Fenomeno> FL= GetFen();
		List<String> FenNam = new ArrayList() ;
		for(Fenomeno fen : FL) {
			FenNam.add(fen.getNombre());
		}
		String[] Fname = FenNam.toArray(new String[0]);
		CBXFen.setModel(new DefaultComboBoxModel(Fname));
	}
	
	private void addtolist(List<Observacion> obsL) {
		String tab [][] = new String [obsL.size()][7];
		for(int i=0;i<obsL.size();i++) {
			tab[i][0] = ""+obsL.get(i).getIdObservacion();
			tab[i][1] = ""+obsL.get(i).getDescripcion();
			tab[i][2] = ""+obsL.get(i).getFecha();
			tab[i][3] = ""+obsL.get(i).getGeolocalizacion();
			tab[i][4] = ""+obsL.get(i).getFenomeno().getIdFenomeno();
			tab[i][5] = ""+obsL.get(i).getLocalidad().getIdLoc();
			tab[i][6] = ""+obsL.get(i).getUsuario().getIdUsuario();
		}
		Observaciones.setModel(new DefaultTableModel(
				tab,
				new String[] {
						"ID", "Descripcion", "Fecha", "Geolocalizacion", "ID_Fenomeno","ID_Localidad","ID_Usuario"
					}
			));
		
	}
}
