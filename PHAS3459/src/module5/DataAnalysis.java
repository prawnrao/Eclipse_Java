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
		ArrayList<Double> url_data = new ArrayList<Double>();
		ArrayList<DataPoint> datapoints = new ArrayList<DataPoint>();
		Scanner s = new Scanner(br);

		while (s.hasNext()) {//Loops while the scanner has another token
			double val = Double.parseDouble(s.next());//resolves the string into a double
			url_data.add(val);
			if (url_data.size() >= 3){
				DataPoint point = new DataPoint(url_data.get(0),url_data.get(1),url_data.get(2));
				datapoints.add(point);
				url_data = new ArrayList<Double>();
			}
		}
		s.close();
		return datapoints;
	}

	public static double goodnessfFit(Theory n, ArrayList<DataPoint> datapoints) {
		double xpoint,ypoint, eypoint, residual;
		double chi_sq = 0;

		for(int i=0; i <= datapoints.size();i++){
			residual = 0;
			DataPoint point = datapoints.get(i);
			xpoint = point.getX();
			ypoint = point.getY();
			eypoint = point.getEY();
			double y_theory = n.y(xpoint);		
			residual = (Math.pow((ypoint - y_theory),2))/(Math.pow(eypoint, 2));
			chi_sq += residual;
		}
		return chi_sq;

	}

	public static void main(String[] args) {
		ArrayList<DataPoint> data = new ArrayList<>();//Defines a new array list with double values

	}

}
