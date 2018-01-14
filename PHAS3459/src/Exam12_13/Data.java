package Exam12_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Data {

	private int minE;
	private int maxE;
	private double expEv;
	private int therEv;

	public Data(int minE, int maxE, double expEv) {
		this.minE = minE;
		this.maxE = maxE;
		this.expEv = expEv;
	}

	public Data(int minE, int maxE, double expEv, int therEv) {
		this.minE = minE;
		this.maxE = maxE;
		this.expEv = expEv;
		this.therEv = therEv;
	}

	public static ArrayList<Data> dataList(String urlName) throws MalformedURLException, IOException{
		ArrayList<Data> dataList = new ArrayList<>();
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();

		Scanner sc = new Scanner(br);

		while(sc.hasNext()) {
			int minE = sc.nextInt();
			int maxE = sc.nextInt();
			double EE = sc.nextDouble();
			Data data = new Data(minE,maxE,EE);
			dataList.add(data);
		}
		return dataList;
	}

	public static double ExpEv(ArrayList<Data> dataList, double min, double max) {
		double sumExpEv = 0;
		for(Data d :dataList) {
			if((d.getMinE()>=min) && (d.getMinE()<max)) {
				sumExpEv += d.getExpEv();
			}
		}
		return sumExpEv;
	}

	public static HashMap<String,ArrayList<Double>> higgsData(String urlName) throws IOException{

		HashMap<String,ArrayList<Double>> higgsMap = new HashMap<>();
		ArrayList<Double> GGlist = new ArrayList<>();
		ArrayList<Double> ZZlist = new ArrayList<>();
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		br.readLine();
		String line = "";

		while((line = br.readLine())!= null) {
			Scanner sc = new Scanner(line);
			String id = sc.next();
			if(id.equals("GG")) {
				GGlist.add(sc.nextDouble());
			}

			if(id.equals("ZZ")) {
				ZZlist.add(sc.nextDouble());
			}
		}
		higgsMap.put("GG", GGlist);
		higgsMap.put("ZZ", ZZlist);
		return higgsMap;
	}

	public static ArrayList<Data> allDataList(ArrayList<Data> dataList,ArrayList<Double> higgsData){
		ArrayList<Data> finalData = dataList;
		for(double e: higgsData) {
			double e_round = Math.floor(e);
			for(Data d:dataList) {
				if(e_round==d.getMinE()) {
					d.setCount(d.getCount()+1);
					break;
				}
			}
		}
		return finalData;
	}


	private void setCount(int i) {
		this.therEv = i;
	}

	private int getCount() {

		return therEv;
	}

	private int getMaxE() {
		return maxE;
	}

	private double getExpEv() {
		return expEv;
	}
	private int getMinE() {
		return minE;
	}
	public String toString() {

		String s = "";
		s = "\nMinE: "+minE +" MaxE: "+ maxE +" Expected Events: "+ expEv+ " Theoretical Events: "+therEv;
		return s;
	}
}
