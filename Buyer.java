
public class Buyer {
	
	/**
	 * Instance fields
	 */
	private Account account;
	
	/**
	 * Constructor
	 */
	public Buyer(int id, String pw, String email, String name) {
		account = new Account(id, pw, email, name);
	}
	

}
