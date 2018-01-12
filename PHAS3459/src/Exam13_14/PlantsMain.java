package Exam13_14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlantsMain {
	public static void main(String[]args) {
		
		ArrayList<Species> ar_sp = new ArrayList<>();
		ArrayList<Survey> sur;
		ArrayList<ArrayList<Double>> surList;
		HashMap<String, ArrayList<ArrayList<Double>>> surMap;
		String urlSpPlant = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";
		String urlSurPlant = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
		
		try {
			String name ="";
			double maxMeanH = -Double.MAX_VALUE;
			double minMeanH = Double.MAX_VALUE;
			String maxName ="";
			String minName = "";
			
			ar_sp = Species.spData(urlSpPlant);
			System.out.println(ar_sp);
			sur = Survey.surveyData(urlSurPlant);
			surMap = Survey.surveyMap(sur);

			for(String s:surMap.keySet()) {
				for(Species sp :ar_sp) {
					if(s.equals(sp.getID())) {
						name = sp.getName();
						break;
					}
				}
				surList = surMap.get(s);
				int size = surList.size();
				double sumH = 0;
				for(ArrayList<Double> singleSurList : surList) {
					sumH += Survey.getH(singleSurList);
				}
				double meanH = sumH/size;
				
				
				if(meanH>maxMeanH) {
					maxMeanH = meanH;
					maxName = name;
				}
				if(meanH<minMeanH) {
					minMeanH = meanH;
					minName = name;
				}
				
				System.out.println("\n\n\tID:\t"+s);
				System.out.println("\tName:\t"+name +"\n\tNo of Species:\t"+size+"\n\tMean H:\t"+meanH+" cm");
			}
			System.out.println("\n\n\tSpecies with the maximum mean height was: "+maxName+
					"\n\tWith a mean height of:\t"+maxMeanH+" cm");
			System.out.println("\n\tSpecies with the minimum mean height was: "+minName+
					"\n\tWith a mean height of:\t"+minMeanH+" cm");
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}