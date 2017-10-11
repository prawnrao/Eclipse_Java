package module2;

public class ThreeVector {
	// member variables
	double x, y, z;
	double mag;
	//constructor
	public ThreeVector(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	//This calculates the magnitude of the Three Vector
	double magnitude () {
		double mag = Math.sqrt(x*x + y*y + z*z);
		this.mag = mag;
		return mag;
	}
	
	ThreeVector unitVector() {
		double unitx = x/mag;
		double unity = y/mag;
		double unitz = z/mag;
		return new ThreeVector(unitx,unity,unitz);	
	}
	
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
}
