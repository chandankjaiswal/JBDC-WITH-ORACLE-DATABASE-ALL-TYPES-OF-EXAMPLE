import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class CreateQue
{
public static void main(String args[])
{
try
{
Class.forName("oracle.jdbc.OracleDriver");
System.out.println("Driver Ready\2");

//Loading Sql Database
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
//System.out.println(con);

//Creating statement object

Statement st = con.createStatement();
//System.out.println(st);

//Preparing Query

String q = "Create table Marks(Roll number(5), Name varchar2(20), address varcha2(30), mobile number(10) , Email varchar2(20))";

//Submitting query to db for processing

int c = st.executeUpdate(q);
System.out.println(c);

//clearing objects
st.close();
con.close(); 
}
catch(ClassNotFoundException e1)
{
System.out.println("Driver not found");
}
catch(SQLException e2)
{
System.out.println(e2);
}
}
}
