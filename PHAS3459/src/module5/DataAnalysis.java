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
		ArrayList<Double> Url_data = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				double x = Double.parseDouble(s.next());//resolves the sting into a double
				Url_data.add(x);
			}
			s.close();
		}

		return Url_data;

	}


	public static void main(String[] args) {


	}

}
