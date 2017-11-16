package exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import test.Exoplanet;

public class MidTermExam {
	/**
	 * This method takes in the file name and outputs an arraylist containing all the raw data as Ice objects
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Ice> dataFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		ArrayList<Ice> iceData = new ArrayList<>();

		while ((line=br.readLine()) != null){
			if (Character.isDigit(line.charAt(0))) {//this is to exclude the first line containing headings
				Ice datapoint = Ice.parseData(line);//creates an ice object containing all the data required
				iceData.add(datapoint);//appends the ice object to the arraylist
			}
		}

		return iceData;//returns the arraylist containing raw data of ice objects
	}


	/**
	 * This method takes an arraylist of ice objects and converts it to a hashmap, with month as the key and Ice objects as values
	 * @param iceData
	 * @return
	 * @throws IOException
	 */
	public static HashMap<Integer, ArrayList<Ice>> sortedDataMap(ArrayList<Ice> iceData) throws IOException{
		HashMap<Integer,ArrayList<Ice>> iceMap = new HashMap<>();//creates new empty hashmap 

		//loops over the entire arraylist
		for (Ice iceDatapoint : iceData) {
			int month = iceDatapoint.getMonth();//extracts the month from the Ice object datapoint
			ArrayList<Ice> thisIceList = iceMap.get(month);	//gets all the values of a specific month in the hashmap
			if(thisIceList == null) {//checks if this arraylist is null
				iceMap.put(month,new ArrayList<Ice>());//creates a new entry in the hashmap
			}
			iceMap.get(month).add(iceDatapoint);//adds the Ice datapoint to its corresponding month
		}

		return iceMap;//returns a hashmap containing the sorted data
	}



	public static void main(String[] args) {
		String rawData = "N:\\Eclipse\\git\\PHAS3459\\src\\exam1\\N_extent_v3.0.csv";//file in which data is stored
		ArrayList<Ice> iceData = new ArrayList<>();//creates new empty arraylist of Ice objects
		HashMap<Integer,ArrayList<Ice>> iceMap = new HashMap<>();//creates a new empty hashmap 

		try {
			iceData = dataFromFile(rawData);//extracts raw data

			//calculates the size of the arraylist, indicating the number of measurements
			System.out.println("Total number of measurements: "+iceData.size());

			iceMap = sortedDataMap(iceData);//sorts raw data
			//System.out.println(iceMap);

		} catch (IOException e) {
			e.printStackTrace();
		}

		double minExt = Double.MAX_VALUE;//variable that will store the minimum extent
		int minExt_i = 0;//variable that will store the index of the minimum extent
		double minArea = Double.MAX_VALUE;//variable that will store the minimum area
		int minArea_i = 0;//variable that will store the index of the minimum area

		for(int i = 0;i < iceData.size();) {
			Ice currIce = iceData.get(i);
			double currExt = currIce.getExt();

			//this if statement finds the value and index of the minimum extent in all the data
			if(currExt > 0) {
				if(currExt < minExt) {
					minExt = currExt;
					minExt_i = i;
				}
			}

			//this if statement finds the value and index of the minimum extent in all the data
			double currArea = currIce.getArea();
			if(currArea > 0) {
				if(currArea < minArea) {
					minArea = currArea;
					minArea_i = i;
				}
			}

			i++;
		}
		System.out.println("\nThe month with the smallest ice extent:"+iceData.get(minExt_i));
		System.out.println("The month with the smallest ice area:"+iceData.get(minArea_i));

		double maxAvgExt = 0;
		int maxAvgExt_key = 0;
		String txt_maxAvgExt_key = "";
		double minAvgExt = Double.MAX_VALUE;
		int minAvgExt_key = 0;
		String txt_minAvgExt_key = "";	

		for(Integer month: iceMap.keySet()) {
			//this converts the integer month to string month
			String txt_month = "";
			if(month ==1) {txt_month = "Jan";}
			if(month ==2) {txt_month = "Feb";}
			if(month ==3) {txt_month = "Mar";}
			if(month ==4) {txt_month = "Apr";}
			if(month ==5) {txt_month = "May";}
			if(month ==6) {txt_month = "Jun";}
			if(month ==7) {txt_month = "Jul";}
			if(month ==8) {txt_month = "Aug";}
			if(month ==9) {txt_month = "Sep";}
			if(month ==10) {txt_month = "Oct";}
			if(month ==11) {txt_month = "Nov";}
			if(month ==12) {txt_month = "Dec";}
			System.out.println("\n\n\t\t"+txt_month);


			ArrayList<Ice> ice_list = new ArrayList<>();
			ice_list = iceMap.get(month);//all Ice datapoints in a month
			minExt = Double.MAX_VALUE;//variable that will store the minimum extent
			minExt_i = 0;//variable that will store the index of the minimum extent
			double totExt= 0; 
			for(int i =0;i<ice_list.size();) {
				Ice currIce = ice_list.get(i);
				double currExt = currIce.getExt();

				//this if statement finds the value and index of the minimum extent in all the data
				if(currExt > 0) {
					totExt = totExt+currExt; //running total of ice extent
					if(currExt < minExt) {
						minExt = currExt;
						minExt_i = i;
					}
				}

				if(i!=0) {
					Ice prevIce = ice_list.get(i-1);
					double prevExt = prevIce.getExt();
					Object ext_diff = 0;
					if(currExt > 0 && prevExt > 0) {
						ext_diff = currExt - prevExt+" (million sqKm)";
					}else {ext_diff = "N/A";}
					System.out.println("Ice extent difference between "+ currIce.getYear()+" and "+prevIce.getYear()+" was: "+ext_diff);
				}
				i++;
			}
			double avgExt = totExt/ice_list.size();// calculates the average ice extent for that month
			//finds the max average extent
			if(avgExt>maxAvgExt) {
				maxAvgExt = avgExt;
				maxAvgExt_key = month;
				txt_maxAvgExt_key = txt_month;
			}
			//finds the min average extent
			if(avgExt<minAvgExt) {
				minAvgExt = avgExt;
				minAvgExt_key = month;
				txt_minAvgExt_key = txt_month;
			}

			Ice minExt_datapoint = iceData.get(minExt_i);
			int minExt_year = minExt_datapoint.getYear();
			System.out.println("\nThe year with the smallest ice extent: "+minExt_year);
			System.out.println("The average ice extent was: "+ avgExt);
		}

		System.out.println("\n"+txt_maxAvgExt_key+" had the highest avgerage ice extent");
		System.out.println("\n"+txt_minAvgExt_key+" had the highest avgerage ice extent");
		
		ArrayList<Ice> ice_list = iceMap.get(maxAvgExt_key);
		
		double totExt_diff =  0; //initialising running total of extent
		//calculating the average extent change per year
		for(int i =0;i<ice_list.size();) {
			Ice currIce = ice_list.get(i);
			double currExt = currIce.getExt();
			if(i!=0) {
				Ice prevIce = ice_list.get(i-1);
				double prevExt = prevIce.getExt();
				double ext_diff = 0;
				if(currExt > 0 && prevExt > 0) {
					ext_diff = currExt - prevExt;
					totExt_diff =  totExt_diff + ext_diff;
				}
			}
			i++;
		}
		double avgExt_diff = totExt_diff/ice_list.size(); 
		System.out.println("\nThe avgerage ice extent change per year for "+ txt_maxAvgExt_key+ " was: "+avgExt_diff+" (million sqKm)");
		double theoretical_extent = iceData.get(iceData.size()-1).getExt();
		int i = 0;
		while(theoretical_extent > 0) {
			theoretical_extent = theoretical_extent + avgExt_diff;
			i++;
		}
		System.out.println("Number of years till no more ice in the arctic is: " +i+" years");
	}
}