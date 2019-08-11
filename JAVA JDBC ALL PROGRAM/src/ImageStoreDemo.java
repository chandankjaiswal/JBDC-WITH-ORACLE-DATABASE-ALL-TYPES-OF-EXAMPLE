/* Example on storing Images into Database JDBC
 
 > Creating Table
 
 create table Empl(id number(4), name varchar(15), joindate date , job varchar(15), sal number(9,2),photo blob);
 */
import java.io.*;
import java.sql.*;
import java.util.*;
public class ImageStoreDemo {

	public static void main(String[] args)throws SQLException, ClassNotFoundException, IOException {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
     PreparedStatement pst=con.prepareStatement("insert into Empl values(?,?,to-date(?,'dd-mon-yyyy'),?,?,?)");
     Scanner scan=new Scanner(System.in);
     System.out.println("Enter Empl id, Name,date(dd-mon-yyyy),job,sal,filename");
     int vid=scan.nextInt();
     String vena=scan.next();
     String vdj=scan.next();
     String vjob=scan.next();
     Double vsal=scan.nextDouble();
     String filename=scan.next();
     
     //binding parameters
     pst.setInt(1, vid);
     pst.setString(2, vena);
     pst.setString(3, vdj);
     pst.setString(4, vjob);
     pst.setDouble(5, vsal);
     
     //loading image into f object for reading 
     FileInputStream f=new FileInputStream(filename);
     //binding file content to ?
     pst.setBinaryStream(6, f,f.available());
     pst.executeUpdate();
     System.out.println("Record Stored Successfully");
     f.close();
     pst.close();
     con.close();
     
	}

}
