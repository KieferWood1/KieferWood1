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
	protected int wrong = 0;

	public Gallows() {
		
		man = new Man();
		
		//hanger displayed as a frame
		frame = new char[60];
		// frame length is 60

		for ( int i = 0 ; i < frame.length ; i++ ) {
			
			frame[i] = ' ';
			
			//this puts a new line every 10 times
			if ( i % 10 == 0 ) {
				
				frame[i] = '\n';
			}
		}
		
		//this builds the hanger
		makeBeam();
		makeCenterPost();
		makeRope();
		makeBase();

		
	}
	
	public void makeCenterPost() {
		for (int i = 13; i<frame.length; i+=10) {
			frame[i]= '|';
			
		}
		

	}
	
	public void makeBeam() {
		for (int i = 4; i< 8; i++) {
			frame[i]= '_';
		}

		
	}
	
	public void makeBase() {
		for (int i = 51; i<56; i++) {
			if (i==53) {
				frame[i] = '|';
			}
			else {
				frame[i] = '_';
			}


		}
		
		
	}
	
	public void makeRope() {
		
		frame[18] = '|';
	}
	
	//this hang method tells the man class to hang the man
	public void hang() {
		
		man.hang();
		

	}
	
	//this asks the man class if the man is alive. 
	public boolean isAlive() {
		
		return man.isAlive();
	}
	
	//this turns the man into a string. 
	public String toString() {
		/* TODO: Render the hangman as a string
		 */
		String s = "";
		char[] ma = man.toCharArray();
		for(int i = 0; i<6;i++) { //the rows
			for(int j = 0; j<10; j++) { //the columns
				if(i>=2 && i<=4 && j>=7) { //ensures that the element is 27-29, 37-39, or 47-49 
					int mStoreinString = (i-2)*4 + j-7; //variable that stores the corresponding element number in the man's array
					s+= ma[mStoreinString];
				}
				else {
					int frameMatch=i*10+j;
					s += frame[frameMatch]; 
					
				}
			}
		}
		return s;

	}
	
	
	public static void main( String[ ] args ) {
		
		Gallows g = new Gallows();
	
		for ( int i = 0 ; i <= 5 ; i++ ) {
			g.hang();
		}
		
		System.out.print(g);
	
		
		
		
	}
}
