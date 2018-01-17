package Exam11_12;

import java.util.ArrayList;
import java.util.HashMap;

public class DiseaseMain {
	
	public static void main(String[] args) {
		String regionURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/regions.txt";
		String popURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/populations.txt";
		String XYZurl = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesXYZ.txt";
		String ABurl = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/final/occurrencesAB.txt";
		try {
			ArrayList<Disease> diseaseDataAB = Disease.diseaseList(ABurl);
			ArrayList<Disease> diseaseDataXYZ = Disease.diseaseList(XYZurl);
			ArrayList<Disease> allDiseaseData = Disease.allDiseaseList(diseaseDataXYZ,diseaseDataAB);
			ArrayList<Region> regionData = Region.regionData(regionURL);
			ArrayList<Population> popData = Population.popData(popURL);
			HashMap<String,Region> regionMap = Region.regionMap(regionData, allDiseaseData, popData);
			double totalPop = (Region.totalPop(regionMap));
			System.out.println("  Total population sample size:  "+totalPop);
			Disease perCapita = Region.diseasePerCap(regionMap); 
			System.out.println("  Per Capita Diseases:\n  "+perCapita);
			ArrayList<Region> regionPerCapita = Region.regionDiseasePerCapita(regionMap);
			System.out.println("  Region with highest per capita disease: "+regionPerCapita.get(0).name);
			System.out.println("  Region with lowest per capita disease: "+regionPerCapita.get(1).name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
