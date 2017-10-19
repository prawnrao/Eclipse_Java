package module3;

import java.util.Random;

public class Alphabet {

	//method to get a random character
	static char randomChar() {
		Random rand = new Random();
		char randChar = (char) rand.nextInt(127);//casts an integer between 0-127 to a character
		return randChar;
	}

	public static void main(String[] args) {

		char char1;
		char char2;
		String str1 = ""; //defines a new empty string
		int int1 = 0; //defines a new integer
		int length = 0;
		int excep = 0;
		boolean LetOrDig;//defines a boolean 
		StringBuilder SB  = new StringBuilder(); //defines a new stringbuilder


		char1 = randomChar();//assigns char1 a random character
		System.out.println("Random character: "+char1);


		int i = 0;//sets the counter to 0
		int max = 250;//sets the max counter, which is used to break the loop

		while (i < max) {
			char2 = randomChar();//assigns char2 a random character
			LetOrDig = Character.isDigit(char2)||Character.isLetter(char2);
			if (LetOrDig == true) {
				SB.append(char2);//appends the sting builder
				str1 = ""+char2;//assigns the char2 value to the str1
				try {
					int int2 = Integer.parseInt(str1);//converts the string into an integer
					int1 = int1 +int2;//adds the integer to the running total
				}
				catch (Exception e) {
					excep = excep +1;//increments the exception counter
				}
			}
			i = i +1;//increments the loop counter
		}
		
		length = SB.length();//calculates the length the string builder
		System.out.println("\nString builder: "+SB);
		System.out.println("Number of characters in the string builder: "+length);
		System.out.println("\nRunning total: "+int1);
		System.out.println("\nNumber of exceptions: "+excep);

	}
}
