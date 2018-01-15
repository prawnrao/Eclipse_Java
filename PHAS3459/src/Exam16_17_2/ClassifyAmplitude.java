package Exam16_17_2;

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
		String s = "  Amplitude Classification:";
		if(rec.amplitude > thesh) {
			s += " Loud";
		}
		else {
			s += " Quiet";
		}
		return s;
	}
	
}
