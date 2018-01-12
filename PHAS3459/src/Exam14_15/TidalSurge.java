package Exam14_15;

import java.util.ArrayList;

public class TidalSurge implements Stat {

	/**
	 * Method that calculates the maximum surge for an ArrayList of tide objects
	 */
	public double stat(ArrayList<Tide> tideList) {
		double maxSurge = -Double.MAX_VALUE;  
		int index=0;
		int maxIndex = 0;
		for(Tide t :tideList) {
			double thisLevel = t.getLevel();
			double predLevel = t.getPredLevel();
			double thisSurge = thisLevel - predLevel;
			if(thisSurge>maxSurge) {
				maxSurge = thisSurge;
				maxIndex = index;
			}
			index++;
		}
		System.out.println("\tDetails of maximum surge:\n"+tideList.get(maxIndex)+"\n\tSurge: "+maxSurge+"\n\n\n");
		return maxSurge;
	}
	
}
