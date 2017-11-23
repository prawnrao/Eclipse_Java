package module6;

import java.util.ArrayList;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {
	
//	public ChiSquared(){
//		
//	}
	
	public double goodnessOfFit(Collection<DataPoint> datapoints,Theory theory) {
		double xpoint,ypoint, eypoint, residual, chi_sq = 0;
		
		ArrayList<DataPoint> arrayData = new ArrayList<>();
		arrayData.addAll(datapoints);
		
		for(int i=0; i < arrayData.size();i++){//Loops till counter is equal to number of datapoints
			residual = 0;
			
			DataPoint point = arrayData.get(i);

			//Extracts x, y and ey from the datapoint

			xpoint = point.getX();
			ypoint = point.getY();
			eypoint = point.getEY();

			//calculates the theoretical value for y
			double y_theory = theory.y(xpoint);		
			//calculates the residual for a specific coordinate

			residual = (Math.pow((ypoint - y_theory),2))/(Math.pow(eypoint, 2));

			chi_sq += residual;//add the residual to the running sum of chi-square
		}
		return chi_sq;//returns chi-square
	}

}