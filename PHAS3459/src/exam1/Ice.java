package exam1;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import test.Exoplanet;

public class Ice {
	//Member variables
	private int year;
	private int month;
	private Object type;
	private String region;//(N/S)
	private double extent;//(million km^2)
	private double area;//(million km^2)
	
	//Constructor of Ice object
	public Ice(int year,int month,Object type, String region,double extent, double area) {
		
		this.year = year;
		this.month = month;
		this.type = type;
		this.region = region;
		this.extent = extent;
		this.area = area;
		
	}
	

	public static Ice parseData(String line) throws IOException {
		
		Scanner s  = new Scanner(line).useDelimiter(",\\s*");
		int year = s.nextInt();
		int month = s.nextInt();
		String type = s.next();
		String region = s.next();
		double extent = s.nextDouble();
		double area = s.nextDouble();

		Ice ice_data = new Ice (year, month,type, region, extent, area);

		return ice_data;
	}
	
	public double getExt() {
		return extent;
	}
	
	public double getArea() {
		return area;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}

	
	public String toString(){
		//this converts the integer month to string month
		String txt_month = "";
		if(month ==1) {txt_month = "Jan";}
		if(month ==2) {txt_month = "Feb";}
		if(month ==3) {txt_month = "Mar";}
		if(month ==4) {txt_month = "Apr";}
		if(month ==5) {txt_month = "May";}
		if(month ==6) {txt_month = "Jun";}
		if(month ==7) {txt_month = "Jul";}
		if(month ==8) {txt_month = "Aug";}
		if(month ==9) {txt_month = "Sep";}
		if(month ==10) {txt_month = "Oct";}
		if(month ==11) {txt_month = "Nov";}
		if(month ==12) {txt_month = "Dec";}
		
		String print = "\n\t\tYear: "+year +"\tMonth: "+ txt_month+ "\t\tData Type: "+type +
						"\n\t\tHemisphere: "+ region+ "\tExtent: "+ extent + "(million sqKm)\tarea: "+area+"(million sqKm)\n";
		return print;
	}




}
