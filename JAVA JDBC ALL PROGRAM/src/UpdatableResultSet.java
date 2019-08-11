/* Example on a JDBC application with Updatable ResultSet 
 
> Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 */
import java.sql.*;
public class UpdatableResultSet {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		//creating st/pst object with SCROLL @ UPDATABLE support
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//OR
		//PreparedStatement pst=con.prepareStatement("select id,name,author,price from books",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select books.* from books");
		//inserting record
		rs.moveToInsertRow();//Allocating memory for new row
		rs.updateInt(1, 808);
		rs.updateString(2, "ase");
		rs.updateString(3, "kk");
		rs.updateInt(4, 590);
		rs.insertRow();
		System.out.println("Inserted");
		//updating a record
		if(rs.absolute(5))
		{
			rs.updateRow();//Commiting
			System.out.println("Updated");
		}
		
	}

}
