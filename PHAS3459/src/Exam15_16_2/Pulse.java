package Exam15_16_2;

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

	public static ArrayList<Pulse> PulseList(String urlName) throws IOException{
		ArrayList<Pulse> PulseList = new ArrayList<>();
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while((line = br.readLine())!= null) {
			Scanner s = new Scanner(line);
			String id = s.next();
			ArrayList<Double> ampList = new ArrayList<>();
			while(s.hasNext()) {
				ampList.add(s.nextDouble());
			}
			Pulse Pulse = new Pulse(id,ampList);
			PulseList.add(Pulse);
		}
		return PulseList;
	}

	public static HashMap<String,ArrayList<Pulse>> detectorMap(String DetectorURL, String PulseURL) throws IOException{
		HashMap<String,ArrayList<Pulse>> detectorMap = new HashMap<>();
		ArrayList<Pulse> PulseList = PulseList(PulseURL);

		URL url = new URL(DetectorURL);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		while((line=br.readLine())!=null) {
			Scanner s = new Scanner(line);
			String id = s.next();
			double dist = s.nextDouble();
			for(Pulse sig: PulseList) {
				if(sig.getID().equals(id)) {
					sig.dist = dist;
					detectorMap.get(id);
					if((detectorMap.get(id))==null) {
						detectorMap.put(id, new ArrayList<Pulse>());
					}
					detectorMap.get(id).add(sig);
				}
			}

		}

		return detectorMap;
	}

	public static int totalPulses(HashMap<String,ArrayList<Pulse>> detectorMap) {
		int sum = 0;
		for(String id: detectorMap.keySet()){
			sum += detectorMap.get(id).size();
		}
		return sum;
	}

	public static double meanAmp(HashMap<String,ArrayList<Pulse>> detectorMap) {
		double sumAmp = 0;
		int sum  = totalPulses(detectorMap);
		for(String id: detectorMap.keySet()){
			for(Pulse sig: detectorMap.get(id)) {
				sumAmp += sig.getAmp();
			}
		}
		return sumAmp/sum;
	}

	public static HashMap<String,ArrayList<Double>> detectorInfo(HashMap<String,ArrayList<Pulse>> detectorMap) throws Exception{
		HashMap<String,ArrayList<Double>> detectorInfo = new HashMap<>();

		for(String id: detectorMap.keySet()) {
			ArrayList<Double> info= new ArrayList<>();
			ArrayList<Pulse> pulseList = detectorMap.get(id);

			double noSignals = noSignals(pulseList);

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
			info.add(meanAmp);

			double meanTime = sumTime/pulseList.size();
			info.add(meanTime);

			double dist = pulseList.get(0).dist;
			double speed = dist/meanTime;

			info.add(speed);

			double meanTimeThresh = sumTimeThresh/pulseList.size();
			double speedThresh = dist/meanTimeThresh;
			info.add(speedThresh);

			detectorInfo.put(id, info);
		}
		return detectorInfo;
	}

	public static double noSignals(ArrayList<Pulse> pulseList) {
		double sum = 0;
		for(Pulse p: pulseList) {
			sum += p.ampList.size();
		}

		return sum;
	}

	public static void getInfo(HashMap<String,ArrayList<Double>> detectorInfo ) {
		for(String id : detectorInfo.keySet()) {
			ArrayList<Double> info = (detectorInfo.get(id));
			System.out.println("\n  Detector: "+id+"\n  No Signals:  "+info.get(0)+"\n  Mean Amp:  "+info.get(1)+" V\n  Mean Arrival Time:  "+info.get(2)+" ns\n  Speed of particles(MaxAmp):  "+info.get(3)+" m/ns\n  Speed of particles(threshold("+tt.thresh+"V)):  "+info.get(4)+" m/ns\n");
		}	
	}

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
