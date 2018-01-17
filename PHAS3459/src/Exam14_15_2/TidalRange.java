package Exam14_15_2;

import java.util.ArrayList;

public class TidalRange implements Statistic {

	@Override
	public double Stat(ArrayList<Tide> tideList) {
		double maxLevel = -Double.MAX_VALUE;
		double minLevel = Double.MAX_VALUE;
		for(Tide t : tideList) {
			double currLevel = t.getObLevel();
			if(currLevel>maxLevel) {
				maxLevel = currLevel;
				continue;
			}
			if(currLevel<minLevel) {
				minLevel = currLevel;
			}
		}
		double tidalRange = maxLevel-minLevel;
		return tidalRange;
	}

}
