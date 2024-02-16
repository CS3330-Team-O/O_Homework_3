package edu.mu;

public class CDRecordProduct extends MediaProduct {
	
	public CDRecordProduct() {
		
	}
	
	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super.type = "CD";
		super.title = title;
		super.price = price;
		super.year = year;
		super.genre = genre;
	}
	
	public void copy(CDRecordProduct cdrp) {
		this.type = cdrp.type;
		this.title = cdrp.title;
		this.price = cdrp.price;
		this.year = cdrp.year;
		this.genre = cdrp.genre;
	}
	
}
