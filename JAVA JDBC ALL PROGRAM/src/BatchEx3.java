/* Ex. :Example on BatchInsert dynamically By Using PreparedStatement .
 > Create Table
 create table books(id number(5),name varchar(15),auther varchar(15),price number(5);
 */
import java.io.*;  
import java.sql.*;
public class BatchEx3 {

	public static void main(String[] args) {
		try{  
			  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");  
			  
			PreparedStatement pst=con.prepareStatement("insert into books values(?,?,?,?)");  
			  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			while(true){  
			  
			System.out.println("enter id");  
			String s1=br.readLine();  
			int id=Integer.parseInt(s1);  
			  
			System.out.println("enter name");  
			String name=br.readLine();  
			  
			System.out.println("enter Auther Name");  
			String auther=br.readLine();  
			//in salary=Integer.parseInt(s3);  
			  
			System.out.println("enter price");  
			String s4=br.readLine();  
			int price=Integer.parseInt(s4);  
			  
			pst.setInt(1,id);  
			pst.setString(2,name);  
			pst.setString(3,auther); 
			pst.setInt(4, price);
			
			  
			pst.addBatch();  
			System.out.println("Want to add more records y/n");  
			String ans=br.readLine();  
			if(ans.equals("n")){  
			break;  
			}  
			  
			}  
			pst.executeBatch();  
			  
			System.out.println("record successfully saved");  
			  
			con.close();  
			}
		catch(Exception e)
		{
			System.out.println(e);
		}  
			  
			}}  
	