package repository;

import java.util.List;

public interface IProductRepository {
	
	public Integer insertProduct(String name,Double price);
	
	public Integer updateProduct(Integer id,String name,Double price);
	
	public Integer deletProduct(Integer id);
	
	public void read();
	
	public List<String> findAllProducts();
	
	public String findProduct();
}
