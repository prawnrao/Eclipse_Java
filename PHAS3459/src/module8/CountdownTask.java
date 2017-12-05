package module8;

public class CountdownTask implements Runnable{
	private int sec;
	/**
	 * Constructor of CountDownTask object
	 * @param sec
	 */
	public CountdownTask(int sec){
		this.sec = sec;
	}
	
	/**
	 * Run method that returns after a defined number of seconds
	 */
	public void run() {

		while(true) {
			sec = sec - 1;//decrements the number of seconds by 1
			System.out.println(sec + " seconds left");

			if (sec <= 0){//returns when number of seconds left is 0
				return;
			}

			try {
				Thread.sleep(1000);//waits for 1 second before looping again
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}