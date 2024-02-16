package edu.mu;

public abstract class MediaProduct {
	
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
	public static Genre convertStringToGenre(String genre) {
		switch (genre) {
			case "POP": 
				return Genre.POP;
			case "CLASSICAL":
				return Genre.CLASSICAL;
			case "HIP_HOP":
				return Genre.HIP_HOP;
			case "ROCK":
				return Genre.ROCK;
			case "JAZZ":
				return Genre.JAZZ;
			case "ELECTRONIC":
				return Genre.ELECTRONIC;
		}
		return Genre.CLASSICAL;
	}
	public boolean equals(MediaProduct product) {
		if (this.title == product.title && this.price == product.price && this.year == product.year && this.genre == product.genre) {
			return true;
		}
		return false;
	}
}
