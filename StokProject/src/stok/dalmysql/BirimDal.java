package stok.dalmysql;

import java.util.ArrayList;
import java.sql.*;

import javax.swing.JOptionPane;

import stok.entities.Birim;
import stok.entities.StokGrubu;
import stok.entities.Urun;
import stok.interfacesDal.IBirimDal;

public class BirimDal implements IBirimDal
{

	@Override
	public boolean Kaydet(Birim birim) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Sil(int BirimId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Güncelle(int BirimId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Birim> Listele()
	{
		ArrayList<Birim> birimler=new ArrayList<Birim>();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost/stok","root","1234");
			String sql="select * from birim order by BirimAdi";
			PreparedStatement psmt=baglanti.prepareStatement(sql);
			ResultSet rs= psmt.executeQuery();
			while(rs.next())
			{
				Birim birim=new Birim();
				birim.setBirimId(rs.getInt("BirimId"));
				birim.setBirimAdi(rs.getString("BirimAdi"));
				birim.setSira(rs.getInt("Sira"));
				birim.setDurumu(rs.getBoolean("Durumu"));
				birimler.add(birim);
			}
			
			
			
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"Hata(BirimDal):"+e.getMessage());
		}
		
		return birimler;
		
		

	}

	

}
