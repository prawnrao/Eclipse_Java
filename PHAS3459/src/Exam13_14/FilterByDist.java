package Exam13_14;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;

public class FilterByDist implements FilterSpecies{
	private double lat;
	private double lon;
	private double r = 6371;//km
	private double h;
	private double maxD;
	
	public FilterByDist(double lat, double lon, double maxD) {
		this.lat = lat;
		this.lon = lon;
		this.maxD = maxD;
	}
	
	public ArrayList<ArrayList<Double>> filerSp(ArrayList<ArrayList<Double>> sur) {
		ArrayList<ArrayList<Double>> filteredSur = new ArrayList<>();
		for(ArrayList<Double> s: sur) {
			double thisLat = Survey.getLat(s);
			double thisLon = Survey.getLon(s);
			double thisH = H((thisLat),(thisLon));
			double thisD = dist(r,thisH);
			if(thisD<maxD) {
				filteredSur.add(s);
			}
					
		}
		return filteredSur;
	}

	
	public double H(double lat, double lon) {
		double a = (1-Math.cos(lat-this.lat))/2;
		double b = Math.cos(lat)*Math.cos(this.lat)*(1-Math.cos(lon-this.lon))/2;
		double H = a+b;
		return H;
	}
	
	public double dist(double r, double h) {
		double d = 2* r*Math.asin(h);
		return d;
	}
}
