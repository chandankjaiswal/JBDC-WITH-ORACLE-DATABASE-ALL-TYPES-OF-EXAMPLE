/* Ex : designing a jdbc application for generating marks report of student in file System.
 
 > Create Table In Oracle Database
 
 create table stu_marks(rollnumber number(5) , name varchar(15), java number(5) , php number(5) , oracle number(5), python number(5));
 
==> Create Procedure for Getting Marks
create or replace procedure get_marks(rno IN int , n OUT varchar , j OUT int , p OUT int , o OUT int , py OUT int) as
begin
select name,java,php,oracle,python INTO n,j,p,o,py from stu_marks where rollnumber=rno;
end;
/

 */
import java.sql.*;
import java.io.PrintStream;
import java.io.IOException;
import java.util.*;
import java.util.Calendar;
public class CallableEx5 {

	public static void main(String[] args) {
		try
	     {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
	    	 //creating a object & initialize with a procedure call
	    	 CallableStatement cst = con.prepareCall("begin get_marks(?,?,?,?,?,?);end;");
	    	 int rno,j,p,o,py,tot,r;
	    	 double avg;
	    	 String grade;
	    	 
	    	 System.out.println("Enter roll Number to Search");
	    	 rno=new java.util.Scanner(System.in).nextInt();
	    	 
	    	 //binding and Registering ?'s
	    	 
	    	 cst.setInt(1, rno);
	    	 cst.registerOutParameter(2, Types.VARCHAR);
	    	 cst.registerOutParameter(3, Types.INTEGER);
	    	 cst.registerOutParameter(4, Types.INTEGER);
	    	 cst.registerOutParameter(5, Types.INTEGER);
	    	 cst.registerOutParameter(6, Types.INTEGER);
	    	 
	    	 //Submitting call for executing procedure
	    	 cst.execute();
	    	 //getting data from OUT ?
	    	 j=cst.getInt(3);
	    	 p=cst.getInt(4);
	    	 o=cst.getInt(5);
	    	 py=cst.getInt(6);
	    	 
	    	 //calculating total, average, and grade
	    	 tot=j+p+o+py;
	    	 avg=tot/4.0;
	    	 r=(int)avg/10;
	    	 
	    	 switch(r)
	    	 {
	    	 case 10:
	    	 case 9:
	    	 case 8: grade="A+";
	    	 break;
	    	 
	    	 case 7: grade="A";
	    	 break;
	    	 
	    	 case 6: grade="B+";
	    	 break;
	    	 
	    	 case 5: grade="B";
	    	 break;
	    	 
	    	 case 4: grade="C";
	    	 break;
	    	 
	    	 default : grade="Fail";
	    
	    	 }
	    	 
      //printStream ps = new printStream(System.out); OR
	    	 //Creating
	    	 PrintStream ps = new PrintStream("E:\\Core Java\\"+rno+".dat");
	    	 //Craeting a date object and init. with system date and time 
	    	 Calendar date = Calendar.getInstance();
	    	 //Starts writting data into a file
	    	 ps.println("------------------------------------------------------------------------------------------------");
	    	 ps.println("\t\t\tNaresh IT");
	    	 ps.println("\t\t\tMarks Report");
	    	 ps.println("------------------------------------------------------------------------------------------------");
             ps.println("\tRollNo:"+rno);
             ps.println("\t\tDate :"+date.getTime());
             ps.println("\tName :"+cst.getString(2));
             ps.println("\tJava\t\tPHP\t\tOracle\t\tPython");
	    	 ps.println("------------------------------------------------------------------------------------------------");
             ps.println("\t"+j+"\t\t"+p+"\t\t"+o+"\t\t"+py);
             ps.println("\tTotal :"+tot);
	    	 ps.println("\tAverage :"+avg);
	    	 ps.println("\tGrade :"+grade);
	    	 ps.println("------------------------------------------------------------------------------------------------");
	    	 System.out.println("Result Printed Successfully Checked Ur Location");
             ps.close(); //saving file
             cst.close();
             con.close();
             
	}
		catch(SQLException | ClassNotFoundException | IOException e)
		{
			System.out.println(e);
		}
	}
}
