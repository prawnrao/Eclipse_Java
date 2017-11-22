package module6;

public class LabelledDataPoint extends DataPoint{
	public String label;

	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label = label;
	}

	//defines the toString method, to print out a datapoint
	public String toString() {
		return label +": x = "+ x + ", y = "+ y + " +- "+ ey;

	}
}
