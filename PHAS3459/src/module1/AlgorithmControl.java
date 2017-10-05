package module1;

public class AlgorithmControl {
	public void loop() {
		int i = 0;
		int maxi = 10;
		System.out.println("Numbers from 1 to 10");
		for (i=0 ; i<=maxi ; i++) {
			System.out.println("i = "+i);
		}
	}
	
	public void decrement() {
		int w = 5;
		int minw = -12;
		System.out.println("Numbers from 5 to -12");
		while (w >= minw) {
			System.out.println("w = "+w);
			w = w-1;
		}
	}
	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		
		
		ac.loop();
		ac.decrement();
	}

}
