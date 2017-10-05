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
	
	public int timer(long maxTime,int loopSteps) {
		long t = System.currentTimeMillis(); //sets the start time to the current time
		long endTime = t+maxTime;//sets the end time, which is eventually used to break the loop
		int c = 0;//sets the counter to 0
		while(System.currentTimeMillis() < endTime) {//creates a loop which stops once the time overshoots the end time
			if (c % loopSteps == 0) {//executes every certain number of loops
				System.out.println("Number of loops " +c);//prints the number of loops every certain number of loops
			}
			c = c+1;	//increments the counter
		}
		return c;
	}	
		
		
	
	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		
		//calling upon the loops that were defined above the main
		ac.loop();
		ac.decrement();
		ac.increment();
		
		//input the runtime in milliseconds and the frequency of the number of loops being displayed
		int totalLoops1 = ac.timer(8000,1000);
		//System.out.println("\nTotal number of loops with 8 seconds and 1000 loop frequency "+totalLoops1);
		
		//input the runtime in milliseconds and the frequency of the number of loops being displayed
		int totalLoops2 = ac.timer(8000,40000);
		System.out.println("\nTotal number of loops with 8 seconds and 1000 loop frequency "+totalLoops1);
		System.out.println("\nTotal number of loops with 8 seconds and 40000 loop frequency "+totalLoops2);
		System.out.println("\n The number of loops completed when using a loop frequency of 40000 was\n more than the number of loops completed with a 1000 loop frequency\n this is because the computer is outputting less\n frequently and hence has more computing power to run the loop itself");
	}

}
