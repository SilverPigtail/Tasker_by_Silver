package exceptions;
/***
 * This is a customized exception that we use when the password in the sing-up is too long.
 * @author Alejandro Molina Lara (SilverPigtail)
 *
 */
public class InvalidPasswordLengthException extends Exception{

	/***
	 * This is the function that allows the program to pop-up the exception
	 * @param msg -> The message that we send to the function that contains the statement of the error.
	 */
	public InvalidPasswordLengthException(String msg) {
		super(msg);
	}
	
}
