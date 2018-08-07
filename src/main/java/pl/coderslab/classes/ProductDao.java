package pl.coderslab.classes;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	
	public static List<Product> getList(){
		 List<Product> productList = new ArrayList<>();
		 productList.add(new Product("Laptop", 1000, 1));
		 productList.add(new Product("Powerbank", 200, 2));
		 productList.add(new Product("Powerbank", 200, 3));
		 productList.add(new Product("Taablet", 899, 4));
		
		return productList;
	}	
	

}
