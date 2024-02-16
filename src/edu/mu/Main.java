package edu.mu;

public class Main {

  public static void main(String[] args) {
	  System.out.println("IN MAIN");
	  StockManagerSingleton stockManagerSingleton = new StockManagerSingleton();
	  boolean fileReadStatus = stockManagerSingleton.initializeStock();
	  
	  
  }

}
