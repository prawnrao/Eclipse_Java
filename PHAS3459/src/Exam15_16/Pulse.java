package Exam15_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pulse {
	String id;
	ArrayList<Double> ampList;
	double maxA;
	double dist;
	int arrivalTime;
	double speed;
	int sum;
	static ThresholdTime tt;

	/**
	 * Constructor of a pulse object
	 * @param id - detector name
	 * @param ampList - ArrayList of voltages
	 */
	public Pulse(String id, ArrayList<Double> ampList) {
		this.id = id;
		this.ampList = ampList;

		double maxA = -Double.MAX_VALUE;
		int maxIndex = 0;
		int i = 0;
		for(double d: ampList) {
			if(d>maxA) {
				maxIndex = i;
				maxA = d;
			}
			i++;
		}
		this.arrivalTime = maxIndex; 
		this.maxA = maxA;
	}

	/**
	 * Method that unpacks the data from a URL into an array list of pulse objects
	 * @param urlName
	 * @return ArrayList of pulse objects
	 * @throws IOException
	 */
	public static ArrayList<Pulse> PulseList(String urlName) throws IOException{
		ArrayList<Pulse> PulseList = new ArrayList<>();
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		
		//loops till buffered reader line is null
		while((line = br.readLine())!= null) {
			Scanner s = new Scanner(line);
			String id = s.next();
			ArrayList<Double> ampList = new ArrayList<>();
			//loops while scanner has next token
			while(s.hasNext()) {
				ampList.add(s.nextDouble());
			}
			
			Pulse Pulse = new Pulse(id,ampList);
			//adds new pulse to ArrayList of pulses
			PulseList.add(Pulse);
			s.close();
		}
		
		return PulseList;
	}

	/**
	 * Method that unpacks the data from 2 URLs, and creates a HashMap of detector id to ArrayList of pulse objects
	 * @param DetectorURL
	 * @param PulseURL
	 * @return - HashMap of id to ArrayList of pulse objects
	 * @throws IOException
	 */
	public static HashMap<String,ArrayList<Pulse>> detectorMap(String DetectorURL, String PulseURL) throws IOException{
		HashMap<String,ArrayList<Pulse>> detectorMap = new HashMap<>();
		ArrayList<Pulse> PulseList = PulseList(PulseURL);

		URL url = new URL(DetectorURL);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		
		//loops till the buffered reader line is null
		while((line=br.readLine())!=null) {
			Scanner s = new Scanner(line);
			String id = s.next();
			double dist = s.nextDouble();
			
			for(Pulse sig: PulseList) {
				
				//matches the id from scanner to id from object
				if(sig.getID().equals(id)) {
					sig.dist = dist;
					detectorMap.get(id);
					
					//creates new key in the hashmap
					if((detectorMap.get(id))==null) {
						detectorMap.put(id, new ArrayList<Pulse>());
					}
					//puts value into map
					detectorMap.get(id).add(sig);
				}
			}
			s.close();
		}

		return detectorMap;
	}
	
	/**
	 * Method that calculates the total number of pulses in the HashMap
	 * @param detectorMap
	 * @return - total number of pulses
	 */
	public static int totalPulses(HashMap<String,ArrayList<Pulse>> detectorMap) {
		int sum = 0;
		for(String id: detectorMap.keySet()){
			//increments the running total of pulses
			sum += detectorMap.get(id).size();
		}
		return sum;
	}
	
	/**
	 * Method to calculate the mean amplitude of the HashMap
	 * @param detectorMap
	 * @return - Mean amplitude of all Pulses in the HashMap
	 */
	public static double meanAmp(HashMap<String,ArrayList<Pulse>> detectorMap) {
		double sumAmp = 0;
		int sum  = totalPulses(detectorMap);
		for(String id: detectorMap.keySet()){
			for(Pulse sig: detectorMap.get(id)) {
				//increments the running total of pulse amplitudes
				sumAmp += sig.getAmp();
			}
		}
		return sumAmp/sum;
	}

	/**
	 * Method that creates a HashMap of detector id to ArrayList of doubles containing information about the detector
	 * @param detectorMap
	 * @return	- HashMap of id to ArrayList of doubles
	 * @throws Exception
	 */
	public static HashMap<String,ArrayList<Double>> detectorInfo(HashMap<String,ArrayList<Pulse>> detectorMap) throws Exception{
		HashMap<String,ArrayList<Double>> detectorInfo = new HashMap<>();
		//loops over HashMap of detector - signal
		for(String id: detectorMap.keySet()) {
			ArrayList<Double> info= new ArrayList<>();
			ArrayList<Pulse> pulseList = detectorMap.get(id);

			double noSignals = noSignals(pulseList);

			//adds number of signals to the ArrayList of doubles (0)
			info.add(noSignals);

			double sumAmp = 0;
			double sumTime = 0;
			double sumTimeThresh = 0;


			tt = new ThresholdTime(1);
			for(Pulse p: detectorMap.get(id)) {
				sumAmp += p.getAmp();
				sumTime += p.getTime();
				sumTimeThresh += tt.calcTime(p);
			}


			double meanAmp = sumAmp/pulseList.size();
			//adds mean amplitude to the ArrayList of doubles (1)
			info.add(meanAmp);

			double meanTime = sumTime/pulseList.size();
			//adds (max amplitude) mean arrival time to the ArrayList of doubles (2)
			info.add(meanTime);

			double dist = pulseList.get(0).dist;
			double speed = dist/meanTime;
			//adds (max amplitude) particle speed to the ArrayList of doubles (3)
			info.add(speed);

			double meanTimeThresh = sumTimeThresh/pulseList.size();
			double speedThresh = dist/meanTimeThresh;
			//adds (threshold) particle speed to the ArrayList of doubles (4)
			info.add(speedThresh);

			//puts id and ArrayList of doubles into HashMap
			detectorInfo.put(id, info);
		}
		return detectorInfo;
	}

	/**
	 * Method that returns number of signals for a detector
	 * @param pulseList
	 * @return	- number of signals for a detector
	 */
	public static double noSignals(ArrayList<Pulse> pulseList) {
		double sum = 0;
		for(Pulse p: pulseList) {
			sum += p.ampList.size();
		}

		return sum;
	}
	
	/**
	 * Method that prints all the information for all the detectors
	 * @param detectorInfo
	 */
	public static void getInfo(HashMap<String,ArrayList<Double>> detectorInfo ) {
		for(String id : detectorInfo.keySet()) {
			ArrayList<Double> info = (detectorInfo.get(id));
			System.out.println("\n  Detector: "+id+"\n  No Signals:  "+info.get(0)+"\n  Mean Amp:  "+info.get(1)+" V\n  Mean Arrival Time:  "+info.get(2)+" ns\n  Speed of particles(MaxAmp):  "+info.get(3)+" m/ns\n  Speed of particles(threshold("+tt.thresh+"V)):  "+info.get(4)+" m/ns\n");
		}	
	}

	/**
	 * Method that prints the highest difference between the two arrival times, and the detector respective detector
	 * @param detectorInfo
	 */
	public static void difference(HashMap<String,ArrayList<Double>> detectorInfo){
		double maxDif = -Double.MAX_VALUE;
		String maxID ="";
		for(String id : detectorInfo.keySet()) {
			ArrayList<Double> info = detectorInfo.get(id);
			Double maxAmpTime = info.get(2);
			Double threshTime = info.get(4);
			double currDif = Math.abs(maxAmpTime - threshTime);
			if(currDif > maxDif) {
				maxDif = currDif;
				maxID = id;
			}
		}
		System.out.println("\n  Detector "+maxID+" had the largest difference between the two methods of"
				+ "\n  calculating arrival times, with a difference of: "+ maxDif +" ns" );
	}

	private double getTime() {
		return arrivalTime;
	}
	private double getAmp() {
		return maxA;
	}
	private String getID() {
		return id;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	public String toString() {
		String s = "";
		s = "Distance: "+dist+" m  Amplitude: "+ maxA+" V";
		return s;
	}
}
