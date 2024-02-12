package edu.mu;

public class VinylRecordProduct extends MediaProduct {
	
	public VinylRecordProduct() {
		
	}
	
	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super.title = title;
		super.price = price;
		super.year = year;
		super.genre = genre;
	}
	
	public copy(VinylRecordProduct vrp) {
		this.title = vrp.title;
		this.price = vrp.price;
		this.year = vrp.year;
		this.genre = vrp.genre;
	}

}
