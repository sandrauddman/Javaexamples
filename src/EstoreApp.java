package src;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EstoreApp {
	
	List<Product> products=new ArrayList<Product>();;
	
	EstoreApp() {
	List<Product> products= this.products;
	products.add(new Product("Samsung tv",2344,4.5));
	products.add(new Product("Hiatchi fridge",4000,4.3));
	products.add(new Product("Apple iphoney",21000,4.8));
	products.add(new Product("JBL speaker",400,5.0));
	
	}
	
	public void showAllProducts() {
		products.forEach((product)-> System.out.println(product));
	}
	
	//Implementation with first List methods then stream
	void filterPriceRange(int from, int to) {
		//with list
		/*products.forEach((product)->{
			if(product.price>=from && product.price <= to) {
				String result=product.toString();
				System.out.println(result);
			}
		});*/
		//with Stream filter
		/*Stream<Product> strm1= products.stream();
		Stream<Product> filteredprod=strm1.filter((product)-> product.price>=from && product.price <= to);
		filteredprod.forEach((product)->product.showProduct());*/
		
		// more condensed with stream
		
		products.stream()
			.filter((product)-> product.price>=from && product.price <= to)
			.forEach((product)->product.showProduct());
	}
	
	void memberOnlyDiscount() {
		int flatdiscount=500;
		//Stream map used
		/*Stream<Product> strm1= products.stream();
		Stream<Product> mappedprod=strm1.map((product)->{
			product.price-=flatdiscount;
			return product;
		});
		mappedprod.forEach((product)->product.showProduct());*/
		
		
		//more condensed with stream
		products.stream()
			.map((product)->{
				product.price-=flatdiscount;
				return product;
			})
			.forEach((product)->product.showProduct());
	}
	
	
	

}
