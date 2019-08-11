/* Example on Simple Transaction Management in JDBC .
 
  > Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 
 */
import java.sql.*;
public class TransactionDemo {

	public static void main(String[] args)throws SQLException , ClassNotFoundException , BatchUpdateException {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
	     //Disabling autocommit
	     con.setAutoCommit(false);//by default it's true.
	     //preparing batch
	     Statement st=con.createStatement();
	     //Adding Different types of queries to st Batch
	    // st.addBatch("select * from Employee");
	     st.addBatch("insert into books values(346,'JSP','mike',550)");
	     st.addBatch("update books set price=price+50 ");
	     st.addBatch("delete books where id=345");
	     //run the batch & get status of queries into an array
	     int a[]=st.executeBatch();
	     
	     int flag=0;
	     for(int t : a)
	     {
	    	 if(t==0)
	    	 {
	    		 flag=1;
	    		 break;
	    	 }
	     }
	     if(flag==1)
	     {
	    	 con.commit();//save all the database operation
	    	 System.out.println("Transaction Success");
	     }
	     else
	     {
	    	 System.out.println("Transaction Failed");
	    	 st.close();
	    	 con.close();
	     }
	     
	}

}
