
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
		
		/*
		 * if all characters in the password are lowercase returns true. Otherwise it returns false
		 */
		private boolean CheckAllLower() {
			String copyPass = pass;
			if(copyPass.toLowerCase().equals(pass)) {
				return true;
			} else {
				return false;
			}
		}
		
		/*
		 * if all characters in the password are uppercase returns true. Otherwise it returns false
		 */
		private boolean CheckAllUpper() {
			String copyPass = pass;
			if(copyPass.toUpperCase().equals(pass)) {
				return true;
			} else {
				return false;
			}
		}
		
		/*
		 * if all characters in the password are numbers return true. Otherwise it returns false
		 */
		private boolean CheckAllNumbers() {
			String copyPass = pass;
			if ((copyPass == null) || (copyPass.length() == 0)) {
				//if the password doesn't exist currently or the length is zero
				return false;
			}
			
			for(int i = 0; i < copyPass.length(); i++) {
				char c = copyPass.charAt(i);
				if(c < '0' || c > '9') {
					//if the character doesn't fall within the ascii values of 0 to 9 then we return false
					//since the password is not all numbers
					return false;
				}
			}
			//when we hit here the password is all numbers
			return true;
		}
		
		/*
		 * if all characters in the password are symbols return true. Otherwise it returns false
		 */
		private boolean CheckSymbols() {
			String copyPass = pass;
			if ((copyPass == null) || (copyPass.length() == 0)) {
				//if the password doesn't exist currently or the length is zero
				return false;
			}
			
			for(int i = 0; i < copyPass.length(); i++) {
				char c = copyPass.charAt(i);
				if(c < ' ') {
					//if the ascii value is less than [space] we return false
					return false;
				} else if (c > '/' || c < ':') {
					//if the ascii value falls within these characters then it is a number therefore we return false
					return false;
				} else if (c > '@' || c < '[') {
					//if ascii value falls within these characters then it is a capital letter so we return false
					return false;
				} else if (c > '`' || c < '{') {
					//if ascii values fall within here then the character is a lowercase letter so we return false
					return false;
				} else if (c > '~') {
					//if it is greater than ~ then it is out of range
					return false;
				}
			}
			//when we hit here the password is all symbols
			return true;
		}
		
		private int CheckRepeatedCharacters() {
			return 0;
		}
		
		private void CheckWords() {
			
		}
		
		private void CheckNames() {
			
		}
		
		private void CheckAscendingNumbers() {
			
		}
}
