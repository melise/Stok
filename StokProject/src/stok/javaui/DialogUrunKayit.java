package stok.javaui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import stok.bll.BirimBll;
import stok.bll.StokGrubuBll;
import stok.bll.UrunBll;
import stok.dalmysql.UrunDal;
import stok.entities.Birim;
import stok.entities.StokGrubu;
import stok.entities.Urun;

public class DialogUrunKayit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBarkodNo;
	private JTextField txtUrunAdi;
	private JTextField txtAlisFiyati;
	private JTextField txtSatisFiyati;
	private JTextField txtKdvOrani;
	UrunBll urunBll=new UrunBll(new UrunDal());
	JComboBox cmbUrunGrubu;
	JComboBox cmbBirimi;
	private IDBListener kayitYenile;//arka formdan ön formu acarken o formunadýný göndermek gerek kayýt yenileye atama yapýcaz
//IUrurnDal dal;
	//DialogUrunKAyit(IUrunDal urun)
	//{
	//dal=urun;
	//}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogUrunKayit dialog = new DialogUrunKayit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//kapandýgý anda bellekten sil
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogUrunKayit() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Barkod No");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 11, 75, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u00DCr\u00FCn Ad\u0131");
		label.setFont(new Font("Verdana", Font.PLAIN, 12));
		label.setBounds(20, 36, 75, 14);
		contentPanel.add(label);
		{
			JLabel lblrnGrubu = new JLabel("\u00DCr\u00FCn Grubu");
			lblrnGrubu.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblrnGrubu.setBounds(20, 61, 75, 14);
			contentPanel.add(lblrnGrubu);
		}
		{
			JLabel lblBirimi = new JLabel("Birimi");
			lblBirimi.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblBirimi.setBounds(20, 86, 75, 14);
			contentPanel.add(lblBirimi);
		}
		{
			JLabel lblAlFiyat = new JLabel("Al\u0131\u015F Fiyat\u0131");
			lblAlFiyat.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblAlFiyat.setBounds(20, 111, 75, 14);
			contentPanel.add(lblAlFiyat);
		}
		{
			JLabel lblSatFiyat = new JLabel("Sat\u0131\u015F Fiyat\u0131");
			lblSatFiyat.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblSatFiyat.setBounds(20, 136, 75, 14);
			contentPanel.add(lblSatFiyat);
		}
		{
			JLabel lblKdvOran = new JLabel("KDV Oran\u0131(%)");
			lblKdvOran.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblKdvOran.setBounds(20, 163, 96, 14);
			contentPanel.add(lblKdvOran);
		}
		
		txtBarkodNo = new JTextField();
		txtBarkodNo.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtBarkodNo.setBounds(109, 9, 128, 20);
		contentPanel.add(txtBarkodNo);
		txtBarkodNo.setColumns(10);
		txtBarkodNo.requestFocus();
		
		txtUrunAdi = new JTextField();
		txtUrunAdi.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtUrunAdi.setColumns(10);
		txtUrunAdi.setBounds(109, 34, 128, 20);
		contentPanel.add(txtUrunAdi);
		
		cmbUrunGrubu = new JComboBox();
		cmbUrunGrubu.setFont(new Font("Verdana", Font.PLAIN, 12));
		cmbUrunGrubu.setBounds(109, 59, 128, 20);
		contentPanel.add(cmbUrunGrubu);
		
		cmbBirimi = new JComboBox();
		cmbBirimi.setFont(new Font("Verdana", Font.PLAIN, 12));
		cmbBirimi.setBounds(109, 84, 128, 20);
		contentPanel.add(cmbBirimi);
		
		txtAlisFiyati = new JTextField();
		txtAlisFiyati.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtAlisFiyati.setColumns(10);
		txtAlisFiyati.setBounds(109, 109, 128, 20);
		contentPanel.add(txtAlisFiyati);
		
		txtSatisFiyati = new JTextField();
		txtSatisFiyati.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtSatisFiyati.setColumns(10);
		txtSatisFiyati.setBounds(109, 134, 128, 20);
		contentPanel.add(txtSatisFiyati);
		
		txtKdvOrani = new JTextField();
		txtKdvOrani.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtKdvOrani.setColumns(10);
		txtKdvOrani.setBounds(109, 161, 128, 20);
		contentPanel.add(txtKdvOrani);
		
		JLabel lblAktiflikDurumu = new JLabel("Aktiflik Durumu");
		lblAktiflikDurumu.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAktiflikDurumu.setBounds(10, 188, 96, 14);
		contentPanel.add(lblAktiflikDurumu);
		
		JCheckBox cbAktiflikDurumu = new JCheckBox("");
		cbAktiflikDurumu.setFont(new Font("Verdana", Font.PLAIN, 12));
		cbAktiflikDurumu.setBounds(109, 188, 108, 23);
		contentPanel.add(cbAktiflikDurumu);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnKaydet = new JButton("Kaydet");
				btnKaydet.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						try 
						{
							if(txtBarkodNo.getText().trim().equals(""))
							{
								JOptionPane.showMessageDialog(null, "Barkod no giriniz:");
								txtBarkodNo.requestFocus();
								return;
							}
							if(txtUrunAdi.getText().trim().equals(""))
							{
								JOptionPane.showMessageDialog(null, "ürün adi giriniz:");
								txtUrunAdi.requestFocus();
								return;
							}
							if(cmbUrunGrubu.getSelectedIndex()<0)
							{
								JOptionPane.showMessageDialog(null, "ürün grubu seciniz:");
								cmbUrunGrubu.requestFocus();
								return;
							}
							if(cmbBirimi.getSelectedIndex()<0)
							{
								JOptionPane.showMessageDialog(null, "birimi seciniz:");
								cmbBirimi.requestFocus();
								return;
							}
							if(txtAlisFiyati.getText().trim().equals("")|| Float.parseFloat(txtAlisFiyati.getText())<=0)
							{
								JOptionPane.showMessageDialog(null, "Alýþ fiyatý giriniz.");
								txtAlisFiyati.requestFocus();
								return;
							}
							Urun urun=new Urun();//bu sekilde yapýlma nedeni metodun urun nesnesi istemesi
							urun.setUrunAdi(txtUrunAdi.getText());
							urun.setBarodNo(txtBarkodNo.getText());
							urun.setAlisFiyati(Float.parseFloat(txtAlisFiyati.getText()));
							urun.setSatisFiyati(Float.parseFloat(txtSatisFiyati.getText()));
							urun.setBirimId(((Birim)cmbBirimi.getSelectedItem()).getBirimId());//nesneye dönüþtürüp birim ýd alýyoruz sectiðimiz combbox birimýd ye gidiryor
							urun.setUrunGrubuId(((StokGrubu)cmbUrunGrubu.getSelectedItem()).getStokGrubuId());
							urun.setAktif(cbAktiflikDurumu.isSelected());
							
							urunBll.Kaydet(urun);
							
							kayitYenile.KayitYenile();//bastaki nesne adý oteki arka formdaki kayýdýn adý
							
						} 
						catch (Exception error) 
						{
							JOptionPane.showMessageDialog(null, "Hata:"+error.getMessage());
						}
					}
				});
				btnKaydet.setActionCommand("OK");
				buttonPane.add(btnKaydet);
				getRootPane().setDefaultButton(btnKaydet);
			}
			{
				JButton btnKapat = new JButton("Kapat");
				btnKapat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);//kapat butonu
					}
				});
				btnKapat.setActionCommand("Cancel");
				buttonPane.add(btnKapat);
			}
		}
		ComboDoldur();
	}
	void ComboDoldur()
	{
		DefaultComboBoxModel birim=new DefaultComboBoxModel(new BirimBll().Listele().toArray());
		DefaultComboBoxModel stok=new DefaultComboBoxModel(new StokGrubuBll().Listele().toArray());
		cmbUrunGrubu.setModel(stok);
		cmbBirimi.setModel(birim);
	}
	public void KayitYenile(IDBListener listeners)
	{
		this.kayitYenile=listeners;//arka taraftaki form onun ozelliklerine eriþilebiliyor
	}
}
