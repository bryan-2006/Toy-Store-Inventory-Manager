package exceptions;
/**
* This exception class represents an error where a price is negative.
*/
@SuppressWarnings("serial") //Eclipse put this in to suppress warning
public class PriceException extends Exception{
	
	/**
	 * Constructor for the PriceException class
	 * @param price is the price of the toy.
	 */
	public PriceException(double price) {
		super("Error: Price of $" + price + " is invalid; price cannot be negative. ");
	}
}
