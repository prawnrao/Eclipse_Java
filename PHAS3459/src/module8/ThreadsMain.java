package module8;

public class ThreadsMain extends Thread{

	public static void main(String[] args) {

		CountdownTask countTask = new CountdownTask(10);
		PrimeNumberTask primeTask = new PrimeNumberTask();

		Thread thread1 = new Thread(countTask);
		Thread thread2 = new Thread(primeTask);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
