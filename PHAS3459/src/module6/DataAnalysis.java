package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	/**
	 * This method calculates the theory that best describes the data
	 * @param data
	 * @param theories
	 * @param gofCalculator
	 * @return
	 */
	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {

		//initialises the different collections used
		Collection<Theory> theories = new ArrayList<>();
		Collection<DataPoint> data = new ArrayList<>();


		try {
			//imports the data into the collection data
			data = TestDataPoint.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			
			
			//defines the theories that are being tested
			PowerLawTheory powerFit1 =new PowerLawTheory(2);
			PowerLawTheory powerFit2 = new PowerLawTheory(2.05);
			QuadraticTheory quadFit1 = new QuadraticTheory(1,10,0);

			//creates a collection of theory objects
			theories.add(powerFit1);
			theories.add(powerFit2);
			theories.add(quadFit1);

			//defines a goodnessOfFitCalculator of Chi squared
			GoodnessOfFitCalculator chi_sq = new ChiSquared();

			//finds the theory that best describes the data, using chi-sq
			Theory bestTheory = bestTheory(data,theories,chi_sq);


			System.out.println("Chi-sq for "+powerFit1 +" is: "+ chi_sq.goodnessOfFit(data,powerFit1));
			System.out.println("Chi-sq for "+powerFit2 +" is: "+ chi_sq.goodnessOfFit(data,powerFit2));
			System.out.println("Chi-sq for "+quadFit1 +" is: "+ chi_sq.goodnessOfFit(data,quadFit1));
			System.out.println("\nThe equation that best describes the data, according to chi-sq is: "+bestTheory);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
