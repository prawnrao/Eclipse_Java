package Exam15_16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DetectorMainPart1 {

	public static void main(String[] args) {
		ArrayList<Detector> det = new ArrayList<>();
		ArrayList<Signal> data = new ArrayList<>();
		HashMap<String,ArrayList<ArrayList<Double>>> dataMap = new HashMap<>();
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt";
		String urlData = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt";
		
		try {

			det = Detector.detData(urlIndex);
			data = Signal.signalData(urlData);
			dataMap = Signal.signalMap(det,data);
			
			int sum = 0;
			double ampSum = 0;
			double timeSum = 0;
			ArrayList<ArrayList<Double>> pulses = new ArrayList<>();

			for(String s: dataMap.keySet()) {
				
				double dist = 0;
				pulses = dataMap.get(s);
				sum += pulses.size();
				for(ArrayList<Double> singlePulse : pulses) {
					ampSum += Signal.amplitude(singlePulse);
					timeSum += Signal.arrivalTime(singlePulse);
				}
				int noSignals = Signal.noSignal(pulses);
				double meanTime = timeSum/sum;
				System.out.println("\n\t\tDetector: "+s+"\n");
				System.out.println("\tNumber of signals:\t"+noSignals);
				System.out.println("\tMean amplitude:\t\t"+ampSum/sum+" V");
				System.out.println("\tMean arrival time:\t"+meanTime+" ns");
				
				for(Detector detector: det) {
					if(s.equals(detector.getDetector())){
						dist = detector.getDistance();
					}
				}
				double speed = dist/meanTime;
				System.out.println("\tDistance:\t\t"+dist+"m");
				System.out.println("\tSpeed of particles:\t"+speed+" m/ns\n\n");
				
			}
			double avg = ampSum/sum;
			System.out.println("\n\tTotal number of pulses:\t"+sum);
			System.out.println("\tMean amplitude of all pulses:\t"+avg+" V");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
