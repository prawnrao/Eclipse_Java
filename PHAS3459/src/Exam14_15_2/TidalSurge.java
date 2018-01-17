package Exam14_15_2;

import java.util.ArrayList;

public class TidalSurge implements Statistic {
	public Tide maxTideSurge = null;
	
	@Override
	public double Stat(ArrayList<Tide> tideList) {
		double maxSurge = -Double.MAX_VALUE;
		for(Tide t: tideList) {
			double currSurge = (t.getObLevel())-(t.getPredLevel());
			if(currSurge>maxSurge) {
				maxSurge = currSurge;
				maxTideSurge = t;
			}
		}
		return maxSurge;
	}

}
