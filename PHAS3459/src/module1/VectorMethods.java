package module1;

public class VectorMethods {
	public VectorMethods() {}
	
	public double magnitude(double x, double y, double z) {
		double mag;
		mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VectorMethods vm = new VectorMethods();
		
			}

}
