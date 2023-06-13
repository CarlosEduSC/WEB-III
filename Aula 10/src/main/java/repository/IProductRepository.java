package repository;

import java.util.List;

import models.Product;

public interface IProductRepository {
	
	public Integer insertProduct(Product product);
	
	public Integer updateProduct(Product product);
	
	public Integer deletProduct(Integer id);
	
	public List<Product> findAllProducts();
	
	public String findProduct();
	
	public Product findById(int id);
	
	public Product findByName(String name);

}
