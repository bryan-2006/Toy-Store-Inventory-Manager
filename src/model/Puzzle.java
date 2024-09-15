package model;

/**
 * For Puzzle instances with parent class Toy
 * @author Bryan, John
 * @version 03-010-2024
 */
public class Puzzle extends Toy{
	
	/**
	 * Char that specifies puzzle type. 
	 */
	private char puzzleType;
	
	/**
	 * Constructor for Puzzle class
	 * @param category To initialize category in Toy super class.
	 * @param serialNumber To initialize serialNumber in Toy super class. 
	 * @param name To initialize name in Toy super class. 
	 * @param brand To initialize brand in Toy super class. 
	 * @param price To initialize price in Toy super class. 
	 * @param availableCount To initialize availableCount in Toy super class. 
	 * @param minAgeAppropriate To initialize minAgeAppropriate in Toy super class.
	 * @param puzzleType To initialize puzzleType as a char.
	 */
	public Puzzle(String category, String serialNumber, String name, String brand, double price, int availableCount, int minAgeAppropriate, char puzzleType) {
		super(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate);
		this.puzzleType = puzzleType;
	}

	/**
	 * Getter for puzzleType.
	 * @return puzzleType; a char. 
	 */
	public char getPuzzleType() {
		return puzzleType;
	}

	/**
	 * Setter for minPlayer.
	 * @param puzzleType new puzzleType value; a char.
	 */
	public void setPuzzleType(char puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	/**
	 * Overrides and adds on to Toy class toString to display the specifics of toy 
	 */
	@Override
	public String toString() {
		return super.toString() + ", Puzzle Type: " + getPuzzleType();
	}
	/**
	 * Overrides and adds on to Toy class toDb to display the specifics of toy 
	 */
	public String toDb() {
		return super.toDb() + ";" + puzzleType;
	}
}
