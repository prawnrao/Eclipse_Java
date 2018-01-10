package Exam16_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart1 {

	public static void main(String[]args) {
		
		String url1 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt";
		String url2 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt";
		String url3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt";
		String url4 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt";
		String url5 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt";
		String url6 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt";
		String url7 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt";
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt";
		HashMap<Recording,Info> SoundMap = new HashMap<>();
		ArrayList<String> urlList = new ArrayList<>();
		urlList.add(url1);
		urlList.add(url2);
		urlList.add(url3);
		urlList.add(url4);
		urlList.add(url5);
		urlList.add(url6);
		urlList.add(url7);

		ArrayList<Recording> rec = new ArrayList<>();

		try {
			rec = Recording.recData(urlIndex);  
			SoundMap = Recording.soundMap(rec,urlList);

			//For loop over the entire HashMap of recordings
			for(Recording r:SoundMap.keySet()) {				
				Info info;
				//gets info for a specific recording
				info = SoundMap.get(r);
				//gets ArrayList of amplitude values
				ArrayList<Double> amp = info.getAmp();
				//outputs the file name
				System.out.println("Recording:\t"+r.getFileName());
				//outputs the Recording name
				System.out.println("Instrument:\t"+r.getInstrumentName());
				//outputs the duration
				System.out.println("Duration:\t"+ Info.duration(info)+" s");
				//outputs the amplitude
				System.out.println("Amplitude:\t" + Info.amplitude(info)+" dFBS\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}