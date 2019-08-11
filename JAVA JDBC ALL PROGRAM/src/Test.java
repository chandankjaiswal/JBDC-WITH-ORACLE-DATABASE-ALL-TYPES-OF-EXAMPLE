//
import java.sql.*;
public class Test {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Employee");
	
	//	System.out.println(rs);
    	while(rs.next()==true) //Moving cursor record by record
    	{
    		System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("job")+"\t"+rs.getDouble("sal"));

    	}
		rs.close();
		st.close();
		con.close();
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}

	}

}
