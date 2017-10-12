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
	
	//This calculates the unit vector of the Three Vector
	ThreeVector unitVector() {
		double unitx = x/mag;
		double unity = y/mag;
		double unitz = z/mag;
		return new ThreeVector(unitx,unity,unitz);	
	}
	
	//This piece of code calculates the scalar product between 2 Three Vectors that are manually inputed 
	double scalarProduct(double x1,double y1,double z1,double x2,double y2,double z2) {
		double SProd = x1*x2+y1*y2+z1*z2;
		return SProd;
	}
	//This piece of code overloads the scalarProduct function, and allows it to take 2 ThreeVector variables to calculate the scalar product
	double scalarProduct(ThreeVector v1,ThreeVector v2) {
		double SProd = v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
		return SProd;
	}
	
	//This is the toString code, which allows to print all the ThreeVector values easily
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
}
