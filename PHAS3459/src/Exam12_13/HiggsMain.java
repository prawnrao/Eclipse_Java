package Exam12_13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HiggsMain {

	public static void main(String[]args) {
		String urlGG = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundGG.txt";
		String urlZZ = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundZZ.txt";
		ArrayList<String> urlList = new ArrayList<>();
		urlList.add(urlGG); urlList.add(urlZZ);

		String urlHiggs = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/higgsData.txt";
		ArrayList<Higgs> higgsData = new ArrayList<>();
		HashMap<String,ArrayList<Background>> bgMap = new HashMap<>();
		HashMap<String,HashMap<Integer,ArrayList<Integer>>> binMap = new HashMap<>();
		

		try {
			higgsData = Higgs.higgsData(urlHiggs);
			bgMap = Background.bgMap(higgsData,urlList);
			binMap = Higgs.binData(bgMap, higgsData);
			
			for(String s:binMap.keySet()) {
				System.out.println("\n\n"+s+"\n");
				for(int i:binMap.get(s).keySet()) {
					System.out.println(i+"\t"+binMap.get(s).get(i).size());
				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
