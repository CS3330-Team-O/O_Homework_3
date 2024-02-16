package edu.mu;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
	  StockManagerSingleton stockManagerSingleton = new StockManagerSingleton();
	  boolean fileReadStatus = stockManagerSingleton.initializeStock();
	  
	  CDRecordProduct cdAddItemTest = new CDRecordProduct("AddItemTest", 20.99, 2024, Genre.ROCK);
	  stockManagerSingleton.addItem(cdAddItemTest);
	  
	  stockManagerSingleton.updateItemPrice(cdAddItemTest, 100000);
	  
	  CDRecordProduct cdRemoveItemTest = new CDRecordProduct("AddItemTest", 20.99, 2024, Genre.ROCK);
	  stockManagerSingleton.addItem(cdRemoveItemTest);
	  stockManagerSingleton.removeItem(cdRemoveItemTest);
	  
	  ArrayList<MediaProduct> mediaProductsBelowPrice = stockManagerSingleton.getMediaProductBelowPrice(20);
	  
	  stockManagerSingleton.printListOfMediaProduct(mediaProductsBelowPrice);
	  
	  ArrayList<VinylRecordProduct> vl = stockManagerSingleton.getVinylRecordList(stockManagerSingleton.getInventory());
	  ArrayList<TapeRecordProduct> tl = stockManagerSingleton.getTapeRecordList(stockManagerSingleton.getInventory());
	  ArrayList<CDRecordProduct> cl = stockManagerSingleton.getCDRecordsList(stockManagerSingleton.getInventory());
	  
	  boolean saveSuccessful = stockManagerSingleton.saveStock();
	  if (!saveSuccessful) {
		  System.out.println("Save Failed");
	  } else if (saveSuccessful) {
		  System.out.println("Save Successful");
	  }
	  
  }
}
