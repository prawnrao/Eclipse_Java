package Exam14_15;

import java.util.ArrayList;

public class TidalRange implements Stat{

	/**
	 * Method that calculates the tidal range for an ArrayList of Tide objects
	 */
	public double stat(ArrayList<Tide> tideList) {
		ArrayList<Double> levelList = new ArrayList<>();
		levelList = Tide.levelData(tideList);
		double maxLevel = -Double.MAX_VALUE;  
		double minLevel = Double.MAX_VALUE;
		for(double d:levelList) {
			if(d>maxLevel) {
				maxLevel = d;
				continue;
			}
			if(d<minLevel) {
				minLevel = d;
				continue;
			}
		}
		double levelDiff = maxLevel - minLevel;
		return levelDiff;
	}
}
