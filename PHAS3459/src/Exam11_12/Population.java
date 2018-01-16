package Exam11_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Population {
	public String ID;
	public double pop;

	public Population(String ID, double pop) {
		this.ID = ID;
		this.pop = pop;
	}

	public static ArrayList<Population> popData(String urlName) throws IOException{
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line = "";

		//ArrayList of each line that contains two strings, ID and region name
		ArrayList<Population> popData = new ArrayList<>();
		while((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);

			String ID = sc.next();//recording name
			double pop = sc.nextDouble();//instrument name
			Population populaion = new Population(ID,pop);
			popData.add(populaion);
		}
		return popData;
	}

	public String getID() {
		return ID;
	}

	public Double getPop() {
		return pop;
	}
}
