package edu.mu;

public class TapeRecordProduct extends MediaProduct {
	
	public TapeRecordProduct() {
		
	}
	
	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super.type = "Tape";
		super.title = title;
		super.price = price;
		super.year = year;
		super.genre = genre;
	}
	
	public void copy(TapeRecordProduct trp) {
		this.type = trp.type;
		this.title = trp.title;
		this.price = trp.price;
		this.year = trp.year;
		this.genre = trp.genre;
	}
	
}
