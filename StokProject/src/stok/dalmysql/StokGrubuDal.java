package stok.dalmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import stok.entities.Birim;
import stok.entities.StokGrubu;
import stok.interfacesDal.IStokGrubuDal;

public class StokGrubuDal implements IStokGrubuDal 
{

	@Override
	public boolean Kaydet(StokGrubu stokGrubu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Sil(int StokGrubuId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Guncelle(int StokGrubuId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<StokGrubu> Listele() 
	{
       ArrayList<StokGrubu> gruplar=new ArrayList<StokGrubu>();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost/stok","root","1234");
			String sql="select * from stokgrubu order by StokGrubuAdi";
			PreparedStatement stmt=baglanti.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			while(rs.next())
			{
				StokGrubu stok=new StokGrubu();
				stok.setStokGrubuId(rs.getInt("StokGrubuId"));
				stok.setStokGrubuAdi(rs.getString("StokGrubuAdi"));
				stok.setSira(rs.getInt("Sira"));
				stok.setDurumu(rs.getBoolean("Durumu"));
				gruplar.add(stok);
			}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"Hata(StokGrubuDal):"+e.getMessage());
		}
		return gruplar;
		
	}

	

	
}
