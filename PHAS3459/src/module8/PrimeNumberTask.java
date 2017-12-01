package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{
	int n = 2;
	public void run() {
		
		ArrayList<Integer> Prime = new ArrayList<>();
		boolean b = true;

		while(Thread.currentThread().isInterrupted() == false) {
			if (n == 2) {
				Prime.add(n);
				n++;
				continue;
			}

			for(int i=2;i<n;i++) {
				if(n%i==0) {
					b = false;
					n++;
					break;
				}
			}

			if (b == true) {
				Prime.add(n);
			}
			n++;
		}
		System.out.println(Prime);
	}
}
