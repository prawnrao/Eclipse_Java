package module3;

public class FallingParticle {
	//member variables
	double m;//mass of falling particle
	double d;//drag coefficient of medium
	double t = 0;//time elapsed since particle was released
	double z;//vertical position of the particle measured from the base
	double h;//initial starting height measured from the base
	double v;//velocity of the particle measured upwards
	static final double g = 9.81;//acceleration due to gravity

	//constructor with arguments of mass and drag coefficient
	public FallingParticle(double m, double d) throws Exception {
		if (m <= 0){
			throw new Exception("Mass cannot be lesser than or equal to 0 ");
		}
		if (d<0) {
			throw new Exception("Drag coefficient cannot be negative");
		}
		this.m = m;
		this.d = d;
	}

	//sets the initial height at which the particle is dropped
	public void setH(double h) throws Exception{
		if (h < 0) {
			throw new Exception("Starting height cannot be negative");
		}
		this.h = h; 
	}

	//sets the velocity with which the particle is dropped
	public void setV(double v) {
		this.v = v;
	}

	//allows the user to get the value of z
	public double getZ() throws Exception{
		return z;
	}

	//allows the user to get the value of v
	public double getV() {
		return v;
	}

	//allows the user to get the value of t
	public double getT() {
		return t;
	}

	//each time step runs this piece of code
	public void doTimeStep(double deltaT) throws Exception{
		//calculates the acceleration at each time step
		double a = (d*v*v/m) - g; 
		//calculates the velocity at each time step
		v = getV()- a*deltaT;
		//calculates the height at each time step
		z = getZ() - v*deltaT;	
	}

	public void drop(double deltaT) throws Exception{
		//Initialises the height, velocity and time 
		z = h;
		v = 0;
		t = 0;
		//Loops as long as the height is positive
		while (z > 0) {
			doTimeStep(deltaT);
			t = t +deltaT;//increments the time
		}	
	}

}

