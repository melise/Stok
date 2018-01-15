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

import stok.bll.BirimBll;
import stok.entities.Birim;
import stok.entities.Urun;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FrmBirim extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBirimId;
	private JTextField txtBirimAdi;
	private JTextField txtSira;
	private JTable JtableBirimListesi;
	BirimBll birimBll=new BirimBll(); 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmBirim dialog = new FrmBirim();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBirim() {
		setBounds(100, 100, 489, 409);
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
				JPanel panel = new JPanel();
				splitPane.setLeftComponent(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Birim Id");
				lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel.setBounds(10, 21, 74, 14);
				panel.add(lblNewLabel);
				
				JLabel lblBirimAd = new JLabel("Birim Ad\u0131");
				lblBirimAd.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblBirimAd.setBounds(10, 46, 74, 14);
				panel.add(lblBirimAd);
				
				JLabel lblSra = new JLabel("S\u0131ra");
				lblSra.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblSra.setBounds(10, 71, 74, 14);
				panel.add(lblSra);
				
				JLabel lblDurumu = new JLabel("Durumu");
				lblDurumu.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblDurumu.setBounds(10, 96, 74, 14);
				panel.add(lblDurumu);
				
				txtBirimId = new JTextField();
				txtBirimId.setBounds(70, 19, 86, 20);
				panel.add(txtBirimId);
				txtBirimId.setColumns(10);
				
				txtBirimAdi = new JTextField();
				txtBirimAdi.setColumns(10);
				txtBirimAdi.setBounds(70, 46, 86, 20);
				panel.add(txtBirimAdi);
				
				txtSira = new JTextField();
				txtSira.setColumns(10);
				txtSira.setBounds(70, 71, 86, 20);
				panel.add(txtSira);
				
				JCheckBox cbxDurumu = new JCheckBox("");
				cbxDurumu.setBounds(70, 92, 97, 23);
				panel.add(cbxDurumu);
				
				JButton btnKaydet = new JButton("Kaydet");
				btnKaydet.setIcon(new ImageIcon( this.getClass().getResource("/Kaydet.png")));
				btnKaydet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnKaydet.setBounds(277, 11, 144, 41);
				panel.add(btnKaydet);
				
				JButton btnGuncelle = new JButton("G\u00FCncelle");
				btnGuncelle.setIcon(new ImageIcon( this.getClass().getResource("/Refresh.png")));
				btnGuncelle.setBounds(278, 54, 143, 31);
				panel.add(btnGuncelle);
				
				JButton btnSil = new JButton("Sil");
				btnSil.setIcon(new ImageIcon( this.getClass().getResource("/Clear.png")));
				btnSil.setBounds(277, 93, 144, 31);
				panel.add(btnSil);
			}
			
			JPanel panelTablo = new JPanel();
			splitPane.setRightComponent(panelTablo);
			panelTablo.setLayout(new BorderLayout(0, 0));
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			panelTablo.add(scrollPane, BorderLayout.CENTER);
			
			JtableBirimListesi = new JTable();
			
			scrollPane.setViewportView(JtableBirimListesi);
			
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
		}
		BirimListele();
		}
	void BirimListele()
	{
		try 
		{
			ArrayList<Birim> birimler=birimBll.Listele();
			
			Object[][] data = new Object[birimler.size()][];
			for (int i = 0; i < data.length; i++) 
			{
				data[i]=new Object[]
						{
						   birimler.get(i).getBirimId(),
						   birimler.get(i).getBirimAdi(),
						   birimler.get(i).getSira(),
						   birimler.get(i).isDurumu(),
						};
			}
			JtableBirimListesi.setModel(new DefaultTableModel(
					data,
					new String[] {
						"Birim ID", "Birim Ad\u0131", "S\u0131ra", "Durumu"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, Integer.class, Boolean.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						true,true,true,true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				JtableBirimListesi.getColumnModel().getColumn(0).setResizable(false);
				JtableBirimListesi.getColumnModel().getColumn(2).setResizable(false);
				JtableBirimListesi.getColumnModel().getColumn(3).setResizable(false);
			
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hata(FrmBirim):"+e.getMessage());
		}
	}
}
