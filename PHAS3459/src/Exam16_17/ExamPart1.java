package Exam16_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.IIOException;

public class ExamPart1 {

	/**
	 * Method that unpacks an Info object from a given URL 
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
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
			Recording = Recording.parseData(line);
			Recordings.add(Recording);
		}

		return Recordings;
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
						info = infoData(u);
						map.put(i, info);
					}
				}
			}
		}
		return map;
	}

	/**
	 * Method to calculate the duration of a given recording
	 * @param info
	 * @return
	 */
	public static double duration(Info info) {
		int f = info.getFreq();
		int N = info.getN();
		return N/f;
	}

	/**
	 * Method to calculate the amplitude for a given recording
	 * @param info
	 * @return
	 */
	public static double amplitude(Info info) {
		ArrayList<Integer> amp = info.getAmp();
		long sum=0;
		long nSq = 0;

		/**
		 * For loop over entire array of amplitude values
		 */
		for(int n : amp) {
			nSq = n*n;
			sum = sum + nSq;
		}

		double rms = Math.sqrt(sum/info.getN());
		double amplitude = 20*Math.log10(rms/info.getMaxAmp());
		return amplitude;
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
			rec = recData(urlIndex);  
			SoundMap = soundMap(rec,urlList);

			//For loop over the entire HashMap of recordings
			for(Recording i:SoundMap.keySet()) {				
				Info info;
				//gets info for a specific recording
				info = SoundMap.get(i);
				//gets ArrayList of amplitude values
				ArrayList<Integer> amp = info.getAmp();

				//outputs the file name
				System.out.println("Recording:\t"+i.getFileName());
				//outputs the Recording name
				System.out.println("Instrument:\t"+i.getInstrumentName());
				//outputs the duration
				System.out.println("Duration:\t"+ duration(info)+" s");
				//outputs the amplitude
				System.out.println("Amplitude:\t" + amplitude(info)+" dFBS\n");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}