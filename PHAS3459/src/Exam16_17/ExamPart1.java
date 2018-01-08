package Exam16_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart1 {
	public static Info infoData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Info info = null;

		while ((line=br.readLine()) != null){
			info = Info.parseData(line);
		}
		return info;
	}

	public static ArrayList<Instrument> instruData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Instrument instrument = null;
		ArrayList<Instrument> instruments = new ArrayList<>();

		while ((line=br.readLine()) != null){
			instrument = Instrument.parseData(line);
			instruments.add(instrument);
		}

		return instruments;
	}

	public static HashMap<Instrument,Info> soundMap(ArrayList<Instrument> instruments,ArrayList<String> urlList) throws IOException{
		HashMap<Instrument, Info> map = new HashMap<>();

		for (Instrument i: instruments) {
			String fn = i.getFileName();
			if (fn != "") {
				for(String u :urlList) {
					if(u.contains(fn)) {
						Info info;
						info = infoData(u);
						map.put(i, info);
					}
				}
			}
		}
		return map;
	}

	public static void main(String[]args) {
		String url1 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt";
		String url2 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt";
		String url3 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt";
		String url4 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt";
		String url5 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt";
		String url6 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt";
		String url7 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt";
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt";
		HashMap<Instrument,Info> SoundMap = new HashMap<>();

		ArrayList<String> urlList = new ArrayList<>();
		urlList.add(url1);
		urlList.add(url2);
		urlList.add(url3);
		urlList.add(url4);
		urlList.add(url5);
		urlList.add(url6);
		urlList.add(url7);

		ArrayList<Instrument> instru = new ArrayList<>();

		try {
			instru = instruData(urlIndex);  
			SoundMap = soundMap(instru,urlList);
			System.out.println(SoundMap);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}