package module2;

public class FallingParticle {
	//member variables
	double m;//mass of falling particle
	double d;//drag coefficient of medium
	double t = 0;//time elapsed since particle was released
	double z;//vertical position of the particle measured from the base
	double h;//initial starting height measured from the base
	double v;//velocity of the particle measured upwards
	static double g = 9.81;//acceleration due to gravity
	
	//constructor with arguments of mass and drag coefficient
	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
	}
	
	//sets the initial height at which the particle is dropped
	public void setH(double h) {
		this.h = h; 
	}
	
	//sets the velocity with which the particle is dropped
	public void setV(double v) {
		this.v = v;
	}
	
	//TODO
	public double getZ(double t) {
		this.z = this.h -  t*t*((d*v*v/m)-g/2);
		return this.z;
	}
}
