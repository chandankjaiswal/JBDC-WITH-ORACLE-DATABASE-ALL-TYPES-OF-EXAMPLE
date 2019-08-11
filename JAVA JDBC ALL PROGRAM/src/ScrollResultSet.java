/* Example on a JDBC application which will point records of a table in forward,backward direction and in random retrieve.
> Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 */
import java.sql.*;
public class ScrollResultSet {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		//creating st/pst object with Scroll Support 
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//OR
		//PreparedStatement pst=con.prepareStatement("select * from Employ",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from books");
		System.out.println("Forward Direction");
		System.out.println("---------------------");
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
	}
		System.out.println("Backward Direction");
		System.out.println("---------------------");
		rs.afterLast();
        while(rs.previous())
		{
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
	}
        if(rs.absolute(5))//place cursor 5 record
        {
    		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

        }
      //  rs.relative(3);//point 8th record
        //rs.relative(-2);// point 6th record
        //rs.last();
        //rs.beforeFirst();
        con.close();
        st.close();
	}
}
