//Example on Select Command with Arithmetic Operation 
import java.sql.*;
public class SelectEx5 {

	public static void main(String[] args) {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
    	Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select Marks.*; C+CPP+JAVA, total , (C+CPP+JAVA)/3 avge from Marks");
    	//if(rs.next()==true) //ITS MOVES CURSOR TO 1ST ROW
        {
    	rs.next();//moving cursor to 1st row
    	System.out.println("S_Sum\tS_Max\tS_Min\tcount");
    	System.out.println("--\t----\t---\t------");
    	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t");
        System.out.println("rs.getDouble(7)");        
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
