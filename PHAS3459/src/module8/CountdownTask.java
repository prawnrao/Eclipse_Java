package module8;

public class CountdownTask implements Runnable{
	private int sec;

	public CountdownTask(int sec){
		this.sec = sec;
	}

	public void run() {

		while(true) {
			sec = sec - 1;
			System.out.println(sec+" seconds left");

			if (sec <= 0){
				return;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}