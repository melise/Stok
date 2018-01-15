package stok.javaui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StokGirisi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarkodNo;
	private JTextField txtStokGrubu;
	private JTextField txtStokAdi;
	private JTextField txtStokBirimi;
	private JTextField txtMevcutStok;
	private JTextField txtBelgeNo;
	private JTextField txtAciklama;
	private JTextField txtMiktar;
	private JTextField txtIslemTarihi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StokGirisi dialog = new StokGirisi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StokGirisi() {
		setBounds(100, 100, 498, 479);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 482, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 394, 482, 46);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnYeniIslem = new JButton("Yeni \u0130\u015Flem");
				buttonPane.add(btnYeniIslem);
			}
			{
				JButton btnKaydet = new JButton("\u0130\u015Flemi Kaydet");
				buttonPane.add(btnKaydet);
			}
			{
				JButton btnKapat = new JButton("Kapat");
				btnKapat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
					}
				});
				buttonPane.add(btnKapat);
			}
		}
		{
			JLabel lblBarkodNo = new JLabel("Barkod No");
			lblBarkodNo.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblBarkodNo.setBounds(56, 40, 109, 14);
			getContentPane().add(lblBarkodNo);
		}
		{
			JLabel lblStokGrubu = new JLabel("Stok Grubu");
			lblStokGrubu.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblStokGrubu.setBounds(56, 77, 109, 14);
			getContentPane().add(lblStokGrubu);
		}
		{
			JLabel lblStokAd = new JLabel("Stok Ad\u0131");
			lblStokAd.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblStokAd.setBounds(56, 109, 109, 14);
			getContentPane().add(lblStokAd);
		}
		{
			JLabel lblStokBirimi = new JLabel("Stok Birimi");
			lblStokBirimi.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblStokBirimi.setBounds(56, 148, 109, 14);
			getContentPane().add(lblStokBirimi);
		}
		{
			JLabel lblMevcutStok = new JLabel("Mevcut Stok");
			lblMevcutStok.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblMevcutStok.setBounds(39, 190, 109, 14);
			getContentPane().add(lblMevcutStok);
		}
		{
			JLabel lblIlemTarihi = new JLabel("\u0130\u015Flem Tarihi");
			lblIlemTarihi.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblIlemTarihi.setBounds(39, 226, 109, 14);
			getContentPane().add(lblIlemTarihi);
		}
		{
			JLabel lblBelgeNo = new JLabel("Belge No");
			lblBelgeNo.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblBelgeNo.setBounds(56, 274, 109, 14);
			getContentPane().add(lblBelgeNo);
		}
		{
			JLabel lblAklama = new JLabel("A\u00E7\u0131klama");
			lblAklama.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblAklama.setBounds(56, 311, 109, 14);
			getContentPane().add(lblAklama);
		}
		{
			JLabel lblMiktar = new JLabel("Miktar");
			lblMiktar.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblMiktar.setBounds(56, 343, 109, 14);
			getContentPane().add(lblMiktar);
		}
		{
			txtBarkodNo = new JTextField();
			txtBarkodNo.setBounds(129, 36, 143, 25);
			getContentPane().add(txtBarkodNo);
			txtBarkodNo.setColumns(10);
		}
		{
			txtStokGrubu = new JTextField();
			txtStokGrubu.setColumns(10);
			txtStokGrubu.setBounds(129, 73, 143, 25);
			getContentPane().add(txtStokGrubu);
		}
		{
			txtStokAdi = new JTextField();
			txtStokAdi.setColumns(10);
			txtStokAdi.setBounds(129, 104, 143, 25);
			getContentPane().add(txtStokAdi);
		}
		{
			txtStokBirimi = new JTextField();
			txtStokBirimi.setColumns(10);
			txtStokBirimi.setBounds(129, 144, 143, 25);
			getContentPane().add(txtStokBirimi);
		}
		{
			txtMevcutStok = new JTextField();
			txtMevcutStok.setColumns(10);
			txtMevcutStok.setBounds(129, 186, 143, 25);
			getContentPane().add(txtMevcutStok);
		}
		{
			txtBelgeNo = new JTextField();
			txtBelgeNo.setColumns(10);
			txtBelgeNo.setBounds(129, 263, 143, 25);
			getContentPane().add(txtBelgeNo);
		}
		{
			txtAciklama = new JTextField();
			txtAciklama.setColumns(10);
			txtAciklama.setBounds(129, 300, 143, 25);
			getContentPane().add(txtAciklama);
		}
		{
			txtMiktar = new JTextField();
			txtMiktar.setColumns(10);
			txtMiktar.setBounds(129, 331, 143, 25);
			getContentPane().add(txtMiktar);
		}
		{
			txtIslemTarihi = new JTextField();
			txtIslemTarihi.setColumns(10);
			txtIslemTarihi.setBounds(129, 222, 143, 25);
			getContentPane().add(txtIslemTarihi);
		}
		
		JButton btnStokAra = new JButton("Stok Ara");
		btnStokAra.setBounds(329, 36, 89, 46);
		getContentPane().add(btnStokAra);
		
		JLabel lblNewLabel = new JLabel("STOK G\u0130R\u0130S\u0130");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel.setBounds(196, 11, 109, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox cmbMiktar = new JComboBox();
		cmbMiktar.setModel(new DefaultComboBoxModel(new String[] {"Adet", "Litre", "Kilogram", "Metre"}));
		cmbMiktar.setBounds(278, 332, 57, 25);
		getContentPane().add(cmbMiktar);
	}
}
