package Exam14_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Exam {
	
	public static void main(String[]args) {
		
		String urlSites = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
		String url1 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt";
		String url2 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt";
		String url3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt";
		ArrayList<String> urlList = new ArrayList<>();
		urlList.add(url1);
		urlList.add(url2);
		urlList.add(url3);
		
		try {
			ArrayList<Sites> sitesList = new ArrayList<>();
			ArrayList<Object> maxLevel = new ArrayList<>();
			ArrayList<Double> levelList = new ArrayList<>();
			Tide maxTide;
			HashMap<String, ArrayList<Tide>> map = new HashMap<>();
			
			sitesList = Sites.parseData(urlSites);
			System.out.println(sitesList);
			ArrayList<Tide> allTides = new ArrayList<>();
			
			allTides = Tide.tideData(urlList);
			levelList =Tide.levelData(allTides); 
			maxLevel= (Tide.maxLevel(levelList));
			maxTide = (allTides.get((int) maxLevel.get(1)));
			
			String id = maxTide.getId();
			String name = Tide.getName(id,sitesList);
			System.out.println("\nName:\t"+name);
			System.out.println(maxTide);
			
			Stat ml = new MeanLevel();
			double mean = 0;
			mean = ml.stat(allTides);
			System.out.println("Mean Level:\t"+mean+" m");
			
			map = Tide.tideMap(allTides, sitesList);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
