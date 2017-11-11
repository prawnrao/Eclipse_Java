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
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Double> url_data = new ArrayList<Double>();//ArrayList of doubles
		ArrayList<DataPoint> datapoints = new ArrayList<DataPoint>();//ArrayList of datapoints
		Scanner s = new Scanner(br);

		while (s.hasNext()) {//Loops while the scanner has another token
			double val = Double.parseDouble(s.next());//resolves the string into a double
			url_data.add(val);//appends the arraylist of data
			if (url_data.size() == 3){
				DataPoint point = new DataPoint(url_data.get(0),url_data.get(1),url_data.get(2));//extracts the x, y and ey values and creates a new datapoint
				datapoints.add(point);//appends the arraylist of datapoints
				url_data = new ArrayList<Double>();//resets the data arraylist to contain 0 values
			}
		}
		s.close();
		return datapoints;
	}

	/**
	 * This method calculates chi-sq for a specific order of the fitted line
	 * @param theory
	 * @param datapoints
	 * @return
	 */
	public static double goodnessOfFit(Theory theory, ArrayList<DataPoint> datapoints) {
		double xpoint,ypoint, eypoint, residual, chi_sq = 0;

		for(int i=0; i < datapoints.size();i++){//Loops till counter is equal to number of datapoints
			residual = 0;
			DataPoint point = datapoints.get(i);
			//Extracts x, y and ey from the datapoint
			xpoint = point.getX();
			ypoint = point.getY();
			eypoint = point.getEY();
			//calculates the theoretical value for y
			double y_theory = theory.y(xpoint);		
			//calculates the residual for a specific coordinate
			residual = (Math.pow((ypoint - y_theory),2))/(Math.pow(eypoint, 2));
			chi_sq += residual;//add the residual to the running sum of chi-square
		}
		return chi_sq;//returns chi-square

	}

	public static void main(String[] args) {

		Theory n_2 = new Theory(2);//theoretical y for a 2nd order fit
		Theory n_4 = new Theory(4);//theoretical y for a 4th order fit
		ArrayList<DataPoint> data = new ArrayList<>();//Defines a new array list with double values
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt";//url from which data is extracted

		try {//extracts data from url and puts it into an array list
			data  = dataFromURL(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		double chi_sq_2 = goodnessOfFit(n_2,data);//calculates chi-sq for 2nd order
		double red_chi_sq_2 = chi_sq_2/(data.size()-1);//calculates reduced chi-sq for 2nd order (DOF = N-1)
		System.out.println("Chi-square value for the y = x^2 fit was: "+chi_sq_2 +" and reduced Chi-square was: "+red_chi_sq_2);

		double chi_sq_4 = goodnessOfFit(n_4,data);//calculates chi-sq for 4th order
		double red_chi_sq_4 = chi_sq_4/(data.size()-1);//calculates reduced chi-sq for 4th order (DOF = N-1)
		System.out.println("\nChi-square value for the y = x^4 fit was: "+chi_sq_4+" and reduced Chi-square was: "+red_chi_sq_4);
		System.out.println("\nThe 2nd order fit better describes the data because it has a smaller chi-sq value");
	}

}
