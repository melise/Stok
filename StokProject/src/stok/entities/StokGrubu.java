package stok.entities;

public class StokGrubu
{
	int StokGrubuId;
	String StokGrubuAdi;
	boolean Durumu;
	int Sira;
	
	public StokGrubu()
	{
	}
	public StokGrubu(int stokGrubuId, String stokGrubuAdi, boolean durumu,
			int sira) {
		super();
		StokGrubuId = stokGrubuId;
		StokGrubuAdi = stokGrubuAdi;
		Durumu = durumu;
		Sira = sira;
	}
	public int getStokGrubuId() {
		return StokGrubuId;
	}
	public void setStokGrubuId(int stokGrubuId) {
		StokGrubuId = stokGrubuId;
	}
	public String getStokGrubuAdi() {
		return StokGrubuAdi;
	}
	public void setStokGrubuAdi(String stokGrubuAdi) {
		StokGrubuAdi = stokGrubuAdi;
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
	public String toString()
	{
		return StokGrubuAdi;
	}
	
}
