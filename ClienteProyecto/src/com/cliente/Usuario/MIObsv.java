package com.cliente.Usuario;

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
import javax.swing.JRadioButton;

public class MIObsv extends JDialog {
	private JTable Observaciones;
	private JComboBox CBXFen = new JComboBox();
	private ClienteProyecto cp = new ClienteProyecto();
	private JTextField textField;
	private Usuario usr = new Usuario();

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MIObsv dialog = new MIObsv();
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
	public MIObsv() {
		setTitle("Mis Observaciones");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 703);
		getContentPane().setLayout(null);
		
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
					List<Observacion> obsL = cp.GetObs((int) usr.getIdUsuario());
					addtolist(obsL);
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnActualizar_1.setBounds(101, 158, 98, 26);
		getContentPane().add(btnActualizar_1);
		

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
		
		JLabel lblNewLabel_1 = new JLabel("Buscar mis observaciones");
		lblNewLabel_1.setBounds(10, 23, 152, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					addtolist(cp.GetObs((int) usr.getIdUsuario()));
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(12, 48, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Filtrar");
		lblNewLabel_2.setBounds(12, 82, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setBounds(12, 107, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setBounds(12, 136, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(76, 104, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		

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
