package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector vect1 = new ThreeVector(1,1,1);
		vect1.magnitude();
		System.out.println(vect1.magnitude());
		System.out.println(vect1.unitVector());
	}

}
