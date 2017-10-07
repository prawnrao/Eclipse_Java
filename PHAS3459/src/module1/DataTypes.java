package module1;

public class DataTypes {

	public static void main(String[] args) {
		//defines various variables with different data types
		double doubVar = 10.0;
		int intVar = 10;
		float floatVar = 10;
		byte byteVar = 10;
		long longVar = 10;
		
		//outputs the variables defined above 
		System.out.println("doubVar has a value of "+doubVar);
		System.out.println("intVar has a value of "+intVar);
		System.out.println("floatVar has a value of "+floatVar);
		System.out.println("byteVar has a value of "+byteVar);
		
		//outputs the multiple of each variable with itself
		System.out.println("\n"+doubVar * doubVar+" double times double");
		System.out.println(intVar * intVar+" int times int");
		System.out.println(floatVar * floatVar+" float times float");
		System.out.println(longVar * longVar+" long times long");
		System.out.println(byteVar * byteVar+" byte times byte");
		
		//The following code is investigating the outcome of mixing differnt data types

		char charVar = 'A'+30;//anding an integer to a character
		System.out.println("\ncharVar contains: "+charVar);
		System.out.println("The integer adds to the ascii code associated to the character, " + "\nand returns the character associated to the new ascii code");
		
		char charVar2 = 'b'*2;//multiplying an integer to a character
		System.out.println("\ncharVar contains: "+charVar2);
		System.out.println("The integer multiplies to the ascii code associated to the character, \nand returns the character associated to the new ascii code");
		
		//byte byteVar2 =intVar*doubVar;//attempts to store the multiple of an integer and a double as a byte
		System.out.println("\nLine 35 (//byte byteVar2 =intVar*doubVar;) does not run as an error pops up which says: \nType mismatch, cannot convert from double to byte");
		
		//int j=1; int i; j=i+1; //attempts to solve simple arithmetic with variables that were not initialised
		System.out.println("\nLine 30 (int j=1; int i; j=i+1;) of the code doesn't run, \nand returns an error about variable i not being initialised");
		
		double doubVar2 = 4.99;//assigns a value to doubVar2
		System.out.println("\ndoubVar2 contains: "+doubVar2);
		int intVar2 = (int)doubVar2;//changes the value of doubVar2 to an integer and stores it in intVar2
		System.out.println("\nAfter casting doubVar2 to intVar2, it contains: "+intVar2+"\nThe cast of a double to an integer, truncates the value of the \ndouble after the decimal place, instead of rounding it.");
		
	}
	

}
