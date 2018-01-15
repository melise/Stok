package stok.bll;

import java.util.ArrayList;

import stok.dalmysql.UrunDal;
import stok.entities.Urun;
import stok.interfacesDal.IUrunDal;

public class UrunBll implements IUrunDal
{
	//ninjaframe yapýlarý katmanlar arasý????
	//UrunDal urun=new UrunDal();
	IUrunDal urun;//dal ýnterface i
	public UrunBll(IUrunDal urun)
	{
		this.urun=urun;
	}
	public ArrayList<Urun> Listele()
	{
			return urun.Listele();			
	}
	public void Kaydet(Urun ur)
	{
		urun.Kaydet(ur);
	}
	public boolean Sil(int urunId)
	{
		return urun.Sil(urunId);
	}
	@Override
	public boolean Guncelle(int urunId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Urun Getir(int urunId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Urun Getir(String barkodNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
