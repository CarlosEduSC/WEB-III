package test;

import models.Product;
import repository.IProductRepository;
import repository.ProductRepository;

public class ProductDaoTest {
	
	IProductRepository repository;
	
	public ProductDaoTest() {
		repository = new ProductRepository();
	}
	
	public static void main(String[] args) {
		ProductDaoTest pdt = new ProductDaoTest();
		//pdt.insert();
		//pdt.delete();
		pdt.update();
	}
	
	public void insert() {
		Product p1 = new Product();
		
		p1.setName("produto1");
		p1.setPrice((float) 3123.323);
		p1.setDescription("product1 description");
		p1.setImageUri("src/image");
		
		repository.insertProduct(p1);
	}
	
	public void delete() {
		repository.deletProduct(100);
	}
	
	public void update() {
		Product p1 = new Product();
		
		p1.setId(99);
		p1.setName("produto99");
		p1.setPrice((float) 777.777);
		p1.setDescription("product99 description");
		p1.setImageUri("src/image");
		
		repository.updateProduct(p1);
	}
}
