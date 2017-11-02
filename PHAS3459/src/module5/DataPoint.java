package module5;

public class DataPoint {
	//Member variables
	private double x, y, ey;
	private double n;
	
	//Constructor
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getEY() {
		return ey;
	}
	
	
}
