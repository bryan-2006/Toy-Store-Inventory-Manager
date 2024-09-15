package model;

/**
 * For Animal instances with parent class Toy
 * @author Bryan, John
 * @version 03-010-2024
 */
public class Animal extends Toy{
	/**
	 * String that specifies material used. 
	 */
	private String material;
	/**
	 * Char that specifies size. 
	 */
	private char size;
	
	/**
	 * Constructor for Puzzle class
	 * @param category To initialize category in Toy super class.
	 * @param serialNumber To initialize serialNumber in Toy super class. 
	 * @param name To initialize name in Toy super class. 
	 * @param brand To initialize brand in Toy super class. 
	 * @param price To initialize price in Toy super class. 
	 * @param availableCount To initialize availableCount in Toy super class. 
	 * @param minAgeAppropriate To initialize minAgeAppropriate in Toy super class.
	 * @param material To initialize material as a String.
	 * @param size To initialize size as a char.
	 */
	public Animal(String category, String serialNumber, String name, String brand, double price, int availableCount, int minAgeAppropriate, String material, char size) {
		super(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate);
		this.size = size;
		this.material = material;
	}
	
	//Can we just have the constructors for child of toy classes not take in category as an arg?
	public Animal(String serialNumber, String name, String brand, double price, int availableCount, int minAgeAppropriate, String material, char size) {
		//instead passing it as a literal and not variable? seems easier but does it mess up our code?
		super("Animal", serialNumber, name, brand, price, availableCount, minAgeAppropriate);
		this.size = size;
		this.material = material;
	}
	/**
	 * Getter for material
	 * @return material; a String
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Setter for material
	 * @param material new material value; a String.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Getter for size
	 * @return size; a char
	 */
	public char getSize() {
		return size;
	}

	/**
	 * Setter for size
	 * @param size new size value; a char.
	 */
	public void setSize(char size) {
		this.size = size;
	}
	
	/**
	 * Overrides and adds on to Toy class toString to display the specifics of toy 
	 */
	@Override
	public String toString() {
		return super.toString() + ", Material: " + getMaterial() + ", Size: " + getSize();
	}

	/**
	 * Overrides and adds on to Toy class toDb to display the specifics of toy 
	 */
	public String toDb () {
		return super.toDb() + ";" + String.join(";", material, String.valueOf(size));
	}
}

