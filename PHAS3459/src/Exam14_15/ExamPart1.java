package Exam14_15;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart1 {
	
	public static void main(String[]args) {
		String urlSites = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";
		try {
			ArrayList<Sites> sitesList = new ArrayList<>();
			sitesList = Sites.parseData(urlSites);
			System.out.println(sitesList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
