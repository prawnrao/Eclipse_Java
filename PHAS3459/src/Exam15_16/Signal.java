package Exam15_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Signal {
	private ArrayList<Double> pulses;
	private String name;
	private double amp;
	private int time;
	
	/**
	 * Constructor
	 * @param name
	 * @param pulses
	 */
	public Signal(String name, ArrayList<Double> pulses) {
		this.name = name;
		this.pulses = pulses;
	}

	/**
	 * Method that parses each line
	 * @param line
	 * @return Signal
	 * @throws IOException
	 */
	public static Signal parseSignal(String line) throws IOException{
		Scanner s = new Scanner(line);
		String name = "";
		ArrayList<Double> pulses = new ArrayList<>();

		name = s.next();

		while(s.hasNext()) {
			pulses.add(s.nextDouble());
		}
		
		Signal signal = new Signal(name,pulses);
		s.close();
		return signal;
	}

	/**
	 * Method that takes in url, uses the parseLine method and outputs an arrayList of Signal objects
	 * @param urlName
	 * @return ArrayList<Signal>
	 * @throws IOException
	 */
	public static ArrayList<Signal> signalData(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Signal signal;
		ArrayList<Signal> data = new ArrayList<>();

		while ((line=br.readLine()) != null){
			signal = parseSignal(line);
			data.add(signal);
		}
		return data;
	}

	/**
	 * toString method for printing Signal objects
	 */
	public String toString() {
		String s = "\tDetector Name:\t"+name +"\n\tPulses:\t"+ pulses+"\n";
		return s;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return ArrayList of pulses
	 */
	public ArrayList<Double> getPulse(){
		return pulses;
	}
	
	public static double amplitude(ArrayList<Double> signals) {
		double max_s = -Double.MAX_VALUE;
		for(double s: signals) {
			if(s > max_s) {
				max_s = s;
			}
		}
		return max_s;
	}

	public static int arrivalTime(ArrayList<Double> signals) {
		double max_s = -Double.MAX_VALUE;
		int index =0;
		for(int i =0; i <signals.size();i++) {
			double s = signals.get(i);
			if(s > max_s) {
				max_s = s;
				index = i;
			}
		}
		return index;//ns
	}
	
	/**
	 * Method that calculates the total number of signals
	 * @param pulses
	 * @return No of pulses
	 */
	public static int noSignal(ArrayList<ArrayList<Double>> pulses){
		int sum = 0;
		for(int i =0; i<pulses.size();i++) {
			sum += pulses.get(i).size();  
		}
		return sum;
	}

	/**
	 * Method that creates a HashMap to store all the required data
	 * @param detectors
	 * @param signals
	 * @return HashMap of Strings as key and ArrayList of Signal objects
	 */
	public static HashMap<String, ArrayList<ArrayList<Double>>> signalMap(ArrayList<Detector> detectors,ArrayList<Signal> signals){
		HashMap<String,ArrayList<ArrayList<Double>>> signalDataMap = new HashMap<>();
		for(Signal sig : signals) {
			String name ="";
			String detName = sig.getName();
			for(Detector d :detectors) {
				name = d.getDetector();
				if(detName.equals(name)) {
					break;
				}
			}
			ArrayList<ArrayList<Double>> s = signalDataMap.get(name);
			if(s == null) {
				signalDataMap.put(name,new ArrayList<ArrayList<Double>>());
			}
			signalDataMap.get(name).add(sig.getPulse());
		}
		return signalDataMap;
	}
}
