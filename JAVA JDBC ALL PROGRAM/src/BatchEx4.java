/* example on batch update with diffrent types of queries.
  
  > Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 */
import java.sql.*;

public class BatchEx4 {

	public static void main(String[] args)throws SQLException , ClassNotFoundException , BatchUpdateException {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
     Statement st=con.createStatement();
     //Adding Different types of queries to st Batch
    // st.addBatch("select * from Employee");
     st.addBatch("insert into books values(333,'perl','KK',500)");
     st.addBatch("update books set price=price+50 where id =123");
     st.addBatch("delete books where id=234");
     //Submitting batch to DataBase
     st.executeBatch();
     System.out.println("Batch Completed");
     st.close();
     con.close();
	}

}
