package module6;

import java.util.ArrayList;


public class ChiSquared implements GoodnessOfFitCalculator {
	
	public static double goodnessOfFit(Theory theory, ArrayList<DataPoint> datapoints) {
		double xpoint,ypoint, eypoint, residual, chi_sq = 0;
		for(int i=0; i < datapoints.size();i++){//Loops till counter is equal to number of datapoints
			residual = 0;
			DataPoint point = datapoints.get(i);
			//Extracts x, y and ey from the datapoint
			xpoint = point.getX();
			ypoint = point.getY();
			eypoint = point.getEY();
			//calculates the theoretical value for y
			double y_theory = Theory.y(xpoint);		
			//calculates the residual for a specific coordinate
			residual = (Math.pow((ypoint - y_theory),2))/(Math.pow(eypoint, 2));
			chi_sq += residual;//add the residual to the running sum of chi-square
		}
		return chi_sq;//returns chi-square
	}
	
}