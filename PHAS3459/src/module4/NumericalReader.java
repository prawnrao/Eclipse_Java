package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NumericalReader {

	//Member variables of the class
	private double minValue, maxValue, sumOfValues;
	private int nValues;
	public PrintWriter pw;
	FileWriter fw;
	BufferedWriter bw;

	//Empty constructor
	public NumericalReader() {

	}

	//Defines the method that allows the user to input via the keyboard
	public static String getStringFromKeyboard()throws Exception{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please enter directory:");
		String s = br.readLine();
		return s;
	}

	//This method allows an input URL and converts its content to text stored in the buffer
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader url_br = new BufferedReader(isr);
		return url_br;//returns new buffered reader object
	}

	//Start analysis method, initialises the member variables
	void analysisStart(String datafile) throws IOException {
		minValue = Double.MAX_VALUE;//assigns the maximum value to ensure all numbers are smaller than the initial
		maxValue = Double.MIN_VALUE;//assigns the minimum value to ensure all the numbers are greater than the initial
		nValues = 0;
		sumOfValues = 0;
		File f = new File(datafile);
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
	}

	//This method analysis the data, and updates the values of the member variables
	void analyseData(String line) {
		if (line.isEmpty() || !Character.isDigit(line.charAt(0))) {//Checks if the line is empty, or the fist character is not a digit 
			return;//goes to the next line if the above condition is satisfied
		}
		Scanner s = new Scanner(line);
		while (s.hasNext()) {

			double x = Double.parseDouble(s.next());//resolves the sting into a double
			//Checks the current token against the minimum value
			if(x<minValue) { 
				minValue = x;
			}
			//Checks the current token against the maximum value
			if(x>maxValue) {
				maxValue = x;
			}

			nValues++; //increments the number of values
			sumOfValues += x; //adds to the running total
			pw.println(x);//prints to the file
			System.out.println(x);//prints to screen
		}
		s.close();//closes the scanner
	}

	void analysisEnd() {
		//prints the max, min, number of values and sum of values to the screen
		System.out.println("Minimum value is: "+minValue);
		System.out.println("Maximum value is: "+maxValue);
		System.out.println("Total number of values read: "+nValues);
		System.out.println("Average value is: "+sumOfValues/nValues+"\n");
		pw.close();//closes the print writer
	}


	public static void main(String[] args) {

		try {
			String saveFile = "";
			String saveDir = NumericalReader.getStringFromKeyboard();//takes the user input
			if (saveDir == null) {
				saveFile = System.getProperty("user.Home");//default directory
			}

			//FILE #1
			saveFile = (saveDir + File.separator + "numbers1.txt");//adds the file name onto the directory inputted by the user
			NumericalReader nr = new NumericalReader();

			BufferedReader br = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = "";

			nr.analysisStart(saveFile); // initialize minValue etc.

			while ((line = br.readLine()) != null) {
				nr.analyseData(line); // analyze lines, check for comments etc.
			}
			nr.analysisEnd(); // print min, max, etc.


			//FILE #2
			saveFile = (saveDir + File.separator + "numbers2.txt");//adds the file name onto the directory inputted by the user
			NumericalReader nr2 = new NumericalReader();

			BufferedReader br2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			line = "";

			nr2.analysisStart(saveFile); // initialise minValue, maxValue, sum and counter

			while ((line = br2.readLine()) != null) {
				nr2.analyseData(line); // analyse lines, check for comments etc.
			}
			nr2.analysisEnd(); //ends the analysis

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
