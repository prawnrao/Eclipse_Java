package Exam16_17;

import java.util.ArrayList;

public class ClassifyFreq implements ClassifySounds{

	public String classify(Info i) {

		String s = "";
		double s1 = Math.abs(spectralDensity(i,100));
		System.out.println(s1);
		double s2 = Math.abs(spectralDensity(i,400));
		System.out.println(s2);
		double s3 = Math.abs(spectralDensity(i,1000));
		System.out.println(s3);
		
		if(s1>s2 && s1>s3) {
			s = "low";
		}
		if(s2>s1 && s2>s3) {
			s = "medium";
		}
		if(s3>s1 && s3>s2) {
		 	s = "high";
		}

		return s;
	}

	/**
	 * Method that calculates the spectral density of a sound for a specific frequency
	 * @param info
	 * @param f
	 * @return
	 */
	private double spectralDensity(Info info, double f) {
		ArrayList<Double> samples = info.getAmp();
		int bigN = samples.size();
		double t = info.getN()/info.getFreq();

		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
			sumCos += samples.get(n)* Math.cos(z*n);
			sumSin += samples.get(n)* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
	}


}
