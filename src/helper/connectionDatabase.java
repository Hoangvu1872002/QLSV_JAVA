package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.UIManager;

import view.QLTS_View_Login_User;
import view.QLTS_View_User;



public class connectionDatabase {
	public static Connection openConnectionDatabase() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL ="jdbc:sqlserver://localhost:1433;databaseName=QLThiSinh;encrypt=false";
			connection=DriverManager.getConnection(connectionURL, "sa", "alone@");
			
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()+"/n"+ e.getClass()+"/n"+ e.getCause());
		}		
		return connection;
	}
}
