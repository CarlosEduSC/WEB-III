package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionFactory;

public class ConnectionTest {
	
	public static void main(String[] args) {
		
		Connection con = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareCall("select * from Product;");
			ResultSet products = stmt.executeQuery();
			
			while (products.next()) {
				int id = products.getInt("id_product");
				String name = products.getString("name_product");
				
				System.out.println(id +" "+ name);
			}
			
		} catch (SQLException e) {
			
		}
	}
}
