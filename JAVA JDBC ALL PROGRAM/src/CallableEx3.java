import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.sql.*;
/*   Ex: Designing a jdbc application for calling the above procedure// deleting a record 

 > Create Table In Oracle Database
 
 create table stu_marks(rollnumber number(5) , name varchar(15), java number(5) , php number(5) , oracle number(5), python number(5));
 

  ==> Creating Procedure.
   Create or Replace Procedure delete_marks(rno_c IN OUT int)as
   begin
   delete stu_marks where rollno=rno_c;
   rno_c:=sql%rowCount;
   end delete_marks;
   /
 
 */
public class CallableEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
	     {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
	    	 //creating a object & initialize with a procedure call
	    	 CallableStatement cst = con.prepareCall("{call delete_marks(?)}");
	    	 System.out.println("Enter the roll number to delete");
	    	 int n = new java.util.Scanner(System.in).nextInt();
	    	 //binding and Register IN OUT Type ?
	    	 cst.setInt(1, n);
	    	 cst.registerOutParameter(1, Types.INTEGER);
	    	 //Submitting call for executing procedure 
	    	 cst.execute();
	    	 //getting count from OUT ?
	    	 
	    	 System.out.println(cst.getInt(1)+"Row Deleted");
	    	 cst.close();
	    	 con.close();
	}
   catch(SQLException | ClassNotFoundException e)
		{
	System.out.println(e);
		}	}
}
