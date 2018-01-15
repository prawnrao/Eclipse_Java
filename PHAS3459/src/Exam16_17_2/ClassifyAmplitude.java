package Exam16_17_2;

public class ClassifyAmplitude implements Classify{
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
			s += " loud";
		}
		else {
			s += " quiet";
		}
		return s;
	}
	
}
