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
			System.out.println("Expected Events between 120GeV and 140GeV for ZZ: "+Data.ExpEv(dataZZ, 120, 140));
			HashMap<String,ArrayList<Double>> higgsData = Data.higgsData(urlHiggs);
			ArrayList<Data> higgsEvent = Data.allDataList(dataGG, higgsData.get("GG"));
			System.out.println(higgsEvent);
			higgsEvent = Data.allDataList(dataGG, higgsData.get("ZZ"));
			System.out.println(higgsEvent);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
