package module2;

public class ParticleMain {

	public static void main(String[] args) {
		//Defines a new object
		FallingParticle fp = new FallingParticle(5.2,3.6);
		//Sets the drop height
		fp.setH(10);
		//Begins the drop with dt=0.5s
		fp.drop(0.5);
		System.out.println("\ndT = 0.5");
		//extracts, and prints the time taken, final velocity 
		double t = fp.getT();
		System.out.println("Total drop time: "+t+" s");
		double v = fp.getV();
		System.out.println("Final velocity: "+-v+" m/s");
		
		//Sets the drop height
		fp.setH(10);
		//Begins the drop with dt=0.1s
		fp.drop(0.1);
		System.out.println("\ndT = 0.1");
		//extracts, and prints the time taken, final velocity 
		t = fp.getT();
		System.out.println("Total drop time: "+t+" s");
		v = fp.getV();
		System.out.println("Final velocity: "+-v+" m/s");
		
		//Sets the drop height
		fp.setH(10);
		//Begins the drop with dt=0.01s
		fp.drop(0.01);
		System.out.println("\ndT = 0.01");
		//extracts, and prints the time taken, final velocity 
		t = fp.getT();
		System.out.println("Total drop time: "+t+" s");
		v = fp.getV();
		System.out.println("Final velocity: "+-v+" m/s");
		
		//Sets the drop height
		fp.setH(10);
		//Begins the drop with dt=0.001s
		fp.drop(0.001);
		System.out.println("\ndT = 0.001");
		//extracts, and prints the time taken, final velocity 
		t = fp.getT();
		System.out.println("Total drop time: "+t+" s");
		v = fp.getV();
		System.out.println("Final velocity: "+-v+" m/s");
		
		//Sets the drop height
		fp.setH(10);
		//Begins the drop with dt=0.0001s
		fp.drop(0.0001);
		System.out.println("\ndT = 0.0001");
		//extracts, and prints the time taken, final velocity 
		t = fp.getT();
		System.out.println("Total drop time: "+t+" s");
		v = fp.getV();
		System.out.println("Final velocity: "+-v+" m/s");
		
		System.out.println("\nIncreasing the time resolution makes the calculation of the time and final velocity more \naccurate. As the time steps become smaller, the total time, and final velocity converge \nto single values respectively.");
		
	}

}
