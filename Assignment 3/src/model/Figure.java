package model;

/**
 * For Figure instances with parent class Toy
 * @author Bryan, John
 * @version 03-010-2024
 */
public class Figure extends Toy{
	/**
	 * Char that specifies how Figure is classified. 
	 */
	private char classification;
	
	/**
	 * Constructor for Figure class
	 * @param category To initialize category in Toy super class.
	 * @param serialNumber To initialize serialNumber in Toy super class. 
	 * @param name To initialize name in Toy super class. 
	 * @param brand To initialize brand in Toy super class. 
	 * @param price To initialize price in Toy super class. 
	 * @param availableCount To initialize availableCount in Toy super class. 
	 * @param minAgeAppropriate To initialize minAgeAppropriate in Toy super class.
	 * @param classification To initialize how Figure is classified as a char.
	 */
	public Figure(String category, String serialNumber, String name, String brand, double price, int availableCount, int minAgeAppropriate, char classification) {
		super(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate);
		this.classification = classification;
	}


	/**
	 * Getter for classification.
	 * @return classification; a char.
	 */
	public char getClassification() {
		return classification;
	}

	/**
	 * Setter for classification.
	 * @param classification new classification value; a char.
	 */
	public void setClassification(char classification) {
		this.classification = classification;
	}
	
	/**
	 * Overrides and adds on to Toy class toString to display the specifics of toy 
	 */
	@Override
	public String toString() {
		return super.toString() + ", Classification:" + getClassification();
	}
	/**
	 * Overrides and adds on to Toy class toDb to display the specifics of toy 
	 */
	public String toDb() {
		return super.toDb() + ";" + classification;
	}
}
