package test;

import java.io.IOException;
import java.util.Scanner;

public class player {

	private String name;
	private String team;
	private String pos;
	private int games;
	private int at_bats;
	private int runs;
	private int singles;
	private int doubles;
	private int triples;
	private int homeruns;
	private double rbi;
	private double avg;
	private double obp;

	public player(String name, String team, String pos, int games, int at_bats, int runs, int singles, int doubles, 
			int triples, int homeruns,double rbi, double avg, double obp) {

		this.name = name;
		this.team = team;
		this.pos = pos;
		this.games = games;
		this.at_bats = at_bats;
		this.runs = runs;
		this.singles = singles;
		this.doubles  = doubles;
		this.triples = triples;
		this.homeruns = homeruns;
		this.rbi = rbi;
		this.avg = avg;
		this.obp = obp;
				
	}
	
	public static player parseLine(String line) throws IOException {
		Scanner s = new Scanner(line).useDelimiter("\t");
		
		String name = s.next();
		String team = s.next();
		String pos = s.next();
		int games = s.nextInt();
		int at_bats = s.nextInt();
		int runs = s.nextInt();
		int singles = s.nextInt();
		int doubles = s.nextInt();
		int triples = s.nextInt();
		int homeruns = s.nextInt();
		double rbi = s.nextDouble();
		double avg = s.nextDouble();
		double obp = s.nextDouble();
		
		s.close();
		player Player = new player(name, team, pos, games, at_bats, runs, singles, doubles, triples, homeruns, rbi, avg, obp);
		return Player;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public int getGames() {
		return games ;
	}
	
	public int getAB() {
		return at_bats;
	}
	
	public int getSingle() {
		return singles ;
	}
	
	public int getDouble() {
		return doubles ;
	}
	
	public int getTriple() {
		return triples ;
	}
	
	public String toString() {
		
		return name;
		
	}
}
