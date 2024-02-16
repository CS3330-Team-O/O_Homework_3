package edu.mu;

public class MediaProduct {
	
	protected String type;
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public void setGenre(String genre) {
		switch (genre) {
			case "POP": 
				this.genre = Genre.POP;
				break;
			case "CLASSICAL":
				this.genre = Genre.CLASSICAL;
				break;
			case "HIP_HOP":
				this.genre = Genre.HIP_HOP;
				break;
			case "ROCK":
				this.genre = Genre.ROCK;
				break;
			case "JAZZ":
				this.genre = Genre.JAZZ;
				break;
			case "ELECTRONIC":
				this.genre = Genre.ELECTRONIC;
				break;
		}
		
		//this.genre = genre;
	}
	public boolean equals(MediaProduct product) {
		if (this.title == product.title && this.price == product.price && this.year == product.year && this.genre == product.genre) {
			return true;
		}
		return false;
	}
}
