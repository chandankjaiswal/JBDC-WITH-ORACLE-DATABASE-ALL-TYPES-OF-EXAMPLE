//Example On Select Query First Model
import java.sql.*;
public class SelectQue {

	public static void main(String[] args)throws SQLException , ClassNotFoundException
	{
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
     Statement st=con.createStatement();
     int c =st.executeUpdate("select * from Employee");
     System.out.println(st);
     System.out.println(c+"Row(s) Found");
     con.close();
	}

}
