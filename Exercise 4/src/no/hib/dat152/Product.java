package no.hib.dat152;

public class Product {
	int pno;
	String pName;
	float priceInEuro;
	String imageFile;
	
	Product(int pno, String pName, float priceInEuro, String imageFile) {
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
	}
	
	public int getPno() {
		return pno;
	}

	public String getpName() {
		return pName;
	}


	public float getPriceInEuro() {
		return priceInEuro;
	}

	public String getImageFile() {
		return imageFile;
	}
	
	public int hashCode() {
		return pno;
	}
}
