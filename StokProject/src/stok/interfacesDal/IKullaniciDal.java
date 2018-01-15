package stok.interfacesDal;

import java.util.ArrayList;

import stok.entities.Kullanici;
//method i�lemi yap�lmaz
//arayuzler prototip olusturmak i�in kullan�l�r
//buras� tan�mlama insas� classlarda ypl�r
public interface IKullaniciDal
{
	boolean KullaniciKontrol(String kullaniciAdi,String parola);
	boolean Kaydet(Kullanici kl);//kay�t olup olmad�g�n� g�rmek i�in.nesne yap�yoruz
	boolean Sil(int KullaniciId);
	boolean Guncelle(int KullaniciId);
	ArrayList<Kullanici> Listele();
	Kullanici Getir(int KullaniciId);//id ye g�re entity getircek

}
