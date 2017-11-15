package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class EarthquakeMain {

	public static ArrayList<Earthquake> data(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		ArrayList<Earthquake> eqData = new ArrayList<>();

		while ((line=br.readLine()) != null){
			if (Character.isDigit(line.charAt(0))) {
				Earthquake eq = Earthquake.parseLine(line);

				eqData.add(eq);
			}
		}
		return eqData;
	}

	public static HashMap<Integer, ArrayList<Earthquake>> dataMap(ArrayList<Earthquake> eqData) throws IOException{
		HashMap<Integer,ArrayList<Earthquake>> eqMap = new HashMap<>();
		for (Earthquake eq : eqData) {
			int month = eq.getMonth();
			ArrayList<Earthquake> thisEQList = eqMap.get(month);
			if(thisEQList == null) {
				eqMap.put(month,new ArrayList<Earthquake>());
			}
			eqMap.get(month).add(eq);
		}
		return eqMap;

	}



	public static void main(String[] args) {
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt";
		ArrayList<Earthquake> all_data = new ArrayList<>();
		HashMap<Integer, ArrayList<Earthquake>> eq_map = new HashMap<>();

		try {
			all_data = data(url);
			System.out.println("Total number of earthquakes: "+all_data.size());//total number of earthquakes
			eq_map = dataMap(all_data);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		double maxMag = 0;
		int maxMag_i = 0;

		//Finding player with most home runs by looping over all players
		for(int i = 0; i < all_data.size();) {
			Earthquake currEq = all_data.get(i);//player with index i
			double currMag = currEq.getMag();//hr of player i
			if (currMag > maxMag) {
				maxMag = currMag;
				maxMag_i = i;
			}
			i++;
		}
		System.out.println("\nEarthquake with the maximum magnitude: "+all_data.get(maxMag_i));

		for(int month: eq_map.keySet()) {
			ArrayList<Earthquake> month_eq_list = new ArrayList<>();
			month_eq_list = eq_map.get(month);//all players in team
			ArrayList<Earthquake> eq_dep = new ArrayList<>();

			double maxDep = 0;
			int maxDep_i = 0;
			double minEZ = Double.MAX_VALUE;
			int minEZ_i = 0;

			for(int i = 0; i < month_eq_list.size();) {
				Earthquake currEq = month_eq_list.get(i);
				double currDep = currEq.getDep();
				double currEZ = currEq.getEZ();
				if(currDep>maxDep) {
					maxDep = currDep;
					maxDep_i = i;
				}
				if(currEZ>0) {
					if(currEZ<minEZ) {
						minEZ = currEZ;
						minEZ_i = i;
					}
				}
				i++;
			}
			System.out.println("\n\t\tMonth: "+month+"\n\nNumber of earthquakes was: "+month_eq_list.size()+"\nThe deepest earthquake was: "+month_eq_list.get(maxDep_i)+"\nThe earthquake with the most accurate depth was: "+month_eq_list.get(minEZ_i));
		}
	}
}