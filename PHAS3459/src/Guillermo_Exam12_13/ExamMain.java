package Guillermo_Exam12_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class ExamMain {

	public static BufferedReader dataFromURL (String URLname) throws IOException, MalformedURLException{

		URL url = new URL(URLname);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

	public static ArrayList<Double> parseLine(String line) {
		ArrayList<Double> eventData = new ArrayList<>(3);
		Scanner sc = new Scanner(line);
		double minE= sc.nextInt();
		double maxE = sc.nextInt();
		double expEvent = sc.nextDouble();
		eventData.add(minE);
		eventData.add(expEvent);
		eventData.add(0.0);
		sc.close();
		return eventData;	
	}

	public static ArrayList<ArrayList<Double>> dataStore(BufferedReader br) throws Exception{

		ArrayList<ArrayList<Double>> allData = new ArrayList<>();
		String line = "";
		br.readLine();
		while ((line = br.readLine()) != null) {
			try {
				allData.add(parseLine(line));				
			} catch (Exception e ) {
				System.out.println("Error: "+e.getMessage());
				System.out.println("Skipping line: "+line);
			}
		}

		br.close();
		return allData;
	}

	public static double numEvents(ArrayList<ArrayList<Double>> bindata, int min, int max, String token) {
		double events = 0;
		for (ArrayList<Double> bin: bindata) {
			if ((bin.get(0) >= min) && (bin.get(0) < max)) {
				if (token.matches("background")) {
					events += bin.get(1);
				}
				else {
					events += bin.get(2);
				}
			}
		}
		return events;
	}

	public static HashMap<String, ArrayList<Double>> dataHiggs(BufferedReader br) throws Exception{

		HashMap<String, ArrayList<Double>> higgsinfo = new HashMap<>();
		ArrayList<Double> GG = new ArrayList<>();
		ArrayList<Double> ZZ = new ArrayList<>();
		String line = "";
		br.readLine();
		while ((line = br.readLine()) != null) {
			Scanner sc = new Scanner(line);
			String channel = sc.next();
			if (channel.matches("GG")) {
				GG.add(sc.nextDouble());								
			}
			else {
				ZZ.add(sc.nextDouble());		
			}
		}
		higgsinfo.put("GG", GG);
		higgsinfo.put("ZZ", ZZ);
		return higgsinfo;
	}

	public static void higgsEvents(ArrayList<Double> higgsData, ArrayList<ArrayList<Double>> background){
		ArrayList<ArrayList<Double>> finalBack = background;
		for (Double energy: higgsData) {
			double energyRound = Math.floor(energy);
			for (ArrayList<Double> backgroundpoint: finalBack) {
				if (energyRound == backgroundpoint.get(0)) {
					backgroundpoint.set(2, backgroundpoint.get(2)+1);
					break;
				}
			}
		}

	}

	public static double likeliHood(ArrayList<ArrayList<Double>> binData) {
		double sum = 0;
		for (ArrayList<Double> datapoint: binData) {
			double candidate = datapoint.get(2);
			if (candidate != 0) {
				double background = datapoint.get(1);
				sum += (background-candidate)+(candidate*(Math.log((candidate)/(background))));
			}
		}
		return sum;
	}

	public static HashMap<Double, ArrayList<ArrayList<Double>>> masssort(double N, double width){
		HashMap<Double, ArrayList<ArrayList<Double>>> finaldata = new HashMap<>();
		ArrayList<Double> massvals = new ArrayList<>();

		for (double i = 110.5; i < 180; i += 1) {
			massvals.add(i);
		}

		for (Double mass: massvals) {
			Predictor Gaussian = new GaussianHiggs(N, mass, width);
			finaldata.put(mass, Gaussian.predictions());
		}
		return finaldata;
	}

	public static 	HashMap<Double, Double> loglikelihood(ArrayList<ArrayList<Double>> bindata,
			HashMap<Double, ArrayList<ArrayList<Double>>> signalmass) {

		HashMap<Double, Double> loglikelihoodsorted = new HashMap<>();

		for (Map.Entry<Double, ArrayList<ArrayList<Double>>> entry: signalmass.entrySet()) {
			ArrayList<ArrayList<Double>> eventsbinned = entry.getValue();
			double LL = 0;
			for (int i=0; i< eventsbinned.size(); i++) {
				double predictevents = eventsbinned.get(i).get(1);
				double backgroundevents = bindata.get(i).get(1);
				double totEvents = predictevents + backgroundevents;
				double candidate = bindata.get(i).get(2);
				double addition = (totEvents-candidate)+(candidate*(Math.log((candidate)/(totEvents))));
				if (!Double.isNaN(addition)) {
					LL += addition;					
				}
			}
			loglikelihoodsorted.put(entry.getKey(), LL);
		}
		return loglikelihoodsorted;
	}

	public static double minLikelihood(HashMap<Double, Double> loglikelihood1, HashMap<Double, Double> loglikelihood2) {
		Boolean first = true;
		double min = 0;
		double higgsmassoutput = 0;
		for (Double higgsmass: loglikelihood1.keySet()) {
			double LLsum = loglikelihood1.get(higgsmass)+loglikelihood2.get(higgsmass);
			if (first) {
				min = LLsum;
				first = false;
				higgsmassoutput = higgsmass;
			}
			else if (LLsum < min){
				min = LLsum;
				higgsmassoutput = higgsmass;
			}
		}
		return higgsmassoutput;
	}

	public static double sigmaCalc(double LLsumval, double explikelihoodG, double explikelihoodZ) {
		return Math.sqrt((-2)*(LLsumval - (explikelihoodG + explikelihoodZ)));		
	}

	public static void main(String[] args) {

		try {
			System.out.println("\n\n                  PART 1 \n-------------------------------"
					+ "----------------");

			BufferedReader bfZ = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt");
			BufferedReader bfG = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt");
			BufferedReader bfH = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt");
			ArrayList<ArrayList<Double>> binDataZ = dataStore(bfZ);
			ArrayList<ArrayList<Double>> binDataG = dataStore(bfG);			

			System.out.println("Number of expected events in energy range 120-140 meV for ZZ: "+
					numEvents(binDataZ, 120, 140,"background"));
			System.out.println("Number of expected events in energy range 120-140 meV for GG: "+
					numEvents(binDataG, 120, 140,"background"));

			HashMap<String, ArrayList<Double>> higgsinfo = dataHiggs(bfH);
			ArrayList<Double> GGData = higgsinfo.get("GG");
			ArrayList<Double> ZZData = higgsinfo.get("ZZ");
			higgsEvents(GGData, binDataG);
			higgsEvents(ZZData, binDataZ);

			System.out.println("\nGG detector... \n");
			for (ArrayList<Double> datapoint: binDataG) {
				System.out.println("For range "+datapoint.get(0)+"-"+(datapoint.get(0)+1)+" Higgs events are "+datapoint.get(2));				
			}
			System.out.println("\nZZ detector... \n");
			for (ArrayList<Double> datapoint: binDataZ) {
				System.out.println("For range "+datapoint.get(0)+"-"+(datapoint.get(0)+1)+" Higgs events are "+datapoint.get(2));				
			}

			System.out.println("\nNumber of candidate events in energy range 120-240 meV for ZZ: "+
					numEvents(binDataZ, 120, 240,"candidate"));
			System.out.println("Number of candidate events in energy range 120-240 meV for GG: "+
					numEvents(binDataG, 120, 240,"candidate"));

			double explikelihoodG = likeliHood(binDataG);
			double explikelihoodZ = likeliHood(binDataZ);

			System.out.println("\nLog-Likelihood for GG detector: "+explikelihoodG);
			System.out.println("Log-Likelihood for ZZ detector: "+explikelihoodZ);

			System.out.println("\n\n                  PART 2 \n-------------------------------"
					+ "----------------");

			HashMap<Double, ArrayList<ArrayList<Double>>> masssortedgg = masssort(100,2);
			HashMap<Double, ArrayList<ArrayList<Double>>> masssortedZZ = masssort(6,1);

			System.out.println("\n\n                  PART 3 \n-------------------------------"
					+ "----------------");

			HashMap<Double, Double> loglikelihoodgg = loglikelihood(binDataG, masssortedgg); 
			HashMap<Double, Double> loglikelihoodZZ = loglikelihood(binDataZ, masssortedZZ); 
			double Higgsvalmin = minLikelihood(loglikelihoodgg, loglikelihoodZZ);
			double LLsumval = loglikelihoodgg.get(Higgsvalmin) + loglikelihoodZZ.get(Higgsvalmin);

			System.out.println("\nHiggs mass with lowest sum of LL across both channels is "+
					Higgsvalmin+ " GeV with a sum of LL of: "+LLsumval);

			double sigma = sigmaCalc(LLsumval, explikelihoodG, explikelihoodZ);
			
			if (sigma>5) {
				System.out.println("\n Discovered new particle of mass: "+Higgsvalmin+" GeV"+ " as "+sigma+ 
						" > 5 standard deviations");
			}
			else {
				System.out.println("\n Did not discover new particle of mass: "+Higgsvalmin+" GeV"+ " as "+sigma+ 
						" < 5 standard deviations");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
