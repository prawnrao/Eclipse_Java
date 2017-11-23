package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
//DONT FORGET UNITS
public class ExoplanetMain {
	public static ArrayList<Exoplanet> data(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		ArrayList<Exoplanet> PlanetData = new ArrayList<>();

		while ((line=br.readLine()) != null){
			if (line.contains(".")) {
				Exoplanet planet = Exoplanet.parseLine(line);
				PlanetData.add(planet);
			}
		}
		return PlanetData;
	}
	
	public static HashMap<String, ArrayList<Exoplanet>> dataMap(ArrayList<Exoplanet> PlanetData) throws IOException{
		HashMap<String,ArrayList<Exoplanet>> PlanetMap = new HashMap<>();
		for (Exoplanet planet : PlanetData) {
			String team = planet.getMethod();
			ArrayList<Exoplanet> thisPlanetList = PlanetMap.get(team);
			if(thisPlanetList == null) {
				PlanetMap.put(team,new ArrayList<Exoplanet>());
			}
			PlanetMap.get(team).add(planet);
		}
		return PlanetMap;

	}
	
	public static void main(String[] args) {
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/exoplanets.txt";
		ArrayList<Exoplanet> all_data = new ArrayList<>();
		HashMap<String,ArrayList<Exoplanet>> dataMap = new HashMap<>();
		try {
			all_data=data(url);
			System.out.println("Total number of exoplanets: "+all_data.size());
			dataMap = dataMap(all_data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		double minDis = Double.MAX_VALUE;
		int minDis_i = 0;
		for(int i = 0; i < all_data.size();) {
			Exoplanet currPlanet = all_data.get(i);
			Object currDis_ob = currPlanet.getDist();
			double currDis = 0;
			if(currDis_ob != "N/A"){
				currDis = (double)currDis_ob;
				if (currDis < minDis) {
					minDis = currDis;
					minDis_i = i;
				}
			}
			
			i++;
		}
		System.out.println("\nPlanet closest to earth is:"+all_data.get(minDis_i));
	
		for(String method: dataMap.keySet()) {
			
			ArrayList<Exoplanet> planet_list = new ArrayList<>();
			planet_list = dataMap.get(method);//all players in team
			//ArrayList<Exoplanet> planet_method = new ArrayList<>();
			int minYear = Integer.MAX_VALUE;
			double minMass = Double.MAX_VALUE;
			int minMass_i = 0;
			
			for(int i = 0; i < planet_list.size();) {
				Exoplanet currPlanet = planet_list.get(i);
				int currYear = currPlanet.getYear();
				double currMass = currPlanet.getMass();
				if(currYear<minYear){
					minYear = currYear;
				}
				if(currMass<minMass){
					minMass = currMass;
					minMass_i = i;
				}
				i++;
			}
			System.out.println("\n\t\tMethod: "+method+"\nNumber of planets descovered using "+ method +" method was: "+planet_list.size()+
								"\nThe earliest an exoplanet was descovered was: "+minYear+
								"\nThe lightest exoplanet was: "+planet_list.get(minMass_i));
		}
	}

}
