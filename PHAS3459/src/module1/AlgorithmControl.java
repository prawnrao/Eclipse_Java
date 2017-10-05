package module1;

public class AlgorithmControl {
	//defines the for loop for counting the integers from 1 to 10
	public void loop() {
		int i = 0;
		int maxi = 10;
		System.out.println("Numbers from 1 to 10");
		for (i=0 ; i<=maxi ; i++) {
			System.out.println("i = "+i);
		}
	}
	//defines the while loop for decrementing the integers from 5 to -12
	public void decrement() {
		int w = 5;
		int minw = -12;
		System.out.println("\nNumbers from 5 to -12");
		while (w >= minw) {
			System.out.println("w = "+w);
			w = w-1;
		}
	}
	//defines the while loop for incrementing 2.4 to 8.8 in steps of 0.2
	public void increment() {
		double b = 2.4;
		double maxb = 8.8;
		System.out.println("\nNumbers from 2.4 to 8.8 incremented by 0.2");
		while (b <= maxb) {
			System.out.printf("b = %.2f\n",b); //had to change the print out command to control the number of decimal places of the double in the output.
			b = b+0.2;
		}
	}
	
	public void timer() {
		long t = System.currentTimeMillis();
		long end = t+1;
		int c = 0;
		while(System.currentTimeMillis() < end) {
			if (c%100 == 0) {
				System.out.println("\nNumber of loops " +c);
			}
			c = c+1;	
		}
	}	
		
		
	
	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		
		//calling upon the loops that were defined above the main
		ac.loop();
		ac.decrement();
		ac.increment();
		ac.timer();
	}

}
