/* Example on to class object into from external resource 
 
 > Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 
===>  #Defining db Properties
 drive=oracle.jdbc.driver.OracleDriver
 URL=jdbc:oracle:thin:@localhost:1523:orcl
 User=scott
 Pword=tiger
 
 #saves this with the name of "db.properties". and keep this file in current location.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.sql.*;

public class PropertiesExJdbc {

	public static void main(String[] args) {

		try
		{
		String a,b,c,d;
		//1st approach
		FileInputStream f=new FileInputStream("db.Properties");
		Properties ob=new Properties();
		ob.load(f);
		a=ob.getProperty("driver");
		b=ob.getProperty("url");
		c=ob.getProperty("user");
		d=ob.getProperty("pword");

		//loading driver and connecting to database with collected detailes from PropertiesFile
		Class.forName(a);
		Connection con=DriverManager.getConnection(b,c,d);
		ResultSet rSet =con.createStatement().executeQuery("select * from books");
		while(rSet.next())
			{
			System.out.println(rSet.getString(1)+"\t"+rSet.getString(2)+"\t"+rSet.getString(3)+"\t"+rSet.getString(4));
			}
		   con.close();
		}
		catch(ClassNotFoundException | SQLException | IOException e)
		{
			System.out.println(e);
}
	}
}