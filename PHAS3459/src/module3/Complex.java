package module3;

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
		double modulus = Math.sqrt(c.a*c.a + c.b*c.b);
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
	static Complex norm(Complex c) throws Exception {
		if ((c.a == 0) && (c.b == 0)){
			throw new Exception("Divide by 0 error while trying to normalise");
		}
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

	//ADDITION of two complex numbers
	static Complex add(Complex c1, Complex c2) {
		double a = c1.a + c2.a;
		double b = c1.b + c2.b;
		return new Complex(a,b);
	}	

	//SUBTRACTION of two complex numbers
	static Complex subtract(Complex c1, Complex c2) {
		double a = c1.a - c2.a;
		double b = c1.b - c2.b;
		return new Complex(a,b);
	}		

	//MULTIPLICATION of two complex numbers
	static Complex multiply(Complex c1, Complex c2) {
		double a = (c1.a * c2.a) - (c1.b *c2.b);
		double b = (c1.a * c2.b) + (c1.b * c2.a);
		return new Complex(a,b);
	}	

	//DIVISION of two complex numbers
	static Complex divide(Complex c1, Complex c2) throws Exception {
		if ((c2.a == 0) && (c2.b == 0)){
			throw new Exception("Divide by 0 error while trying to divide ");
		}
		double a = ((c1.a*c2.a+c1.b*c2.b)/(c2.a*c2.a+c2.b*c2.b));
		double b = ((c1.b*c2.a-c1.a*c2.b)/(c2.a*c2.a+c2.b*c2.b));
		return new Complex(a,b);
	}	

	//This is the toString code, which allows to print all the complex values easily
	public String toString() {
		if (b> 0) {
			return a+"+"+b+"i";
		}		
		if (b<0) {
			return a+""+b+"i";
		}
		if (b==0) {
			return a+" ";
		}
		if (a==0) {
			return b+" ";
		}
		else return a+" ";
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
