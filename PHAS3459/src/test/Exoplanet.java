package test;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exoplanet {
	private String name;
	private int year;
	private String method_disc;
	private double mass;
	private double sep;
	private Object distance;


	public Exoplanet(String name, int year, String method_disc, double mass, double sep, Object distance) {

		this.name = name;
		this.year = year;
		this.method_disc = method_disc;
		this.mass = mass;
		this.sep = sep;
		this.distance = distance;

	}

	public static Exoplanet parseLine(String line) throws IOException {
		
		//Scanner s = new Scanner(line).useDelimiter(",");
		StringTokenizer st = new StringTokenizer(line,",");
		Object distance = "N/A";
		String name = st.nextToken();
		int year = Integer.parseInt(st.nextToken());
		String method_disc = st.nextToken();
		double mass = Double.parseDouble(st.nextToken());
		double sep = Double.parseDouble(st.nextToken());
		
		if(st.hasMoreTokens()){
			distance = Double.parseDouble(st.nextToken());
		}


		//s.close();
		Exoplanet planet = new Exoplanet (name, year, method_disc, mass, sep, distance);

		return planet;
	}

	public String getMethod(){
		return method_disc;
	}

	public int getYear(){
		return year;
	}

	public double getMass(){
		return mass;
	}
	public Object getDist(){
		return distance;
		
	}

	public String toString(){
		String print = "\n\t\tName: "+name +"  Year: "+ year+ "  Mass: "+mass +
						"\n\t\tSeparation: "+ sep+ " Distance: "+ distance + " Method: "+method_disc+"\n";
		return print;
	}
}

