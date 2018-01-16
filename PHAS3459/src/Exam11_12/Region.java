package Exam11_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Region {

	private String ID;
	private String name;
	private Disease disease;
	private Double pop;

	public Region(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public static ArrayList<Region> regionData(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line = "";
		//ArrayList of each line that contains two strings, ID and region name
		ArrayList<Region> regionData = new ArrayList<>();
		while((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line).useDelimiter(",");
			String ID = (sc.next());//recording name
			String name = (sc.next());//instrument name
			Region region = new Region(ID, name);
			regionData.add(region);
		}
		return regionData;
	}

	public static HashMap<String,Region> regionMap(ArrayList<Region> regionData,ArrayList<Disease> diseaseList, ArrayList<Population> popData){
		HashMap<String,Region> regionMap = new HashMap<>();
		for(Region r:regionData) {
			String ID = r.getID();

			for(Disease d:diseaseList) {
				if(d.getID().equals(ID)) {
					r.setDisease(d);
					break;
				}
			}

			for(Population p:popData) {
				if(p.getID().equals(ID)) {
					r.setPop(p.getPop());
					break;
				}
			}
			regionMap.put(ID, r);
		}
		return regionMap;
	}

	public static double totalPop(HashMap<String,Region> regionMap) {
		double totalPop = 0;
		for(String s:regionMap.keySet()) {
			Region region = regionMap.get(s);
			double pop = region.getPop();
			totalPop+=pop;
		}
		return totalPop;
	}

	public static Disease diseasePerCap(HashMap<String,Region> regionMap){
		double total = totalPop(regionMap);
		double A = 0;double B=0;double X=0;double Y=0;double Z=0;
		for(String s:regionMap.keySet()) {
			Region r = regionMap.get(s);
			Disease disease = r.getDisease();
			if(disease!=null) {
				ArrayList<Double> d = disease.getInfected();
				X += d.get(0);
				Y += d.get(1);
				Z +=d.get(2);
				if(d.size()>3) {
					A += d.get(3);
					B += d.get(4);
				}
			}
		}
		System.out.println(A+"  "+B+"  "+X+"  "+Y+"  "+Z);
		ArrayList<Double> perCapita = new ArrayList<>();
		perCapita.add(X/total);perCapita.add(Y/total);perCapita.add(Z/total);perCapita.add(A/total);perCapita.add(B/total);
		Disease diseasePerCapita = new Disease("",perCapita);
		return diseasePerCapita;
	}

	private Disease getDisease() {
		return disease;

	}
	private double getPop() {
		return pop;
	}
	private void setPop(Double pop) {
		this.pop = pop;
	}
	private void setDisease(Disease diseaseData) {
		this.disease = diseaseData;
	}
	private String getID() {
		return ID;
	}

	public String toString() {
		String s = "";
		s = ID + "=\tRegion Name: "+name +"  Population: "+ pop +"  "+ disease; 
		return s;
	}
}
