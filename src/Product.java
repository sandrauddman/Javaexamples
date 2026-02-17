package src;

public class Product {
	
	String name;
	int price;
	double rating;
	
	public Product(){
		
	}

	public Product(String name, int price, double rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", rating=" + rating + "]";
	}
	public void showProduct() {
		System.out.println("Product [name="+name + ", price=" + price + ", rating=" + rating +"]");
	}
	

}
