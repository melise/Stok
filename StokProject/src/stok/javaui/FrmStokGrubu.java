package stok.javaui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

import stok.bll.StokGrubuBll;
import stok.entities.Birim;
import stok.entities.StokGrubu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FrmStokGrubu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable StokGrubuListesi;
	private JTextField txtStokGrubuId;
	private JTextField txtStokGrubuAdi;
	private JTextField txtSira;
	StokGrubuBll stokBll=new StokGrubuBll();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmStokGrubu dialog = new FrmStokGrubu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmStokGrubu() {
		setBounds(100, 100, 491, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setResizeWeight(0.5);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			contentPanel.add(splitPane, BorderLayout.CENTER);
			{
				JPanel UstPanel = new JPanel();
				splitPane.setLeftComponent(UstPanel);
				UstPanel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Stok Grubu Id");
				lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel.setBounds(10, 11, 97, 14);
				UstPanel.add(lblNewLabel);
				
				JLabel lblStokGrubuAdi = new JLabel("Stok Grubu Adi");
				lblStokGrubuAdi.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblStokGrubuAdi.setBounds(10, 36, 97, 14);
				UstPanel.add(lblStokGrubuAdi);
				
				JLabel lblSira = new JLabel("Sira");
				lblSira.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblSira.setBounds(10, 61, 97, 14);
				UstPanel.add(lblSira);
				
				JLabel lblDurumu = new JLabel("Durumu");
				lblDurumu.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblDurumu.setBounds(10, 86, 97, 14);
				UstPanel.add(lblDurumu);
				
				txtStokGrubuId = new JTextField();
				txtStokGrubuId.setBounds(108, 9, 86, 20);
				UstPanel.add(txtStokGrubuId);
				txtStokGrubuId.setColumns(10);
				
				txtStokGrubuAdi = new JTextField();
				txtStokGrubuAdi.setColumns(10);
				txtStokGrubuAdi.setBounds(108, 36, 86, 20);
				UstPanel.add(txtStokGrubuAdi);
				
				txtSira = new JTextField();
				txtSira.setColumns(10);
				txtSira.setBounds(108, 61, 86, 20);
				UstPanel.add(txtSira);
				
				JCheckBox cbxDurumu = new JCheckBox("");
				cbxDurumu.setBounds(108, 83, 97, 23);
				UstPanel.add(cbxDurumu);
				
				JButton btnKaydet = new JButton("Kaydet");
				btnKaydet.setIcon(new ImageIcon( this.getClass().getResource("/Kaydet.png")));
				btnKaydet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnKaydet.setBounds(296, 8, 114, 42);
				UstPanel.add(btnKaydet);
				
				JButton btnGuncelle = new JButton("G\u00FCncelle");
				btnGuncelle.setIcon(new ImageIcon( this.getClass().getResource("/Refresh.png")));
				btnGuncelle.setBounds(296, 58, 114, 42);
				UstPanel.add(btnGuncelle);
				
				JButton btnSil = new JButton("Sil");
				btnSil.setIcon(new ImageIcon( this.getClass().getResource("/Clear.png")));
				btnSil.setBounds(296, 107, 114, 42);
				UstPanel.add(btnSil);
			}
			{
				JPanel AltPanel = new JPanel();
				splitPane.setRightComponent(AltPanel);
				AltPanel.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					AltPanel.add(scrollPane, BorderLayout.CENTER);
					{
						StokGrubuListesi = new JTable();
						
						scrollPane.setViewportView(StokGrubuListesi);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}StokListele();
	}
	void StokListele()
	{
		try 
		{
            ArrayList<StokGrubu> StokGruplar=stokBll.Listele();
			
			Object[][] data = new Object[StokGruplar.size()][];
			for (int i = 0; i < data.length; i++) 
			{
				data[i]=new Object[]
						{
						   StokGruplar.get(i).getStokGrubuId(),
						   StokGruplar.get(i).getStokGrubuAdi(),
						   StokGruplar.get(i).getSira(),
						   StokGruplar.get(i).isDurumu(),
						};
		}
			StokGrubuListesi.setModel(new DefaultTableModel(
					data,
					new String[] {
						"Stok Grubu Id", "Stok Grubu Adi", "Sira", "Durumu"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, Integer.class, Boolean.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				StokGrubuListesi.getColumnModel().getColumn(0).setResizable(false);
				StokGrubuListesi.getColumnModel().getColumn(0).setPreferredWidth(79);
				StokGrubuListesi.getColumnModel().getColumn(1).setPreferredWidth(95);
				StokGrubuListesi.getColumnModel().getColumn(2).setResizable(false);
				StokGrubuListesi.getColumnModel().getColumn(3).setResizable(false);
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hata(FrmStokGrubu):"+e.getMessage());		
		}
		
	}
}
