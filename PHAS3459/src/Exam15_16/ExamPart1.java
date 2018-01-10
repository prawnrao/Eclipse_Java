package Exam15_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import test.Earthquake;

public class ExamPart1 {

	public static void main(String[] args) {
		ArrayList<Detector> det = new ArrayList<>();
		ArrayList<ArrayList<Object>> data = new ArrayList<>();
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt";
		String urlData = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt";
		try {
			det = Detector.detData(urlIndex);
			System.out.println(det+"\n");
			data = signalData(urlData);
			for(int i =0; i<data.size();i++) {
				System.out.println(data.get(i)+"\n");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	public static ArrayList<Object> parseSignal(String line) throws IOException{
		Scanner s = new Scanner(line);
		String name = "";
		ArrayList<Object> signals = new ArrayList<>();

		name = s.next();
		signals.add(name);
		while(s.hasNext()) {
			signals.add(s.nextDouble());
		}

		return signals;
	}
	
	public static ArrayList<ArrayList<Object>> signalData(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		ArrayList<Object> signal = new ArrayList<>();
		ArrayList<ArrayList<Object>> data = new ArrayList<>();
		
		while ((line=br.readLine()) != null){
			signal = parseSignal(line);
			data.add(signal);
		}
		
		return data;
	}
	
	public static HashMap<Detector, ArrayList<ArrayList<Double>>> signalMap(ArrayList<Detector> detectors,ArrayList<ArrayList<Object>> signals){
		HashMap<Integer,ArrayList<Earthquake>> dataMap = new HashMap<>();
		for(ArrayList<Object> ar : signals) {
			String det = (String) ar.get(1);
			
		}
		return null;
		
	}
}
