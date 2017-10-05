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
	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		ac.loop();
		
	}

}
