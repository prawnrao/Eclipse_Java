package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {


	/**
	 * This method extracts the data from a URL into an ArrayList
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Double> dataFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		ArrayList<Double> url_data = new ArrayList<>();
		while ((line = br.readLine()) != null) {//Loops until the buffered reader is empty
			Scanner s = new Scanner(line);
			while (s.hasNext()) {//Loops until the scanner has another token
				double x = Double.parseDouble(s.next());//resolves the string into a double
				url_data.add(x);
			}
			s.close();
		}
		return url_data;
	}

	public static double goodnessfFit(Theory n, ArrayList<DataPoint> datapoint) {
		
		return 0;
		
	}

	public static void main(String[] args) {
		ArrayList<Double> data = new ArrayList<>();//Defines a new array list with double values
		try {
			data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");//imports data from the url to the array list
			System.out.println("All data from the URL:\n\t"+data);//outputs the data to screen
		} catch (IOException e) {
			e.printStackTrace();
		}


		//initialises variables used in the loops
		ArrayList<Double> xdata = new ArrayList<>();
		ArrayList<Double> ydata = new ArrayList<>();
		ArrayList<Double> eydata = new ArrayList<>();
		int n= 0;
		
		while(n < data.size()) {//loops for the entire size of the array
			int i = 0;
			while(i < 3) {//loops every 3 integers
				if(i == 0) {//catches the 0th, 3rd, 6th... index of the array list
					double x = data.get(n);
					xdata.add(x);//appends the x data array list with the value of index n
				}
				else if(i == 1) {//catches the 1st, 4th, 7th... index of the data array list
					double y = data.get(n);
					ydata.add(y);//appends the y data array list with the value of index n
				}
				else if (i==2) {//catches the 2nd, 5th, 8th... index of the data array list
					double ey = data.get(n); 
					eydata.add(ey);//appends the error y data array list with the value of index n
				}
				i++;//increments i
				n++;//increments n
			}
		}

		System.out.println("\nX data from URL:\n\t"+xdata);
		System.out.println("\nY data from URL:\n\t"+ydata);
		System.out.println("\neY data from URL:\n\t"+eydata);
	}

}
