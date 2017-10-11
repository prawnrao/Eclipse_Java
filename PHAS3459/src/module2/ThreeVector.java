package module2;

public class ThreeVector {
	// member variables
	double x, y, z;
	
	//constructor
	public ThreeVector(double x,double y,double z) {}

	//This calculates the magnitude of the Three Vector
	double magnitude () {
		double mag = Math.sqrt(x*x + y*y + z*z);
		
		return mag;
	}
	
	ThreeVector unitVector() {
		double unitx = x/magnitude();
		double unity = y/magnitude();
		double unitz = z/magnitude();
		return new ThreeVector(unitx, unity, unitz);
		
	}
}
