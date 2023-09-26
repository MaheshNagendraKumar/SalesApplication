package in.achievers.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private long cid;
	private String firstName;
	private String lastName;
	private double balance;
	private List<Product> productsBought;
	
	public Customer() {
		productsBought = new ArrayList<>();
	}
	
	public long getCid() {
		return cid;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Product> getProductsBought() {
		return productsBought;
	}

	public void setProductsBought(List<Product> productsBought) {
		this.productsBought = productsBought;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstName=" + firstName + ", lastName=" + lastName + ", balance=" + balance
				+ ", productsBought=" + productsBought + "]";
	}	

}
