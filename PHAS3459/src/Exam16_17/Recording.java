package Exam16_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Recording {
	String fileName;
	String RecordingName;
	
	/**
	 * Constructor for a Recording object
	 * @param fileName
	 * @param RecordingName
	 */
	public Recording(String fileName, String RecordingName){
		this.fileName = fileName;
		this.RecordingName = RecordingName;
	}
	
	/**
	 * Method to parse the data to make a recording object
	 * @param line
	 * @return
	 * @throws IOException
	 */
	public static Recording parseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		String fileName="";
		String RecordingName="";
		while (s.hasNext()) {
			fileName = s.next();
			RecordingName = s.next();
		}
		Recording Recording = new Recording(fileName, RecordingName);
		return Recording;
	}

	public String getFileName() {
		return fileName;
	}

	public String getInstrumentName() {
		return RecordingName;
	}


	public String toString() {
		String print = "\tFilename: "+fileName+"\tRecording Name: "+RecordingName ;
		return print;
	}

	/**
	 * Method that creates a HashMap of Recording and Info objects
	 * @param Recordings
	 * @param urlList
	 * @return
	 * @throws IOException
	 */
	public static HashMap<Recording,Info> soundMap(ArrayList<Recording> Recordings,ArrayList<String> urlList) throws IOException{
		HashMap<Recording, Info> map = new HashMap<>();

		for (Recording i: Recordings) {

			String fn = i.getFileName();
			if (fn != "") {
				for(String u :urlList) {
					if(u.contains(fn)) {
						Info info;
						info = Info.parseData(u);
						map.put(i, info);
					}
				}
			}
		}
		return map;
	}

	/**
	 * Method that unpacks an ArrayList of Recording Objects from a given URL
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Recording> recData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Recording Recording = null;
		ArrayList<Recording> Recordings = new ArrayList<>();

		while ((line=br.readLine()) != null){
			Recording = parseData(line);
			Recordings.add(Recording);
		}

		return Recordings;
	}
}