import java.sql.*;
import java.util.Scanner;
public class InsertQue {

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
			System.out.println("Enter id,name,job and Salary details");
			int a=sc.nextInt();
			String b=sc.next();
			String c=sc.next();
			Double d=sc.nextDouble();
			
			//Preparing query
			
			String q="insert into Employee value("+a+",'"+b+"','"+c+"',"+d+")";
			//Submitting query to database
			int count=st.executeUpdate(q);
			System.out.println(count+ "Row(s) Inserted");
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
	
	

        
	


