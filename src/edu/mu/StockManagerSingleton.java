package edu.mu;
import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.FileWriter;
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
		
		//Referenced from: https://www.javatpoint.com/how-to-read-csv-file-in-java
		public boolean initializeStock() {
			String line = "";  
			String split = ",";  
			try {
				BufferedReader br = new BufferedReader(new FileReader("inventory.csv")); 
				while ((line = br.readLine()) != null) {
				
				String[] employee = line.split(split); 
				System.out.println("Type: " + employee[0] + ", Title: " + employee[1] + ", Price: " + employee[2] + ", Year: " + employee[3] + ", Genre: " + employee[4]);
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
				VinylRecordProduct curr = (VinylRecordProduct) productList.get(i);
				if("Vinyl".equals(curr.getType())) {
					vinyl.add(curr);
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
				CDRecordProduct curr = (CDRecordProduct) productList.get(i);
				if("CD".equals(curr.getType())) {
					cd.add(curr);
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
				TapeRecordProduct curr = (TapeRecordProduct) productList.get(i);
				if("Tape".equals(curr.getType())) {
					tape.add(curr);
				}
			}
			
			return tape;
		}
		
		public boolean saveStock() {
			FileWriter fw;
			try {
				fw = new FileWriter("inventory.csv");
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
		

}
