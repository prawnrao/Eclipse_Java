package Exam15_16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DetectorMainPart2 {
	public static void main(String[] args) {
		ArrayList<Detector> det = new ArrayList<>();
		ArrayList<Signal> data = new ArrayList<>();
		HashMap<String,ArrayList<ArrayList<Double>>> dataMap = new HashMap<>();
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt";
		String urlData = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt";

		try {

			det = Detector.detData(urlIndex);
			//System.out.println(det+"\n");
			data = Signal.signalData(urlData);
			//System.out.println(data);
			dataMap = Signal.signalMap(det,data);
			int timeSum = 0;
			int timeSum1 = 0;
			int sum = 0;
			ArrayList<ArrayList<Double>> pulses = new ArrayList<>();
			String index ="";
			double maxDif = -Double.MAX_VALUE;
			for(String s: dataMap.keySet()) {
				double dist = 0;
				pulses = dataMap.get(s);
				sum += pulses.size();
				pulses = dataMap.get(s);
				
				for(ArrayList<Double> singlePulse : pulses) {
					Time_threshold tt = new Time_threshold(1.0);
					Time_Max tm = new Time_Max();
					timeSum += tt.arrival(singlePulse); 
					timeSum1 += tm.arrival(singlePulse);
				}
				double meanTime = timeSum/sum;
				double meanTime1 = timeSum1/sum;
				for(Detector detector: det) {
					if(s.equals(detector.getDetector())){
						dist = detector.getDistance();
					}
				}
				double speed = dist/meanTime;
				double speed1 = dist/meanTime1;
				System.out.println("\tDetector:\t\t\t"+s);
				System.out.println("\tSpeed of particles (>1V):\t"+speed+" m/ns");
				System.out.println("\tSpeed of particles (Max amp):\t"+speed1+" m/ns\n\n");
				
				
				double speedDif = Math.abs(speed - speed1);
				if(speedDif > maxDif) {
					maxDif = speedDif;
					index = s;
				}
			}
			System.out.println("The detector with the largest difference in speeds between the two methods\n(>1V and Max amp) was: "+index+" with a difference of: "+maxDif);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
