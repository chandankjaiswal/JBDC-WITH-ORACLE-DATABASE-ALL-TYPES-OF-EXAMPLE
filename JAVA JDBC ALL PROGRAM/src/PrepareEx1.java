//Example on PreparedStatement With Dynamic insert query 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class PrepareEx1 {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
			
			//creating pst object with a pre-compiled insert query
			PreparedStatement pst=con.prepareStatement("insert into Employee values(?,?,?,?)");
			System.out.println(pst);
			
			//binding values to ?s.
			pst.setInt(1, 4);
			pst.setString(2,"Dhiraj");
			pst.setString(3, "Business Man");
			pst.setDouble(4, 60000);
			
			//Submitting pst's query per execution
			
			int c = pst.executeUpdate();
			System.out.println(c);
			
			//2nd Record
			
			/*pst.setInt(5, 99);
			pst.setString(6,"Dhiraj");
			pst.setString(7, "Business Man");
			pst.setDouble(8, 60000);
			
			//Submitting pst's query per execution
			
			int d = pst.executeUpdate();
			System.out.println(d); */
			
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}

	}

}
