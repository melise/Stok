package stok.entities;

public class Field 
{
	String ad;
	String soyad;
	long TCKimlik;
	int yas;
	public Field()
	{
		
	}
	public Field(String ad, String soyad, long tCKimlik, int yas) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		TCKimlik = tCKimlik;
		this.yas = yas;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public long getTCKimlik() {
		return TCKimlik;
	}
	public void setTCKimlik(long tCKimlik) {
		TCKimlik = tCKimlik;
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}

}
