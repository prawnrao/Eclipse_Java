package module6;

public class PowerLawTheory implements Theory {
	//member variable
	private double n, x;
	
	PowerLawTheory(double n){
		this.n = n;
	}
	
	public double y(double x) {
		return Math.pow(x,n);
	}
	
	public String toString() {
		return "x^"+n;
		
	}
}
