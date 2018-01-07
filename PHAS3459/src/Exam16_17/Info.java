package Exam16_17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Info {

	int N;
	int freq;
	int maxAmp;
	static int freq1,N1,maxAmp1;
	static ArrayList<Integer> amp1 = new ArrayList<>();
	ArrayList<Integer> amp = new ArrayList<>();

	public Info (int freq, int N, int maxAmp, ArrayList<Integer> amp ) {
		this.freq = freq;
		this.N = N;
		this.maxAmp = maxAmp;
		this.amp = amp;
	}

	public static Info parseData(String line) throws IOException {
		StringTokenizer st = new StringTokenizer(line);

		if(st.countTokens()>1) {
			freq1 = Integer.parseInt(st.nextToken());
			N1 = Integer.parseInt(st.nextToken());
			maxAmp1 = Integer.parseInt(st.nextToken());
		}

		else{
			int i_amp = Integer.parseInt(st.nextToken());
			amp1.add(i_amp);
		}

		Info info = new Info(freq1,N1,maxAmp1,amp1);
		return info;
	}

	public String toString(){
		String print = "frequency: "+freq+"N: "+N+"Maximum Amplitude: "+maxAmp+"\n";//+ " Amplitudes: "+amp;
		return print;
	}
}
