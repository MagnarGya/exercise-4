package no.hib.dat152;

public class FakeDAO {
	static final Product[] products = {new Product(0,"White Chair",2.50f,"white-chair.jpg"),new Product(1,"Black Chair",3.50f,"black-chair.jpg")};
	static final String[][] descriptions = {{"This chair is the ultimate chair for your living room", "Denne stolen er den ultimate stuestolen", "La último silla de sala"}
							  ,{"This chair is the best chair for your sleeping room", "Denne stolen er den beste stolen for soverommet", "La silla mejor para el dormitorio"}};
	
	 static public Product getProduct(int pno) {
		return products[pno];
	}
	
	static public String getDescription(int pno, String language) {
		int langcode = 0;
		
		if (language.equals("no")) {
			langcode = 1;
		} else if (language.equals("es")){
			langcode = 2;
		}
		
		return descriptions[pno][langcode];
	}
}
