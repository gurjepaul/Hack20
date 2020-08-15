import java.util.HashMap;

/**
 * 
 */

/**
 * @author Gurjepaul
 *
 */
public class PasswordManager
{
	private String masterKey;
	private HashMap<String, String> container;
	
	public PasswordManager()
	{
		this.masterKey = this.setupMasterKey();
		this.container = new HashMap<>();
	}
	
	private String setupMasterKey()
	{
		// user password strength checker
		// set this.masterKey to hash of password inputed
		return null;
	}
	
	private String getHash(String sequence)
	{
		// uses hashing algorithm to return a hash of a string
		return null;
	}
	
	private boolean isMasterKey(String key)
	{
		// returns true if the hash of the key equals the hash of the masterkey
		return (this.getHash(key)).equals(this.masterKey);
	}
	
	public boolean addPassword(String account, String password)
	{
		// compare and see if there is already a key for that
		// if there is update ? or return false
		// if not add new key and password to hashmap
	    // return true
		return true;
	}
	
	public String getPassword(String account)
	{
		// ask to input account name (key)
		// check if key is in hashmap
		// if it is then ask user to put in masterkey
		// if valid then display the password
		return null;
	}
	
	@Override
	public String toString()
	{
		// outputs all the account names on the left and asterisks for 
		// passwords on the right
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
