//Example on PreparedStatement with Dynamic Select Query. 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class PrepareSelectEx3 {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
			
			//creating pst object with a pre-compiled Update query
			PreparedStatement pst=con.prepareStatement("select * from Employee where job= ? order by desc");
			System.out.println("Enter job to Search");
			String s = new Scanner(System.in).next();
			pst.setString(1, s); //binding
			
			//Submitting query for getting rs object
			ResultSet rs = pst.executeQuery();
			boolean flag=false;
			while(rs.next())//row-by-row
			{
				System.out.println(rs.getRow()+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				flag=true;
			}
			if(flag==false)
			{
				System.out.println("Data Not Found");
			}
		}catch(SQLException | ClassNotFoundException e)
				{
					System.out.println(e);
				}
			}
	
}		
	


