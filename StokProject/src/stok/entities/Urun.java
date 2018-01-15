package stok.entities;

public class Urun 
{
	//Entity dikine kesme her yerde kullanýldý
//private deðiþkenleri kullanmaya kapsulleme denir
	int UrunId;
	 String UrunAdi;
     String BarodNo;
     float MevcutStok;
	 int UrunGrubuId;
	 int BirimId;
	 int KullaniciId;
	 int KritikStokSayisi;
	 float AlisFiyati;
	 float SatisFiyati;
	 boolean Aktif;
	 StokGrubu stokGrubu;
	 
	 public Urun()
	 {
	 }
	 
	

	public int getKullaniciId() {
		return KullaniciId;
	}



	public void setKullaniciId(int kullaniciId) {
		KullaniciId = kullaniciId;
	}



	public int getKritikStokSayisi() {
		return KritikStokSayisi;
	}



	public void setKritikStokSayisi(int kritikStokSayisi) {
		KritikStokSayisi = kritikStokSayisi;
	}



	public int getUrunId() {
		return UrunId;
	}



	public void setUrunId(int urunId) {
		UrunId = urunId;
	}



	public String getUrunAdi() {
		return UrunAdi;
	}



	public void setUrunAdi(String urunAdi) {
		UrunAdi = urunAdi;
	}



	public String getBarodNo() {
		return BarodNo;
	}



	public void setBarodNo(String barodNo) {
		BarodNo = barodNo;
	}



	public float getMevcutStok() {
		return MevcutStok;
	}



	public void setMevcutStok(float mevcutStok) {
		MevcutStok = mevcutStok;
	}



	public int getUrunGrubuId() {
		return UrunGrubuId;
	}



	public void setUrunGrubuId(int urunGrubuId) {
		UrunGrubuId = urunGrubuId;
	}



	public int getBirimId() {
		return BirimId;
	}



	public void setBirimId(int birimId) {
		BirimId = birimId;
	}



	public float getAlisFiyati() {
		return AlisFiyati;
	}



	public void setAlisFiyati(float alisFiyati) {
		AlisFiyati = alisFiyati;
	}



	public float getSatisFiyati() {
		return SatisFiyati;
	}



	public void setSatisFiyati(float satisFiyati) {
		SatisFiyati = satisFiyati;
	}



	public boolean isAktif() {
		return Aktif;
	}



	public void setAktif(boolean aktif) {
		Aktif = aktif;
	}






	public Urun(int urunId, String urunAdi, String barodNo, float mevcutStok,
			int urunGrubuId, int birimId, int kullaniciId,
			int kritikStokSayisi, float alisFiyati, float satisFiyati,
			boolean aktif, StokGrubu stokGrubu) {
		super();
		UrunId = urunId;
		UrunAdi = urunAdi;
		BarodNo = barodNo;
		MevcutStok = mevcutStok;
		UrunGrubuId = urunGrubuId;
		BirimId = birimId;
		KullaniciId = kullaniciId;
		KritikStokSayisi = kritikStokSayisi;
		AlisFiyati = alisFiyati;
		SatisFiyati = satisFiyati;
		Aktif = aktif;
		this.stokGrubu = stokGrubu;
	}



	public StokGrubu getStokGrubu() {
		return stokGrubu;
	}

	public void setStokGrubu(StokGrubu stokGrubu) {
		this.stokGrubu = stokGrubu;
	}
	
	 
}
