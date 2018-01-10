package Exam16_17;

public class ClassifyVolume implements ClassifySounds{

	public String classify(Info i) {
		
		double v = Info.amplitude(i);
		String s = "";
		if (v>-20) {
			s = "loud";
		}
		else {
			s = "quiet";
		}
		return s;
	}

}
