package stok.bll;

import stok.dalmysql.KontrolDal;
import stok.interfacesDal.IKontrol;

public class KontrolBll implements IKontrol
{
	KontrolDal kontrol=new KontrolDal();

	@Override
	public boolean DatabaseKontrol() {
		// TODO Auto-generated method stub
		return kontrol.DatabaseKontrol();
	}



	@Override
	public boolean DatabaseEkle() {
		// TODO Auto-generated method stub
		return kontrol.DatabaseEkle();
	}

	

	@Override
	public boolean TableKontrol(String tabloAdi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void TableEkle(String tabloAdi) {
		// TODO Auto-generated method stub
		
	}
	

}
