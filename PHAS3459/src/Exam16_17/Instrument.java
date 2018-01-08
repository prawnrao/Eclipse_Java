package Exam16_17;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Instrument {
	String fileName;
	String instrumentName;

	public Instrument(String fileName, String instrumentName){
		this.fileName = fileName;
		this.instrumentName = instrumentName;
	}
	
	public static Instrument parseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		String fileName="";
		String instrumentName="";
		while (s.hasNext()) {
			fileName = s.next();
			instrumentName = s.next();
		}
		Instrument instrument = new Instrument(fileName, instrumentName);
		return instrument;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String toString() {
		String print = "\tFilename: "+fileName+" Instrument Name: "+instrumentName;
		return print;
	}
}