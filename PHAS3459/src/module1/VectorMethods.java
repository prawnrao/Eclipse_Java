package module1;

public class VectorMethods {
	
	public VectorMethods() {}
	
	//defines the function to find the magnitude of a vector
	public double magnitude(double x, double y, double z) {
		double mag;
		mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
	}
	
	//defines the function to find the dot product between two vectors
	public double dotProduct(double x1, double y1, double z1, double x2, double y2, double z2 ) {
		double dotProd;
		dotProd = x1*x2 +y1*y2+z1*z2;
		return dotProd;
	}
	
	//defines the function to find the angle between two vectors
	public double angle(double x1, double y1, double z1, double x2, double y2, double z2) {
		double ang;
		ang = Math.acos(dotProduct(x1,y1,z1,x2,y2,z2)/(magnitude(x1,y1,z1)*magnitude(x2,y2,z2)));
		return ang;
	}
	
	public static void main(String[] args) {

		VectorMethods vm = new VectorMethods();
		
		//Calls the magnitude function, to determine the magnitude of the vector (5,3,4)
		double mag1 = vm.magnitude(5,3,4);
		System.out.println("\nThe magnitude of (5,3,4) vector is: "+mag1);
		
		//Calls the angle function to determine the angle between the two vectors (2,3,4) and (1,3,2)
		double ang1 = vm.angle(2,3,4,1,3,2);
		System.out.println("\nThe angle between (2,3,4) and (1,3,2) is: "+ang1+" radians");
		
		//Calls the angle function to try to find the angle between the two vectors (2,3,4) and (0,0,0)
		double ang2 = vm.angle(2,3,4,0,0,0);
		System.out.println("\nThe angle between (2,3,4) and (0,0,0) is: "+ang2+" radians");
		System.out.println("The angle function is defined using the dot product method and so when \nattempting to solve it for (2,3,4) and (0,0,0) it runs into a divide by zero \nand returns 'not a number' as the answer.");
			}
		
}
