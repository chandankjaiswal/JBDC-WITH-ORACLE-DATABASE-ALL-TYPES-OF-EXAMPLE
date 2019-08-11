//Example on PreparedStatement with Dynamic Delete Query.
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PrepareEx2Delete {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
			
			//creating pst object with a pre-compiled insert query
			PreparedStatement pst=con.prepareStatement("delete Employee where id=?");
			Scanner in =new Scanner(System.in);
			//System.out.println(pst);
			String choice;
			do {
				System.out.println("Enter the empid to Delete");
				int a = in.nextInt();
				//binding values to ?s
				
				pst.setInt(1, a);
				//submitting pst's query for execution
				
				int c =pst.executeUpdate();
				System.out.println(c==0 ? "Not deleted" : "Deleted");
				System.out.println("Do You Want to Continue (y/n)");
				choice=in.next();
			}
			while(choice.equalsIgnoreCase("y"));
		}
			catch(SQLException | ClassNotFoundException e)
			{
				System.out.println(e);
			}
				
			}
	}

