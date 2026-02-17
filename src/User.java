package src;

import java.util.List;


public class User {
	
	String name;
	List<Product> cart;
	
	User(){
		
	}

	public User(String name, List<Product> cart) {
		this.name = name;
		this.cart = cart;
	}
	void showCart() {
		System.out.println("Cart: ");
		cart.forEach((product)->product.showProduct());
	}
	
	

}
