package Exam13_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Survey {
	private String id;
	private double lat;
	private double lon;
	private double height;

	public Survey(String id, double lat,double lon, double height) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.height = height;
	}
	
	/**
	 * Method that takes in url, uses the parseLine method and outputs an arrayList of Survey objects
	 * @param urlName
	 * @return ArrayList<Signal>
	 * @throws IOException
	 */
	public static ArrayList<Survey> surveyData(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Survey survey;
		ArrayList<Survey> data = new ArrayList<>();

		while ((line=br.readLine()) != null){
			survey = parseLine(line);
			data.add(survey);
		}
		return data;
	}
	
	/**
	 * Method that parses each line
	 * @param line
	 * @return Signal
	 * @throws IOException
	 */
	public static Survey parseLine(String line) throws IOException{
		Scanner s = new Scanner(line);
		double lat=0;
		double lon=0;
		String id="";
		double height=0;
		while(s.hasNext()) {
			lat = s.nextDouble();
			lon = s.nextDouble();
			id = s.next();
			height = s.nextDouble();
			}
		
		Survey survey = new Survey(id,lat,lon,height);
		s.close();
		return survey;
	}
	
	public String toString() {
		String s = "";
		s = "ID: "+this.id+"\tLat: " + this.lat+"\tLon: " + this.lon+"\tHeight: " + this.height+" cm\n";
		return s;
	}
	
	public static HashMap<String,ArrayList<ArrayList<Double>>> surveyMap (ArrayList<Survey> sur){
		HashMap<String,ArrayList<ArrayList<Double>>> map= new HashMap<>();
		for(Survey s: sur) {
			ArrayList<Double> surList  = new ArrayList<>();
			String id = s.getID();
			double lat = s.getLat();
			surList.add(lat);
			double lon = s.getLon();
			surList.add(lon);
			double height = s.getH();
			surList.add(height);
			
			ArrayList<ArrayList<Double>> surData = map.get(id);
			if(surData == null) {
				map.put(id, new ArrayList<ArrayList<Double>>());
			}
			map.get(id).add(surList);
		}
		return map;
		
	}

	public double getH() {
		return height;
	}
	public double getLon() {
		return lon;
	}
	public double getLat() {
		return lat;
	}
	public String getID() {
		return id;
	}
	public static double getH(ArrayList<Double> surList) {
		return surList.get(2);
	}
	public double getLon(ArrayList<Double> surList) {
		return surList.get(1);
	}
	public double getLat(ArrayList<Double> surList) {
		return surList.get(0);
	}

}
