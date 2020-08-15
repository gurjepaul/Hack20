public class Password {
		private String pass;
		private double strength;
		
		/*
		 * no argument constructor
		 */
		public Password(boolean up, boolean low, boolean num, boolean sym) {
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
		public String GeneratePassword(boolean letters, boolean upper, boolean lower, boolean numbers, boolean symbols, int length) {
			//generate password based on specifications of user
			String generatedPass = "";
			
			//do the generating thing
			
			for(int i = 0; i < length - 2; i++) {
			generatedPass = generatedPass + randomCharacter("abcdefghijklmnopqrstuvwxyz");
			}
			
			
			String randomDigit = randomCharacter("0123456789");
			generatedPass = insertAtRandom(generatedPass, randomDigit);
			
			String randomSymbs = randomCharacter("+-*/?!@#$%^&()");
			generatedPass = insertAtRandom(generatedPass, randomSymbs);
			
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
		
		/*
		 * returns an integer with the length of the most amount of characters that are repeated in the password
		 */
		private int CheckRepeatedCharacters() {
			int maxRepeated = 0;
			int currentRepeated = 0;
			
			
			for(int i = 0; i < pass.length(); i++) {
				char current = pass.charAt(i);
				int j = i;
				
				//if we still have a next character to compare to
				while(j != pass.length()-1) {
					//if the current character is the same as the next character
					if (current == pass.charAt(j+1)) {
						//increment the current repeated values by 1
						currentRepeated+= 1;
						//increment j
						j++;
					}
				}
				
				//After we finish up with the while loop to figure out how many repeated characters there are
				//update i to have the value of j now;
				i = j;
				
				//find out if it is the most amount of repeated characters
				if (currentRepeated > maxRepeated) {
					maxRepeated = currentRepeated;
					currentRepeated = 0;
				}
				//we go back up and iterate here
			}
			return 0;
		}
		
		private void CheckWords() {
			
		}
		
		private void CheckNames() {
			
		}
		
		private void CheckAscendingNumbers() {
			
		}
}