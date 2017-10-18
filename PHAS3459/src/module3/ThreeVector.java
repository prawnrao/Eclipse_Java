package module3;

public class ThreeVector {
	// member variables
	double x, y, z;
	//constructor
	public ThreeVector(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//STATIC MAGNITUDE of a ThreeVecotr
	static double magnitude (ThreeVector v) {
		double mag = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);

		return mag;
	}

	//STATIC UNIT VECTOR
	static ThreeVector unitVector(ThreeVector v) throws Exception {
		if ((v.x == 0) && (v.y == 0) &&(v.z == 0)){
			throw new Exception("Divide by 0 error while trying to calculate the unit vector of ");
		}
		double unitx = v.x/magnitude(v);
		double unity = v.y/magnitude(v);
		double unitz = v.z/magnitude(v);
		return new ThreeVector(unitx,unity,unitz);	
	}

	//STATIC scalar product of two ThreeVectors
	static double scalarProduct(ThreeVector v1,ThreeVector v2) {
		double SProd = v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
		return SProd;
	}

	//NON-STATIC scalar product of two ThreeVectors
	double scalarProduct(ThreeVector v) {
		return scalarProduct(this, v);
	}


	//STATIC VECTOR product of two ThreeVectors
	static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
		double VProdx = (v1.y*v2.z)-(v1.z*v2.y);
		double VPrody = (v1.z*v2.x)-(v1.x*v2.z);
		double VProdz = (v1.x*v2.y)-(v1.y*v2.x);
		return new ThreeVector(VProdx, VPrody,VProdz);
	}

	//NON-STATIC VECTOR of two ThreeVectors
	ThreeVector vectorProduct(ThreeVector v) {
		return vectorProduct(this,v);
	}

	//STATIC ADDITION of two ThreeVectors
	static ThreeVector add(ThreeVector v1,ThreeVector v2) {
		double addx = v1.x+v2.x;
		double addy = v1.y+v2.y;
		double addz = v1.z+v2.z;
		return new ThreeVector(addx,addy,addz);
	}

	//NON-STATIC ADDITION of two ThreeVectors
	ThreeVector add(ThreeVector v) {
		return add(this,v);
	}

	//STATIC ANGLE between two ThreeVectors
	static double angle(ThreeVector v1, ThreeVector v2) throws Exception {
		if ((v1.x == 0) && (v1.y == 0) && (v1.z == 0) || (v2.x == 0) && (v2.y == 0) && (v2.z == 0) ){
			throw new Exception("Divide by 0 error while trying to calculate the angle between ");
		}
		double theta = Math.acos((scalarProduct(v1,v2)/(magnitude(v1)*magnitude(v2))));
		return theta;
	}

	//NON-STATIC ANGLE between two ThreeVectors
	double angle(ThreeVector v) throws Exception {

		return angle(this,v);
	}


	//This is the toString code, which allows to print all the ThreeVector values easily
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
}
