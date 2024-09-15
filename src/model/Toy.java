package model;

/**
 * Abstract class Toy for Animal, BoardGame, Figure, and Puzzle class. 
 * @author Bryan, John
 * @version 03-010-2024
 */
public abstract class Toy {
	/**
	 * Type of toy as a String
	 */
	private String category;
	/**
	 * Serial number of toy as a String
	 */
	private String serialNumber;
	/**
	 * Name of toy as a String
	 */
	private String name;
	/**
	 * Name of brand as a String
	 */
	private String brand;
	/**
	 * Price of the toy as a double
	 */
	private double price;
	/**
	 * Available number of toys in inventory
	 */
	private int availableCount;
	/**
	 * The minimum age recommendation for the toy
	 */
	private int minAgeAppropriate;
	
	/**
	 * Constructor for Toy abstract class that is called as super constructor in child classes.
	 * @param category To initialize toy type
	 * @param serialNumber To initialize serialNumber
	 * @param name To initialize name
	 * @param brand To initialize brand 
	 * @param price To initialize price 
	 * @param availableCount To initialize availableCount
	 * @param minAgeAppropriate To initialize minAgeAppropriate
	 */
	public Toy(String category, String serialNumber, String name, String brand, double price, int availableCount, int minAgeAppropriate) {
		this.category = category;
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.minAgeAppropriate = minAgeAppropriate;
	}

	/**
	 * Getter for category
	 * @return category; a String.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter for category
	 * @param category new serialNumber value; a String.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Getter for serialNumber
	 * @return serialNumber; a String. 
	 */
	public String getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * Setter for serialNumber
	 * @param serialNumber new serialNumber value; a String.
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	/**
	 * Getter for name
	 * @return name; a String. 
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for name
	 * @param name new name value; a String.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for brand
	 * @return brand; a String. 
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Setter for brand
	 * @param brand new brand value; a String.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Getter for price
	 * @return price; a double. 
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for price
	 * @param price new price value; a String.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Getter for availableCount
	 * @return availableCount; an int
	 */
	public int getAvailableCount() {
		return availableCount;
	}
	
	/**
	 * Setter for availableCount
	 * @param availableCount new availableCount value; an int.
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	
	/**
	 * Getter for minAgeAppropriate
	 * @return minAgeAppropriate; an int
	 */
	public int getMinAgeAppropriate() {
		return minAgeAppropriate;
	}
	
	/**
	 * Setter for minAgeAppropriate
	 * @param minAgeAppropriate new minAgeAppropriate value; an int.
	 */
	public void setMinAgeAppropriate(int minAgeAppropriate) {
		this.minAgeAppropriate = minAgeAppropriate;
	}
	
	/**
	 * Returns String of general Toy specifics 
	 */
	public String toString(){
		return "Category:" + getCategory() + ", Serial Number: " + getSerialNumber() + ", Name:" + getName() +
				", Brand:" + getBrand() + ", Price:" + getPrice() + ", Available Count:" + getAvailableCount() +
				", Age Appropriate:" + getMinAgeAppropriate();
	}

	/**
	 * Returns String of general Toy specifics for DB
	 * @return String of general Toy specifics for DB
	 */
	public String toDb() {
		return String.join(";", serialNumber, name, brand, String.valueOf(price),
				String.valueOf(availableCount), String.valueOf(minAgeAppropriate));
	}

	/**
	 * OLD CODE: just checks serialNumber is 10 digits long but we have better validation now.
	 * @param serialNumber String that is serialNumber
	 * @return true if serialNumber is 10 digits/chars long and false otherwise.
	 */
	public static boolean validateSerialNumber(String serialNumber) {
		return serialNumber.length() != 10;
	}
}
