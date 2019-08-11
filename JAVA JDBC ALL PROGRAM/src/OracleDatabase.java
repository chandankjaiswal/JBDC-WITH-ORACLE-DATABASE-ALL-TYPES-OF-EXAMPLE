//Example on Connecting Oracle Database (By Using Type 4 Driver).
import java.sql.*;
//import java.sql.Connection;

public class OracleDatabase {

	public static void main(String[] args) {
		{
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Ready\2");

			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
			System.out.println(con);
			System.out.println("Connection done\2");
			}
			catch(ClassNotFoundException e1)
			{
			System.out.println("Driver not found");
			}
			catch(SQLException e2)
			{
			System.out.println(e2);
			}
			}
			}

	}

