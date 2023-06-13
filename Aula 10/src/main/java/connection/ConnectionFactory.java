package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	
	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/ifpr_store", "root", "bancodedados");
			
			} catch(SQLException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}	
		
		}
		
		return con;
	}
	
	public static void close() {
		try {
			if (con != null) {
				con.close();
			}
		
		} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
		}
		
	}
}
