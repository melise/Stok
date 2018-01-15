package stok.javaui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import stok.bll.KontrolBll;
import stok.bll.UrunBll;
import stok.dalmysql.Baglanti;
import stok.dalmysql.KontrolDal;
import stok.dalmysql.UrunDal;
import stok.entities.Kullanici;
import stok.entities.Urun;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class StokIslemleri extends JFrame implements IDBListener
{

	private JPanel contentPane;
	private JTable tableStokKartiListesi;
	UrunBll urunBll=new UrunBll(new UrunDal());//static olmadýgý için nesne ile eriþim yapacagýz
	KontrolBll kontrolBll=new KontrolBll();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokIslemleri frame = new StokIslemleri();
					//frame.setLocationRelativeTo(null);//tam ekranýn ortasýnda konumlama
					frame.setExtendedState(MAXIMIZED_BOTH);//Tüm ekraný kapla
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
	public StokIslemleri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 492);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u0130\u015Flemler");
		menuBar.add(mnNewMenu);
		
		JMenuItem btnYeniStokKarti = new JMenuItem("Yeni Stok Kart\u0131");
		mnNewMenu.add(btnYeniStokKarti);
		
		JMenuItem btnStokKartiSil = new JMenuItem("Stok Kart\u0131 Sil");
		mnNewMenu.add(btnStokKartiSil);
		
		JMenuItem btnStokKartiGuncelle = new JMenuItem("Stok kart\u0131 G\u00FCncelle");
		mnNewMenu.add(btnStokKartiGuncelle);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem btnBirimIslemleri = new JMenuItem("Birim");
		btnBirimIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				FrmBirim BirimDialog=new FrmBirim();
				BirimDialog.setLocationRelativeTo(null);
				BirimDialog.setVisible(true);								
			}
		});
		mnNewMenu.add(btnBirimIslemleri);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem btnStokGrubu = new JMenuItem("Stok Grubu");
		btnStokGrubu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				FrmStokGrubu StokDialog=new FrmStokGrubu();
				StokDialog.setLocationRelativeTo(null);
				StokDialog.setVisible(true);
			}
		});
		mnNewMenu.add(btnStokGrubu);
		
		JMenu mnNewMenu_1 = new JMenu("Raporlar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem btnStokListesi = new JMenuItem("Stok Listesi");
		mnNewMenu_1.add(btnStokListesi);
		
		JMenuItem btnStokKritikListe = new JMenuItem("Stok Kritik Liste");
		mnNewMenu_1.add(btnStokKritikListe);
		
		JMenuItem btnCokSatilanlar = new JMenuItem("\u00C7ok Sat\u0131lanlar");
		mnNewMenu_1.add(btnCokSatilanlar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panelUst = new JPanel();
		splitPane.setLeftComponent(panelUst);
		panelUst.setLayout(new BoxLayout(panelUst, BoxLayout.X_AXIS));
		
		JPanel panelStokKartlari = new JPanel();
		panelStokKartlari.setBorder(new TitledBorder(null, "Stok Kartlar\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUst.add(panelStokKartlari);
		panelStokKartlari.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelStokKartlari.add(scrollPane, BorderLayout.CENTER);
		
		tableStokKartiListesi = new JTable();
		
		
		scrollPane.setViewportView(tableStokKartiListesi);
		
		JPanel panelStokIslemleri = new JPanel();
		panelStokIslemleri.setBorder(new TitledBorder(null, "Stok \u0130\u015Flemleri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUst.add(panelStokIslemleri);
		
		JButton btnSatirSayisi = new JButton("Satir Sayisi Bulma");
		btnSatirSayisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int satir=tableStokKartiListesi.getRowCount();//Table satýr sayýsýný verir
				JOptionPane.showMessageDialog(null, "Satir sayisi:"+satir);
				
				/*//int satir1=tableStokKartiListesi.getSelectedRowCount();//Table secili satýr sayýsýný verir
				//JOptionPane.showMessageDialog(null, "Secili Satir sayisi:"+satir1);
				
				int indis=tableStokKartiListesi.getSelectedRow();//Table secili satýrýn indis sayýsýný verir
				//JOptionPane.showMessageDialog(null, "Satir indisi:"+indis);
				
				int kolonindis=tableStokKartiListesi.getSelectedColumn();//Table secili kolon sayýsýný verir
				//JOptionPane.showMessageDialog(null, "Secili Kolon indisi:"+kolonindis);
				
				int kolonsayisi=tableStokKartiListesi.getSelectedColumnCount();//Table kolon sayýsýný verir
				//JOptionPane.showMessageDialog(null, "Kolon sayisi:"+kolonsayisi);
				
				String id=tableStokKartiListesi.getValueAt(indis, 0).toString();//secili saýrdaki ve belirtiken kolondaki veri
*/				//JOptionPane.showMessageDialog(null, "id:"+id);
				int veri=(int) tableStokKartiListesi.getValueAt(--satir, 0);
				JOptionPane.showMessageDialog(null,"son veri:" +veri);
				
				//Object cell=tableStokKartiListesi.getValueAt(tableStokKartiListesi.getSelectedRow(), tableStokKartiListesi.getSelectedColumn());
				//JOptionPane.showMessageDialog(null, "cell:"+cell);
				//secili hucredeki veriyi alýr
			}
		});
		
		JButton btnYeniKayit = new JButton("Yeni Kay\u0131t");
		btnYeniKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DialogUrunKayit dialog=new DialogUrunKayit();
				dialog.setLocationRelativeTo(null);//ortada cýkmasý
				dialog.KayitYenile(StokIslemleri.this);//mevcut formu arka taraftakini gönderip on form ozelliklerini kullanabiliyor
				dialog.setVisible(true);
				
			}
		});
		panelStokIslemleri.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelStokIslemleri.add(btnYeniKayit);
		panelStokIslemleri.add(btnSatirSayisi);
		
		JButton btnStokGirii = new JButton("Stok Giri\u015Fi");
		btnStokGirii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				StokGirisi stokDialog=new StokGirisi();
				stokDialog.setLocationRelativeTo(null);
				stokDialog.setVisible(true);
			}
		});
		panelStokIslemleri.add(btnStokGirii);
		
		JButton btnKayitSil = new JButton("Kay\u0131t Sil");
		btnKayitSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(tableStokKartiListesi.getSelectedRowCount()==0)
				{
					JOptionPane.showMessageDialog(null, "Urun Seciniz.");
					return;
				}
				int donen=JOptionPane.showConfirmDialog(null, "Seçili Ürünü Silmek Ýçin Emin Misiniz?","KAYÝT SÝL",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(donen==0)
				{
					int satir=tableStokKartiListesi.getSelectedRow();//kolon sýfýr cunku secýlen satiri sildik
			        boolean deger=	new UrunBll(new UrunDal()).Sil(Integer.parseInt( tableStokKartiListesi.getValueAt(satir, 0).toString()));
					if(deger==true)
					{
						StokKartiListele();
						JOptionPane.showMessageDialog(null, "Kayýt Basarýlý Silindi.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Kayit Silinemedi.");
					}
				}
				
				
			}
		});
		panelStokIslemleri.add(btnKayitSil);
		
		JButton btnRapor = new JButton("Rapor");
		btnRapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Connection conn=Baglanti.Baglan();
				JasperPrint print;
				try 
				{
					print = JasperFillManager.fillReport("rapor2.jasper", null,conn);
					JasperViewer.viewReport(print,false);
				}
				catch (JRException e)
				{
					e.printStackTrace();
				}
			}
		});
		panelStokIslemleri.add(btnRapor);
		
		JButton btnDosyaokumayazma = new JButton("DosyaOkumaYazma");
		btnDosyaokumayazma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					ArrayList<Urun> urunler= urunBll.Listele();
					
					StringBuilder sb=new StringBuilder();
					
					
					for (int i = 0; i <urunler.size(); i++) 
					{
						sb.append(urunler.get(i).getUrunId());//ekleme
						sb.append(";");
						sb.append( urunler.get(i).getUrunAdi());
						sb.append(";");
						sb.append(urunler.get(i).getStokGrubu().getStokGrubuAdi());
						sb.append(";");
						sb.append(urunler.get(i).getMevcutStok());
						sb.append(";");
						sb.append(urunler.get(i).getAlisFiyati());
						sb.append(";");
						sb.append(urunler.get(i).getSatisFiyati());
						sb.append(";\n");

						}
					
					File dosya=new File("C:\\Users\\Buse\\Desktop\\dosya\\urunlistesi.txt");
					FileWriter yazici=new FileWriter(dosya);
					yazici.write(sb.toString());
					yazici.flush();
					yazici.close();
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				
				
				
			}
		});
		panelStokIslemleri.add(btnDosyaokumayazma);
		
		JPanel panelAlt = new JPanel();
		splitPane.setRightComponent(panelAlt);
		StokKartiListele();
	}
void StokKartiListele()
{
	try 
	{
		ArrayList<Urun> urunler= urunBll.Listele();
		
		Object[][] data = new Object[urunler.size()][];
		for (int i = 0; i < data.length; i++) 
		{
			data[i]=new Object[]
					{
					    urunler.get(i).getUrunId(),
					    urunler.get(i).getUrunAdi(),
					    urunler.get(i).getStokGrubu().getStokGrubuAdi(),
					    urunler.get(i).getMevcutStok(),
					    urunler.get(i).getAlisFiyati(),
					    urunler.get(i).getSatisFiyati(),
					    urunler.get(i).isAktif()
					    
					};
			}		
		
		tableStokKartiListesi.setModel(new DefaultTableModel(
				data,
				new String[] {
					"\u00DCr\u00FCn kodu", "\u00DCr\u00FCn ad\u0131", "\u00DCr\u00FCn grubu", "Mevcut stok", "Al\u0131\u015F fiyat\u0131", "sat\u0131s fiyat\u0131", "aktif"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, Object.class, Integer.class, Float.class, Float.class, Float.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, true, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		tableStokKartiListesi.getColumnModel().getColumn(0).setResizable(false);
		tableStokKartiListesi.getColumnModel().getColumn(2).setResizable(false);
		tableStokKartiListesi.getColumnModel().getColumn(3).setResizable(false);
		tableStokKartiListesi.getColumnModel().getColumn(4).setResizable(false);
		tableStokKartiListesi.getColumnModel().getColumn(5).setResizable(false);
		tableStokKartiListesi.getColumnModel().getColumn(6).setResizable(false);
		
		
	} 
	catch (Exception e)
	{
		JOptionPane.showMessageDialog(null, "hata var"+ e.getMessage());
	}
	
}

@Override
public void KayitYenile() 
{
	StokKartiListele();	
}
}
