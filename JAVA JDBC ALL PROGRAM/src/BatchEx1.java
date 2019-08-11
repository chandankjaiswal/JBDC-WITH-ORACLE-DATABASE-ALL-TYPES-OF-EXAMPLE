//Example on BatchUpdates By Using Statement 
import java.sql.*;
public class BatchEx1
{
	public static void main(String args[])throws SQLException,ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		//creating static batch
		Statement st=con.createStatement();
		//adding queries to st batch
		st.addBatch("create table books(id number(5),name varchar(15),auther varchar(15),price number(5))");
		st.addBatch("insert into books values(101,'C','DR',350)");
		st.addBatch("insert into books values(102,'JAVA','JG',450)");
		st.addBatch("insert into books values(101,'CPP','BR',300)");
// Submitting batch to database
		st.executeBatch();
		System.out.println("Batch Completed");
		st.clearBatch();//removing all queries from st batch
	st.close();
	con.close();
		
		
	}
}