package edu.mu;

public class Main {

  public static void main(String[] args) {
	  System.out.println("IN MAIN");
	  StockManagerSingleton stockManagerSingleton = new StockManagerSingleton();
	  boolean fileReadStatus = stockManagerSingleton.initializeStock();
	  TapeRecordProduct addthis = new TapeRecordProduct("Tape", "Test", 20.99, 1902, Genre.ELECTRONIC);
	  stockManagerSingleton.addItem(addthis);
	  stockManagerSingleton.saveStock();
  }

}
