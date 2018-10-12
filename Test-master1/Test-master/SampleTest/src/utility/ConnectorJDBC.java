package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorJDBC {

	static Connection connection;
	public static Connection getConnecion(){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
}
