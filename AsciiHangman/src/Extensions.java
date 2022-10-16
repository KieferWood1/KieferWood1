import java.io.Console;
import java.io.File;

// File f = new File (" dictionary.txt)
import java.util.Scanner;

public class Extensions {

	public static void main( String[ ] args ) {

		//introduce hangman game
		System.out.println( "Welcome to the ASCII Version of Hangman!" );

		Console c = System.console();
		Scanner s = new Scanner(System.in);

		int numTimesP1Wins = 0;
		int whoGuesses = 0;
		Gallows g = new Gallows ();


		//System.out.println("Do you want to play against a computer? Yes or no.");
		//String answer = s.nextLine().toLowerCase();  // Read user input

		//if (answer=="no") {


		System.out.println("Do you want to play against the computer "); // this asks if the user wants to play against the coputer
		boolean vsComputer;
		String vsComputer1 = s.nextLine().toLowerCase();  // Read user input and makes the input lower case
		if (vsComputer1.equals("no")) { // this checks if the user wants to play against the computer or another player
			vsComputer=false;
		}
		else {
			vsComputer=true;
		}






		//GAME LOOP

		while(numTimesP1Wins!=2 && numTimesP1Wins!=-2){ // this makes it so that the computer or the user has a chance to redeem themself. 
			g = new Gallows ();
			char[] letters;
			String prompt = "Please enter a secret word: "; // asks the user for a secret word






			//Player 1 inputs a secret word for player 2 to guess

			//check if program is being run on terminal
			if( c != null ) {

				letters = c.readPassword( prompt );

				for( int i = 0 ; i < letters.length ; i++ ) {

					//array created to store each letter in secret word (in upper case)
					letters[i] = Character.toUpperCase( letters[i]);
				}

			} else {

				System.out.println( "For best results, please run this from the command line." );
				System.out.print( prompt );
				letters = s.nextLine().trim().toUpperCase().toCharArray();

				//a lot of spaces to hide the secret word 
				for(int i = 0 ; i < 1000 ; i++ ) System.out.println();
			}

			//array that will represent the underscores shown 

			//fill array with underscores 


			//print the hanger
			char[] frame = new char[letters.length]; // this makes a new array by the length of the letters. 

			for ( int i = 0 ; i < frame.length ; i++ ) { // this fills the array with blank 

				frame[i] = '_';

			} 
			System.out.println(g);
			char[] wrongLetters = new char[12]; // makes a wrongLetters array that is length of 12. 
			int wrongInt = 0;
			g = new Gallows();
			boolean userWhoTyped = false; // used later to see who typed in the guesses. 

			while ( g.isAlive() == true && userWhoTyped == false ) { // the game runs while the man is still alive

				System.out.print( "Puzzle to solve: " ) ;

				//iterates through frame array
				for ( int i = 0 ; i < frame.length ; i++ ) {

					System.out.print( frame[i] + " " );; 

				}

				boolean guessedInArray = false; 
				boolean guessedIncorrect = false;
				char guessChar;

				if (vsComputer){ // if the user is against the computer
					System.out.print( "Press enter for the computer's next guess: ");
					String filler = s.nextLine();
					guessChar = (char) (int) ((Math.random()*26) + 'A');//a random int generator so that the computer guesses a random letter. 
					System.out.println("The computer's guess was: " + guessChar);


				}
				else { // if the user is against another player
					//player 2 guesses a letter
					System.out.print( "\nPlease guess a letter: ");
					String guess = s.nextLine();

					//guessed letter stored
					guessChar = guess.toUpperCase().charAt(0);

					//prints guessed letter in upper case
					System.out.println(guessChar);

					//boolean to check if the secret word contains the letter

				}
				//iterates through array of letters in secret word to check if it contains the guessed letter
				for ( int i = 0 ; i < letters.length ; i++ ) {

					if ( letters[i] == guessChar ) {// if the letter guessed is in secret word then it is guessed in the array. 

						guessedInArray = true; 




						//add guessedInArrayect letter to displayed spaces
						frame[i] = letters[i];

					} 
				} 
				for (int i =0; i < wrongLetters.length; i++) {
					if (guessChar == wrongLetters[i]) {
						guessedIncorrect = true; // checks to see if the letter guessed by the user is an incorrect letter they already guessed. 

					}
				}

				if (guessedInArray == false && !(guessedIncorrect)) { // if the incorrect letter isn't guessed and the guess isn't in the correct letter array, then hang the man. 

					//increment hangman
					g.hang();

					//print hanger
					System.out.println(g);	
					System.out.print("Incorrect Letters: ");
					wrongLetters[wrongInt]= guessChar;
					wrongLetters[wrongInt+1]=' '; // adds a space between the incorrect letters. 
					System.out.print(wrongLetters);
					System.out.println();
					wrongInt+=2;


				}
				if (guessedIncorrect) {// if the letter is already guessed, then tell the user that it is already guessed. 
					System.out.println("You already guessed that letter!\n"); 
				}

				userWhoTyped = true;

				//check if frame array still has underscores, if it doesn't, player 2 wins
				for ( int i = 0 ; i < frame.length ; i++ ) {

					if ( frame[i] == '_' ) {

						userWhoTyped = false;

					} 
				}

			}
			if (!(vsComputer)) { // makes sure it isn't against the computer
				//player 1 wins 
				if (g.isAlive()&& whoGuesses==0) { // if player 1 wins that game

					System.out.println( "Success!  Player 1 wins that game!");
					numTimesP1Wins++;
					g = new Gallows();
					whoGuesses=1;


				} 

				else if (g.isAlive()&& whoGuesses==1) {  // if player 2 wins that game

					System.out.println( "Success! Player 2 wins that game!");
					g = new Gallows();
					numTimesP1Wins--;
					whoGuesses=0;

				}
				else if (!(g.isAlive())&& whoGuesses==0) { // if player 2 wins that game
					System.out.println( "Game over! Player 2 wins that game!");
					g = new Gallows();
					numTimesP1Wins--;
					whoGuesses=1;
				}
				else if (!(g.isAlive())&& whoGuesses==1) { // if player 1 wins that game
					System.out.println( "Game over! Player 1 wins that game!");
					numTimesP1Wins++;
					g = new Gallows();
					whoGuesses=0;
				}

			}
			else {
				if (g.isAlive()) { // if computer wins that game

					System.out.println( "Game over! Computer Wins that game");
					numTimesP1Wins--;
					g = new Gallows();


				} 

				
				else if (!(g.isAlive())) { // if player 1 wins that game
					System.out.println( "Success! You win that game!");
					g = new Gallows();
					numTimesP1Wins++;
				}
				

			
	
			}
			
			
			
		}
		System.out.println();
		if (numTimesP1Wins==2&& vsComputer) {  // if player beats the computer
			System.out.println("Congrats! You beat the computer");
		}
		else if (numTimesP1Wins== -2 && vsComputer) { // if player loses to the computer
			System.out.println("Sorry! You lost the computer");
		}
		else if (numTimesP1Wins==2 && !(vsComputer)) {  // if player 1 beats player 2
			System.out.println("Congrats! Player 1 wins");

		}
		else {  // if player 2 beats player 1. 
			System.out.println("Congrats! Player 2 wins");
		}
	}
}

