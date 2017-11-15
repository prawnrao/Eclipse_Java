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

public class Baseball {

	public static ArrayList<Player> data(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		ArrayList<Player> PlayerData = new ArrayList<>();

		while ((line=br.readLine()) != null){
			if (line.contains(".")) {
				Player player = Player.parseLine(line);
				String team = player.getTeam();
				PlayerData.add(player);
			}
		}
		return PlayerData;
	}

	public static HashMap<String, ArrayList<Player>> dataMap(ArrayList<Player> PlayerData) throws IOException{
		HashMap<String,ArrayList<Player>> PlayerMap = new HashMap<>();
		for (Player player : PlayerData) {
			String team = player.getTeam();
			ArrayList<Player> thisPlayerList = PlayerMap.get(team);
			if(thisPlayerList == null) {
				PlayerMap.put(team,new ArrayList<Player>());
			}
			PlayerMap.get(team).add(player);
		}
		return PlayerMap;

	}


	public static void main(String[] args){
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";
		ArrayList<Player> data = new ArrayList<>();

		try {
			data = data(url);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);

	}

} 


