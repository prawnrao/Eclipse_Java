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
	static double magnitude (ThreeVector v) {
		double mag = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
		
		return mag;
	}
	
	//This calculates the unit vector of the Three Vector
	static ThreeVector unitVector(ThreeVector v) {
		double unitx = v.x/magnitude(v);
		double unity = v.y/magnitude(v);
		double unitz = v.z/magnitude(v);
		return new ThreeVector(unitx,unity,unitz);	
	}
	
	//NON-STATIC scalar product between 2 Three Vectors 
	double scalarProduct(ThreeVector v) {
		double SProd = v.x*this.x+v.y*this.y+v.z*this.z;
		return SProd;
	}
	//STATIC scalar product between 2 Three Vectors 
	static double scalarProduct(ThreeVector v1,ThreeVector v2) {
		double SProd = v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
		return SProd;
	}
	
	//NON-STATIC VECTOR product between 2 Three Vectors
	ThreeVector vectorProduct(ThreeVector v2) {
		double VProdx = (this.y*v2.z)-(this.z*v2.y);
		double VPrody = (this.z*v2.x)-(this.x*v2.z);
		double VProdz = (this.x*v2.y)-(this.y*v2.x);
		return new ThreeVector(VProdx, VPrody,VProdz);
	}
	
	//STATIC VECTOR product between 2 Three Vectors
	static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
		double VProdx = (v1.y*v2.z)-(v1.z*v2.y);
		double VPrody = (v1.z*v2.x)-(v1.x*v2.z);
		double VProdz = (v1.x*v2.y)-(v1.y*v2.x);
		return new ThreeVector(VProdx, VPrody,VProdz);
	}
	
	
	
	//This is the toString code, which allows to print all the ThreeVector values easily
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
}
