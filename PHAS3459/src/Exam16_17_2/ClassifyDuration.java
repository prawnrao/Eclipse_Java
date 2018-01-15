package Exam16_17_2;

public class ClassifyDuration implements Classify{
	/**
	 * Member variable
	 */
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
		String s ="  Duration Classification:";
		if(rec.duration > thresh) {
			s += " Long";
		}
		else {
			s += "  Short";
		}
		return s;
	}
}
