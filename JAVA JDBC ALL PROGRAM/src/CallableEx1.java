//Example on to call a procedure by using callableStstement 

// Create Procedure 
/* 
 CREATE OR REPLACE PROCEDURE add(int x , int y) AS
 begin
 dbms_output.put_line('Sum is || (x + y));
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;

public class CallableEx1 {

	public static void main(String[] args) {
     try
     {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
    	 //creating cst object and initialize with a procedure call
    	 CallableStatement cst = con.prepareCall("{call add2(?,?,?)}");
    	 System.out.println(cst);
    	 //binding IN Type ?'s
    	 cst.setInt(1, 10);
    	 cst.setInt(2, 30);
    	 
    	 //registering OUT Type ?'s
    	 cst.registerOutParameter(3, Types.INTEGER);
    	 
    	 //Submiting data from OUT ?'s
    	System.out.println("Sum is"+ cst.getInt(3));
    	cst.close();
    	con.close();
    	 
     }
     catch(SQLException | ClassNotFoundException e)
     {
    	 System.out.println(e);
     }
	}

}
