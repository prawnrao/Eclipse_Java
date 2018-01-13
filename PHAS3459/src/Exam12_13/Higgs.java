package Exam12_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Higgs {
	private String id;
	private double eventE;

	public Higgs(String id, double eventE) {
		this.id = id;
		this.eventE = eventE;
	}

	public static ArrayList<Higgs> higgsData(String urlName) throws IOException{

		ArrayList<Higgs> higgsData= new ArrayList<>();

		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		Scanner sc = new Scanner(br);
		while(sc.hasNext()) {
			String id = sc.next();
			double eventE = sc.nextDouble();
			Higgs higgs = new Higgs(id,eventE);
			higgsData.add(higgs);
		}
		return higgsData;

	}

	public String getID() {
		return id;
	}

	public String toString() {
		String s = "";
		s = "Channel ID: "+id+"\t\tEvent Energy: "+eventE+"(GeV)\n";
		return s;
	}

	public static HashMap<String,HashMap<Integer,ArrayList<Integer>>> binData(HashMap<String,ArrayList<Background>>bgMap,ArrayList<Higgs>higgsData){
		HashMap<String,HashMap<Integer,ArrayList<Integer>>> binMap = new HashMap<>();
		ArrayList<Double> bin = new ArrayList<>();

		for(String s:bgMap.keySet()) {//loops over HashMap of background objects
			for(Higgs h:higgsData) {//loops over ArrayList of Higgs objects
				String id = h.getID();
				if(id.equals(s)) {
					if(binMap.get(s)==null) {
						binMap.put(s, new HashMap<>());
					}
					int EE = h.getEE();
					if(binMap.get(s).get(EE)==null) {
						binMap.get(s).put(EE, new ArrayList<>());
					}
					binMap.get(s).get(EE).add(h.getEE());
				}
			}
		}

		return binMap;

	}

	private int getEE() {
		
		return (int) Math.floor(eventE);
	}
}
