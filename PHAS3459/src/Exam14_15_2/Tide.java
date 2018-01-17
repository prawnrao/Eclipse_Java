package Exam14_15_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tide {
	private String id;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private double obLevel;
	private double predLevel;
	private String siteName;

	public Tide(String id, int year, int month, int day, int hour, int min, double obLevel, double predLevel) {
		this.id = id;
		this.year = year;
		this.month = month; 
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.obLevel = obLevel;
		this.predLevel = predLevel;
	}

	public static ArrayList<Tide> tideList(ArrayList<String> urlList) throws IOException{
		ArrayList<Tide> tideList = new ArrayList<>();
		for(String urlName: urlList) {
			URL url = new URL(urlName);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			Scanner sc = new Scanner(br);
			Tide tide;
			while(sc.hasNext()) {
				if(sc.hasNextDouble()) {
					int year = sc.nextInt();
					int month = sc.nextInt();
					int day = sc.nextInt();
					int hour = sc.nextInt();
					int min = sc.nextInt();
					String id = sc.next();
					double level = sc.nextDouble();
					double predLevel = sc.nextDouble();
					tide = new Tide(id,year,month,day,hour,min,level,predLevel);
					tideList.add(tide);
				}
				else {
					String id = sc.next();
					int year = sc.nextInt();
					int month = sc.nextInt();
					int day = sc.nextInt();
					int hour = sc.nextInt();
					int min = sc.nextInt();
					double level = sc.nextDouble();
					double predLevel = sc.nextDouble();
					tide = new Tide(id,year,month,day,hour,min,level,predLevel);
					tideList.add(tide);
				}
			}
			sc.close();
		}
		return tideList;
	}

	public static ArrayList<ArrayList<String>> sitesList(String urlName) throws IOException{
		ArrayList<ArrayList<String>> sitesList = new ArrayList<>();
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();

		String line = "";
		while((line = br.readLine())!=null) {
			Scanner sc = new Scanner(line);
			String name = sc.next();
			String id = sc.next();
			ArrayList<String> site = new ArrayList<>();
			site.add(id);
			site.add(name);
			sitesList.add(site);
		}
		return sitesList;
	}

	public static HashMap<String,ArrayList<Tide>> tideMap(ArrayList<ArrayList<String>> sitesList,ArrayList<Tide> tideList) throws IOException{
		HashMap<String,ArrayList<Tide>> tideMap = new HashMap<>();
		for(ArrayList<String> site : sitesList) {
			String id = site.get(0);
			for(Tide tide : tideList) {
				String thisID = tide.getID();
				if(thisID.equals(id)) {
					if(tideMap.get(id)==null) {
						tideMap.put(id, new ArrayList<Tide>());
					}
					String siteName = site.get(1);
					tide.setSiteName(siteName);
					tideMap.get(id).add(tide);
				}
			}
		}
		return tideMap;
	}

	public static Tide maxTide(HashMap<String,ArrayList<Tide>> tideMap) {
		double maxObLevel = -Double.MAX_VALUE;
		Tide maxTide = null;
		for(String id: tideMap.keySet()) {
			ArrayList<Tide> tideList = tideMap.get(id);
			for(Tide t: tideList) {
				double currObLevel = t.getObLevel();
				if(currObLevel>maxObLevel) {
					maxObLevel = currObLevel;
					maxTide = t;
				}
			}
		}
		return maxTide;
	}

	public static void siteInfo(HashMap<String,ArrayList<Tide>>tideMap) {
		for(String id : tideMap.keySet()) {
			ArrayList<Tide> tideList = tideMap.get(id);
			Tide t = tideList.get(0);
			Statistic mt = new MeanTide();
			double meanTide = mt.Stat(tideList);
			System.out.println("\nSite: "+t.getSiteName()+" ("+id+")\nMean Tide: "+meanTide+" m");
			Statistic tr = new TidalRange();
			double tidalRange = tr.Stat(tideList);
			System.out.println("Tidal Range: "+tidalRange+" m");
		}
	}

	public static void maxSurge(HashMap<String,ArrayList<Tide>> tideMap) {
		double maxSurge = -Double.MAX_VALUE;
		Tide maxTideSurge = null;
		for(String id : tideMap.keySet()) {
			ArrayList<Tide> tideList = tideMap.get(id);
			TidalSurge ts = new TidalSurge();
			double currSurge = ts.Stat(tideList);
			if(currSurge > maxSurge) {
				maxSurge =  currSurge;
				maxTideSurge = ts.maxTideSurge;
			}
		}
		System.out.println("\n\nSite details for the highest surge:"+maxTideSurge+"\nSurge: "+maxSurge+" m");
	}

	private String getSiteName() {
		return siteName;
	}

	public double getObLevel() {
		return obLevel;
	}

	public void setSiteName(String name) {
		siteName = name;	
	}

	public String getID() {
		return id;
	}

	public String toString() {
		String s = "";
		s = "\nSite Name: "+siteName+"\nDate: "+day+"/"+month+"/"+year+" Time: "+hour+":"+min+"  \nObserved Level: "+obLevel+" m  \nPredected Level: "+ predLevel+" m";
		return s;
	}

	public double getPredLevel() {
		return predLevel;

	}
}
