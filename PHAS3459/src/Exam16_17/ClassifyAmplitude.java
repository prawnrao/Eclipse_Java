package Exam16_17;

public class ClassifyAmplitude implements Classify{
	/**
	 * Member variable
	 */
	double thesh;
	
	/**
	 * Constructor
	 * @param thresh
	 */
	public ClassifyAmplitude(double thresh){
		this.thesh = thresh;
	}
	
	/**
	 * Classifies recording by amplitude, either loud or quiet
	 */
	@Override
	public String classify(Recording rec) {
		String s = "  Amplitude:";
		if(rec.amplitude > thesh) {
			s += "\tLoud";
		}
		else {
			s += "\tQuiet";
		}
		return s;
	}
	
}
