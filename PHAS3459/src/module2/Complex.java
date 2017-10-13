package module2;

public class Complex {
	//member variables
	double a, b;
	//constructor
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	
	
	//REAL component of Complex number c
	static double real(Complex c) {
		return c.a;
	}
	
	//IMAGINARY component of Complex number c
	static double imag(Complex c) {
		return c.b;
	}
	
	//MODULUS of Complex number c
	static double modulus(Complex c) {
		double modulus = c.a*c.a + c.b*c.b;
		return modulus;
	}
	
	//ANGLE on the Argand diagram measured anti-clockwise from the positive real axis.
	static double ang(Complex c) {
		double ang = Math.tan(c.b/c.a);
		return ang;
	}
	
	//COMPLEX CONJUGATE of Complex number c
	static Complex conj(Complex c) {
		return new Complex (c.a, -1*c.b);
	}
	
	//NORMALISED Complex number c
	static Complex norm(Complex c) {
		double a = c.a/modulus(c);
		double b = c.b/modulus(c);
		return new Complex (a,b);
	}
	
	//EQUALITY of two complex numbers
	boolean equals(Complex c) {
		boolean c1 = false;
		if(this == c) {
		c1 = true;
		}		
		return c1;
	}
	
	//ADDITION
	static Complex add(Complex c1, Complex c2) {
		double a = c1.a + c2.a;
		double b = c1.b + c2.b;
		return new Complex(a,b);
	}	
	
	//SUBTRACTION
	static Complex subtract(Complex c1, Complex c2) {
		double a = c1.a - c2.a;
		double b = c1.b - c2.b;
		return new Complex(a,b);
	}		
	
	//MULTIPLICATION 
	static Complex multiply(Complex c1, Complex c2) {
		double a = (c1.a * c2.a) - (c1.b *c2.b);
		double b = (c1.a * c2.b) + (c1.b * c2.a);
		return new Complex(a,b);
	}	
	
	//DIVISION
	static Complex divide(Complex c1, Complex c2) {
		double a = (c1.a*c2.a+c1.b*c2.b)/modulus(c2);
		double b = (c1.b*c2.a-c1.a*c2.b)/modulus(c2);
		return new Complex(a,b);
	}	
	
	//This is the toString code, which allows to print all the complex values easily
	public String toString() {
		return "("+a+","+b+"i)";
	}
	
	//This allows to define a complex number using magnitude and angle from positive real axis
	public Complex setFromModulusAngle(double mag, double ang) {
		a = mag*Math.cos(ang);
		b = mag*Math.sin(ang);
		return new Complex(a,b);
	}
	
	//Defining static variables of 1, zero and i
	static Complex One = new Complex(1,0);
	static Complex Zero = new Complex(0,0);
	static Complex I = new Complex(0,1);
		 
}
