package Exam14_15_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main (String[] args) {
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
		String urlIndexPart3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/sites.txt";
		String url1999 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt";
		String url2000 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt";
		String url2001 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt";
		ArrayList<String> urlList = new ArrayList<>();
		
		urlList.add(url1999);
		urlList.add(url2000);
		urlList.add(url2001);
		
		String url2002 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt";
		String url2003 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt";
		String url2004 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt";
		ArrayList<String> urlListPart3 = new ArrayList<>();
		
		urlListPart3.add(url2002);
		urlListPart3.add(url2003);
		urlListPart3.add(url2004);
		
		try {
			//----------PART 1--------------------PART 1----------//
			ArrayList<Tide> tideLists = Tide.tideList(urlList);
			ArrayList<ArrayList<String>> sitesList = Tide.sitesList(urlIndex);
			HashMap<String,ArrayList<Tide>> tideMap = Tide.tideMap(sitesList, tideLists);
			
			
			//----------PART 2--------------------PART 2----------//
			Tide maxTide = Tide.maxTide(tideMap);
			System.out.println(maxTide);
			Tide.siteInfo(tideMap);
			
			
			//----------PART 3--------------------PART 3----------//
			Tide.maxSurge(tideMap);
			
			System.out.println("\n\n-------------Part 3 DATA--------------");
			tideLists = Tide.tideList(urlListPart3);
			sitesList = Tide.sitesList(urlIndexPart3);
			tideMap = Tide.tideMap(sitesList, tideLists);
			Tide.maxSurge(tideMap);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
