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
			
			//unpacking tide data
			allTides = Tide.tideData(urlList);
			allTidesPart3 = Tide.tideDataPart3(urlListPart3);
			//unpacking the level data
			levelList =Tide.levelData(allTides); 
			levelListPart3 = Tide.levelData(allTidesPart3);
			
			//determining the max level
			maxLevel= (Tide.maxLevel(levelList));
			//finding the max tide from maxLevel
			maxTide = (allTides.get((int) maxLevel.get(1)));
			
			//identifier of maxTide
			String id = maxTide.getId();
			//Site name of maxTide
			String name = Tide.getName(id,sitesList);
			//Output
			System.out.println("\n\tThe details of the maximum level recorded:");
			System.out.println("\tName:\t"+name);
			System.out.println(maxTide+"\n\n");
			
			//Creates HashMaps of Site id and ArrayList of Tide objects
			map = Tide.tideMap(allTides, sitesList);
			mapPart3 = Tide.tideMap(allTidesPart3, sitesListPart3);
			
			//loops over the map for all sites (part 1 and part 2)
			for(String s:map.keySet()) {
				name = Tide.getName(s,sitesList);//gets the site name for the current id (s)
				//gets an ArrayList of tide objects from map for id s
				ArrayList<Tide> thisTideList = map.get(s);
				//instantiates new implementations of the Stat interface
				Stat ml = new MeanLevel();
				Stat tr = new TidalRange();
				Stat ts = new TidalSurge();
				//variables to store Stat method results
				double mean = 0;
				double range = 0;
				
				mean = ml.stat(thisTideList);//calculates the mean level for a site
				
				System.out.println("------x------Site: "+s+"\tName: "+name+"------X------\n\n\tMean level was: "+mean+" m");
				range = tr.stat(thisTideList);//calculates the tidal range for a site
				
				System.out.println("\tTidal range was: "+range+" m\n");
				ts.stat(thisTideList);//calculates the max tidal surge for a site
			}
			
			
			System.out.println("-------x-------x-------PART 3-------x-------x--------\n\n");
			//loops over the map for all sites (part 3)
			for(String s: mapPart3.keySet()) {
				
				name = Tide.getName(s,sitesListPart3);
				
				ArrayList<Tide> thisTideList = mapPart3.get(s);//list of tide objects for a site
				Stat ts = new TidalSurge();
				
				System.out.println("------x------Site: "+s+"\tName: "+name+"------X------\n\n");
				
				ts.stat(thisTideList);//calculates the max tidal suge for a site

			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
