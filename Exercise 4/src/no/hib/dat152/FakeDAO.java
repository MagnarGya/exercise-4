package no.hib.dat152;

public class FakeDAO {
	Product[] products = {new Product(0,"White Chair",2.50f,"WEB-INF/white-chair.jpg"),new Product(1,"Black Chair",3.50f,"WEB-INF/black-chair.jpg")};
	String[][] descriptions = {{"This chair is the ultimate chair for your living room", "Denne stolen er den ultimate stuestolen", "Donde esta la biblioteca?"}
							  ,{"This chair is the best chair for your sleeping room", "Denne stolen er den beste stolen for soverommet", "Quanta costa la biblioteca?"}};
	
	Product getProduct(int pno) {
		return products[pno];
	}
	
	String getDescription(int pno, String language) {
		int langcode = 0;
		
		if (language.equals("no")) {
			langcode = 1;
		} else if (language.equals("es")){
			langcode = 2;
		}
		
		return descriptions[pno][langcode];
	}
}
