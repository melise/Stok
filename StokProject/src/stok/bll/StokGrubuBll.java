package stok.bll;

import java.util.ArrayList;

import stok.dalmysql.StokGrubuDal;
import stok.entities.StokGrubu;

public class StokGrubuBll
{
	StokGrubuDal stok=new StokGrubuDal();
	public ArrayList<StokGrubu> Listele()
	{
			return stok.Listele();			
	}
	public void Kaydet(StokGrubu sg)
	{
		stok.Kaydet(sg);
	}

}
