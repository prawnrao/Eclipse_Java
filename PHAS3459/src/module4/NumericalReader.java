package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class NumericalReader {

	double minValue, maxValue, sumOfValues;
	int nValues;
	PrintWriter pw;
	public NumericalReader() {

	}

	public static String getStringFromKeyboard() throws IOException{

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please type the directory where the data should be stored:");
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
		minValue = Double.MIN_VALUE;
		maxValue = Double.MAX_VALUE;
		nValues = 0;
		sumOfValues = 0;
		File f = new File(datafile);
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		pw.format("The minimum value is: %d"+"The maximum value is: %d "+"The number of values is: %d"+"The sum of the values is: %d",minValue,maxValue,nValues,sumOfValues);
		pw.close();
	}


	void analyseData(String line) {
		if (line.isEmpty() || !Character.isDigit(line.charAt(0))) {
			return;
		}
		Scanner s = new Scanner(line);
		
	}

	public static void main(String[] args) {
		try {
			String directory = getStringFromKeyboard();
			System.out.println(directory);
		} catch (IOException e) {
			System.out.println(e);
		}

		//		try {
		//			analysisStart()
		//		}



	}

}
