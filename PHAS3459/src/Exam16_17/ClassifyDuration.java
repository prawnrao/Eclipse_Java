package Exam16_17;

public class ClassifyDuration implements ClassifySounds{

	public String classify(Info i) {

		double t = Info.duration(i);
		String s = "";

		if(t<1) {
			s = "short";
		}
		else {
			s ="long";
		}
		return s;
	}

}
