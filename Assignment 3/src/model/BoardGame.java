package model;

/**
 * For BoardGame instances with parent class Toy
 * @author Bryan, John
 * @version 03-010-2024
 */
public class BoardGame extends Toy{
	
	/**
	 * Minimum amount of players for the game
	 */
	private int minPlayer;
	/**
	 * Maximum amount of players for the game
	 */
	private int maxPlayer;
	/**
	 * String of designers for the board game; each designer seperated with a comma. 
	 */
	private String[] designers;
	
	/**
	 * Constructor for BoardGame class
	 * @param category To initialize category in Toy super class.
	 * @param serialNumber To initialize serialNumber in Toy super class. 
	 * @param name To initialize name in Toy super class. 
	 * @param brand To initialize brand in Toy super class. 
	 * @param price To initialize price in Toy super class. 
	 * @param availableCount To initialize availableCount in Toy super class. 
	 * @param minAgeAppropriate To initialize minAgeAppropriate in Toy super class.
	 * @param minPlayer To initialize minimum amount of players for the game as an int
	 * @param maxPlayer To initialize maximum amount of players for the game as an int
	 * @param designers To initialize designers for the board game as array of String
	 */
	public BoardGame(String category, String serialNumber, String name, String brand, double price, int availableCount, int minAgeAppropriate, int minPlayer, int maxPlayer, String[] designers) {
		super(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate);
		this.minPlayer = minPlayer;
		this.maxPlayer = maxPlayer;
		this.designers = designers;
	}
	

	/**
	 * Getter for minPlayer.
	 * @return minPlayer; an int. 
	 */
	public int getMinPlayer() {
		return minPlayer;
	}

	/**
	 * Setter for minPlayer.
	 * @param minPlayer new minPlayer value; an int. 
	 */
	public void setMinPlayer(int minPlayer) {
		this.minPlayer = minPlayer;
	}

	/**
	 * Getter for maxPlayer. 
	 * @return maxPlayer; an int. 
	 */
	public int getMaxPlayer() {
		return maxPlayer;
	}

	/**
	 * Setter for maxPlayer.
	 * @param maxPlayer new maxPlayer value; an int. 
	 */
	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}

	/**
	 * Getter for designers. 
	 * @return designers; a String of designers seperated by a comma. 
	 */
	public String[] getDesigners() {
		return designers;
	}

	/**
	 * Setter for designers.
	 * @param designers String of designers seperated by a comma. 
	 */
	public void setDesigners(String[] designers) {
		this.designers = designers;
	}
	
	/**
	 * Overrides and adds on to Toy class toString to display the specifics of toy 
	 */
	@Override
	public String toString() {
		return super.toString() + ", Min # of Players: " + getMinPlayer() + ", Max # of Players: " +
				getMaxPlayer() + ", Designers: " + String.join(",", getDesigners());
	}

	/**
	 * Overrides and adds on to Toy class toDb to display the specifics of toy 
	 */
	public String toDb() {
		return super.toDb() + String.format(";%d-%d;%s", minPlayer, maxPlayer, String.join(",", getDesigners()));
	}
}
