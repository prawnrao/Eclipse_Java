package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class earthquake {
	public static HashMap <Integer, ArrayList<Object>> earthquake(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		HashMap <Integer, ArrayList<Object>> earthquake = new HashMap<Integer,ArrayList<Object>>();
		ArrayList<Object> data = new ArrayList<>();
		String line;

		while ((line=br.readLine()) != null){
			data = new ArrayList<>();

			if (Character.isDigit(line.charAt(0))){
				Scanner s = new Scanner(line);
				data.add(s.nextInt());//year-0
				data.add(s.nextInt());//month-1
				data.add(s.nextInt());//day-2
				data.add(s.nextInt());//hour-3
				data.add(s.nextInt());//min-4
				data.add(s.nextDouble());//sec-5
				data.add(s.nextDouble());//Latitude-6
				data.add(s.nextDouble());//longitude-7
				data.add(s.nextDouble());//dep-8
				data.add(s.nextDouble());//eh1-9
				data.add(s.nextDouble());//eh2-10
				data.add(s.nextInt());//az-11
				data.add(s.nextDouble());//ez-12
				data.add(s.nextDouble());//mag-13
				int a = s.nextInt();//key

				s.close();
				earthquake.put(a,data);
			}
		}

		return earthquake;

	}

	public static void main(String[] args){
		String url = ("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/earthquakesCA1989.txt");

		HashMap <Integer, ArrayList<Object>> eq = new HashMap<Integer,ArrayList<Object>>();
		try {
			eq = earthquake(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		double mag = 0;
		double max_mag = 0;
		
		for(int i=1;i<13;) {
			int month=0;
			double depth = 0;
			double max_depth = 0;
			int eq_month=0;
			int index_depth = 0;
			int index_ez = 0; 
			double d_err=0;
			double min_d_err=100;
			for (int code :eq.keySet()) {
				ArrayList<Object> datapoint = eq.get(code);
				month = (int) datapoint.get(1);
				depth = (double)datapoint.get(8);
				d_err = (double) datapoint.get(12);

				if (month==i){
					eq_month++;
					if(depth>max_depth) {
						max_depth = depth;
						index_depth = code;
					}
					if(d_err != -1.0) {
						if(d_err<min_d_err) {
							min_d_err = d_err;
							index_ez = code;
						}
					}
				}
			}
			System.out.println("Month "+i+" had: "+eq_month+" earthquakes "+"and details of the max depth: "+eq.get(index_depth)+" details of min err "+ eq.get(index_ez));
			i++;
		}


		
		int index = 0;
		for (int code :eq.keySet()) {

			ArrayList<Object> datapoint = eq.get(code);
			mag = (double) datapoint.get(13);
			if (mag > max_mag) {
				index = code;
			}
		}


		System.out.println("Number of earthquakes: "+eq.size());
		System.out.println(eq.get(index));
	}
}
