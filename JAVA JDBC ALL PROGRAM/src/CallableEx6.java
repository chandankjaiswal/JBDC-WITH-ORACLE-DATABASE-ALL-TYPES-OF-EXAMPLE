/* Ex. :Designing a jdbc application for calling above function.
 
 ==> Designing a Function
 create or replace function sum2(x int , y int) return int is
 begin
 return x+y;
 end;
 /
  
 */ 
import java.sql.*;
import java.util.*;
public class CallableEx6 {

	public static void main(String[] args) {
     try
     {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
    	 ResultSet rs=con.createStatement().executeQuery("select sum2(10,20)from dual");
    	 //OR
    	 //Creating cst object & init with a function call 
    	 CallableStatement cst= con.prepareCall("{call ?:=sum2(?,?)}");
    	 Scanner in =new Scanner(System.in);
    	 System.out.println("Enter the value of x and y");
    	int x=in.nextInt();
    	int y =in.nextInt();
    	//binding and registering ?'s
    	cst.setInt(2, x);
    	cst.setInt(3, y);
    	cst.registerOutParameter(1,Types.INTEGER);
    	//Submitting call for executing function.
    	cst.execute();
    	//getting data from OUT ?
    	System.out.println("Sum is "+cst.getInt(1));
    	cst.close();
    	con.close();
	}
     catch(SQLException | ClassNotFoundException e)
     {
    	 System.out.println(e);
     }

}
}
