package module3;

public class TestException {

	public static void main(String[] args) {

		//COMPLEX TEST
		//Defines complex numbers c1 and c2
		Complex c1 = new Complex(1,2);
		Complex c2 = new Complex(-2,-1);

		//Calculates the ratio of c1 to c2 (c1/c2)
		try {
			Complex ratio_c1c2 = Complex.divide(c1, c2);
			System.out.println("The ratio of c1 to c2 is: "+ratio_c1c2);
		}
		catch (Exception e) {
			System.out.println(e+"c1 and c2");
		}

		//Calculates the ratio of c1 to 0
		try {
			Complex ratio_c1Zero = Complex.divide(c1, Complex.Zero);
			System.out.println("The ratio of c1 and 0 is: "+ratio_c1Zero);
		} 
		catch (Exception e) {
			System.out.println(e+"c1 and 0");
		}

		//THREEVECTOR TEST
		ThreeVector v1 = new ThreeVector(3,5,2);//assigns a value to v1
		ThreeVector v3 = new ThreeVector(0,0,0);//assigns a value to v3

		//calculates the unit vector of vect3
		try { 
			ThreeVector unitv3 = ThreeVector.unitVector(v3);
			System.out.println("Unit Vector3 is: "+unitv3);
		} 
		catch (Exception e) {
			System.out.println(e+"v3");
		}

		//calculates the unit vector of vect3
		try { 
			double static_angle13 = ThreeVector.angle(v1, v3);
			System.out.println("\nAngle between v1 and v2 is: "+static_angle13+" rad");

		} 
		catch (Exception e) {
			System.out.println(e+"v1 and v3");
		}

		//FALLING PARTICLE TEST
		//Defines a new object and sets the initial height
		FallingParticle fp = null;
		try {
			fp = new FallingParticle(5.2,3.6);
			fp.setH(10);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}


