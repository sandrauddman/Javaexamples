package src;

import java.util.List;

public class StreamObjExample {

	public static void main(String[] args) {
		
		EstoreApp store2= new EstoreApp();
	
		store2.showAllProducts();
		
		System.out.println("-------------------");
		System.out.println("");
		System.out.println("Filtered products");
		//check EstoreApp class to see Stream with filter implementation
		store2.filterPriceRange(40, 6000);
		
		System.out.println("-------------------");
		System.out.println("");
		System.out.println("mapped products");
		//check EstoreApp class to see Stream with map implementation
		store2.memberOnlyDiscount();
		
		List<Product> cart= store2.products.subList(2, 4);
		User john= new User("John", cart);
		
		john.showCart();
		
		
		
	}

}
