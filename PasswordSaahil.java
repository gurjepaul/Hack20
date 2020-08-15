public class PasswordSaahil {
		private String pass;
		private double strength;
		
		/*
		 * no argument constructor
		 */
		public PasswordSaahil() {
			//call generatePassword();
			//check the strength of password
		}
		
		/*
		 * constructor where user passes in value
		 */
		public PasswordSaahil(String pass) {
			//check strength of password
		}
		
		/*
		 * getter for password
		 */
		public String getPassword() {
			return this.pass;
		}
		
		/*
		 * getter for strength
		 */
		public double getStrength() {
			return this.getStrength();
		}
		
		/*
		 * setter for password
		 */
		public boolean setPassword(String pass) {
			this.pass = pass;
			//call strength checker again to reset the strength value
			return true;
		}
		
		/*
		 * Password generator
		 */
		public String GeneratePassword(boolean letters, boolean upper, boolean lower, boolean numbers, boolean symbols, int length) {
			//generate password based on specifications of user
			String generatedPass = "";
			
			//do the generating thing
			for(int i = 0; i < length - 2; i++) {
				generatedPass = generatedPass + randomCharacter("abcdefghijklmnopqrstuvwxyz");
			}
			
			String randomDigit = randomCharacter("0123456789");
			generatedPass = insertAtRandom(generatedPass, randomDigit);
			
			String randomChar = randomCharacter("+-*/?!@#$%^&()");
			generatedPass = insertAtRandom(generatedPass, randomChar);
			
			return generatedPass;
			
		}
		
		public String randomCharacter(String characters) {
			int n = characters.length();
			int r = (int) (n * Math.random());
			return characters.substring(r, r + 1);
		}
		
		public String insertAtRandom(String str, String toInsert) {
			int n = str.length();
			int r = (int) ((n + 1) * Math.random());
			return str.substring(0,r) + toInsert + str.substring(r);
		}
		
		/*
		 * Strength checker for password
		 */
		public void CheckStrength() {
			double strValue = 0.0;
			//calculate strValue
			this.strength = strValue;
		}
		
		private void CheckLower() {
			
		}
		
		private void CheckUpper() {
			
		}
		
		private void CheckNumbers() {
			
		}
		
		private void CheckSymbols() {
			
		}
		
		private void CheckWords() {
			
		}
		
		private void CheckNames() {
			
		}
		
		private void CheckAscendingNumbers() {
			
		}
}