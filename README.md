# O_Homework_3

Class Media Product

Properties
  *protected String type;
	*protected String title;
	*protected double price;
	*protected int year;
	*protected Genre genre;

Related Subclasses to MediaProduct Class
  *CDRecordProduct
  *TapeRecordProduct
  *VinylRecordProduct
  
Description
MediaProduct class represents individual media products including CD, Tape, and Vinyls
---
Enum Genre
Genres: 
  ROCK,POP,JAZZ,CLASSICAL,HIP_HOP,ELECTRONIC,CHILDREN
Description: 
  represents different genres for each media product
---

StockManagerSingleton Class

Properties
  *private String inventoryFilePath;
	*private ArrayList<MediaProduct> inventory = new ArrayList<>();
	*private static MediaProduct[] mediaProduct;

 Methods
		*public boolean updateItemPrice(MediaProduct product, double newPrice) 
		*public boolean addItem(MediaProduct product) 
		*public boolean removeItem(MediaProduct product) 
		*public void printListOfMediaProduct(ArrayList<MediaProduct> productList) 
		*public boolean initializeStock() 
    *public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
		*public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList)
		*public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
		*public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList)
		*public boolean saveStock() 

Description: 
StockManagerSingleton allows admins to perform query and modifying operations on the MediaProduct inventory as well as printing the list of MediaProducts that are given.
