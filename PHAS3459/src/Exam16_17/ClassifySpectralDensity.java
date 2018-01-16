package Exam16_17;

public class ClassifySpectralDensity implements Classify{
	/**
	 * Member Variables
	 */
	private double low;
	private double med;
	private double high;
	
	/**
	 * Constructor
	 * @param low
	 * @param med
	 * @param high
	 */
	public ClassifySpectralDensity(double low, double med, double high) {
		this.low = low;
		this.med = med;
		this.high = high;
	}

	/**
	 *  Classifies recording by spectral density, either low, medium or high
	 */
	@Override
	public String classify(Recording rec) {
		String s = "  Spectral Den:";
		//calculates the spectral densities for each of the frequencies 
		double sd1 = spectralDensity(rec,low);
		double sd2 = spectralDensity(rec,med);
		double sd3 = spectralDensity(rec,high);
		
		//checks which of the three spectral densities is the largest
		if(sd1>sd2 && sd1>sd3) {
			s += "\tLow\n";
		} 
		else if(sd2>sd1 && sd2>sd3) {
			s += "\tMedium\n";
		}
		else if(sd3>sd1 && sd3>sd1) {
			s += "\tHigh\n";
		}
		return s;//returns the classification string
	}

	/**
	 * Method to calculate the spectral density
	 * @param rec
	 * @param freq
	 * @return	double spectral density
	 */
	private double spectralDensity(Recording rec, double freq) {
		double z = 2 * Math.PI * freq * rec.duration / rec.N;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < rec.N; ++n) {
			sumCos += rec.ampList.get(n)* Math.cos(z*n);
			sumSin += rec.ampList.get(n)* Math.sin(z*n);
		}
		double norm = rec.duration / (rec.N*rec.N);
		return norm * (sumCos*sumCos + sumSin*sumSin);
	}

}
