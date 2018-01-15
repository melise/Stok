package stok.dalmysql;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;





import stok.entities.StokGrubu;
import stok.entities.Urun;
import stok.interfacesDal.IUrunDal;

public class UrunDal implements IUrunDal
{
	Connection baglanti;
	public UrunDal() 
	{
		baglanti=Baglanti.Baglan();
	}

	@Override
	public void Kaydet(Urun urun) 
	{
		try 
		{
			
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost/stok","root","1234");
			String sql="insert into urun"
					+ "(UrunAdi,StokGrubuId,BirimId,"
					+ "KullaniciId,AlisFiyati,SatisFiyati,"
					+ "BarkodNo,Durumu,KritikStokSayisi)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt=baglanti.prepareStatement(sql);
			psmt.setString(1,urun.getUrunAdi());
			psmt.setInt(2,urun.getUrunGrubuId());
			psmt.setInt(3,urun.getBirimId());
			psmt.setInt(4,urun.getUrunGrubuId());
			psmt.setFloat(5, urun.getAlisFiyati());
			psmt.setFloat(6,urun.getSatisFiyati());
			psmt.setString(7,urun.getBarodNo());
			psmt.setBoolean(8, urun.isAktif());
			psmt.setInt(9,urun.getKritikStokSayisi());
			
			psmt.executeUpdate();		
			
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Kayýt Basarýsýz.Hata:"+e.getMessage());
		}
	}

	@Override
	public boolean Sil(int urunId) 
	{
		//Connection baglanti=Baglanti.Baglan();
		try 
		{
			String sql="delete from urun where UrunId=?";
			PreparedStatement psmt;
			psmt = baglanti.prepareStatement(sql);
			psmt.setInt(1,urunId);
			
			int satir=psmt.executeUpdate();
			
			return satir>0 ? true:false;
		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean Guncelle(int urunId)
	{
		
		return false;
	}

	@Override
	public ArrayList<Urun> Listele() 
	{
		ArrayList<Urun> urunler=new ArrayList<Urun>();
		try 
		{
			//Class.forName("com.mysql.jdbc.Driver");//mysql driver yuklenmesi
			//String url="jdbc:mysql://localhost/stok";//Sunucu yolunun belirlenmesi,farklý portlarda belirtmek zorunlu
			//String userName="root";//veritabani/sunucu kullnýcý adý
			//String psw="1234";//veritabani/sunucu parola					
			
			//Connection baglanti=DriverManager.getConnection(url, userName, psw); 
			
			String sql="select g.StokGrubuAdi , u.* from urun u " +
              "left outer join stokgrubu g on (g.StokGrubuId=u.StokGrubuId) "+
               "order by UrunAdi";
			
			PreparedStatement psmt=baglanti.prepareStatement(sql);
			
			ResultSet rs=psmt.executeQuery();
			
			while(rs.next())
			{
				Urun urun=new Urun();
				StokGrubu stokGrubu=new StokGrubu();
				stokGrubu.setStokGrubuId(rs.getInt("StokGrubuId"));
				stokGrubu.setStokGrubuAdi(rs.getString("StokGrubuAdi"));
				
				
				urun.setUrunAdi(rs.getString("UrunAdi"));
				urun.setUrunId(rs.getInt("UrunId"));
				urun.setAlisFiyati(rs.getFloat("AlisFiyati"));
				urun.setSatisFiyati(rs.getFloat("SatisFiyati"));
				urun.setAktif(rs.getBoolean("Durumu"));
				urun.setBarodNo(rs.getString("BarkodNo"));
				urun.setMevcutStok(rs.getInt("MevcutStokSayisi"));
				urun.setUrunGrubuId(rs.getInt("StokGrubuId"));
				urun.setStokGrubu(stokGrubu);
				
				
				urunler.add(urun);
			}
			
			
			
			
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Hata(UrunDal):"+e.getMessage());
		}
		
		
		return urunler;
	}

	@Override
	public Urun Getir(int urunId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Urun Getir(String barkodNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
