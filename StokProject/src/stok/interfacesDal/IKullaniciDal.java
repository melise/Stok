package stok.interfacesDal;

import java.util.ArrayList;

import stok.entities.Kullanici;
//method iþlemi yapýlmaz
//arayuzler prototip olusturmak için kullanýlýr
//burasý tanýmlama insasý classlarda yplýr
public interface IKullaniciDal
{
	boolean KullaniciKontrol(String kullaniciAdi,String parola);
	boolean Kaydet(Kullanici kl);//kayýt olup olmadýgýný görmek için.nesne yapýyoruz
	boolean Sil(int KullaniciId);
	boolean Guncelle(int KullaniciId);
	ArrayList<Kullanici> Listele();
	Kullanici Getir(int KullaniciId);//id ye göre entity getircek

}
