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

	public Sites(String site, String port) {
		this.site = site;
		this.port = port;
	}

	/**
	 * Unpacks the site data from a URL
	 * @param urlName
	 * @return ArrayList of site objects
	 * @throws IOException
	 */
	public static ArrayList<Sites> parseData(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		Scanner s = new Scanner(br);
		String siteName="";
		String portName="";
		int n = 1;
		ArrayList<Sites> sites = new ArrayList<>();
		Sites site = null;
		
		while (s.hasNext()){
			//To skip the first line
			if(n==1) {
				s.next();
				s.next();
				n++;
			}
			siteName = s.next();
			portName = s.next();
			site = new Sites(siteName,portName);
			sites.add(site);
		}
		
		return sites;
	}
	
	public String toString() {
		String s = "";
		s = this.site +" "+this.port+"\n";
		return s;
	}
	
	public String getSiteName() {
		return site;
	}
	public String getPort() {
		return port;
	}
}
