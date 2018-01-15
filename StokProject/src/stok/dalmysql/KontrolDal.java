package stok.dalmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import stok.interfacesDal.IKontrol;


public class KontrolDal implements IKontrol
{
	Connection baglanti;
	public KontrolDal() 
	{
		baglanti=Baglanti.Baglan();
		if(TableKontrol("Mel")==true)
		{
			//JOptionPane.showMessageDialog(null,"tablo var.");
		}
		else
		{
			TableEkle("Mel");
			JOptionPane.showMessageDialog(null,"tablo oluþturuldu.");
		}
		
	}

	@Override
	public boolean DatabaseKontrol()
	{
		return false;
		
	}


	@Override
	public boolean DatabaseEkle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void TableEkle(String tabloAdi)
	{
		
		try 
		{
			String sql="CREATE TABLE "+tabloAdi+" ( eposta VARCHAR(128), meslek VARCHAR(128))";
			PreparedStatement psmt;
			psmt = baglanti.prepareStatement(sql);
			psmt.executeUpdate();
			
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "HataTable:"+e.getMessage());
		}
	}

	@Override
	public boolean TableKontrol(String tabloAdi) {
		try 
		{
			String sql="SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE table_name =?";
			PreparedStatement psmt=baglanti.prepareStatement(sql);
			psmt.setString(1,tabloAdi);
			ResultSet rs=psmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				TableEkle(tabloAdi);
				return false;
			}	
			
			
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hata:"+e.getMessage());
			return false;
		}
		
		
		
	}

}
