
public class Password {
		private String pass;
		private double strength;
		
		/*
		 * no argument constructor
		 */
		public Password() {
			//call generatePassword();
			//check the strength of password
		}
		
		/*
		 * constructor where user passes in value
		 */
		public Password(String pass) {
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
		public void GeneratePassword(boolean letters, boolean upper, boolean lower, boolean numbers, boolean symbols, int length) {
			//generate password based on specifications of user
			String generatedPass = "";
			
			//do the generating thing
			
			this.pass = generatedPass;
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
