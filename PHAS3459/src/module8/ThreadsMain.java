package module8;

public class ThreadsMain extends Thread{

	public static void main(String[] args) {

		CountdownTask countTask = new CountdownTask(10);//Instantiates the CountdownTask object with 10 seconds
		PrimeNumberTask primeTask = new PrimeNumberTask();//Instantiates the PrimeNumberTask object

		Thread thread1 = new Thread(countTask);//Instantiates a new thread running the CountdownTask
		Thread thread2 = new Thread(primeTask);//Instantiates a new thread running the PrimeNumberTask

		thread1.start();//begins thread1
		thread2.start();//begins thread2

		try {
			thread1.join();//waits until thread1 is dead 
			thread2.interrupt();//interrupts the PrimeNumberTask
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
