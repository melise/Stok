package stok.interfacesDal;

import java.util.ArrayList;

import stok.entities.Birim;

public interface IBirimDal 
{
	boolean Kaydet(Birim birim);
	boolean Sil(int BirimId);
	boolean G�ncelle(int BirimId);
	ArrayList<Birim> Listele();
	

}
