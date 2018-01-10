package Exam16_17;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Recording {
	String fileName;
	String RecordingName;

	public Recording(String fileName, String RecordingName){
		this.fileName = fileName;
		this.RecordingName = RecordingName;
	}

	public static Recording parseData(String line) throws IOException {
		Scanner s = new Scanner(line);
		String fileName="";
		String RecordingName="";
		while (s.hasNext()) {
			fileName = s.next();
			RecordingName = s.next();
		}
		Recording Recording = new Recording(fileName, RecordingName);
		return Recording;
	}

	public String getFileName() {
		return fileName;
	}

	public String getInstrumentName() {
		return RecordingName;
	}


	public String toString() {
		String print = "\tFilename: "+fileName+"\tRecording Name: "+RecordingName;
		return print;
	}
	
}
