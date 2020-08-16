import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	private final String masterKey;
	private HashMap<String, String> container;
	
	public PasswordManager(String masterKey) throws NoSuchAlgorithmException
	{
		this.masterKey = this.toHexString(this.getSHA(masterKey));
		this.container = new HashMap<>();
	}
	
	private byte[] getSHA(String input) throws NoSuchAlgorithmException
	{
		// Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}
	
	public String toHexString(byte[] hash)
	{
		// Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
	}
	
	public boolean isMasterKey(String key) throws NoSuchAlgorithmException
	{
		// returns true if the hash of the key equals the hash of the master key
		return (this.toHexString(this.getSHA(key))).equals(this.masterKey);
	}
	
	public boolean addPassword(String account, String password)
	{
		// Check if container contains the account
		if (container.containsKey(account))
		{
			return false;
		}
		
		String encrypted = AES.encrypt(password, this.masterKey);
		
		// Adding new account and password to HashMap
		container.put(account, encrypted);
	    
		return true;
	}
	
	public boolean updatePassword(String account, String password)
	{
		// Check if container doesn't contain the account
		if (!container.containsKey(account))
		{
			return false;
		}
		
		String encrypted = AES.encrypt(password, this.masterKey);
		
		// Updates the password of the account in the HashMap
		container.replace(account, encrypted);
		
		return true;
	}
	
	public String retrievePassword(String account)
	{
		// Check if container doens't contain the account
		if (!container.containsKey(account))
		{
			return null;
		}
		
		String decrypted = AES.decrypt((String)container.get(account), this.masterKey);
		
		// Return the password of the account
		return decrypted;
	}
	
	public boolean removePassword(String account)
	{
		// Check if container doesn't contain the account
		if (!container.containsKey(account))
		{
			return false;
		}
		
		// Remove the account from the HashMap
		container.remove(account);
		
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder accounts = new StringBuilder();
		
		for (String accountName : this.container.keySet())
		{
			accounts.append(String.format("%-12s: *******\n", accountName));
		}
		
		return accounts.toString();
	}

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException
	{
//		PasswordManager pm = new PasswordManager("Jay");
//		
//		System.out.println(pm.isMasterKey("Jay"));
//		System.out.println(pm.isMasterKey("Saahil"));
//		System.out.println(pm.isMasterKey("Jay"));
//		
//		System.out.println(pm.addPassword("Google", "123456"));
//		System.out.println(pm.addPassword("Google", "jay"));
//		
//		System.out.println(pm.updatePassword("Google", "jay"));
//		
//		System.out.println(pm.updatePassword("Spotify", "jay"));
//		
//		System.out.println(pm.addPassword("Microsoft", "566969"));
//		System.out.println(pm.addPassword("Apple", "Password"));
//		System.out.println(pm.addPassword("Steam", "Password"));
//		
//		System.out.println(pm.removePassword("Spotify"));
//		System.out.println(pm.removePassword("Google"));
//		
//		System.out.println(pm.retrievePassword("Google"));
//		System.out.println(pm.retrievePassword("Microsoft"));
//		System.out.println(pm.retrievePassword("Apple"));
//		
//		System.out.println(pm.toString());
	}

}
