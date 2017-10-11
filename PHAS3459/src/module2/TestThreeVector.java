package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector vect1 = new ThreeVector(1,1,1);
		double mag1 = vect1.magnitude();
		ThreeVector unitv1 = vect1.unitVector();
		System.out.println("The vector is: "+vect1);
		System.out.println("The magnitude is: "+mag1);
		System.out.println("Unit Vector is: "+unitv1);
		
	}

}
