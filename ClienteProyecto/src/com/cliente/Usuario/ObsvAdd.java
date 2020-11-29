package com.cliente.Usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import com.cliente.ClienteProyecto;
import com.entities.Fenomeno;
import com.entities.Imagenes;
import com.entities.Localidad;
import com.entities.Usuario;
import com.exception.ServiciosException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.cliente.Coor;

@SuppressWarnings("serial")
public class ObsvAdd extends JDialog {

	private JDialog frame;
	private JLabel lblImge;
	private ClienteProyecto cp = new ClienteProyecto();
	private String camino = "";
	private String formato ="";
	private Localidad loca = new Localidad();
	private Fenomeno feno = new Fenomeno();
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDesc;
	private JTextField txtGeo;
	private JTextField txtEnlace;
	private JComboBox cbxFen = new JComboBox();
	private JComboBox cbxLoc = new JComboBox();
	private Coor cr = new Coor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ObsvAdd dialog = new ObsvAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ObsvAdd() {
		setTitle("Agregar una Observacion");
		setBounds(100, 100, 540, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Descripci\u00F3n");
			lblNewLabel.setBounds(10, 18, 97, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Geolocalizaci\u00F3n");
			lblNewLabel_1.setBounds(10, 43, 97, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtDesc = new JTextField();
			txtDesc.setBounds(119, 18, 184, 20);
			contentPanel.add(txtDesc);
			txtDesc.setColumns(10);
		}
		{
			txtGeo = new JTextField();
			txtGeo.setBounds(119, 43, 184, 20);
			contentPanel.add(txtGeo);
			txtGeo.setColumns(10);
		}
		{
			JLabel lblFenmeno = new JLabel("Fen\u00F3meno");
			lblFenmeno.setBounds(10, 79, 63, 14);
			contentPanel.add(lblFenmeno);
		}
		{
			JLabel lblLocalidad = new JLabel("Localidad");
			lblLocalidad.setBounds(10, 122, 63, 14);
			contentPanel.add(lblLocalidad);
		}
		{
			JLabel lblImagen = new JLabel("Imagen");
			lblImagen.setBounds(10, 173, 46, 14);
			contentPanel.add(lblImagen);
		}

		{
			JButton btnSave = new JButton("Guardar");
			btnSave.setBounds(119, 509, 89, 23);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					List<double[]> a = cr.Coordi_Maker(txtGeo.getText());
					if(cr.Check(a.get(0), a.get(1))) {
						byte[] img = null;
						//Paso la imagen a byte
						try {
							img = img(camino,formato);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						//inserto la observacion
						/*try {
							cp.AddObs(txtDesc.getText(), txtGeo.getText(), cbxFen.getSelectedIndex()+1, cbxLoc.getSelectedIndex()+1, 1,img);
		
						} catch (ServiciosException e1) {
							System.out.println("no se pudo crear la obsv");
							e1.printStackTrace();
						}*/
						
					} else {
						System.out.println("Las coordenadas son incorrectas");
					}
					
				}
			});
			contentPanel.add(btnSave);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(119, 199, 359, 298);
			contentPanel.add(scrollPane);
			
			lblImge = new JLabel("");
			scrollPane.setViewportView(lblImge);
			lblImge.setIcon(new ImageIcon("C:\\Users\\fabia\\Desktop\\a.jpg"));
		}
		
		txtEnlace = new JTextField();
		txtEnlace.setBounds(119, 167, 227, 20);
		txtEnlace.setEditable(false);
		txtEnlace.setText("");
		contentPanel.add(txtEnlace);
		txtEnlace.setColumns(10);
		cbxFen.setMaximumRowCount(4);
		
		
		cbxFen.setBounds(119, 76, 184, 25);
		contentPanel.add(cbxFen);
		
		
		cbxLoc.setBounds(119, 117, 184, 25);
		contentPanel.add(cbxLoc);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Selecciona una imagen");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG y JPG", "png", "jpg");
				jfc.addChoosableFileFilter(filter);

				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					setCamino(jfc.getSelectedFile().getPath());
					setFormato(getExtencion(camino));
					txtEnlace.setText(camino);
					lblImge.setIcon(new ImageIcon(camino));
					System.out.println(formato);
				}
				
				
			}
		});
		button.setBounds(358, 161, 120, 26);
		contentPanel.add(button);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpLoc();
				UpFen();
				System.out.println("Se actualizo correctamente");
			}
		});
		btnActualizar.setBounds(315, 73, 98, 26);
		contentPanel.add(btnActualizar);
		
		JButton btnGuardarImagenEn = new JButton("Guardar imagen en Bd");
		btnGuardarImagenEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Inserto  la imagen en la BD
				byte[] img = null;
				try {
					img = img(camino,formato);
				} catch (IOException e2) {
					System.out.println("fallo a pasar la imagen a byte");
				}
				try {
					cp.AddImg(img,formato);
				} catch (ServiciosException e1) {
					System.out.println("No se pudo dar de alta la imagen");
				}
				
			}
		});
		btnGuardarImagenEn.setBounds(220, 507, 168, 26);
		contentPanel.add(btnGuardarImagenEn);
		}
		//final de observaciones
		public byte[] img(String dir,String form) throws IOException {
			BufferedImage bImage = ImageIO.read(new File(dir));
		      ByteArrayOutputStream bos = new ByteArrayOutputStream();
		      ImageIO.write(bImage, form, bos );
		      byte [] data = bos.toByteArray();
		      return data;
		}
		
		public void ByteToImg(byte[] imageInByte,String form) throws IOException {
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			File a = new File("boy.png").createTempFile("abc", ".png");
			ImageIO.write(bImageFromConvert, form, a);
			System.out.println(a.getAbsolutePath());
		}
		
		
		
		public void UpFen() {
			List<Fenomeno> fenl = null;
			try {
				fenl = cp.FGet();
			} catch (ServiciosException e) {
				e.printStackTrace();
			}
			for(int i = 0; i < fenl.size(); i ++ ) {
				cbxFen.addItem(fenl.get(i).getNombre());
				
			}
			
			
		}
		
		private void UpLoc() {
			List<Localidad> locL = null;
			try {
				locL = cp.Getloc();
			} catch (ServiciosException e) {
				e.printStackTrace();
			}
			for(int i = 0; i < locL.size(); i ++ ) {
				cbxLoc.addItem(locL.get(i).getNombre());
				
			}
			
			
	}
		
		private String getExtencion(String a) {
			String extension = "";

			int i = a.lastIndexOf('.');
			if (i > 0) {
			    extension = a.substring(i+1);
			}
			return extension;

		}

		public Localidad getLoca() {
			return loca;
		}

		public void setLoca(Localidad loca) {
			this.loca = loca;
		}

		public Fenomeno getFeno() {
			return feno;
		}

		public void setFeno(Fenomeno feno) {
			this.feno = feno;
		}

		public String getCamino() {
			return camino;
		}

		public void setCamino(String path) {
			this.camino = path;
		}

		public String getFormato() {
			return formato;
		}

		public void setFormato(String formato) {
			this.formato = formato;
		}
}
