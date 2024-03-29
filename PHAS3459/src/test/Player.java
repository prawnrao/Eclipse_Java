package test;

import java.io.IOException;
import java.util.Scanner;
//DONT FORGET UNITS
public class Player {

	private String name;
	private String team;
	private String pos;
	private int games;
	private double at_bats;
	private int runs;
	private int singles;
	private int doubles;
	private int triples;
	private int homeruns;
	private double rbi;
	private double avg;
	private double obp;
	private double slg;
	private double ops;

	public Player(String name, String team, String pos, int games, double at_bats, int runs, int singles, int doubles, 
			int triples, int homeruns,double rbi, double avg, double obp, double slg, double ops) {

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
		if(at_bats == 0) {
			this.slg = 0; 
			this.ops = obp;
		}
		else {
			this.slg = (singles+(2*doubles)+(3*triples)+(4*homeruns))/at_bats;
			this.ops = slg + obp;
		}

	}

	public static Player parseLine(String line) throws IOException {
		Scanner s = new Scanner(line).useDelimiter("\t");

		String name = s.next();
		String team = s.next();
		String pos = s.next();
		int games = s.nextInt();
		double at_bats = s.nextInt();
		int runs = s.nextInt();
		int singles = s.nextInt();
		int doubles = s.nextInt();
		int triples = s.nextInt();
		int homeruns = s.nextInt();
		double rbi = s.nextDouble();
		double avg = s.nextDouble();
		double obp = s.nextDouble();
		double slg = 0;
		double ops = obp;


		s.close();

		if(at_bats == 0) {
			slg = 0; 
			ops = obp;
		}
		else {
			slg = (singles+(2*doubles)+(3*triples)+(4*homeruns))/at_bats;
			ops = slg + obp;
		}
		Player player = new Player(name, team, pos, games, at_bats, runs, singles, doubles, triples, homeruns, rbi, avg, obp, slg, ops);
		return player;

	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public int getHR() {
		return homeruns;
	}
	
	public double getAB() {
		return at_bats;
	}
	
	public double getSLG() {
		return slg;
	}
	
	public double getOPS() {
		return ops;
	}

	public String toString() {
		String print = "\n\t\tName: "+name +"  Team: "+ team+ "  Positon: "+pos +
				"\n\t\tGames: "+games+"  At-bats: "+at_bats+"  Runs: "+runs+
				"\n\t\tSingles: "+singles+"  Doubles: "+doubles+"  Triples: "+triples+
				"\n\t\tHomeruns: "+homeruns+"  RBI: "+rbi+ "  AVG: "+avg+ "  OBP: "+obp+
				"\n\t\tSLG: "+slg+"  OPS: "+ops+"\n";
		return print;

	}


}
