package Exam13_14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlantsMain {
	public static void main(String[]args) {

		ArrayList<Species> spPlant = new ArrayList<>();
		ArrayList<Species> spAnimal = new ArrayList<>();
		ArrayList<Survey> surPlant;
		ArrayList<Survey> surAnimal;
		ArrayList<ArrayList<Double>> surListPlant;
		HashMap<String, ArrayList<ArrayList<Double>>> surMapPlant;
		HashMap<String, ArrayList<ArrayList<Double>>> surMapAnimal;
		String urlSpPlant = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";
		String urlSurPlant = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
		String urlSpAnimal = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt";
		String urlSurAnimal = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt";
		try {
			String name ="";
			double maxMeanH = -Double.MAX_VALUE;
			double minMeanH = Double.MAX_VALUE;
			String maxName ="";
			String minName = "";

			spPlant = Species.spData(urlSpPlant);//ArrayList of species objects
			spAnimal = Species.spData(urlSpAnimal);//ArrayList of species objects
			System.out.println(spPlant);
			System.out.println(spAnimal);

			surPlant = Survey.surveyDataPlant(urlSurPlant);//ArrayList of survey objects
			surAnimal = Survey.surveyDataAnimal(urlSurAnimal);//ArrayList of survey objects

			surMapPlant = Survey.surveyMapPlant(surPlant);//HashMap of string to AR<AR<Double>>
			surMapAnimal = Survey.surveyMapAnimal(surAnimal);//HashMap of string to AR<AR<Double>>

			for(String s:surMapPlant.keySet()) {
				name = Species.getName(s,spPlant);
				surListPlant = surMapPlant.get(s);
				int size = surListPlant.size();
				double meanH = Survey.meanH(surListPlant);

				if(meanH>maxMeanH) {
					maxMeanH = meanH;
					maxName = name;
				}
				if(meanH<minMeanH) {
					minMeanH = meanH;
					minName = name;
				}

				System.out.println("\n\tID:\t"+s);
				System.out.println("\tName:\t"+name +"\n\tNo of Species:\t"+size+"\n\tMean H:\t"+meanH+" cm");
			}

			System.out.println("\n\n\tSpecies with the maximum mean height was: "+maxName+
					"\n\tWith a mean height of:\t"+maxMeanH+" cm");
			System.out.println("\n\tSpecies with the minimum mean height was: "+minName+
					"\n\tWith a mean height of:\t"+minMeanH+" cm");

			String id = Species.getID("Urtica dioica", spPlant);

			ArrayList<ArrayList<Double>> filtSurList = new ArrayList<>();
			ArrayList<ArrayList<Double>> surList1 = new ArrayList<>();
			surList1 = surMapPlant.get(id);

			FilterSpecies fr = new FilterByRegion(-30.0,90.0);
			filtSurList = fr.filerSp(surList1);
			double meanH = Survey.meanH(filtSurList);
			System.out.println("\n\n\tMean height of Urtica dioica ("+id+") found north of -30 degrees was: "+meanH+" m");
			FilterSpecies fr1 = new FilterByRegion(-90,-30);
			filtSurList = fr1.filerSp(surList1);
			meanH = Survey.meanH(filtSurList);
			System.out.println("\n\tMean height of Urtica dioica ("+id+") found south of -30 degrees was: "+meanH+" m");

			ArrayList<ArrayList<Double>> surList2 = new ArrayList<>();
			id = Species.getID("Solanum carolinense", spPlant);
			surList2 = surMapPlant.get(id);

			FilterSpecies fd = new FilterByDist(-30.967,75.430,50);
			filtSurList = fd.filerSp(surList1);
			meanH = Survey.meanH(filtSurList);
			System.out.println("\n\tMean height of Solanum carolinense ("+id+") found 50 km from (-30.967,75.430) was: "+meanH+" m");


			ArrayList<ArrayList<Double>> surList3 = new ArrayList<>();
			surList3 = Survey.surveyArrayAnimal(surAnimal);

			ArrayList<ArrayList<Double>> filtSurList1 = new ArrayList<>();
			ArrayList<ArrayList<Double>> findKeyList = new ArrayList<>();
			ArrayList<String> nameList = new ArrayList<>();

			FilterSpecies fd1 = new FilterByDist(-30.967,75.430,155);
			filtSurList1 = fd1.filerSp(surList3);


			for(String s: surMapAnimal.keySet()) {
				name = Species.getName(s, spAnimal);
//				System.out.println(name);
				findKeyList = surMapAnimal.get(s);
//				System.out.println(findKeyList);
				for(ArrayList<Double> ar: filtSurList1) {
					for(double d :ar) {
						if(findKeyList.contains(d)) {
							nameList.add(name);
						}
					}
				}
			}
			System.out.println(nameList);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}