package Exam14_15;

import java.util.ArrayList;

public class TidalRange implements Stat{

	public double stat(ArrayList<Tide> tideList) {
		ArrayList<Double> levelList = new ArrayList<>();
		levelList = Tide.levelData(tideList);
		
		return 0;
	}
	

}
