package src;

import java.util.Collections;
import java.util.Comparator;

public class ComparableExample {
	
	
//Comparable example
//Optional example
//Stream with Objects
	
	
	public static void main(String args[]) {
		
		EstoreApp estore= new EstoreApp();
		System.out.println("------------------------");
		System.out.println("All products");
		System.out.println("------------------------");
		
		estore.products.forEach((product)->System.out.println(product));
		
		//to sort as list using Comparable we can create a comparator
		Comparator<Product> comp1= new Comparator<Product>(){
			public int compare(Product p1,Product p2){
				return p1.name.compareTo(p2.name);
			}
		};
		
		//You can enhance by creating Comparator with lambda expression
		
		Comparator<Product> comp2= (p1,p2)->p1.name.compareTo(p2.name);
		
		// you can even create an anonymous Comparator within the sort call to make the code even shorter
		//Collections.sort(estore.products, comp2);
		
		Collections.sort(estore.products, (p1,p2)->p1.name.compareTo(p2.name));
		System.out.println("------------------------");
		System.out.println("Products sorted on names");
		System.out.println("------------------------");
		estore.products.forEach((product)->System.out.println(product));
		
		//you can do the same for price, change places on P1 and P2 in the Comparator to change ASC/DESC
		Collections.sort(estore.products, (p1,p2)->p2.price-(p1.price));
		System.out.println("------------------------");
		System.out.println("Products sorted on price");
		System.out.println("------------------------");
		estore.products.forEach((product)->System.out.println(product));
		
		

	}
}
