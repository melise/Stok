package stok.entities;

import javax.swing.JOptionPane;

public class Kullanici 
{
	int KullaniciId;
	String KullaniciAdi;
	String KullaniciSoyadi;
	long KimlikNo;
	String Parola;
	String CepTelNo;
	String Email;
	String Adres;
	boolean Durumu;
	public Kullanici(){
		
	}
	public Kullanici(int kullaniciId, String kullaniciAdi,
			String kullaniciSoyadi, long kimlikNo, String parola,
			String cepTelNo, String email, String adres, boolean durumu) {
		super();
		KullaniciId = kullaniciId;
		KullaniciAdi = kullaniciAdi;
		KullaniciSoyadi = kullaniciSoyadi;
		KimlikNo = kimlikNo;
		Parola = parola;
		CepTelNo = cepTelNo;
		Email = email;
		Adres = adres;
		Durumu = durumu;
	}
	public int getKullaniciId() {
		return KullaniciId;
	}
	public void setKullaniciId(int kullaniciId) {
		KullaniciId = kullaniciId;
	}
	public String getKullaniciAdi() {
		return KullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		KullaniciAdi = kullaniciAdi;
	}
	public String getKullaniciSoyadi() {
		return KullaniciSoyadi;
	}
	public void setKullaniciSoyadi(String kullaniciSoyadi) {
		KullaniciSoyadi = kullaniciSoyadi;
	}
	public long getKimlikNo() {
		return KimlikNo;
	}
	public void setKimlikNo(long kimlikNo) {
		KimlikNo = kimlikNo;
	}
	public String getParola()
	{
		return Parola;	
		
	}
	public void setParola(String parola) {
		Parola =parola;
	}
	public String getCepTelNo() {
		return CepTelNo;
	}
	public void setCepTelNo(String cepTelNo) {
		CepTelNo = cepTelNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAdres() {
		return Adres;
	}
	public void setAdres(String adres) {
		Adres = adres;
	}
	public boolean isDurumu() {
		return Durumu;
	}
	public void setDurumu(boolean durumu) {
		Durumu = durumu;
	}
	
	
}
