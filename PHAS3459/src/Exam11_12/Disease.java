package Exam11_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Disease {

	public String ID;
	public ArrayList<Double> infected;
	public String regionName;
	public double population;

	public Disease(String ID, ArrayList<Double> infected) {
		this.ID = ID;
		this.infected = infected;
	}

	public static ArrayList<Disease> diseaseList (String urlName) throws IOException{
		URL url1 = new URL(urlName);
		ArrayList<Disease> diseaseList = new ArrayList<>();

		InputStream is = url1.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		while((line = br.readLine())!=null) {
			Scanner s  = new Scanner(line);
			String ID = s.next();
			ArrayList<Double> infected = new ArrayList<>();
			while(s.hasNext()) {
				infected.add(s.nextDouble());
			}
			Disease disease = new Disease(ID,infected);
			diseaseList.add(disease);
			s.close();
		}
		
		return diseaseList;
	}

	public static ArrayList<Disease> allDiseaseList(ArrayList<Disease> diseaseList1,ArrayList<Disease> diseaseList2){
		ArrayList<Disease> allDiseaseList = diseaseList1;
		for(Disease d1 : diseaseList1) {
			String ID = d1.getID();
			for(Disease d2: diseaseList2) {
				if(d2.getID().equals(ID)) {
					d1.getInfected().addAll(d2.getInfected());
					break;
				}
			}
		}
		return allDiseaseList;
	}
	
	public static double infectedPop(Disease dis) {
		double sum =0;
		for(double d: dis.getInfected()) {
			sum+=d;
		}
		return sum;
	}

	private void setInfected(ArrayList<Double> infected2) {
		infected = infected2;
	}

	public ArrayList<Double> getInfected() {
		return infected;
	}

	public String getID() {
		return ID;
	}
	
	public String toString() {
		String s = "";
		if(infected.size()==2) {
			s = "(A: "+ infected.get(0)+" B: "+ infected.get(1)+")\n";
		}
		if(infected.size()==3) {
			s = "(X: "+ infected.get(0)+" Y: "+ infected.get(1)+" Z: "+ infected.get(2)+")";
		}
		if(infected.size()==5) {
			s = "(A: "+ infected.get(3)+" B: "+ infected.get(4)+", X: "+ infected.get(0)+" Y: "+ infected.get(1)+" Z: "+ infected.get(2)+")";
		}
		return s;
	}
}
