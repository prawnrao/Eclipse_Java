package test;

import java.io.IOException;
import java.util.Scanner;

public class Earthquake {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private double second;
	private double latitude;
	private double longitude;
	private double depth;
	private double EH1;
	private double EH2;
	private double AZ;
	private double EZ;
	private double magnitude;
	private int id;

	public Earthquake(int year, int month, int day, int hour, int min, double second, double latitude, double longitude, 
			double depth, double EH1,double EH2, double AZ, double EZ, double magnitude, int id) {

		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.second = second;
		this.latitude = latitude;
		this.longitude  = longitude;
		this.depth = depth;
		this.EH1 = EH1;
		this.EH2 = EH2;
		this.AZ = AZ;
		this.EZ = EZ;
		this.magnitude = magnitude;
		this.id = id;


	}

	public static Earthquake parseLine(String line) throws IOException {
		Scanner s = new Scanner(line);

		int year = s.nextInt();
		int month = s.nextInt();
		int day = s.nextInt();
		int hour = s.nextInt();
		int min = s.nextInt();
		double second = s.nextDouble();
		double latitude = s.nextDouble();
		double longitude = s.nextDouble();
		double depth = s.nextDouble();
		double EH1 = s.nextDouble();
		double EH2 = s.nextDouble();
		double AZ = s.nextDouble();
		double EZ = s.nextDouble();
		double magnitude = s.nextDouble();
		int id = s.nextInt();


		s.close();

		Earthquake eq = new Earthquake(year,  month,  day,  hour,  min,  second,  latitude,  longitude, 
				depth,  EH1, EH2,  AZ,  EZ,  magnitude,  id);
		return eq;

	}

	public double getDep() {
		return depth;
	}

	public double getMag() {
		return magnitude;
	}

	public double getEZ() {
		return EZ;
	}
	
	public int getMonth() {
		return month;
	}

	public String toString() {
		String print = "\n\t\t"+year+"/"+month+"/"+day+"("+hour+":"+min+":"+second+
				")\n\t\tLatitude: "+latitude+"  Longitude: "+longitude+"  Depth: "+depth+" km"+
				"\n\t\tEZ: "+EZ+" km  Magnitude: "+magnitude+ "  id: "+id+"\n";
		return print;

	}
}
