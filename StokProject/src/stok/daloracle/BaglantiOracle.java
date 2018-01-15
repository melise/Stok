package stok.daloracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaglantiOracle 
{
	public static Connection Baglan()
	{
		Connection baglanti=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			baglanti=DriverManager.getConnection("jdbc:oracle:thin:@LOCALHOST/xe","STOK","1234");
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
		return baglanti;

}
}
