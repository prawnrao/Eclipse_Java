package Exam12_13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HiggsMain {

	public static void main(String[] args) {
		String urlGG = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundGG.txt";
		String urlZZ = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundZZ.txt";
		String urlHiggs = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/higgsData.txt";
		try {
			
			ArrayList<Data> dataGG = Data.dataList(urlGG);
			ArrayList<Data> dataZZ = Data.dataList(urlZZ);
			System.out.println("Expected Events between 120GeV and 140GeV for GG: "+Data.ExpEv(dataGG, 120, 140));
			System.out.println("Expected Events between 120GeV and 140GeV for ZZ: "+Data.ExpEv(dataZZ, 120, 140)+"\n");
			HashMap<String,ArrayList<Double>> higgsData = Data.higgsData(urlHiggs);
			
			ArrayList<Data> higgsEventGG = Data.allDataList(dataGG, higgsData.get("GG"));
			System.out.println(higgsEventGG);
			System.out.println("\nObserved Events between 120GeV and 140GeV for GG: "+Data.obEv(higgsEventGG, 120, 140));
			System.out.println("Log Likelyhood: "+Data.logLikelyhood(higgsEventGG));
			ArrayList<Data> higgsEventZZ = Data.allDataList(dataZZ, higgsData.get("ZZ"));
			System.out.println("Observed Events between 120GeV and 140GeV for ZZ: "+Data.obEv(higgsEventZZ, 120, 140));
			System.out.println("Log Likelyhood: "+Data.logLikelyhood(higgsEventZZ));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
