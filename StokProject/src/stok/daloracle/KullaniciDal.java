package stok.daloracle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import stok.entities.Kullanici;
import stok.interfacesDal.IKullaniciDal;

//interface implement class extend edilir
//interfaceden bagýmsýz method eklenebilir
//global methodsa interface yazmak gerekir
public class KullaniciDal implements IKullaniciDal 
{

	
	@Override
	public boolean Kaydet(Kullanici kl) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Sil(int KullaniciId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Guncelle(int KullaniciId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Kullanici> Listele() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kullanici Getir(int KullaniciId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean KullaniciKontrol(String kullaniciAdi, String parola) {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
