package Exam15_16_2;

public class MaxAmpTime implements CalcTime {
	
	@Override
	public int calcTime(Pulse pulse) {
		return pulse.arrivalTime;
	}

}
