package Exam14_15_2;

import java.util.ArrayList;

public class MeanTide implements Statistic {

	public double Stat(ArrayList<Tide> tideList) {
		double sum = 0;
		double nTides = tideList.size();
		for(Tide t: tideList) {
			double level = t.getObLevel();
			sum+=level;
		}
		double meanLevel = sum/nTides;
		return meanLevel;
	}

}
