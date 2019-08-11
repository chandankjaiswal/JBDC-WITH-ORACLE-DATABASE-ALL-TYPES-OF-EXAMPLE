import java.sql.*;
import java.util.Scanner;
public class DeleteQue {

	public static void main(String[] args) throws ClassNotFoundException {
        try
        {
        	//loading to oracle db
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
          //System.out.println(con);
			//Creating Statement objects
			Statement st = con.createStatement();
			//System.out.println(st);
			
			//taking input from user
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter empid to Delete");
			int a=sc.nextInt();
			
			//Preparing query
			
			String q="delete Employee where id="+a;
			//Submitting query to database
			int count=st.executeUpdate(q);
			System.out.println(count==0 ? "Data Not Deleted" : "Data Deletion Done");
			//clearing objects
			st.close();
			con.close();
         }
           catch(SQLException e2)
		  {
		  System.out.println(e2);
        }
	}
}
	
	

        
	


