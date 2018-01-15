package stok.javaui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

import stok.bll.KullaniciBll;
import stok.entities.Kullanici;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class FrmKullnaiciIslemleri extends JFrame {

	private JPanel contentPane;
	private JTextField txtKullaniciAdi;
	private JTextField txtKullaniciSoyadi;
	private JTextField txtTCkimlikNo;
	private JPasswordField Password;
	private JTextField txtCepTelNo;
	private JTextField txtEmail;
	JTextPane txtAdres;
	JCheckBox cbxDurum;
	KullaniciBll kullaniciBll=new KullaniciBll();
	private JTable KullaniciListesi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKullnaiciIslemleri frame = new FrmKullnaiciIslemleri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmKullnaiciIslemleri() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 411);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);	
		
		
		JButton btnYeniKayit = new JButton("Yeni Kay\u0131t");
		btnYeniKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		Image images=new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnYeniKayit.setIcon(new ImageIcon(images));
		btnYeniKayit.setToolTipText("Yeni Kay\u0131t");
		menuBar.add(btnYeniKayit);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setIcon(new ImageIcon(this.getClass().getResource("/save.png")));
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					//hata yoksa calýsýr
					//sýrayla calýsýrý nerde hata varsa ordan catch e gecer devamý calýsmaz
					if(txtKullaniciAdi.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Kullanici Adý bos geçilemez.");
						txtKullaniciAdi.requestFocus();
						return;
					}
					Kullanici kullanici=new Kullanici();
					kullanici.setKullaniciAdi(txtKullaniciAdi.getText());
					kullanici.setKullaniciSoyadi(txtKullaniciSoyadi.getText());
					kullanici.setKimlikNo(Long.parseLong(txtTCkimlikNo.getText()));
					kullanici.setAdres(txtAdres.getText());
					kullanici.setEmail(txtEmail.getText());
					kullanici.setDurumu(cbxDurum.isSelected());
										
				
					
				} catch (Exception hata) 
				{
					//hata annda calýsýr
					JOptionPane.showMessageDialog(null,"Hata:"+ hata.getMessage());
				}
				finally
				{
					//her zaman calýsacak iþlem!
				}
			}
		});
		menuBar.add(btnKaydet);
		
		JButton btnDuzenle = new JButton("D\u00FCzenle");
		btnDuzenle.setIcon(new ImageIcon(this.getClass().getResource("/convert.png")));
		menuBar.add(btnDuzenle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
		menuBar.add(btnSil);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblKullancAd.setBounds(10, 11, 76, 14);
		panel.add(lblKullancAd);
		
		JLabel lblKullancSoyad = new JLabel("Kullan\u0131c\u0131 Soyad\u0131");
		lblKullancSoyad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblKullancSoyad.setBounds(10, 37, 96, 14);
		panel.add(lblKullancSoyad);
		
		JLabel lblTcKimlikNo = new JLabel("TC Kimlik No");
		lblTcKimlikNo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTcKimlikNo.setBounds(10, 64, 76, 14);
		panel.add(lblTcKimlikNo);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblParola.setBounds(10, 89, 76, 14);
		panel.add(lblParola);
		
		JLabel lblCepTelNo = new JLabel("Cep Tel No");
		lblCepTelNo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCepTelNo.setBounds(286, 11, 76, 14);
		panel.add(lblCepTelNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEmail.setBounds(286, 51, 76, 14);
		panel.add(lblEmail);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAdres.setBounds(286, 90, 76, 14);
		panel.add(lblAdres);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(111, 9, 86, 20);
		panel.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		
		txtKullaniciSoyadi = new JTextField();
		txtKullaniciSoyadi.setBounds(111, 35, 86, 20);
		panel.add(txtKullaniciSoyadi);
		txtKullaniciSoyadi.setColumns(10);
		
		txtTCkimlikNo = new JTextField();
		txtTCkimlikNo.setBounds(111, 62, 86, 20);
		panel.add(txtTCkimlikNo);
		txtTCkimlikNo.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(111, 89, 86, 20);
		panel.add(Password);
		
		txtCepTelNo = new JTextField();
		txtCepTelNo.setBounds(372, 9, 86, 20);
		panel.add(txtCepTelNo);
		txtCepTelNo.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(372, 49, 86, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtAdres = new JTextPane();
		txtAdres.setBounds(372, 83, 86, 51);
		panel.add(txtAdres);
		
		cbxDurum = new JCheckBox("");
		cbxDurum.setBounds(111, 116, 97, 23);
		panel.add(cbxDurum);
		
		JLabel lblDurumu = new JLabel("Durumu");
		lblDurumu.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDurumu.setBounds(10, 121, 76, 14);
		panel.add(lblDurumu);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		KullaniciListesi = new JTable();
		
		scrollPane.setViewportView(KullaniciListesi);
		KullaniciListele();
	}
	void KullaniciListele()
	{
		try 
		{
			 ArrayList<Kullanici> kullanicilar=kullaniciBll.Listele();
				
				Object[][] data = new Object[kullanicilar.size()][];
				for (int i = 0; i < data.length; i++) 
				{
					data[i]=new Object[]
							{
							kullanicilar.get(i).getKullaniciId(),
							kullanicilar.get(i).getKullaniciAdi(),
							kullanicilar.get(i).getKullaniciSoyadi(),
							kullanicilar.get(i).getKimlikNo(),
							kullanicilar.get(i).getParola(),
							kullanicilar.get(i).getCepTelNo(),
							kullanicilar.get(i).getEmail(),
							kullanicilar.get(i).getAdres(),
							kullanicilar.get(i).isDurumu(),
							};
			}KullaniciListesi.setModel(new DefaultTableModel(
					data,
						new String[] {
							"Kullanici \u0131d", "Kullanici Adi", "Kullanici Soyadi", "TC Kimlik No", "Parola", "Cep Tel No", "Email", "Adres", "Durumu"
						}
					) {
						Class[] columnTypes = new Class[] {
							Integer.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					KullaniciListesi.getColumnModel().getColumn(0).setResizable(false);
					KullaniciListesi.getColumnModel().getColumn(2).setPreferredWidth(98);
					KullaniciListesi.getColumnModel().getColumn(3).setResizable(false);
					KullaniciListesi.getColumnModel().getColumn(4).setResizable(false);
					KullaniciListesi.getColumnModel().getColumn(5).setResizable(false);
				
			
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hata(FrmKullanici):"+e.getMessage());
		}
	}
}
