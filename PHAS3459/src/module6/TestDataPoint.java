package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestDataPoint {
	/**
	 * Creates an array list of datapoints
	 * @param urlName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException {

		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		ArrayList<DataPoint> data = new ArrayList<>();

		while ((line=br.readLine()) != null){
			Scanner s = new Scanner(line);

			double x = Double.parseDouble(s.next());
			double y = Double.parseDouble(s.next());
			double ey = Double.parseDouble(s.next());

			DataPoint datapoint = new DataPoint(x,y,ey);

			if(s.hasNext()){
				String label =s.next();
				datapoint = new LabelledDataPoint(x,y,ey,label);
				data.add(datapoint);
			}
			else {
				data.add(datapoint);
			}
			s.close();
		}
		return data;
	}

	public static void main(String[] args) {
		ArrayList<DataPoint> datalist = new ArrayList<>();
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";

		try {
			datalist = dataFromURL(url);
			for(int i = 0; i<datalist.size();) {
				System.out.println(datalist.get(i));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
