package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector vect1 = new ThreeVector(1,1,1);//assigns a value to vect1
		ThreeVector vect2 = new ThreeVector(2,2,2);//assigns a value to vect2
		
		double mag1 = vect1.magnitude();//calculates the magnitude of vect1
		ThreeVector unitv1 = vect1.unitVector();//calculates the unit vector of vect1
		
		System.out.println("Vector1 is: "+vect1);
		System.out.println("The magnitude of Vector1 is: "+mag1);
		System.out.println("Unit Vector1 is: "+unitv1);
		
		double scalar_product1 = vect1.scalarProduct(1,1,1,2,2,2);//calculates the scalar product between two vectors using method 1
		double scalar_product = vect1.scalarProduct(vect1, vect2);//calculates the scalar product between vect1 and vect2 using method 2
		
		System.out.println("Scalar Product is: "+scalar_product);
		System.out.println("Scalar Product between vect1 and vect2 is: "+scalar_product1);
	}

}
