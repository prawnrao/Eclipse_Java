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

	public static HashMap<String, ArrayList<player>> data(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		//ArrayList<player> PlayerData = new ArrayList<>();
		HashMap<String, ArrayList<player>> dataMap = new HashMap<>();

		while ((line=br.readLine()) != null){
			if (line.contains(".")) {
				player Player = player.parseLine(line);
				String team = Player.getTeam();
				
				if (dataMap.get(team)==null) {
					//create team name
					ArrayList<player> list = new ArrayList<player>();
					dataMap.put(team, list);
				}
				
				dataMap.get(team).add(Player);
				
			}
		}
		return dataMap;
	}




	public static void main(String[] args){
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";
		HashMap<String, ArrayList<player>> data = new HashMap<>();

		try {
			data = data(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);
		//		HashMap<String, ArrayList<Object>> baseball_data = new HashMap<>();
		//		try {
		//			baseball_data = baseball(url);
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//
		//		String index = "";
		//		int hr = 0;
		//		int max_hr = 0;
		//		int no_bats =0;
		//		int i =0;
		//		String name ="";
		//		String team ="";
		//		ArrayList<String> teams= new ArrayList<>();
		//		ArrayList<Object> datapoint = new ArrayList<>();
		//
		//		for (String key :baseball_data.keySet()) {
		//			datapoint = baseball_data.get(key);
		//			hr = (int) datapoint.get(8);
		//			team = (String) datapoint.get(0);
		//			if(!teams.contains(team)){
		//				teams.add(team);
		//			}
		//			if (hr > max_hr) {
		//				max_hr = hr;
		//				index = key;
		//			}
		//		}
		//
		//
		//		for(i = 0; i<teams.size();){
		//			no_bats = 0;
		//			String maxkey ="";
		//			String maxops ="";
		//			double slg = 0;
		//			double maxslg = 0;
		//			name = teams.get(i);
		//			double ops = 0;
		//			double max_ops = 0;
		//			System.out.println(name+"\n");
		//
		//			for (String key :baseball_data.keySet()) {
		//				datapoint = baseball_data.get(key);
		//				team =(String) datapoint.get(0);
		//				if(name.equals(team)){
		//					double bats = (Integer)datapoint.get(3);
		//					if(bats>=10){
		//						double b1 = (Integer)datapoint.get(5);
		//						double b2 = (Integer)datapoint.get(6);
		//						double b3 = (Integer)datapoint.get(7);
		//						double h = (Integer)datapoint.get(8);
		//						double obp = (Double)datapoint.get(11);
		//						slg = ((b1+(2*b2)+(3*b3)+(4*h))/bats);
		//						ops = obp + slg;
		//						if (ops>max_ops){
		//							max_ops = ops;
		//							maxops = key;
		//						}
		//						//System.out.println(slg);
		//						if(slg>maxslg){
		//							maxslg = slg;
		//							maxkey = key;
		//						}
		//						System.out.print("("+key+")");
		//						no_bats++;
		//					}
		//				}
		//			}
		//			System.out.println("\n"+no_bats);
		//			System.out.println(maxkey+" had the max slg of : "+maxslg);
		//			System.out.println(maxops+" had the max ops of : "+max_ops);
		//			i++;
	}

} 


