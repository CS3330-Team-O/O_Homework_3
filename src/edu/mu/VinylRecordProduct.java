package edu.mu;

public class VinylRecordProduct extends MediaProduct {

	public VinylRecordProduct() {

	}

	public VinylRecordProduct(String type, String title, double price, int year, Genre genre) {
		super.type = type;
		super.title = title;
		super.price = price;
		super.year = year;
		super.genre = genre;
	}

	public void copy(VinylRecordProduct vrp) {
		this.type = vrp.type;
		this.title = vrp.title;
		this.price = vrp.price;
		this.year = vrp.year;
		this.genre = vrp.genre;
	}

}
