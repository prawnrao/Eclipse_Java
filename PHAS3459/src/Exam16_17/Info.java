package Exam16_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Info {

	int N=0;
	int freq=0;
	int maxAmp;
	static int freq1=0,N1=0,maxAmp1=0;
	static ArrayList<Double> amp1 = new ArrayList<>();
	ArrayList<Double> amp = new ArrayList<>();

	public Info (int freq, int N, int maxAmp, ArrayList<Double> amp ) {
		this.freq = freq;
		this.N = N;
		this.maxAmp = maxAmp;
		this.amp = amp;

	}
	
	/**
	 * Method to parse the data that returns a info object
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static Info parseData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		Scanner s = new Scanner(br);

		int freq = s.nextInt();
		int N  = s.nextInt();
		int MaxA = s.nextInt();

		ArrayList<Double> amp = new ArrayList<>();

		for(int n=0;n<N;n++) {
			amp.add(s.nextDouble());
		}

		Info info = new Info(freq,N,MaxA,amp);

		return info;
	}

	public int getN() {
		return N;
	}

	public int getFreq() {
		return freq;
	}

	public int getMaxAmp() {
		return maxAmp;
	}

	public ArrayList<Double> getAmp(){
		return amp;
	}

	public String toString(){
		String print = "\n\tfrequency: "+freq+"\n\tN: "+N+"\n\tMaximum Amplitude: "+maxAmp+"\n\n"; //" Amplitudes: "+amp+"\n\n";
		return print;
	}
	
	/**
	 * Method to calculate the duration of a given recording
	 * @param info
	 * @return
	 */
	public static double duration(Info info) {
		double f = info.getFreq();
		int N = info.getN();
		return N/f;
	}

	/**
	 * Method to calculate the amplitude for a given recording
	 * @param info
	 * @return
	 */
	public static double amplitude(Info info) {
		ArrayList<Double> amp = info.getAmp();
		double sum = 0;
		double nSq =0;
		//For loop over entire array of amplitude values
		for(double n : amp) {
			nSq = n*n;

			sum += nSq;
		}
		double rms = Math.sqrt(sum/info.getN());
		double amplitude = 20*Math.log10(rms/info.getMaxAmp());
		return amplitude;
	}
}