package ch05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	Map<String, Product> products = new HashMap<>();
	
	public ProductService() {
		Product p1 = new Product("1", "aaa", "samsung", 100, "2025.05.13");
		products.put("1", p1);
		Product p2 = new Product("2", "bbb", "apple", 120, "2025.04.13");
		products.put("2", p2);
	}
	
	public List<Product> findAll() {
		return new ArrayList<>(products.values());
	}
	
	public Product find(String id) {
		return products.get(id);	
	}
}
