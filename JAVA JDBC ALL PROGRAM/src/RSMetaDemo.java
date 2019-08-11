/* Example on ResultSetMetaData
 
 > Creating Table
 
 create table Empl(id number(4), name varchar(15), joindate date , job varchar(15), sal number(9,2),photo blob);
 */
 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class RSMetaDemo {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		//getting md object
		ResultSet rSet=con.createStatement().executeQuery("select * from Empl");
		ResultSetMetaData md=rSet.getMetaData();
		int c=md.getColumnCount();
		System.out.println("on of columns "+c);
		//getting columns details
		for(int i=1;i<=c;i++)
		{
			System.out.printf("%10s", md.getColumnName(i));
			System.out.printf("%10s", md.getColumnTypeName(i));
			System.out.printf("%10s",md.getPrecision(i));
			System.out.printf("%10s\n",md.getScale(i));
			
		}
    
	}

}
