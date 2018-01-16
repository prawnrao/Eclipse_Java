package Exam15_16_2;

import java.util.ArrayList;

public class ThresholdTime implements CalcTime {
	double thresh;
	
	public ThresholdTime(double thresh) throws Exception{
		if(thresh <= 0) {
			throw new Exception (" Threshold voltage cannot be lesser than or equal to zero! ");
		}
		this.thresh = thresh;
	}
	
	@Override
	public int calcTime(Pulse pulse) {
		ArrayList<Double> ampList = pulse.ampList;
		int i = 0;
		for(double amp : ampList) {
			if(amp>thresh) {
				break;
			}
			i++;
		}
		return i;
	}

}
