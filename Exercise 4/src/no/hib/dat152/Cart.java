package no.hib.dat152;

public class Cart {
	Product[] cart;
	
	Cart(){
		cart = new Product[0];
	}
	
	public void addProduct(Product p){
		Product[] tempCart = new Product[cart.length+1];
		for(int i = 0; i < cart.length; i++){
			tempCart[i] = cart[i];
		}
		tempCart[tempCart.length-1] = p;
		
		cart = tempCart;
	}
	
	
}
