package Exam12_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Background {

	private int minE;
	private int maxE;
	private double expEvent;

	public Background(int minE, int maxE, double expEvent) {
		this.minE = minE;
		this.maxE = maxE;
		this.expEvent = expEvent;
	}

	public static ArrayList<Background> bgData(String urlName) throws IOException{

		ArrayList<Background> bgList= new ArrayList<>();

		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		br.readLine();

		Scanner sc = new Scanner(br);
		Background bg;

		while(sc.hasNext()) {
			int minE = sc.nextInt();
			int maxE = sc.nextInt();
			double expEvent = sc.nextDouble();
			bg = new Background(minE,maxE,expEvent);
			bgList.add(bg);
		}

		sc.close();
		return bgList;
	}

	public String toString() {
		String s = "";
		s = "Min E: "+minE+"(GeV) Max E: "+maxE+"(GeV) Expected Events: "+expEvent+"\n";
		return s;
	}

	public static HashMap<String,ArrayList<Background>> bgMap(ArrayList<Higgs> higgsData, ArrayList<String> urlList) throws IOException{
		HashMap<String,ArrayList<Background>> higgsMap = new HashMap<>();

		for(Higgs h:higgsData) {
			String id = h.getID();
			ArrayList<Background>ar = higgsMap.get(id);
			if(ar==null) {
				for(String u : urlList) {
					if(u.contains(id)) {
						ar = new ArrayList<>();
						ar = Background.bgData(u);
						higgsMap.put(id,ar);
					}
				}
			}
		}
		
		return higgsMap;

	}
}
