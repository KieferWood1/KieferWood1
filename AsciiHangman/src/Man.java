public class Man {
	
	/*  An ASCII Hangman looks like this:
	 *   O 
	 *  \|/
	 *  / \
	 */

	protected static final int MAX_INCORRECT = 6;
	protected int numWrong = 0;
	protected char[] body;
	
	public Man() {
		// makes the body a char array length of 11. 
		
		body = new char[11];
		
		for (int i =0;i < body.length; i++) {
			
			body[i] = ' ';
			
			//put line breaks every 4, making 3 lines
			if ( ( i + 1 ) % 4 == 0 ) {
				
				body[i] = '\n';
			}
		}
	}
	
	//if 6 wrong guesses, man is dead
	public boolean isAlive() {
		
		if (numWrong == MAX_INCORRECT ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//increment the man after an incorrect guess
	public void hang() {
		
		numWrong++;
		
		if ( numWrong == 1 ) {
			
			body[1] = 'O';
			
		}
		
		if ( numWrong == 2 ) {
			 
			body[5] = '|';
		}
		
		if ( numWrong == 3 ) {
			 
			body[4] = '\\';
		}
		
		if ( numWrong == 4 ) {
			 
			body[6] = '/';
		}
		
		if ( numWrong == 5 ) {
			 
			body[8] = '/';
		}
		
		if ( numWrong == 6 ) {
			 
			body[10] = '\\';
		}
	}
	
	//prints the man
	public String toString() {
		
		String s = "";
		
		for ( int i = 0 ; i < body.length ; i++ ) {
			
			s += body[i];
		}
		
		return s;
	}
	
	protected char[] toCharArray() {
		/* TODO: Return the relevant data */
		return body;
	}

	public static void main( String [ ] args ) {
		
		Man ma = new Man();
		
		for(int i = 0 ; i < Man.MAX_INCORRECT ; i++ ) {
			ma.hang();
		}
		
		System.out.println(ma);
	}
	
}
