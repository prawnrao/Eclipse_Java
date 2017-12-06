package module8;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String [] args) {

		long nPoints = 10000000L;//number of points used for the simulation

		//SINGLE THREAD CALCULATION
		MonteCarloPiCalculatorTask pi_task1 = new MonteCarloPiCalculatorTask(nPoints);//Instantiates a new MonteCarloPiCalculator object
		long start_t = System.currentTimeMillis();//start timer
		
		double pi1 = pi_task1.call();//performs the calculation
		
		long end_t = System.currentTimeMillis();//end timer
		System.out.println("pi = "+pi1);
		
		long time = end_t - start_t;//calculates the time to find pi using a single thread
		System.out.println(time+" milliseconds for single threaded task\n");

		
		//MULTI-THREAD CALCULATION
		int  nThreads = 4;//number of threads
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		//creates an arrayList of future objects which will store each thread's value of pi
		ArrayList<Future<Double>> futures = new ArrayList<Future<Double>>();

		long start_t1 = System.currentTimeMillis();//start timer
		for (int iThread = 0; iThread < nThreads; ++iThread) {//loops over all threads

			MonteCarloPiCalculatorTask pi_task2 = new MonteCarloPiCalculatorTask(nPoints/nThreads);//performs the calculation 
			Future<Double> future = threadPool.submit(pi_task2);
			futures.add(future);

		}

		double sum = 0.0;

		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = 0;

			try {
				result = futures.get(iThread).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			sum += result;//calculates the running total
		}

		threadPool.shutdown();
		double pi2 = sum/nThreads;//calculates the average pi value from the threads
		long end_t1 = System.currentTimeMillis();//end timer
		
		time  = end_t1 - start_t1;//calculates time taken to find pi using multiple threads
		System.out.println("pi = " +pi2+"\n"+time +" milliseconds for multi-threaded task\n");
		
		System.out.println("As shown ablove the multi-threaded time is significantly shorter that the single threaded time,"
				+ "\nhowever the value of pi is not better."
				+ "\nThis is because the value of pi calculated is dependent on the number of random points, not how long "
				+ "\nit takes to calculate them. The multi-threaded task is significantly faster becasue each thread runs"
				+ "\n1/n number of points where n is the number of threads. However each thread has less number of random"
				+ "\npoints and hence the value of pi will be less accurate and less precise.");
	}
}
