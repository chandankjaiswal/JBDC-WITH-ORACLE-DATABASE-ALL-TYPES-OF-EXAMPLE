//Example on Select Command with Group Function 
import java.sql.*;
public class SelectEx4 {

	public static void main(String[] args) {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
    	Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select sum(sal), max(sal), min(sal), count(*) from Employee");
    	//if(rs.next()==true) //ITS MOVES CURSOR TO 1ST ROW
    			{
    				rs.next();//moving cursor to 1st row
    				System.out.println("S_Sum\tS_Max\tS_Min\tcount");
    				System.out.println("--\t----\t---\t------");
    				System.out.println(rs.getDouble(1)+"\t"+rs.getDouble(2)+"\t"+rs.getDouble(3)+"\t"+rs.getDouble(4));

    			}
    
    	st.close();
    	con.close();
	    }
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}
}

}
