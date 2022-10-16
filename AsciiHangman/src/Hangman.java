/*
 * Haskell and I worked on this together. The reason why I am turning it in late is because I had to work on my extenions. 
 * 1.) The toUpperCase method is necessary to compare the letters array to the user's input
 This is because in lowercase letters do not equal their uppercase counterparts in java. 
Because some users could type in lowercase and some could guess in upper, 
they are referring to the same letters, so it should not be case sensitive
Capitalization or lack thereof would stop the code from working, 
Therefore, we used the uppercase method to eliminate the variability of the user's response.   


2.) we would need to adjust all the mutator methods in the gallows class
 to shape it into the box/frame rather than a gallow
    
3.) No, the two lines will not produce the same output. sort alphabetizes the text so when that command
 happens first, it is more likely that the uniq command will be able to remove identical stuff next to 
each other because the sort command
that happened before it made the same ones next to each other. 
It is possible that these two command lines can give the same outputs if there are no repeats. 
But, the only times the uniq code will actual do anything if it happens before the sort is if 
  The texts are already next to each other.

4.) The MAX_INCORRECT constant becomes redundant the more classes it is put in, taking up extra space. The Number of Incorrect guesses directly affects the man/man class, so it should be in there. It should not be in the Galllows class because that class is used to create the gallow (the number of incorrect guesses will not affect that class). The Hangman class determines what is a correct guess and an incorrect guess and when the game should end when the secret array equals the guessed array. It states what to print when it isnt alive, but it doesnt show the effect of an incorrect guess (it would show the direct effect in Man class).


 */
import java.io.Console;
import java.util.Scanner;

public class Hangman {
		
	public static void main( String[ ] args ) {
		
		//introduce hangman game
		System.out.println( "Welcome to the ASCII Version of Hangman!" );
		
		Console c = System.console();
		Scanner s = new Scanner(System.in);
		char[] letters;
		
		Gallows g = new Gallows ();
		boolean player2Win = false;
		
		//Player 1 inputs a secret word for player 2 to guess
		String prompt = "Please enter a secret word: ";
		
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
			for(int i = 0 ; i < 10000 ; i++ ) System.out.println();
		}
		
		//array that will represent the underscores shown 
		char[] frame = new char[letters.length];
		
		//this fills array with underscores 
		for ( int i = 0 ; i < frame.length ; i++ ) {
			
			frame[i] = '_';
			
		}
		
		//print the hanger
		System.out.println(g);
		
		//GAME LOOP
		while ( g.isAlive() == true && player2Win == false ) {
			
			System.out.print( "Puzzle to solve: " ) ;
			
			//iterates through frame array
			for ( int i = 0 ; i < frame.length ; i++ ) {
				
				System.out.print( frame[i] + " " );;
		
			}
			
			
			//player 2 guesses a letter
			System.out.print( "\nPlease guess a letter: ");
			String guess = s.nextLine();
			
			//guessed letter stored
			char guessChar = guess.toUpperCase().charAt(0);
			
			//prints guessed letter in upper case
			System.out.println(guessChar);
			
			//boolean to check if the secret word contains the letter
			boolean guessedInArray = false;
			
			//this iterates through array of letters in secret word to check if it contains the guessed letter
			for ( int i = 0 ; i < letters.length ; i++ ) {
				
				if ( letters[i] == guessChar ) {
					
					guessedInArray = true;
					
					//add guessedInArrayect letter to displayed spaces
					frame[i] = letters[i];
					
				} 
			} 
			
			
			if (guessedInArray == false) {
				
				//increment hangman if the gussed letter isn't in a letter in the secret word. 
				g.hang();
				
				//print hanger
				System.out.println(g);	
			
			}
			
			player2Win = true;
			
			//check if frame array is completely filled, if it isn't, player 2 wins
			for ( int i = 0 ; i < frame.length ; i++ ) {
				
				if ( frame[i] == '_' ) {
					
					player2Win = false;
				
				} 
			}
			
		}
		
		//man is dead so player 1 wins 
		if ( g.isAlive() == false ) {
			
			System.out.println( "Game over! Player 1 wins!");
			
			
		} 
	
		//word is gussed so player 2 wins 
		if ( player2Win == true ) {
			
			System.out.println( "Success!  Player 2 wins!");
			
		}
	}

}
