/* Example on Reading Images From Database into a file(Downloading Images).
 
 
 > Creating Table
 
 create table Empl(id number(4), name varchar(15), joindate date , job varchar(15), sal number(9,2),photo blob);
 */
 
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class ImageReadingDemo {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		ResultSet rSet=con.createStatement().executeQuery("select * from Empl");
		while(rSet.next())
		{
			//getting the col6(image)data into blob object 
			Blob b=rSet.getBlob(6);
			//Creating folder
			new java.io.File("e://ANKIT").mkdir();
         //creating a blank file(image)with a name of employid	
			FileOutputStream f=new FileOutputStream("e://ANKIT"+rSet.getString(1)+"jpg");
			//write byte data into a image file
			f.write(b.getBytes(1,(int)b.length()));
			f.close();//closing(saving) file
		}
		System.out.println("completed");
			con.close();
		}

	}

