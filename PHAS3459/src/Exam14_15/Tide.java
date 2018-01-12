package Exam14_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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
	private double level;
	private double predLevel;

	/**
	 * Constructor of Tide Object
	 * @param id
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param min
	 * @param level
	 * @param predLevel
	 */
	public Tide(String id, int year, int month, int day, int hour, int min, double level, double predLevel ) {
		this.id = id;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.level = level;
		this.predLevel = predLevel;
	}

	/**
	 * Unpacks all the tide data from multiple URLs
	 * @param urlList
	 * @return ArrayList of Tide Objects
	 * @throws IOException
	 */
	public static ArrayList<Tide> tideData(ArrayList<String> urlList) throws IOException {
		ArrayList<Tide> tideList = new ArrayList<>();
		for(String s:urlList) {
			URL url = new URL(s);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			Scanner sc = new Scanner(br);
			Tide tide;
			while(sc.hasNext()) {
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
		return tideList;
	}

	/**
	 * Determines the value and index of the maximum level
	 * @param levelList
	 * @return ArrayList containing value,index
	 */
	public static ArrayList<Object> maxLevel(ArrayList<Double> levelList) {
		ArrayList<Object> max = new ArrayList<>();
		double maxLevel = -Double.MAX_VALUE;
		int index = 0;
		int maxIndex = -Integer.MAX_VALUE;
		for(int i=0;i<levelList.size();i++) {
			double level = levelList.get(i);

			if(level>maxLevel) {
				maxLevel = level;
				maxIndex = i;
			}
		}
		max.add(maxLevel);
		max.add(maxIndex);
		return max;
	}
	
	//getter methods
	public double getLevel() {
		return level;
	}
	public String toString() {
		String s = "";
		s = "\tId: "+this.id+" Date: "+this.day+"/"+this.month+
				"/"+this.year+" Time: "+this.hour+":"+this.min+
				"\n\tLevel:\t"+this.level+"m  Predicted Level: "+this.predLevel+"m";
		return s;
	}
	public String getId() {
		return id;
	}
	public double getPredLevel() {
		return predLevel;
	}

	/**
	 * Determines a site name for an index
	 * @param id
	 * @param sitesList
	 * @return String of site name
	 */
	public static String getName(String id, ArrayList<Sites> sitesList) {
		String name="";
		for(Sites s:sitesList) {
			String thisId = s.getPort();
			if(thisId.equals(id)) {
				name = s.getSiteName();
			}
		}
		return name;
	}

	/**
	 * Creates an ArrayList of doubles containing all the level data
	 * @param tideList
	 * @return ArrayList of Doubles (level data)
	 */
	public static ArrayList<Double> levelData(ArrayList<Tide> tideList) {
		ArrayList<Double> levelList = new ArrayList<>();
		for(Tide t: tideList) {
			double level = t.getLevel();
			levelList.add(level);
		}
		return levelList;
	}

	/**
	 * Creates a HashMap of string to ArrayList<Tide>
	 * @param tideList
	 * @param siteList
	 * @return
	 */
	public static HashMap<String,ArrayList<Tide>> tideMap(ArrayList<Tide> tideList,ArrayList<Sites> siteList){
		HashMap<String,ArrayList<Tide>> map = new HashMap<>();
		
		for(Tide t : tideList) {
			String thisId = "";
			String id = t.getId();
			for(Sites s : siteList) {
				thisId = s.getPort();
				if(thisId.equals(id)) {
					break;
				}
			}
			ArrayList<Tide> list = map.get(id);
			if(list == null) {
				map.put(id, new ArrayList<Tide>());
			}
			map.get(id).add(t);
		}
		return map;

	}

	/**
	 * Unpacks all the tide data from multiple URLs
	 * @param urlList
	 * @return ArrayList of Tide Objects
	 * @throws IOException
	 */
	public static ArrayList<Tide> tideDataPart3(ArrayList<String> urlList) throws IOException{
		ArrayList<Tide> tideList = new ArrayList<>();
		for(String s:urlList) {
			URL url = new URL(s);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			Scanner sc = new Scanner(br);
			Tide tide;
			while(sc.hasNext()) {
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
		}
		return tideList;
	}
}
