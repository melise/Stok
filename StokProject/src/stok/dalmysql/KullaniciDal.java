package stok.dalmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import stok.entities.Kullanici;
import stok.entities.StokGrubu;
import stok.interfacesDal.IKullaniciDal;

public class KullaniciDal implements IKullaniciDal
{

	

	@Override
	public boolean Kaydet(Kullanici kl) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Sil(int KullaniciId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Guncelle(int KullaniciId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Kullanici> Listele()
	{
		 ArrayList<Kullanici> kullanicilar=new ArrayList<Kullanici>();
			
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost/stok","root","1234");
				String sql="select * from kullanici order by KullaniciAdi";
				PreparedStatement stmt=baglanti.prepareStatement(sql);
				ResultSet rs= stmt.executeQuery();
				while(rs.next())
				{
					Kullanici kullanici=new Kullanici();
					kullanici.setKullaniciId(rs.getInt("KullaniciId"));
					kullanici.setKullaniciAdi(rs.getString("KullaniciAdi"));
					kullanici.setKullaniciSoyadi(rs.getString("KullaniciSoyadi"));
					kullanici.setKimlikNo(rs.getLong("TCKimlikNo"));
					kullanici.setParola(rs.getString("Parola"));
					kullanici.setCepTelNo(rs.getString("CepTelNo"));
					kullanici.setEmail(rs.getString("Email"));
					kullanici.setAdres(rs.getString("Adres"));
					kullanici.setDurumu(rs.getBoolean("Durumu"));
					kullanicilar.add(kullanici);
				}
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null,"Hata(StokGrubuDal):"+e.getMessage());
			}
			return kullanicilar;
	}

	@Override
	public Kullanici Getir(int KullaniciId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean KullaniciKontrol(String kullaniciAdi, String parola)
	{
		Connection baglanti=Baglanti.Baglan();
		
		try 
		{
			String sql="select KullaniciId from kullanici where TCKimlikNo=? and parola=?";
			PreparedStatement psmt=baglanti.prepareStatement(sql);
			psmt.setString(1,kullaniciAdi);
			psmt.setString(2, parola);
			ResultSet rs=psmt.executeQuery();
			return rs.next();
			
			
		} 
		catch (SQLException e) 
		{
			return false;
		}
	}

	
	

}
