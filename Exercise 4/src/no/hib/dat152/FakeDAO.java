package no.hib.dat152;

public class FakeDAO {
	Product[] products = {new Product(0,"Name1",2.50f,"imagepath1"),new Product(1,"Name2",3.50f,"imagepath2")};
	String[][] descriptions = {{"This is description", "Dette er beskrivelse", "Donde esta la biblioteca?"}
							  ,{"This is a different description", "Beskrivelse?", "Quanta costa la biblioteca?"}};
	
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
