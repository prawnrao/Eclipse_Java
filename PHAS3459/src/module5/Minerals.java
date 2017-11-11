package module5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Minerals {

	/**
	 * This method extracts the data from a URL into an ArrayList
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
		int i = 0;
		int key = 0;
		double value = 0;

		while (s.hasNext()) {//Loops while the scanner has another token
			for(i =0;i < 2;){
				if(i%2 == 0){
					key = Integer.parseInt(s.next());//resolves the string into a double
				}
				if (i%2 == 1){
					value = Double.parseDouble(s.next());
				}
				i++;
			}
			mass_map.put(key, value);
		}
		s.close();
		return mass_map;
	}

	//public static HashMap<Integer, String> location_map = new HashMap<>();

	public static void main(String[] args) {
		HashMap <Integer, Double> mass_map = new HashMap<Integer, Double>();
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";//url from which data is extracted

		try {
			mass_map = massMapFromURL(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mass_map);

		double maxMass = Collections.max(mass_map.values());
		int key = 0;
		
		for(Entry<Integer, Double> entry: mass_map.entrySet()){
			if (entry.getValue().equals(maxMass)){
				key = entry.getKey();
			}
		}

		System.out.println("The entry corresponding to the max mass is: {" + key+ "=" + maxMass+"}");
	}

}
