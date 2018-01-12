package Exam14_15;

import java.util.ArrayList;

public class MeanLevel implements Stat{
	
	/**
	 * Method that calculates the mean level for an ArrayList of Tide objects
	 */
	public double stat(ArrayList<Tide> tideList) {
		double sum = 0;
		double meanLevel = 0;
		ArrayList<Double> levelList = new ArrayList<>();
		levelList = Tide.levelData(tideList);
		for(double d :levelList) {
			sum+=d;
		}
		meanLevel = sum/levelList.size();
		return meanLevel;
	}
}
