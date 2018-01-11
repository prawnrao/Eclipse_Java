package Exam15_16;

import java.util.ArrayList;

public class Time_threshold implements TimePulse{
	private double thresh;

	public Time_threshold(double thresh) {
		this.thresh = thresh;
	}
	
	public int arrival(ArrayList<Double> ar) {
		int index = 0;
		for(int i=0;i<ar.size();i++) {
			if(ar.get(i)>thresh) {
				index = i;
				break;
			}
		}
		return index;//ns
	}

}
