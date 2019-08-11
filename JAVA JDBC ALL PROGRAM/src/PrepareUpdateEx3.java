//Example on PreparedStatement With Dynamic Update Query .
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PrepareUpdateEx3 {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
			
			//creating pst object with a pre-compiled Update query
			PreparedStatement pst=con.prepareStatement("update Employee set sal = sal +? , job = ? where id = ? ");
			Scanner in =new Scanner(System.in);
			System.out.println("Enter Empid to Update");
			int a = in.nextInt();
			System.out.println("Enter new Job");
			String s = in.next();
			System.out.println("Enter Increament Ammount");
			Double d = in.nextDouble();
			
			pst.setInt(3, a);
			pst.setDouble(1, d);
			pst.setString(2,s);
			System.out.println(pst.executeUpdate());
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}

	}

}
