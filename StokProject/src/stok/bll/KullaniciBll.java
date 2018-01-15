package stok.bll;

import java.util.ArrayList;

import javax.swing.JOptionPane;



import stok.dalmysql.KullaniciDal;
import stok.entities.Birim;
import stok.entities.Kullanici;
import stok.interfacesDal.IKullaniciDal;


public class KullaniciBll 
{
	KullaniciDal kullaniciDal=new KullaniciDal();
	public ArrayList<Kullanici> Listele()
	{
			return kullaniciDal.Listele();			
	}
	public void Kaydet(Kullanici kl)
	{
		kullaniciDal.Kaydet(kl);
	}
	public boolean KullaniciKontrol(String kullaniciAdi,String parola)
	{
		return kullaniciDal.KullaniciKontrol(kullaniciAdi, parola);
	}
}
