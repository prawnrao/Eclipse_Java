package module3;

import java.util.Random;

public class Alphabet {
	
	//method to get a random character
	static char randomChar() {
		Random rand = new Random();
		char randChar = (char) rand.nextInt(128);//casts an integer between 0-127 to a character
		return randChar;
	}
	
	public static void main(String[] args) {
		
		char char1 = 'a' ;//defines new character
		char1 = randomChar();//assigns char1 a random character
		System.out.println("Random character: "+char1);
		
		
	}
}
