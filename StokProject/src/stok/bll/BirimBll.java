package stok.bll;

import java.util.ArrayList;

import stok.dalmysql.BirimDal;
import stok.dalmysql.UrunDal;
import stok.entities.Birim;
import stok.entities.Urun;
import stok.interfacesDal.IBirimDal;

public class BirimBll 
{
	BirimDal birim=new BirimDal();
	public ArrayList<Birim> Listele()
	{
			return birim.Listele();			
	}
	public void Kaydet(Birim br)
	{
		birim.Kaydet(br);
	}

	
	

}
