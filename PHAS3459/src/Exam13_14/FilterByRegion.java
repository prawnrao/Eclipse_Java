package Exam13_14;

import java.util.ArrayList;

public class FilterByRegion implements FilterSpecies{
	private double minLat;
	private double maxLat;

	public FilterByRegion(double minLat, double maxLat){
		this.minLat = minLat;
		this.maxLat = maxLat;
	}

	@Override
	public ArrayList<ArrayList<Double>> filerSp(ArrayList<ArrayList<Double>> sur) {
		ArrayList<ArrayList<Double>> filteredSur = new ArrayList<>();
		for(ArrayList<Double> s: sur) {
			double thisLat = Survey.getLat(s);
			if(thisLat < maxLat && thisLat > minLat) {
				filteredSur.add(s);
			}
		}

		return filteredSur;
	}

}
