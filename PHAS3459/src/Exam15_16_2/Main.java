package Exam15_16_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		String PulseURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt";	
		String DetectorURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt";

		try {
			HashMap<String, ArrayList<Pulse>> detectorMap;
			detectorMap = Pulse.detectorMap(DetectorURL,PulseURL);

			for(String id: detectorMap.keySet()) {
				System.out.println(detectorMap.get(id));
			}

			int totalPulses = Pulse.totalPulses(detectorMap);
			System.out.println("  Total number of pulses:  "+totalPulses);

			double meanAmp = Pulse.meanAmp(detectorMap);
			System.out.println("  Mean Amplitude of all pulses:  "+meanAmp+" V");
			try {
				HashMap<String,ArrayList<Double>> detectorInfo = Pulse.detectorInfo(detectorMap);
				Pulse.getInfo(detectorInfo);
				Pulse.difference(detectorInfo);
			} catch(Exception e){
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
