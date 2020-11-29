package com.cliente.Admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.entities.Fenomeno;
import com.exception.ServiciosException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class AdmFen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2196698915948842347L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textTelef;
	private JTable Fenomenos;
	private ClienteProyecto cp = new ClienteProyecto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdmFen dialog = new AdmFen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdmFen() {
		setTitle("Manejo de Fenomenos");
		setBounds(100, 100, 562, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 116, 14);
		contentPanel.add(lblId);
		
		textID = new JTextField();
		textID.setBounds(154, 11, 96, 20);
		textID.setEditable(false);
		contentPanel.add(textID);
		textID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 39, 116, 14);
		contentPanel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(154, 39, 96, 20);
		textNombre.setColumns(10);
		contentPanel.add(textNombre);
		
		JLabel lblDes = new JLabel("Descripcion");
		lblDes.setBounds(10, 67, 116, 14);
		contentPanel.add(lblDes);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(154, 67, 96, 20);
		textDescripcion.setColumns(10);
		contentPanel.add(textDescripcion);
		
		JLabel lblTelef = new JLabel("Telef. de Emergencia");
		lblTelef.setBounds(10, 95, 134, 14);
		contentPanel.add(lblTelef);
		
		textTelef = new JTextField();
		textTelef.setBounds(154, 95, 96, 20);
		textTelef.setColumns(10);
		contentPanel.add(textTelef);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Fenomeno> userL = cp.FGet();
					addtolist(userL);
					System.out.println("Se actualizo la lista");
					System.out.println(""+userL.get(0).getNombre());
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n "+e1.getMessage());
				}
			}
		});
		btnActualizar.setBounds(20, 140, 116, 23);
		contentPanel.add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 175, 524, 157);
		contentPanel.add(scrollPane);
		
		Fenomenos = new JTable();
		Fenomenos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = Fenomenos.getSelectedRow();
				textID.setText( Fenomenos.getValueAt(i, 0).toString() );
				textNombre.setText( Fenomenos.getValueAt(i, 1).toString() );
				textDescripcion.setText( Fenomenos.getValueAt(i, 2).toString() );
				textTelef.setText( Fenomenos.getValueAt(i, 3).toString() );
			}
		});
		Fenomenos.setFillsViewportHeight(true);
		Fenomenos.setModel(new DefaultTableModel(
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
				"ID", "Nombre", "Descripcion", "Teléf. de emergencia"
			}
		));
		scrollPane.setViewportView(Fenomenos);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.FDel(Integer.parseInt(textID.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro eliminado con exito!");
				} catch (NumberFormatException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}

			}
		});
		btnBorrar.setBounds(262, 89, 98, 26);
		contentPanel.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cp.FMod(Integer.parseInt(textID.getText()), textNombre.getText(), textDescripcion.getText(), Integer.parseInt(textTelef.getText()));
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro actualizado con exito!");
				} catch (ServiciosException e1) {
					System.out.println("A ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		btnModificar.setBounds(260, 49, 98, 26);
		contentPanel.add(btnModificar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a =0;
					a=Integer.parseInt(textTelef.getText());
					System.out.println(a);
					cp.FAdd(textNombre.getText(), textDescripcion.getText(),a);
					tableList();
					JOptionPane.showMessageDialog(null, "Regsitro ingresado con exito!");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "A Ocurrido un error :/r/n"+e1.getMessage());
				} catch (ServiciosException e1) {
					System.out.println("A Ocurrido un error :/r/n"+e1.getMessage());
				}
			}
		});
		btnAgregar.setBounds(260, 11, 98, 26);
		contentPanel.add(btnAgregar);
	}
	public void tableList() {
		try {
			List<Fenomeno> userL = cp.FGet();
			addtolist(userL);
			System.out.println("Se actualizo la lista");
			System.out.println(""+userL.get(0).getNombre());
		} catch (ServiciosException e1) {
			System.out.println("A ocurrido un error :/r/n "+e1.getMessage());
		}
	}
	
	private void addtolist(List<Fenomeno> userL) {
		String tab [][] = new String [userL.size()][4];
		for(int i=0;i < userL.size();i++) {
			tab[i][0] = ""+userL.get(i).getIdFenomeno();
			tab[i][1] = ""+userL.get(i).getNombre();
			tab[i][2] = ""+userL.get(i).getDescripcion();
			tab[i][3] = ""+userL.get(i).getTelefonoDeEmergencia();
			
		}
		Fenomenos.setModel(new DefaultTableModel(
				tab,
				new String[] {
						"ID", "Nombre", "Descripcion", "Teléf. de emergencia"
				}
			));
		
	}
}
