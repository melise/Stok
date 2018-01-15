package stok.interfacesDal;

import java.util.ArrayList;

import stok.entities.StokGrubu;

public interface IStokGrubuDal 
{
	boolean Kaydet(StokGrubu stokGrubu);
	boolean Sil(int StokGrubuId);
	boolean Guncelle(int StokGrubuId);
	ArrayList<StokGrubu> Listele();

}
