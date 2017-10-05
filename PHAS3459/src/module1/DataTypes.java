package module1;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double doubVar = 10.0;
		int intVar = 10;
		float floatVar = 10;
		byte byteVar = 10;
		long longVar = 10;
		System.out.println("doubVar has a value of "+doubVar);
		System.out.println("intVar has a value of "+intVar);
		System.out.println("floatVar has a value of "+floatVar);
		System.out.println("byteVar has a value of "+byteVar);
		System.out.println("\n"+doubVar * doubVar+" double times double");
		System.out.println(intVar * intVar+" int times int");
		System.out.println(floatVar * floatVar+" float times float");
		System.out.println(longVar * longVar+" long times long");
		System.out.println(byteVar * byteVar+" byte times byte");
		
		char charVar = 'A'+30;
		System.out.println("\ncharVar contains: "+charVar);
		System.out.println("The integer adds to the code associated to the character, " + "\nand returns the character associated to the new code");
		
		char charVar2 = 'b'*2;
		System.out.println("\ncharVar contains: "+charVar2);
		System.out.println("The integer multiplies to the code associated to the character, \nand returns the character associated to the new code");
		
		//int j=1; int i; j=i+1;
		System.out.println("\nLine 30 (int j=1; int i; j=i+1;) of the code doesn't run, \nand returns an error about variable i not being initialised");
		
		
		
		
	}
	

}
