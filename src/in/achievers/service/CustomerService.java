package in.achievers.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import in.achievers.dto.Customer;
import in.achievers.dto.Product;

public class CustomerService {

	List<Customer> customers; // stores all customers

	List<Product> products;

	
	public CustomerService(List<Customer> customers, List<Product> products) {
		this.customers=customers;
		this.products=products;
	}


	public void registerCustomer(String firstName, String lastName, double balance) {
		Customer customer = new Customer();
		UUID cid = UUID.randomUUID();
		customer.setCid(cid.getMostSignificantBits());
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setBalance(balance);

		if (customer != null) {
			customers.add(customer);
			System.out.println("customer added successfully");
		}
	}

	public void buyProduct(long cid, long pid) {
		Optional<Customer> customerfound = customers.stream().filter(customer -> customer.getCid() == cid).findFirst();
		Optional<Product> productfound = products.stream().filter(product -> product.getPid() == pid).findFirst();
		
		if(customerfound.isPresent() && productfound.isPresent()) {
			if(customerfound.get().getBalance() >= productfound.get().getPprice()) {
				double remainBal = customerfound.get().getBalance() - productfound.get().getPprice();
				customerfound.get().setBalance(remainBal);
				boolean add = customerfound.get().getProductsBought().add(productfound.get());
				if(add) {
					System.out.println("Product bought successfully");
				}
			}
		}else {
			System.out.println("Given customer id or product id isnt present in current records");
		}
	}

	public Customer findCustomerById(long cid) {	
		for(Customer c: customers) {
			if(c.getCid()==cid) {
				return c;
			}
		}
		return null;
	}

	public List<Product> productsBoughtByCustomer(long cid) {
		for(Customer c: customers) {
			if(c.getCid()==cid) {
				return c.getProductsBought();
			}
		}
		return null;
	}

}
