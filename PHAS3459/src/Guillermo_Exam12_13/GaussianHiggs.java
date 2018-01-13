package Guillermo_Exam12_13;

import java.util.ArrayList;

public class GaussianHiggs implements Predictor{
	
	double N;
	double massH;
	double width;
	
	public GaussianHiggs(double N, double massH, double width) {
		this.N = N;
		this.massH = massH;
		this.width = width;
	}

	public ArrayList<ArrayList<Double>> predictions() {
		ArrayList<ArrayList<Double>> allData = new ArrayList<>();
		ArrayList<Double> energies = new ArrayList<>();
		for (int i = 100; i < 200; i++) {
			energies.add((double) i);
		}

		for (Double energy: energies) {
			ArrayList<Double> indData = new ArrayList<>();
			double fEl = ((N)/(width*Math.sqrt(2*Math.PI)))*Math.exp(-(Math.pow(energy - massH, 2))/(2*Math.pow(width, 2)));
			double fEh = ((N)/(width*Math.sqrt(2*Math.PI)))*Math.exp(-(Math.pow((energy+1) - massH, 2))/(2*Math.pow(width, 2)));
			double num = (0.5)*((fEh)+(fEl))*((energy+1)-(energy));
			indData.add(energy);
			indData.add(num);
			allData.add(indData);
		}

		return allData;
	}
}
