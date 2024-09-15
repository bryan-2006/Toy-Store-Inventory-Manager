package exceptions;
/**
* This exception class represents an error where the minimum number of players exceeds the maximum number.
**/
@SuppressWarnings("serial") //Eclipse put this in to suppress warning
public class PlayerAmountException extends Exception{
	
	/**
	 * The constructor for the PlayerAmountException class
	 * @param max is the max players allowed
	 * @param min is the min players allowed
	 */
	public PlayerAmountException(int max, int min) {
		super("Error: minimum number of players (" + min + ") cannot exceed maximum number of players ("
				+ max + "). ");
	}
}
