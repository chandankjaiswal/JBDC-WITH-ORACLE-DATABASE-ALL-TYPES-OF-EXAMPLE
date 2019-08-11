/* Ex : designing jdbc application for calling the above procedure/ searching and Updating
     > Create Table In Oracle Database
 
 create table stu_marks(rollnumber number(5) , name varchar(15), java number(5) , php number(5) , oracle number(5), python number(5));
 
 ==> Creating Procedure for Updating Record 
 Create or Replace Procedure Update_marks(rno IN int , m IN int , c OUT int)as
 begin
 update stu_marks set php=m where rollnumber=rno;
 c:sql%rowCount;
 end Update_marks;
 /
 */
import java.sql.*;
public class CallableEx4 {

	public static void main(String[] args) {
		try
	     {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
	    	 //creating a object & initialize with a procedure call
	    	 CallableStatement cst = con.prepareCall("{call update_marks(?,?,?)}");
	    	 System.out.println("Enter the Roll Number to Update");
	    	 int n=new java.util.Scanner(System.in).nextInt();
	    	 System.out.println("Enter the New marks");
	    	 int m=new java.util.Scanner(System.in).nextInt();
	    	 //binnding and registering IN OUT Type ?
	    	 
	    	 cst.setInt(1, n);
	    	 cst.setInt(2, m);
	    	 
	    	 cst.registerOutParameter(3, Types.INTEGER);
	    	 
	    	 //Submitting call for executing procedure
	    	 
	    	 cst.execute();
	    	 //getting count from OUT
	    	 
	    	 System.out.println(cst.getInt(3)+"Row Updated");
	    	 cst.close();
	    	 con.close();
	}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
}
