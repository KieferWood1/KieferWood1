import java.util.Arrays;

public class Gallows {
	
	/* Gallows look like this:
	 *    ____            
	 *   |    |
	 *   |    O
	 *   |   \|/
	 *   |   / \
	 * __|__          
	 */
	
	protected Man man;
	protected char[] frame;
	protected int incorrect = 0;

	public Gallows() {
		
		man = new Man();
		
		//hanger displayed as a 1D array 
		frame = new char[ 60 ];

		for ( int i = 0 ; i < frame.length ; i++ ) {
			
			frame[i] = ' ';
			
			//put line breaks every 11, making 6 lines
			if ( i % 10 == 0 ) {
				
				frame[i] = '\n';
			}
		}
		
		//build the hanger
		makeCenterPost();
		makeBeam();
		makeBase();
		makeRope();
		
	}
	
	public void makeCenterPost() {
		
		frame[13] = '|';
		frame[23] = '|';
		frame[33] = '|';
		frame[43] = '|';
	}
	
	public void makeBeam() {
		
		frame[4] = '_';
		frame[5] = '_';
		frame[6] = '_';
		frame[7] = '_';
		
	}
	
	public void makeBase() {
		
		frame[51] = '_';
		frame[52] = '_';
		frame[53] = '|';
		frame[54] = '_';
		frame[55] = '_';
		
	}
	
	public void makeRope() {
		
		frame[18] = '|';
	}
	
	//take the array that has the hanged-man, and refresh frame 
	public void hang() {
		
		man.hang();
		
		frame[28] = man.toCharArray()[1];
		
		frame[38] = man.toCharArray()[5];
		frame[37] = man.toCharArray()[4];
		frame[39] = man.toCharArray()[6];
		
		frame[47] = man.toCharArray()[8];
		frame[49] = man.toCharArray()[10];

	}
	
	//if the last leg of the hangman is filled, game is over
	public boolean isAlive() {
		
		if ( frame[49] == '\\' ) {
			
			return false;
		}
		
		return true;
	}
	
	//iterates through frame and prints the hanger
	public String toString() {
		/* TODO: Render the hangman as a string
		 */
		
		String s = "";
		
		for ( int i = 0 ; i < frame.length ; i++ ) {
			
				s = s + frame[i];
		
		}
		return s;
	}
	
	/* This code is included to allow you to test the
	 * Gallows independently from the Hangman code. 
	 */
	public static void main( String[ ] args ) {
		
		Gallows g = new Gallows();
	
		for ( int i = 0 ; i < 6 ; i++ ) {
			g.hang();
		}
		
		System.out.print(g);
	
		
		
		/*
		
		System.out.println(g);
		for( int i = 0 ; i < Man.MAX_INCORRECT ; i++ ) {
			g.hang();
			System.out.println( g );
		}
		
		*/
		
	}
}
