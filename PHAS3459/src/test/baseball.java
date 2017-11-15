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
		ArrayList<Player> all_data = new ArrayList<>();
		HashMap<String,ArrayList<Player>> team_map = new HashMap<>();

		try {
			all_data = data(url);
			System.out.println("Total number of players: "+all_data.size());//total number of players
			team_map = dataMap(all_data);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		int maxHR = 0;
		int maxHR_i = 0;

		//Finding player with most home runs by looping over all players
		for(int i = 0; i < all_data.size();) {
			Player currPlayer = all_data.get(i);//player with index i
			int currHR = currPlayer.getHR();//hr of player i
			if (currHR > maxHR) {
				maxHR = currHR;
				maxHR_i = i;
			}
			i++;
		}
		System.out.println("\nPlayer with the most home runs:"+all_data.get(maxHR_i));

		//Finding players with AB>10 and max SLG, max OPS for each team
		for(String team: team_map.keySet()) {
			ArrayList<Player> team_player_list = new ArrayList<>();
			team_player_list = team_map.get(team);//all players in team
			ArrayList<Player> player_ab = new ArrayList<>();
			double maxSLG = 0;
			int maxSLG_i = 0;
			double maxOPS = 0;
			int maxOPS_i = 0;
			
			for(int i = 0; i < team_player_list.size();) {
				Player currPlayer = team_player_list.get(i);
				double currAB = currPlayer.getAB();
				if(currAB > 10) {
					player_ab.add(currPlayer);
					double currSLG = currPlayer.getSLG();
					double currOPS = currPlayer.getOPS();
					if (currSLG>maxSLG) {
						maxSLG = currSLG;
						maxSLG_i = i;
					}
					if (currOPS>maxOPS) {
						maxOPS = currOPS;
						maxOPS_i = i;
					}
				}
				i++;
			}
			System.out.println("\n\t\tTeam: "+team+"\n\n"+player_ab.size()+" players with more than 10 at-bats\nPlayer with the highest SLG: "+team_player_list.get(maxSLG_i)+"\nPlayer with the highest OPS: "+team_player_list.get(maxOPS_i));
		}

	}

} 


