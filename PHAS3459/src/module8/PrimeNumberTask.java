package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{
	/**
	 * Run Method that breaks when the thread is interrupted
	 */
	public void run() {

		ArrayList<Integer> PrimeNumbers = new ArrayList<>(); //defines an arrayList that will contain all prime numbers
		int n = 2;//initialisation

		while(!Thread.currentThread().isInterrupted()) {//while loop is broken when the thread is interrupted
			boolean b = false;//initialisation of boolean

			if (n == 2) {//only runs for the number 2
				PrimeNumbers.add(n);//adds 2 to the array list of primes
				n++;
				continue;//continues the while loop
			}

			for(int i=2;i<n;i++) {
				if(n%i==0) {
					b = true;
					break;//breaks the for loop, the first instance that n mod i is zero 
				}
			}

			if (b == false) {//if n is not divisible by any i 
				PrimeNumbers.add(n);//appends arrayList of primes
			}
			n++;
		}
		System.out.println(PrimeNumbers);//prints arrayList of primes to the console
	}
}
