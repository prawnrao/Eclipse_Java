package Exam16_17_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Recording {
	/**
	 * Member Variables
	 */
	int N;
	double f;
	double maxA;
	ArrayList<Double> ampList;
	String instruName;
	double duration;
	double amplitude;
	String recName;
	double rmsA;

	/**
	 * Constructor of a recording object
	 * @param f
	 * @param N
	 * @param maxA
	 * @param ampList
	 * @param instruName
	 */
	public Recording(double f, int N, double maxA, ArrayList<Double> ampList){
		//assigning values to member variables
		this.f = f;
		this.N = N;
		this.maxA = maxA;
		this.ampList = ampList;

		//calculates duration
		duration = N/f;

		//calculates rmsAmp
		double sum = 0;
		for(double d : ampList) {//loop over all amplitude values
			sum+=(d*d);//sum of amplitude square
		}
		rmsA = Math.sqrt(sum/N);

		//calculates amplitude
		amplitude = 20*Math.log10(rmsA/maxA);
	}

	/**
	 * Method to unpack recording data from URL
	 * @param urlName
	 * @return Recording object from URL
	 * @throws IOException
	 */
	public static Recording recData(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		Scanner sc = new Scanner(br);

		double f = sc.nextDouble();//frequency
		int N = sc.nextInt();//number of recordings
		double maxA =sc.nextDouble();//max amplitude

		//ArrayList of individual amplitudes
		ArrayList<Double> ampList = new ArrayList<>(N);
		while(sc.hasNext()){
			ampList.add(sc.nextDouble());//individual amplitude values
		}
		Recording rec = new Recording(f,N,maxA,ampList);
		return rec;
	}

	/**
	 * Method to unpack index from URL
	 * @param urlName
	 * @return	ArrayList(ArrayList(String)) index
	 * @throws IOException
	 */
	public static ArrayList<ArrayList<String>> recIndex(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		//ArrayList of each line that contains two strings, recording name and instrument name
		ArrayList<ArrayList<String>> index = new ArrayList<>();
		while((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			ArrayList<String> i = new ArrayList<>();
			i.add(sc.next());//recording name
			i.add(sc.next());//instrument name
			index.add(i);
		}
		return index;
	}

	/**
	 * Method to create a HashMap of recording name to Recording object
	 * @param urlIndex
	 * @param urlList
	 * @return HashMap(String,Recording) recMap
	 * @throws IOException
	 */
	public static HashMap<String, Recording> recMap(String urlIndex, ArrayList<String> urlList) throws IOException{

		HashMap<String,Recording> recMap = new HashMap<>();
		ArrayList<ArrayList<String>> index = recIndex(urlIndex);//unpacks index data

		//loops over index elements
		for(ArrayList<String> s: index) {
			String fileName = s.get(0);//gets file name from index element
			//loops over list of URLs
			for(String u: urlList) {
				//checks if URL contains file name
				if(u.contains(fileName)) {
					//creates new recording object
					Recording rec = recData(u);
					rec.setRecName(fileName);
					//adds instrument name to the recording object
					rec.setInstruName(s.get(1));
					//adds recording name and recording to HashMap
					recMap.put(fileName, rec);
					break;
				}
			}
		}
		return recMap;
	}


	/**
	 * toString method to print out required information of a recording object
	 */
	public String toString() {
		String s = "";
		s = "\n  Recording: "+recName+",  Instrument: "+instruName+"\n  Duration: "+duration+"s,  Amplitude: "+amplitude+" dBFS";
		return s;
	}

	/**
	 * Setter/Getter Methods
	 */

	public double getF() {
		return f;
	}
	public double getMaxAmp() {
		return maxA;
	}
	public double getN() {
		return N;
	}
	public ArrayList<Double> getAmpList() {
		return ampList;
	}
	public String getName() {
		return instruName;
	}
	private void setInstruName(String s) {
		this.instruName =s;
	}
	private void setRecName(String s){
		recName = s;
	}
	
}

