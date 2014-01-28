
/**
 * @class berkeley cs61b Lab 6 Solution
 * @author Saeed Alalwan
 *
 */
public class BadTransactionException extends Exception {
	public int badTrans;
	
	public BadTransactionException(int balance)  {
		 super("Really?? Negative Balance!!" + balance);

		    balance = badTrans;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
