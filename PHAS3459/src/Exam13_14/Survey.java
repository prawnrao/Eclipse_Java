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
	public Survey(String id,double lat,double lon) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * Method that takes in url, uses the parseLine method and outputs an arrayList of Survey objects for plants
	 * @param urlName
	 * @return ArrayList<Signal>
	 * @throws IOException
	 */
	public static ArrayList<Survey> surveyDataPlant(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Survey survey;
		ArrayList<Survey> data = new ArrayList<>();

		while ((line=br.readLine()) != null){
			survey = parseLinePlant(line);
			data.add(survey);
		}
		return data;
	}

	public static ArrayList<Survey> surveyDataAnimal(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Survey survey;
		ArrayList<Survey> data = new ArrayList<>();

		while ((line=br.readLine()) != null){
			survey = parseLineAnimal(line);
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
	public static Survey parseLineAnimal(String line) throws IOException{
		Scanner s = new Scanner(line);
		double lat=0;
		double lon=0;
		String id="";
		while(s.hasNext()) {
			lat = s.nextDouble();
			lon = s.nextDouble();
			id = s.next();
		}

		Survey survey = new Survey(id,lat,lon);
		s.close();
		return survey;
	}

	public static Survey parseLinePlant(String line) throws IOException{
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

	public static HashMap<String,ArrayList<ArrayList<Double>>> surveyMapPlant (ArrayList<Survey> sur){
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

	public static HashMap<String,ArrayList<ArrayList<Double>>> surveyMapAnimal (ArrayList<Survey> sur){
		HashMap<String,ArrayList<ArrayList<Double>>> map= new HashMap<>();
		for(Survey s: sur) {
			ArrayList<Double> surList  = new ArrayList<>();
			String id = s.getID();
			double lat = s.getLat();
			surList.add(lat);
			double lon = s.getLon();
			surList.add(lon);

			ArrayList<ArrayList<Double>> surData = map.get(id);
			if(surData == null) {
				map.put(id, new ArrayList<ArrayList<Double>>());
			}
			map.get(id).add(surList);
		}
		return map;
	}
	public static ArrayList<ArrayList<Double>> surveyArrayAnimal(ArrayList<Survey> sur){
		ArrayList<ArrayList<Double>> surData = new ArrayList<>();
		ArrayList<Double> surList  = new ArrayList<>();
		for(Survey s: sur) {
			String id = s.getID();
			double lat = s.getLat();
			surList.add(lat);
			double lon = s.getLon();
			surList.add(lon);
			surData.add(surList);
		}
		return surData;

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
	public static double getLon(ArrayList<Double> surList) {
		return surList.get(1);
	}
	public static double getLat(ArrayList<Double> surList) {
		return surList.get(0);
	}

	public static double meanH(ArrayList<ArrayList<Double>> surListPlant) {
		int size = surListPlant.size();
		double sumH = 0;
		for(ArrayList<Double> singleSurList : surListPlant) {
			sumH += Survey.getH(singleSurList);
		}
		double meanH = sumH/size;
		return meanH;
	}
}
