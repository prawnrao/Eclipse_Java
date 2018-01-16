package Exam15_16;

import java.util.ArrayList;

/**
 *Class that implements the CalTime interface
 * @author zcappra
 *
 */
public class ThresholdTime implements CalcTime {
	double thresh;
	
	/**
	 * Constructor that takes in the threshold used to calculate arrival time
	 * @param thresh
	 * @throws Exception
	 */
	public ThresholdTime(double thresh) throws Exception{
		if(thresh <= 0) {
			throw new Exception (" Threshold voltage cannot be lesser than or equal to zero! ");
		}
		this.thresh = thresh;
	}
	
	/**
	 * Method that calculates the arrival time by first voltage greater than threshold
	 */
	@Override
	public int calcTime(Pulse pulse) {
		ArrayList<Double> ampList = pulse.ampList;
		int i = 0;
		//loop over all amplitudes of a pulse
		for(double amp : ampList) {
			if(amp>thresh) {
				break;
			}
			i++;
		}
		return i;//ns arrival time
	}

}
