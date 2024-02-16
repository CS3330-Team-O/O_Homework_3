package edu.mu;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;

public class StockManagerSingleton {
	private String inventoryFilePath;
	private ArrayList<MediaProduct> inventory = new ArrayList<>();
	private static MediaProduct[] mediaProduct;
	
		//Updates the price of the given media product to the newPrice.
		//Returns true if the update is successful, false otherwise
		public boolean updateItemPrice(MediaProduct product, double newPrice) {
			try {
				product.setPrice(newPrice);
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
		
		
		public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
			System.out.println(productList);
		}
		
		//Referenced from: https://www.javatpoint.com/how-to-read-csv-file-in-java
		public boolean initializeStock() {
			String line = "";  
			String split = ",";  
			try {
				BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));  
				while ((line = br.readLine()) != null) {  
				String[] mp = line.split(split); 
				String title = mp[1];
				double price = Double.parseDouble(mp[2]);
				int year = Integer.parseInt(mp[3]);
				switch(mp[0]) {
					case "CD":
						CDRecordProduct cd = new CDRecordProduct(title, price, year, genre);
						inventory.add(cd);
					case"Vinyl":
						VinylRecordProduct vinyl = new VinylRecordProduct(title, price, year, genre);
						inventory.add(vinyl);
					case "Tape":
						TapeRecordProduct tape = new TapeRecordProduct(title, price, year, genre);
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

}
