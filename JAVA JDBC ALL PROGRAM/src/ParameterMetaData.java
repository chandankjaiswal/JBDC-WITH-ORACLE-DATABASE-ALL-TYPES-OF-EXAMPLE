//Example on ParameterMetaData for getting information about ?'s.
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ParameterMetaData {

	public static void main(String[] args)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:orcl","scott","tiger");
		//PreparedStatement ob = con.prepareStatement("update Employ set sal=? where id=?");
		//OR
		CallableStatement ob=con.prepareCall("{call insert_marks(?,?,?,?,?,?)}");
		//getting pmd object using PS
		ParameterMetaData pm=(ParameterMetaData) ob.getParameterMetaData();
		System.out.println(pm);
		int c=pm.getParameterCount();
		System.out.println(c);
		for(int i=1;i<=c;i++)
		{
			System.out.println(pm.getParameterTypeNamme(i));
			System.out.println(pm.getParameterMode());
			System.out.println(pm.getParameterClassName());
		}
		
	}

	private char[] getParameterTypeNamme(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private char[] getParameterClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	private char[] getParameterMode() {
		// TODO Auto-generated method stub
		return null;
	}

	private int getParameterCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
