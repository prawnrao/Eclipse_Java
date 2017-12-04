package module8;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {
	
	public static void main(String [] args) {
		
		long nPoints = 10000000L;
		
		  MonteCarloPiCalculatorTask pi_task1 = new MonteCarloPiCalculatorTask(nPoints);
		  double pi1 = pi_task1.call();
		  System.out.println(pi1);

		  
		  int  nThreads = 4;//number of threads
		  
		  ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		  
		  ArrayList<Future<Double>> futures = new ArrayList<Future<Double>>();
		  
		  for (int iThread = 0; iThread < nThreads; ++iThread) {//loops over all threads
			  
		    MonteCarloPiCalculatorTask pi_task2 = new MonteCarloPiCalculatorTask(nPoints/nThreads);
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
		    sum += result;
		  }
		  
		  threadPool.shutdown();
		  double pi2 = sum/nThreads;
		  System.out.println(pi2);
	}
}
