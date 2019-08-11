//Example on Select Command For Retrieving data by Using ResutSet(2nd Approach)
import java.sql.*;
public class SelectEx2 {

	public static void main(String[] args) {
    try
    {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
    	Statement st=con.createStatement();
    	ResultSet rs =st.executeQuery("select * from Employee");
    	//System.out.println(rs);
    	//System.out.println(rs.next());
    	System.out.println("ID\t+Name\t+Job\t+Salary");
    	System.out.println("--\t----\t---\t------");
    	while(rs.next()==true) //Moving cursor record by record
    	{
    		//getting column volumn of CR
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
