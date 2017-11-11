package module5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Minerals {

	/**
	 * This method extracts the data from a URL into a HashMap
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static HashMap <Integer, Double> massMapFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		HashMap <Integer, Double> mass_map = new HashMap<Integer,Double>();
		Scanner s = new Scanner(br);

		//initialises variables needed
		int i = 0;
		int key = 0;
		double mass = 0;

		while (s.hasNext()) {//Loops while the scanner has another token
			for(i =0;i < 2;){//Loops for the number of columns
				if(i%2 == 0){//for column 1 values
					key = Integer.parseInt(s.next());//resolves the string into an integer
				}
				if (i%2 == 1){//for column 2 values
					mass = Double.parseDouble(s.next());//resolves the string into a double
				}
				i++;//increments counter
			}
			mass_map.put(key, mass);//Adds a new entry to the hashmap
		}
		s.close();
		return mass_map;
	}
	

	/**
	 * This method extracts the data from a URL into an ArrayList
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static HashMap <Integer, String> locationMapFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		HashMap <Integer, String> location_map = new HashMap<Integer,String>();
		Scanner s = new Scanner(br);

		//initialises variables needed
		int i = 0;
		int key = 0;
		String location = null;

		while (s.hasNext()) {//Loops while the scanner has another token
			for(i =0;i < 2;){//Loops for the number of columns
				if(i%2 == 1){//for column 2 values
					key = Integer.parseInt(s.next());//resolves the string into a double
				}
				if (i%2 == 0){//for column 1 values
					location = (s.next());
				}
				i++;//increments counter
			}
			location_map.put(key, location);//Adds the new entry to the hash map
		}
		s.close();
		return location_map;
	}


	public static void main(String[] args) {
		//Creates two new empty hashmap objects
		HashMap <Integer, Double> mass_map = new HashMap<Integer, Double>();
		HashMap <Integer, String> location_map = new HashMap<Integer, String>();

		String url_mass = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";//url from which mass data is extracted
		String url_location = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";//url from which location data is extracted

		try {//Extracts data from url and loads it into the mass hashmap
			mass_map = massMapFromURL(url_mass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Mass Hashmap : "+mass_map);

		try {//Extracts data from url and loads it into the location hashmap
			location_map = locationMapFromURL(url_location);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Locations Hashmap: "+location_map);

		double maxMass = Collections.max(mass_map.values());//finds the maximum mass value
		double minMass = Collections.min(mass_map.values());//finds the minimum mass value

		int key_min = 0, key_max = 0;//initialises the variables that will store the key values

		//Finds the key for the maximum mass value
		for(Entry<Integer, Double> entry: mass_map.entrySet()){
			if (entry.getValue().equals(maxMass)){
				key_max = entry.getKey();
			}
		}

		//Finds the key corresponding to the minimum mass value
		for(Entry<Integer, Double> entry: mass_map.entrySet()){
			if (entry.getValue().equals(minMass)){
				key_min = entry.getKey();
			}
		}

		//Finds the location of corresponding to the key of the minimum mass and the location corresponding to the key of the maximum mass.
		String location_max = location_map.get(key_max);
		String location_min = location_map.get(key_min);

		System.out.println("\nThe entry corresponding to the minimum mass is: {Sample Code: " + key_min+ ", Mass: " + minMass+" g, Loaction: "+ location_min+"}");		
		System.out.println("The entry corresponding to the maximum mass is: {Sample Code: " + key_max+ ", Mass: " + maxMass+" g, Location: "+ location_max+"}");

	}

}
