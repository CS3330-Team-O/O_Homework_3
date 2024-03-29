package edu.mu;
import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;

public class StockManagerSingleton {
	private String inventoryFilePath = "inventory.csv";
	private ArrayList<MediaProduct> inventory = new ArrayList<>();
	
		//Updates the price of the given media product to the newPrice.
		//Returns true if the update is successful, false otherwise
		public boolean updateItemPrice(MediaProduct product, double newPrice) {
			try {
				for(int i = 0; i < inventory.size(); ++i) {
					if(this.inventory.get(i).equals(product)) {
						inventory.get(i).setPrice(newPrice);
					}
				}
				return true;
			}catch(Exception e) {
				return false;
			}
		}
			
		//Adds a new media product to the inventory.
		//Returns true if the addiHon is successful, false otherwise.
		public boolean addItem(MediaProduct product) {
			try {
				this.inventory.add(product);
				return true;
			}catch(Exception e) {
				return false;
			}	
		}
			
		//Removes the given media product from the inventory.
		//Returns true if the removal is successful, false otherwise.
		public boolean removeItem(MediaProduct product) {
			try {
				for(int i = 0; i < inventory.size(); ++i) {
					if(this.inventory.get(i).equals(product)) {
						inventory.remove(i);
					}
				}
				return true;
			}catch(Exception e) {
				return false;
			}	
		}
		
		//Referenced from: https://www.javatpoint.com/how-to-read-csv-file-in-java
		public boolean initializeStock() {
			String line = "";  
			String split = ",";  
			try {
				BufferedReader br = new BufferedReader(new FileReader(inventoryFilePath));  
				while ((line = br.readLine()) != null) {  
				String[] mp = line.split(split); 
				String title = mp[1];
				double price = Double.parseDouble(mp[2]);
				int year = Integer.parseInt(mp[3]);
				Genre genre = MediaProduct.convertStringToGenre(mp[3]);
				switch(mp[0]) {
					case "CD":
						MediaProduct cd = new CDRecordProduct(title, price, year, genre);
						inventory.add(cd);
					case"Vinyl":
						MediaProduct vinyl = new VinylRecordProduct(title, price, year, genre);
						inventory.add(vinyl);
					case "Tape":
						MediaProduct tape = new TapeRecordProduct(title, price, year, genre);
						inventory.add(tape);
					default:
						break;
				}
				}  
				return true;
			} catch (IOException e) {
				System.out.println("File Not Found");
				e.printStackTrace();
				return false;
			}
		}
		
		public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
			if (productList == null || productList.isEmpty()) {
				System.out.println("There are no products in this list!");
				return new ArrayList<>();
			}
			ArrayList<VinylRecordProduct> vinyl = new ArrayList<>();
			for(int i=0; i<productList.size(); i++) {
				
				if("Vinyl".equals(productList.get(i).getType())) {
					vinyl.add((VinylRecordProduct) productList.get(i));
				}
				
			}
			
			return vinyl;
		}
		
		public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
			if (productList == null || productList.isEmpty()) {
				System.out.println("There are no products in this list!");
				return new ArrayList<>();
			}
			ArrayList<CDRecordProduct> cd = new ArrayList<>();
			for(int i=0; i<productList.size(); i++) {
				if("CD".equals(productList.get(i).getType())) {
					cd.add((CDRecordProduct) productList.get(i));
				}
			}
			
			return cd;
		}
		
		public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList){
			if (productList == null || productList.isEmpty()) {
				System.out.println("There are no products in this list!");
				return new ArrayList<>();
			}
			
			ArrayList<TapeRecordProduct> tape = new ArrayList<>();
			for(int i=0; i<productList.size(); i++) {
				if("Tape".equals(productList.get(i).getType())) {
					tape.add((TapeRecordProduct) productList.get(i));
				}
			}
			
			return tape;
		}
		
		public boolean saveStock() {
			FileWriter fw;
			try {
				fw = new FileWriter(inventoryFilePath);
				BufferedWriter bwr = new BufferedWriter(fw);
				for (int i = 0; i < this.inventory.size(); i++) {
					bwr.write(this.inventory.get(i).getType() + "," + this.inventory.get(i).getTitle() + "," + this.inventory.get(i).getPrice() + "," + this.inventory.get(i).getYear() + "," + this.inventory.get(i).getGenre() + "\n");
				}
				bwr.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			
			return true;
		}
		
		public ArrayList<MediaProduct> getMediaProductBelowPrice (int maxPrice) {
			ArrayList<MediaProduct> mediaProductsBelowPrice = new ArrayList<MediaProduct>();
			for (int i = 0; i < this.inventory.size(); i++) {
				if (this.inventory.get(i).getPrice() <= maxPrice) {
					mediaProductsBelowPrice.add(this.inventory.get(i));
				}
			}
			return mediaProductsBelowPrice;
		}
		
		public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
			for (int i = 0; i < productList.size(); i++) {
				System.out.println("Type: " + productList.get(i).getType() + ", Title: " + productList.get(i).getTitle() + ", Price: " + productList.get(i).getPrice() + ", Year: " + productList.get(i).getYear() + ", Genre: " + productList.get(i).getGenre());
			}
			
		}
		
		public ArrayList<MediaProduct> getInventory() {
			return inventory;
		}

		public void setInventory(ArrayList<MediaProduct> inventory) {
			this.inventory = inventory;
		}
		
		

}
