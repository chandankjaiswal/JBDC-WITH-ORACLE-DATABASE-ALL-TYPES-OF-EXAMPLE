/*
==> Designing a jdbc application for calling the above peocedure

> Create Table In Oracle Database
 
 create table stu_marks(rollnumber number(5) , name varchar(15), java number(5) , php number(5) , oracle number(5), python number(5));
 
 ==> Designing Procedure For Inserting a record
  
  Create or replace Procedure insert_marks(a IN int , b IN varchar , c IN int , d IN int , e IN int , f IN int)as
  begin
  insert into stu_marks values(a,b,c,d,e,f);
  end insert_marks;
  /
 
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class CallableEx2 {

	public static void main(String[] args) {
		try
	     {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
	    	 CallableStatement cst = con.prepareCall("{call insert_marks(?,?,?,?,?,?)}");
	    	 //binding IN Type ?'s
	    	 
	    	 cst.setInt(1,88);
	    	 cst.setString(2,"Sanjay");
	    	 cst.setInt(3,67);
	    	 cst.setInt(4,68);
	    	 cst.setInt(5,70);
	    	 cst.setInt(6,87);
	    	 //submitting call for executing procedure
	    	 cst.execute();
	    	 
	    	 cst.setInt(1,66);
	    	 cst.setString(2,"Anshul");
	    	 cst.setInt(3,75);
	    	 cst.setInt(4,66);
	    	 cst.setInt(5,70);
	    	 cst.setInt(6,80);
	    	 //submitting call for executing procedure
              cst.execute();

	    	 cst.setInt(1,99);
	    	 cst.setString(2,"Rajnish");
	    	 cst.setInt(3,78);
	    	 cst.setInt(4,72);
	    	 cst.setInt(5,81);
	    	 cst.setInt(6,90);
	    	 //submitting call for executing procedure
	    	 cst.execute();
	    	 
	    	 System.out.println("Row Inserted");
	    	 cst.close();
	    	 con.close();
	}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
}
