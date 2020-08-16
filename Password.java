public class Password {
		private String pass;
		private double strength;
		
		
		public static void main(String[] args) {
			System.out.println("hello world");
			Password wtf = new Password("helllloo24");
			System.out.println(wtf.CheckRepeatedCharacters());
		}
		
		
		
		/*
		 * no argument constructor
		 */
		public Password() {
			this.pass = generateStrongPassword();
			
			CheckStrength();
		}
		
		/*
		 * Constructor where user passes the types of characters they want in their password (Includes length)
		 */
		public Password(boolean letters, boolean num, boolean sym, int length) {
			
			this.pass = generatePassword(letters, num, sym, length);
			
			CheckStrength();
		}
		
		/*
		 * constructor where user passes in value
		 */
		public Password(String pass) {
			this.setPassword(pass);
			
			CheckStrength();
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
			return this.strength;
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
		
		public String generatePassword(boolean letters, boolean numbers, boolean symbols, int length) {
			if(letters == false && numbers == false && symbols == false || length < 1) {
				throw new IllegalArgumentException("Invalid Argument");
			}
			
			String generatedPass = "";
			int lettersCount = 0;
			int numbersCount = 0;
			int symbolsCount = 0;
			
			boolean charAdded = false;
			for(int i = 0; i < length; i++) {
				charAdded = false;
				while(!charAdded) {
					int randNum = (int) (Math.random()*4);
					
					if(randNum == 0 && lettersCount < 2 && letters == true) {
						generatedPass += randomCharacter("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
						
						lettersCount++;
						numbersCount = 0;
						symbolsCount = 0;
						
						charAdded = true;
					}
					else if(randNum == 1 && numbersCount < 2 && numbers == true) {
						generatedPass += randomCharacter("0123456789");
						
						lettersCount = 0;
						numbersCount++;
						symbolsCount = 0;
						
						charAdded = true;
					}
					else if(randNum == 2 && symbolsCount < 2 && symbols == true) {
						generatedPass += randomCharacter(" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
						
						lettersCount = 0;
						numbersCount = 0;
						symbolsCount++;
						
						charAdded = true;
					}
				}
			}
			return generatedPass;
		}
		
		public String randomCharacter(String characters) {
			int n = characters.length();
			int r = (int) (n * Math.random());
			return characters.substring(r, r + 1);
		}
		
		public String generateStrongPassword() {
			int randNum = getRandomInteger(16, 13);
			return generatePassword(true, true, true, randNum);
		}
		
		public static int getRandomInteger(int maximum, int minimum){
	        return ((int) (Math.random()*(maximum - minimum))) + minimum;
	    }
		
		/*
		 * Strength checker for password
		 * First checks that the characters are not all of 1 character type
		 * Then check to ensure the length isn't 0 which would be invalid
		 * Then we do a calculation which is 1 + 0.5 * the amount of different character types
		 * then we take that and multipy it by the length squared and after that divide everything by repeated characters squared
		 */
		public void CheckStrength() {
			double strValue = 0.0;
			//calculate strValue
			if(CheckAllLower() || CheckAllUpper() || CheckAllNumbers() || CheckSymbols()) {
				//if the password is all one character type then it is weak so we should give it a value of 0
				this.strength = strValue;
				return;
			}
			
			//gather the characteristics of the password
			double num = 0;
			double upper = 0;
			double lower = 0;
			double symb = 0;
			//if it contains a number increase the number multiplier
			if(ContainsNumber()) {
				num = 0.5;	
			}
			
			//if it contains an upper case increase the multiplier
			if(ContainsUpper()) {
				upper = 0.5;
			}
			
			//if it contains an lower case increase the multiplier
			if(ContainsLower()) {
				lower = 0.5;
			}
			
			//if it contains an special character increase the multiplier
			if(ContainsSpecial()) {
				symb = 0.5;
			}

			int repeated = CheckRepeatedCharacters();
			
			int length = pass.length();
			
			if(length ==  0) {
				//password needs a length of longer than 1 otherwise it is given a strength of 0
				this.strength = strValue;
				return;
			}
			
			
			//calculate the strength here
			strValue = ((1 + num + lower + upper + symb) * (length * length))/(repeated * repeated);
			
			this.strength = strValue;
		}
		
		/*
		 * if all characters in the password are lowercase returns true. Otherwise it returns false
		 */
		private boolean CheckAllLower() {
			String copyPass = pass;
			if(copyPass.toLowerCase().equals(pass)) {
				if(this.ContainsNumber() || this.ContainsSpecial()) {
					return false;
				} else {
				return true;
				}
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
				if(this.ContainsNumber() || this.ContainsSpecial()) {
					return false;
				} else {
				return true;
				}
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
			int maxRepeated = 1;
			int currentRepeated = 1;
			
			
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
					else {
						break;
					}
				}
				
				//After we finish up with the while loop to figure out how many repeated characters there are
				//update i to have the value of j now;
				i = j;
				
				//find out if it is the most amount of repeated characters
				if (currentRepeated > maxRepeated) {
					maxRepeated = currentRepeated;
					currentRepeated = 1;
				}
				//we go back up and iterate here
			}
			return maxRepeated;
		}
		
		/*
		 * returns true if the password contains an uppercase character and false if it doesn't
		 */
		private boolean ContainsLower() {
			String copyPass = this.pass;
			return !copyPass.equals(copyPass.toUpperCase());
		}
		
		/*
		 * returns true if the password contains a lowercase character and false if it doesn't
		 */
		private boolean ContainsUpper() {
			String copyPass = this.pass;
			return !copyPass.equals(copyPass.toLowerCase());
		}
		
		/*
		 * returns true if password contains a special character
		 */
		private boolean ContainsSpecial() {
			String copyPass = this.pass;
			return !copyPass.matches("[A-Za-z0-9]*");
		}
		
		/*
		 * returns true if password contains numbers
		 */
		private boolean ContainsNumber() {
			String copyPass = this.pass;
			return copyPass.matches(".*\\d.*");
		}
		
}