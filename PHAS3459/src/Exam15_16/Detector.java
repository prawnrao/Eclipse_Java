package Exam15_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Detector {
	String distance;
	String DetectorName;
	
	/**
	 * Constructor for a Detector object
	 * @param distance
	 * @param DetectorName
	 */
	public Detector(String DetectorName,String distance){
		this.distance = distance;
		this.DetectorName = DetectorName;
	}
	
	/**
	 * Method to parse the data to make a Detector object
	 * @param line
	 * @return
	 * @throws IOException
	 */
	public static Detector parseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		String distance="";
		String DetectorName="";
		while (s.hasNext()) {
			DetectorName = s.next();
			distance = s.next();
		}
		Detector Detector = new Detector(DetectorName,distance);
		return Detector;
	}

	public String getDistance() {
		return distance;
	}

	public String getDetector() {
		return DetectorName;
	}


	public String toString() {
		String print = "\n\tDetector Name: "+DetectorName +"\tdistance: "+distance;
		return print;
	}

	/**
	 * Method that unpacks an ArrayList of Detector Objects from a given URL
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Detector> detData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Detector Detector = null;
		ArrayList<Detector> Detectors = new ArrayList<>();

		while ((line=br.readLine()) != null){
			Detector = parseData(line);
			Detectors.add(Detector);
		}

		return Detectors;
	}
}