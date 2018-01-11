package Exam15_16;

import java.util.ArrayList;

public class Time_Max implements TimePulse{

	public int arrival(ArrayList<Double> ar) {
		double max_s = -Double.MAX_VALUE;
		int index =0;
		for(int i =0; i <ar.size();i++) {
			double s = ar.get(i);
			if(s > max_s) {
				max_s = s;
				index = i;
			}
		}
		return index;//ns
	}

}
