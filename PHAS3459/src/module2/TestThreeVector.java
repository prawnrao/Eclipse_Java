package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(3,5,2);//assigns a value to v1
		ThreeVector v2 = new ThreeVector(2,4,1);//assigns a value to v2
		ThreeVector v3 = new ThreeVector(0,0,0);//assigns a value to v3
				
		ThreeVector unitv1 = ThreeVector.unitVector(v1);//calculates the unit vector of vect1
		ThreeVector unitv2 = ThreeVector.unitVector(v2);//calculates the unit vector of vect2
		ThreeVector unitv3 = ThreeVector.unitVector(v3);//calculates the unit vector of vect3
		
		//This code block prints out the values of v1,v2,v3 and their unit vectors
		System.out.println("Vector1 is: "+v1);
		System.out.println("Unit Vector1 is: "+unitv1);
		System.out.println("\nVector2 is: "+v2);
		System.out.println("Unit Vector2 is: "+unitv2);
		System.out.println("\nVector3 is: "+v3);
		System.out.println("Unit Vector3 is: "+unitv3);
		System.out.println("The reason why the unit vector of v3 is zero is because the vector has no length.");
		
		
		//STATIC SCALAR PRODUCT
		double static_scalar_product_12 = ThreeVector.scalarProduct(v1, v2);//calculates the static scalar product between v1 and v2
		double static_scalar_product_13 = ThreeVector.scalarProduct(v1, v3);//calculates the static scalar product between v1 and v3
		System.out.println("\nScalar Product using static method between v1 and v2 is: "+static_scalar_product_12);
		System.out.println("Scalar Product using static method between v1 and v3 is: "+static_scalar_product_13);

		//NON-STATIC SCALAR PRODUCT
		double scalar_product_12 = v1.scalarProduct(v2);//calculates the non-static scalar product between v1 and v2
		double scalar_product_13 = v1.scalarProduct(v3);//calculates the non-static scalar product between v1 and v3
		System.out.println("\nScalar Product using non-static method between v1 and v2 is: "+scalar_product_12);
		System.out.println("Scalar Product using non-static method between v1 and v3 is: "+scalar_product_13);
				
		//STATIC VECTOR PRODUCT
		ThreeVector static_vector_product_12 = ThreeVector.vectorProduct(v1, v2) ;
		ThreeVector static_vector_product_13 = ThreeVector.vectorProduct(v1, v3) ;
		System.out.println("\nVector Product using static method between v1 and v2 is: "+ static_vector_product_12);
		System.out.println("Vector Product using static method between v1 and v3 is: "+ static_vector_product_13);
	
		//NON-STATIC VECTOR PRODUCT
		ThreeVector vector_product_12 = v1.vectorProduct(v2) ;
		ThreeVector vector_product_13 = v1.vectorProduct(v3) ;
		System.out.println("\nVector Product using non-static method between v1 and v2 is: "+ vector_product_12);
		System.out.println("Vector Product using non-static method between v1 and v3 is: "+ vector_product_13);
	
		
		//STATIC ANGLE 
		double static_angle12 = ThreeVector.angle(v1, v2);
		double static_angle13 = ThreeVector.angle(v1, v3);
		System.out.println("\nAngle between v1 and v2 is: "+static_angle12);
		System.out.println("\nAngle between v1 and v3 is: "+static_angle13);
		
		//NON-STATIC ANGLE 
		double angle12 = v1.angle(v2);
		double angle13 = v1.angle(v3);
		System.out.println("\nAngle between v1 and v2 is: "+angle12);
		System.out.println("\nAngle between v1 and v3 is: "+angle13);
		System.out.println("\nThe reason why the angle between v1 and v3 is not defined is because there is a divide by 0 \nin the formula for calculating the angle.");
		
		System.out.println("If you print ThreeVectors without the toString method instead of printing values it prints\nsomething similar to this : 'module2.ThreeVector@33909752'");
	}

}
