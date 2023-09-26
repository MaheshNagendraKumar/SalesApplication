package in.achievers.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import in.achievers.dto.Product;

public class ProductService {

	List<Product> products;  // all products stored here
	
	public ProductService(List<Product> products) {
		this.products=products;
	}
	
	
	public void registerProduct(String pname , double price ) {
		Product product = new Product();
		UUID pid = UUID.randomUUID();
		
		product.setPid(pid.getMostSignificantBits());
		product.setPname(pname);
		product.setPprice(price);
		
		if(product != null) {
			products.add(product);
		}
	}
	
	public Product findProductById(long pid) {
		
		Optional<Product> productFound = products.stream().filter(product -> product.getPid() == pid).findFirst();
		
		if(productFound.isPresent()) {
			System.out.println(productFound);
			return productFound.get();
		}
		return null;
	}
}
