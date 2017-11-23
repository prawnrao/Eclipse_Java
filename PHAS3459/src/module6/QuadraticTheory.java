package module6;

public class QuadraticTheory implements Theory{
	//member variables
	private double a,b,c;

	QuadraticTheory(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double y(double x) {
		return a*Math.pow(x, 2) + b*x + c;
	}

	public String toString() {
		return a+"x^2 + "+b+"x + "+c;

	}
}
