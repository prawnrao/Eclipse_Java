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

		char char1 = 'a';
		char char2 = 'a';
		String str1 = ""; //defines a new empty string
		int int1 = 0; //defines a new integer
		int excep = 0;
		boolean LetOrDig = true;//defines a boolean 
		StringBuilder SB  = new StringBuilder(250); //defines a new stringbuilder


		//		char1 = randomChar();//assigns char1 a random character
		//		System.out.println("Random character: "+char1);


		int i = 0;//sets the counter to 0
		int max = 250;//sets the max counter, which is used to break the loop

		while (i < max) {

			char2 = randomChar();//assigns char2 a random character
			LetOrDig = Character.isLetterOrDigit(char2);//
			if (LetOrDig == true) {
				SB.append(char2);//appends the sting builder
				str1 = ""+char2;//assigns the char2 value to the str1

				try {
					int int2 = Integer.parseInt(str1);
					int1 = int1 +int2;
				}
				catch (Exception e) {
					excep = excep +1;
				}
				i = i +1;
			}

		}
		System.out.println("String builder: "+SB);
		System.out.println("Running total: "+int1);
		System.out.println("Number of exceptions: "+excep);

	}
}
