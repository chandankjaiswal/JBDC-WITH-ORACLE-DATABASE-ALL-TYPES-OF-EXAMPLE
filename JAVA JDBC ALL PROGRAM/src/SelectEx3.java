//Example on Select Command For Searching Employee Data
import java.sql.*;
public class SelectEx3 {

	public static void main(String[] args) {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
    	Statement st=con.createStatement();
    	//taking input from user
    	System.out.println("Enter Eid to Search ");
    	int n =new java.util.Scanner(System.in).nextInt();
    	ResultSet rs=st.executeQuery("select * from Employee where id=+n");
    	if(rs.next()==true) //ITS MOVES CURSOR TO 1ST ROW
    			{
    		//getting columns values of CR
    		   System.out.println("Search Results of "+n+"id");
    		   System.out.println("name : " + rs.getString(2));
    		   System.out.println("job : " + rs.getString(3));
    		   System.out.println("Sal : " + rs.getString(4));

    			}
    	else
    	{
    		System.out.println("Data are not Found");
    	}
    	st.close();
    	con.close();
	    }
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}
}

}
