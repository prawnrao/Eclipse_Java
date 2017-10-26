package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class NumericalReader {

	public static String getStringFromKeyboard() throws Exception{
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please type something:");
		String s = br.readLine();
		return s;
	}
	
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader url_br = new BufferedReader(isr);
		return url_br;
	}
	
	void analysisStart(String datafile) throws IOException {
		FileWriter fw = new FileWriter(datafile);
		BufferedWriter bw = new BufferedWriter(fw);
		double minValue = 0;
		double maxValue = 0;
		double nValues = 0;
		double sumOfValues = 0;
		PrintWriter pw = new PrintWriter(bw);
		pw.format("The minimum value is: %d"+"The maximum value is: %d "+"The number of values is: %d"+"The sum of the values is: %d",minValue,maxValue,nValues,sumOfValues);
		pw.close();
	}

	public static void main(String[] args) {
		try {
			System.out.println(getStringFromKeyboard());
		} catch (Exception e) {
			System.out.println(e);
		}



	}

}
