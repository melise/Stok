package stok.interfacesDal;

import java.util.ArrayList;

import stok.entities.Urun;

public interface IUrunDal
{
	//interface default eriþim publictir,class da private
	void Kaydet(Urun urun);
	boolean Sil(int urunId);
	boolean Guncelle(int urunId);
	ArrayList<Urun> Listele();
	Urun Getir(int urunId);
	Urun Getir(String barkodNo);
}
