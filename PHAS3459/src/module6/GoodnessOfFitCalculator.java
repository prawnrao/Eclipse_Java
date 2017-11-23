package module6;

import java.util.Collection;

public interface GoodnessOfFitCalculator {
	//defines the goodness of fit interface
	public double goodnessOfFit(Collection<DataPoint> datapoints,Theory theory);
	
}
