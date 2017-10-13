package module2;

public class ComplexTest {

	public static void main(String[] args) {
	//Defines complex numbers c1 and c2
	Complex c1 = new Complex(1,2);
	Complex c2 = new Complex(-2,-1);
	
	//Calculates the product of c1 and c2
	Complex product_c1c2 = Complex.multiply(c1, c2);
	System.out.println("The product of c1 and c2 is: "+product_c1c2);
 	
	//Calculates the ratio of c1 to c2 (c1/c2)
	Complex ratio_c1c2 = Complex.divide(c1, c2);
	System.out.println("The ratio of c1 to c2 is: "+ratio_c1c2);
	
	//Calculates the product of c1 and I
	Complex product_c1I = Complex.multiply(c1, Complex.I);
	System.out.println("The product of c1 and I is: "+product_c1I);
	
	//Calculates the ratio of c1 to 0
	Complex ratio_c1Zero = Complex.divide(c1, Complex.Zero);
	System.out.println("The ratio of c1 and 0 is: "+ratio_c1Zero);
	
	//Calculates the product of c1 with the conjugate of c1
	Complex c1_conj = Complex.conj(c1);
	Complex product_c1c1conj = Complex.multiply(c1,c1_conj);
	System.out.println("The product of c1 and c1* is: "+product_c1c1conj);
	
	//Calculates the product of c1 with the conjugate of c1
	Complex c2_conj = Complex.conj(c2);
	Complex product_c2c2conj = Complex.multiply(c2,c2_conj);
	System.out.println("The product of c1 and c1* is: "+product_c2c2conj);
	}

}
