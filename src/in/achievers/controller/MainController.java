package in.achievers.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import in.achievers.dto.Customer;
import in.achievers.dto.Product;
import in.achievers.service.CustomerService;
import in.achievers.service.ProductService;

public class MainController {

	public static void main(String[] args) {

		List<Customer> customers = new ArrayList<>();

		List<Product> products = new ArrayList<>();

		CustomerService customerService = new CustomerService(customers, products);
		ProductService productService = new ProductService(products);

		Scanner sc = new Scanner(System.in);

		int option = 0;

		while (option != 7) {

			System.out.println("Enter any below option");
			System.out.println("1. Register Product\n" + "2. Find product by id\n" + "3. Register customer\n"
					+ "4. find customer by id\n" + "5. customer can buy a product\n"
					+ "6. return array of products a customer has bought by customer id\n" + "7. Exit");

			option = sc.nextInt();

			switch (option) {

			case 1:
				System.out.println("Enter product name");
				String pname = sc.next();
				System.out.println("Enter product price");
				double pprice = sc.nextDouble();
				productService.registerProduct(pname, pprice);
				System.out.println(products);
				break;

			case 2:
				System.out.println("Enter product id");
				long pid = sc.nextLong();
				Product productFound = productService.findProductById(pid);
				System.out.println(productFound);
				break;

			case 3:
				System.out.println("Enter customer First Name");
				String fname = sc.next();
				System.out.println("Enter customer Last Name");
				String lname = sc.next();
				System.out.println("Enter customer balance");
				double balance = sc.nextDouble();
				customerService.registerCustomer(fname, lname, balance);
				System.out.println(customers);
				break;

			case 4:
				System.out.println("Enter customer id");
				long cid = sc.nextLong();
				Customer customerFound = customerService.findCustomerById(cid);
				System.out.println(customerFound);
				break;

			case 5:
				for (Product p : products) {
					System.out.println("Product: " + p + "\n");
				}

				for (Customer c : customers) {
					System.out.println("Customer: " + c + "\n");
				}

				System.out.println("Enter customer id for under which customer you want to buy");
				long bcid = sc.nextLong();
				System.out.println("Enter product id which product you want to buy");
				long bpid = sc.nextLong();
				customerService.buyProduct(bcid, bpid);
				break;

			case 6:
				System.out.println("Enter customer id for see that what are all products bought by that customer");
				long productsBoughtByCustomerid = sc.nextLong();
				List<Product> productsBoughtByCustomer = customerService.productsBoughtByCustomer(productsBoughtByCustomerid);
				System.out.println(productsBoughtByCustomer);
				break;
			}
		}

		sc.close();
		System.out.println("Thank you");
	}

}
