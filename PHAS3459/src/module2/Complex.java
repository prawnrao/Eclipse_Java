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
	public static double real(Complex c) {
		return c.a;
	}
	
	//IMAGINARY component of Complex number c
	public static double imag(Complex c) {
		return c.b;
	}
	
	//MODULUS of Complex number c
	public static double modulus(Complex c) {
		double modulus = c.a*c.a + c.b*c.b;
		return modulus;
	}
	
	//ANGLE on the Argand diagram measured anticlockwise from the positive real axis.
	public static double ang(Complex c) {
		double ang = Math.tan(c.b/c.a);
		return ang;
	}
	
	//COMPLEX CONJUGATE of Complex number c
	public static Complex conj(Complex c) {
		return new Complex (c.a, -1*c.b);
	}
	
	//NORMALISED Complex number c
	public static Complex norm(Complex c) {
		double a = c.a/modulus(c);
		double b = c.b/modulus(c);
		return new Complex (a,b);
	}
	
	//
	public boolean equals(Complex c) {
		
	}
		 
}
