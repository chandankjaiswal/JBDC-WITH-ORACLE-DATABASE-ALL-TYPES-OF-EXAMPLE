/* Ex. :Example on Batch Updates By Using PreparedStatement
  > Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 */

import java.sql.*;
import java.io.*;  

public class BatchEx2 {

	public static void main(String[] args)throws SQLException,ClassNotFoundException {
   
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		PreparedStatement pst=con.prepareStatement("pst.addBatch(insert into books values(?,?,?,?)");

		System.out.println(pst);
		 
				
		//binding values to ?s.
		pst.setInt(1, 222);
		pst.setString(2,"Oracle");
		pst.setString(3, "Sunken Earth");
		pst.setDouble(4, 600);
   
		pst.executeBatch();
		System.out.println("Batch Completed");
        pst.clearBatch();
        pst.close();
        con.close();
		//System.out.println(c);
		
   
    
	}
}
