package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.Product;

public class ProductRepository implements IProductRepository{
	private Connection con; 
	
	public ProductRepository() {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public Integer insertProduct(Product product) {
		PreparedStatement stm = null;
		int id = 0;
		try {
			String sql = "insert into products (name,price,description,imageUri) values (?, ?, ?, ?);";
			stm = con.prepareStatement(sql, stm.RETURN_GENERATED_KEYS);
			
			stm.setString(1, product.getName());
			stm.setDouble(2, product.getPrice());
			stm.setString(3, product.getDescription());
			stm.setString(4, product.getImageUri());
			
			int rowsAffected = stm.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet ids = stm.getGeneratedKeys();
				
				while(ids.next()) {
					id = ids.getInt(1);
					
					System.out.println("Ok! ids generated: "+ id);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Integer updateProduct(Product product) {
		PreparedStatement stm = null;

		try {
			String sql = "update products set name= ?,price= ?,descirption = ?,uriImage = ? where id = ?";
			stm = con.prepareStatement(sql);
			
			stm.setString(1, product.getName());
			stm.setDouble(2, product.getPrice());
			stm.setString(3, product.getDescription());
			stm.setString(4, product.getImageUri());
			
			stm.setInt(5, product.getId());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer deletProduct(Integer id) {
		PreparedStatement stm = null;
		
		try {
			String sql = "delete from products where id = ?;";
			stm = con.prepareStatement(sql);
			
			stm.setInt(1, id);
			
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Rows Affacted: "+ rowsAffected);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		
		List<Product> products = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet results = null;
		
		try {
			stmt =  con.prepareStatement("select * from products;");
			results = stmt.executeQuery();
			
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				float price = results.getFloat("price");
				String description = results.getString("description");
				String imageUri = results.getString("imageUri");
				
				//System.out.println(id + name);
				
				Product p = new Product(id, name, price, description, imageUri);
				
				products.add(p);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		
		} finally {
			ConnectionFactory.close();
			try {
				stmt.close();
				results.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return products;
	}

	@Override
	public String findProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
