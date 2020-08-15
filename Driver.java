import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the password generator");
		
		boolean again = true;	//Boolean variable that will be true if the user wants to do something else

		
		while(again == true)
		{
			
		System.out.println("Type 'Create' for a new password, type 'Update' to update a password ");
		System.out.print("type 'Delete' to delete a password, type 'Retrieve' to get a password, or type 'Exit' ");
		System.out.println();
		
		
		Scanner scan = new Scanner(System.in);
		
		String word = scan.nextLine();

			
			switch(word)
			{
			//Case where the user wants to create a password
			case "Create":
				
				System.out.println("Enter 'New' to type your own password, or 'Genereate' for a randomly generated password ");
				
				Scanner scanner = new Scanner(System.in);
				
				String pass = scanner.nextLine();
				
				//Case where the user wants to type their own password
				if(pass == "New")
				{
					System.out.println("Type your password");
					
					String theP = scanner.nextLine();
					
					Password password = new Password(theP);
					
				}
				//Case where the user wants to have a generated password with certain characteristics
				else if(pass == "Generate")
				{
					System.out.println("Do you want your password to contain Upper/Lower case letters, numbers, and/or symbols ");
					System.out.println("Type Y for each option you want, and N to not include the option ");
					System.out.print("(Upper Case letters, Lower Case letters, Numbers, Symbols) ");
					
					String upper = scanner.next();
					String lower = scanner.next();
					String number = scanner.next();
					String symbol = scanner.next();
					
					boolean up = false;
					boolean low = false;
					boolean num = false;
					boolean sym = false;
					
					if(upper == "Y")
					{
						up = true;
					}
					if(lower == "Y")
					{
						low = true;
					}
					if(number == "Y")
					{
						num = true;
					}
					if(symbol == "Y")
					{
						sym = true;
					}
					
					Password password = new Password(up, low, num, sym);
					
				}
				
				//Ask the user if they want to input their own password or if they want a generated one
				//return the password to the user and see if they are content
				//if so, ask for account details and open the password manager
				//ask for the master key to enter which will then add the password to the hash map
			 
				//ask the user if they want to do something else
				//if not then set 'again' to false
				
				break;
		
			//Case where the user wants to update a password
			case "Update":
			
				//Here we can go directly to our password manager where we ask for the master key
				//Once we access the passwords, the user chooses an account to change the password
				//returns whether the password is strong, weak ,or okay
				
				//ask the user if they want to do something else
				//if not then set 'again' to false
				
				break;
			
			//Case where the user wants to delete a password
			case "Delete":
			
				//Go directly to password manager where we ask for the master key
				//once we access the password, choose which account to delete
				//ask the user for the master key again to make sure we want to delete
			
				//ask the user if they want to do something else
				//if not then set 'again' to false
				
				break;
			
				//Case where the user wants to retrieve a password
			case "Retrieve":
			
				//Go directly to password manager where we ask for the master key
				//once we access the password, choose which account to retrieve
				//ask the user again for the master key
				//return the password as a string to the user
				
				//ask the user if they want to do something else
				//if not then set 'again' to false
				break;
			
			//User wants to exit the program
			case "Exit":
				
				scan.close();
				
				System.out.println("Exiting the password manager...");
				System.exit(0);
			
				break;
				
			default:
				System.out.println("No input entered");
				System.out.println("-----------------------------------");
				
				//boolean 'again' stays as true
			}
		
			scan.close();
		}
		
		
	}

	
}
