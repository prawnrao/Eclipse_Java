package Exam16_17_2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class RecMain {
	
	public static void main(String[]args) {
		
		String genA_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt";
		String genB_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt";
		String genC_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt";
		String rec1_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt";
		String rec2_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt";
		String rec3_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt";
		String rec4_URL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt";
		String indexURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt";
		ArrayList<String> urlList = new ArrayList<>();
		urlList.add(genA_URL);urlList.add(genB_URL);urlList.add(genC_URL);
		urlList.add(rec1_URL);urlList.add(rec2_URL);urlList.add(rec3_URL);urlList.add(rec4_URL);

		try {
			//unpacking all the data into one HashMap of recording name to recording object
			HashMap<String,Recording> recMap = Recording.recMap(indexURL,urlList);
			
			//looping over all recordings in the HashMap
			for(String s :recMap.keySet()) {
				System.out.println(recMap.get(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
