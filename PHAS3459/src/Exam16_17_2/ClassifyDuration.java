package Exam16_17_2;

public class ClassifyDuration implements Classify{
	double thresh;

	/**
	 * Constructor
	 * @param thresh
	 */
	public ClassifyDuration(double thresh) {
		this.thresh = thresh;
	}

	/**
	 * Classifies recording by duration, either long or short
	 */
	@Override
	public String classify(Recording rec) {
		String s ="  Duration:";
		if(rec.duration > thresh) {
			s += " long";
		}
		else {
			s += "  short";
		}
		return s;
	}
}
