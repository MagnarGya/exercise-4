package no.hib.dat152;

public class FakeDAO {
	Product[] products = {new Product(0,"Name1",2.50f,"imagepath1"),new Product(1,"Name2",3.50f,"imagepath2")};
	
	Product getProduct(int pno) {
		return products[pno];
	}
}
