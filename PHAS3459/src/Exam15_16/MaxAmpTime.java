package Exam15_16;

/**
 * Class that implements the CalTime interface
 * @author zcappra
 *
 */
public class MaxAmpTime implements CalcTime {
	
	/**
	 * Calculates the arrival time using the maximum voltage
	 */
	@Override
	public int calcTime(Pulse pulse) {
		return pulse.arrivalTime;//ns arrival time
	}

}
