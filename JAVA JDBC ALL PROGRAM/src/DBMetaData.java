//Example on DatabaseMetaData(Getting information about database)
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.lang.*;
public class DBMetaData {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		//getting MetaData object
		DatabaseMetaData md=con.getMetaData();
		System.out.println(md);
		//getting details about current working database
		System.out.println("user:"+md.getUserName());
		//String st[]=md.getNumericFunctions();
		System.out.println("String funs:"+md.getStringFunctions());
		System.out.println("SupportProcedure:"+md.supportsStoredProcedures());
		System.out.println("StatementLength:"+md.getMaxStatementLength());
		System.out.println("DB is :"+md.getDatabaseProductName());
		System.out.println("DB ver:"+md.getDatabaseProductVersion());
		System.out.println("driver:"+md.getDriverName());
		
	}
	

}
