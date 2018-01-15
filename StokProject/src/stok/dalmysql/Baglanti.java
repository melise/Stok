package stok.dalmysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Baglanti 
{
	public static Connection Baglan()
	{
		Connection baglanti=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			baglanti=DriverManager.getConnection("jdbc:mysql://localhost/stok","root","1234");
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
		return baglanti;
	
	}

}
