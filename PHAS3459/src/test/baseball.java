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

public class baseball {

	public static HashMap <String, ArrayList<Object>> baseball(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		HashMap <String, ArrayList<Object>> baseball = new HashMap<String,ArrayList<Object>>();
		ArrayList<Object> data = new ArrayList<>();
		String line;

		while ((line=br.readLine()) != null){
			data = new ArrayList<>();
			Scanner s = new Scanner(line).useDelimiter("\t");
			if (line.contains(".")){
				String K = s.next();//key(player)
				data.add(s.next());//team-0
				data.add(s.next());//position-1
				data.add(s.nextInt());//number of games-2
				data.add(s.nextInt());//AB-3
				data.add(s.nextInt());//R-4
				data.add(s.nextInt());//H-5
				data.add(s.nextInt());//2B-6
				data.add(s.nextInt());//3B-7
				data.add(s.nextInt());//HR-8
				data.add(s.nextInt());//RBI-9
				data.add(s.nextDouble());//AVG-10
				data.add(s.nextDouble());//OBP-11

				s.close();
				baseball.put(K,data);
			}
		}
		return baseball;
	}


	public static void main(String[] args){
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";
		HashMap<String, ArrayList<Object>> baseball_data = new HashMap<>();
		try {
			baseball_data = baseball(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String index = "";
		int hr = 0;
		int max_hr = 0;
		int no_bats =0;
		int i =0;
		String name ="";
		String team ="";
		ArrayList<String> teams= new ArrayList<>();
		ArrayList<Object> datapoint = new ArrayList<>();

		for (String key :baseball_data.keySet()) {
			datapoint = baseball_data.get(key);
			hr = (int) datapoint.get(8);
			team = (String) datapoint.get(0);
			if(!teams.contains(team)){
				teams.add(team);
			}
			if (hr > max_hr) {
				max_hr = hr;
				index = key;
			}
		}
		

		for(i = 0; i<teams.size();){
			no_bats = 0;
			String maxkey ="";
			String maxops ="";
			double slg = 0;
			double maxslg = 0;
			name = teams.get(i);
			double ops = 0;
			double max_ops = 0;
			System.out.println(name+"\n");
			
			for (String key :baseball_data.keySet()) {
				datapoint = baseball_data.get(key);
				team =(String) datapoint.get(0);
				if(name.equals(team)){
					double bats = (Integer)datapoint.get(3);
					if(bats>=10){
						double b1 = (Integer)datapoint.get(5);
						double b2 = (Integer)datapoint.get(6);
						double b3 = (Integer)datapoint.get(7);
						double h = (Integer)datapoint.get(8);
						double obp = (Double)datapoint.get(11);
						slg = ((b1+(2*b2)+(3*b3)+(4*h))/bats);
						ops = obp + slg;
						if (ops>max_ops){
							max_ops = ops;
							maxops = key;
						}
						//System.out.println(slg);
						if(slg>maxslg){
							maxslg = slg;
							maxkey = key;
						}
						System.out.print("("+key+")");
						no_bats++;
					}
				}
			}
			System.out.println("\n"+no_bats);
			System.out.println(maxkey+" had the max slg of : "+maxslg);
			System.out.println(maxops+" had the max ops of : "+max_ops);
			i++;
		}
	}
	
} 


