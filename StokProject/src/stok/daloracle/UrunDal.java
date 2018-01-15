package stok.daloracle;

import java.util.ArrayList;

import stok.entities.Urun;
import stok.interfacesDal.IUrunDal;
//interfaceden türetilmiþ sýnýftýr
//urundal turetilmiþ sýnýf
public class UrunDal implements IUrunDal
{
	

	@Override
	public void Kaydet(Urun urun) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Sil(int urunId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Guncelle(int urunId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Urun> Listele() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Urun Getir(int urunId) {
		// TODO Auto-generated method stub
		return null;
	}
	//yeni methodlar eklenir interfacede olmayan

	@Override
	public Urun Getir(String barkodNo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
