package module1;
//import java.util.Date;

public class Simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Program Starting");
		//Date myDate = new Date();
		//System.out.println(myDate);
		//System.out.println("Program finished");
		
		int x = 100; int y = 200;
		 // Print the value of x
		 // to the screen
		 System.out.println(x);
		 // Prefix the printing of the
		 // value with some descriptive
		 // information:
		 System.out.println("The value of x is "+x);
		 // Note the "" for any words.
		 // The + means append to the
		 // output going to the screen
		 System.out.println(" x = "+x+" and y = "+y);
		 // We can have any number of
		 // things appended using a '+'
		 
		 int ix = 123456789;
		 int iy = 123456788;
		 System.out.println(ix-iy);
		 // Widening conversions
		 float fx = ix;
		 float fy = iy;
		 System.out.println(fx-fy);
	}

}
