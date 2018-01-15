package stok.entities;

public class Birim 
{
	int BirimId;
	String BirimAdi;
	boolean Durumu;
	int Sira;
	public Birim()
	{	
	}
	public int getBirimId() {
		return BirimId;
	}
	public void setBirimId(int birimId) {
		BirimId = birimId;
	}
	public String getBirimAdi() {
		return BirimAdi;
	}
	public void setBirimAdi(String birimAdi) {
		BirimAdi = birimAdi;
	}
	public boolean isDurumu() {
		return Durumu;
	}
	public void setDurumu(boolean durumu) {
		Durumu = durumu;
	}
	public int getSira() {
		return Sira;
	}
	public void setSira(int sira) {
		Sira = sira;
	}
	public Birim(int birimId, String birimAdi, boolean durumu, int sira) {
		super();
		BirimId = birimId;
		BirimAdi = birimAdi;
		Durumu = durumu;
		Sira = sira;
	}
	public String toString()
	{
		return BirimAdi;
	}
	
}

