package no.hib.dat152;

import java.util.ArrayList;

public class Cart {
	ArrayList<Product> cart;
	
	Cart(){
		cart = new ArrayList<Product>();
	}
	
	void add(Product product){
		cart.add(product);
	}
}
