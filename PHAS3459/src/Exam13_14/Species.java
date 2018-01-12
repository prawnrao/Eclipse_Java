package Exam13_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Species {
	private String id;
	private String name;

	public Species(String id , String name){
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Method that unpacks an ArrayList of Species Objects from a given URL
	 * @param urlName
	 * @return ArrayList<Species>
	 * @throws IOException
	 */
	public static ArrayList<Species> spData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Species sp = null;
		ArrayList<Species> ar_sp = new ArrayList<>();

		while ((line=br.readLine()) != null){
			sp = parseLine(line);
			ar_sp.add(sp);
		}
		return ar_sp;
	}
	
	/**
	 * Method to parse the data to make a Species object
	 * @param line
	 * @return Species
	 * @throws IOException
	 */
	public static Species parseLine(String line) throws IOException {
		Scanner s = new Scanner(line);
		String name="";
		String id="";
		while (s.hasNext()) {
			id = s.next();
			name = s.next()+" "+s.next();
		}
		Species Detector = new Species(id,name);
		return Detector;
	}
	
	public String toString() {
		String s ="";
		s ="\n\tIdentifier: "+id + "\tName: "+name;
		return s;
	}

	public String getID() {
		
		return id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
