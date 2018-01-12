package Exam14_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Sites {
	private String site;
	private String port;
	
	//Constructor
	public Sites(String site, String port) {
		this.site = site;
		this.port = port;
	}

	/**
	 * Unpacks the Site data from a URL
	 * @param urlName
	 * @return ArrayList of site objects
	 * @throws IOException
	 */
	public static ArrayList<Sites> parseData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		br.readLine();
		
		String siteName="";
		String portName="";
		int n = 1;
		ArrayList<Sites> sites = new ArrayList<>();
		Sites site = null;
		
		while ((line=br.readLine())!=null){
			Scanner s = new Scanner(line);
			siteName = s.next();
			portName = s.next();
			site = new Sites(siteName,portName);
			sites.add(site);
		}
		
		return sites;
	}
	
	/**
	 * toString method, helps to print Site objects
	 */
	public String toString() {
		String s = "";
		s = this.site +" "+this.port+"\n";
		return s;
	}
	
	/**
	 * Getter methods
	 */
	public String getSiteName() {
		return site;
	}
	public String getPort() {
		return port;
	}
}
