package Exam14_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Exam {
	
	public static void main(String[]args) {
		
		String urlSites = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
		String urlSitesPart3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/sites.txt";
		String url1 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt";
		String url2 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt";
		String url3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt";
		String url4 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt";
		String url5 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt";
		String url6 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt";
		ArrayList<String> urlList = new ArrayList<>();
		urlList.add(url1);
		urlList.add(url2);
		urlList.add(url3);
		ArrayList<String> urlListPart3 = new ArrayList<>();
		urlListPart3.add(url4);
		urlListPart3.add(url5);
		urlListPart3.add(url6);
		try {
			//Instantiating objects used in the main method
			ArrayList<Sites> sitesList = new ArrayList<>();
			ArrayList<Sites> sitesListPart3 = new ArrayList<>();
			ArrayList<Object> maxLevel = new ArrayList<>();
			ArrayList<Double> levelList = new ArrayList<>();
			ArrayList<Double> levelListPart3 = new ArrayList<>();
			Tide maxTide;
			HashMap<String, ArrayList<Tide>> map = new HashMap<>();
			HashMap<String, ArrayList<Tide>> mapPart3 = new HashMap<>();
			ArrayList<Tide> allTides = new ArrayList<>();
			ArrayList<Tide> allTidesPart3 = new ArrayList<>();
			//Unpacking the sites data 
			sitesList = Sites.parseData(urlSites);
			sitesListPart3 = Sites.parseData(urlSitesPart3);
//			System.out.println(sitesList);
//			System.out.println(sitesListPart3);
			
			//unpacking tide data
			allTides = Tide.tideData(urlList);
			allTidesPart3 = Tide.tideDataPart3(urlListPart3);
			levelList =Tide.levelData(allTides); 
			levelListPart3 = Tide.levelData(allTidesPart3);
			maxLevel= (Tide.maxLevel(levelList));
			maxTide = (allTides.get((int) maxLevel.get(1)));
			
			String id = maxTide.getId();
			String name = Tide.getName(id,sitesList);
			System.out.println("\n\tThe details of the maximum level recorded:");
			System.out.println("\tName:\t"+name);
			System.out.println(maxTide+"\n\n");
			
			map = Tide.tideMap(allTides, sitesList);
			mapPart3 = Tide.tideMap(allTidesPart3, sitesListPart3);
			
			//loops over the map for all sites
			for(String s:map.keySet()) {
				ArrayList<Tide> thisTideList = map.get(s);//list of tide objects for a site
				Stat ml = new MeanLevel();
				Stat tr = new TidalRange();
				Stat ts = new TidalSurge();
				double mean = 0;
				double range = 0;
				
				mean = ml.stat(thisTideList);//calculates the mean level for a site
				System.out.println("\t\tSite: "+s+"\n\tMean level was: "+mean+" m");
				range = tr.stat(thisTideList);//calculates the tidal range for a site
				System.out.println("\tTidal range was: "+range+" m\n");
				ts.stat(thisTideList);
			}
			
			System.out.println("\tPART 3 PART 3 PART 3 PART 3\n\n");
			for(String s: mapPart3.keySet()) {
				ArrayList<Tide> thisTideList = mapPart3.get(s);//list of tide objects for a site
				Stat ts = new TidalSurge();
				System.out.println("\t\tSite: "+s);
				ts.stat(thisTideList);

			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
