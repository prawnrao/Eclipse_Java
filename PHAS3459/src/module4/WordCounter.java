package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	//This method allows an input URL and converts its content to text stored in the buffer
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);//defines a new URL
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader url_br = new BufferedReader(isr);
		return url_br;//returns a new buffered reader object 
	}
	
	//This method allows an input file and converts its context to text stored in the buffer
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader file_br = new BufferedReader(fr);
		return file_br;//returns a new buffered reader object
	}
	
	//This method scans the buffered reader for 'words' (tokens) and counts how many there are
	public static int countWordsInResource(BufferedReader br) {
		Scanner s = new Scanner(br);
		int i = 0;//initialises the counter
		
		//loops while the condition of having a token is satisfied
		while (s.hasNext()) {
			s.next();
			i += 1;//increments the counter
		}
		return i;//returns the number of words
	}

	//The main method, which takes a url, and counts the number of words contained.
	public static void main(String[] args){
		String url1 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt";
		
		BufferedReader br = null; //initialises the buffered reader
		
		//counts the number of words in the text file
		try {
			br = brFromURL(url1);
			int words = 0;
			words = countWordsInResource(br);
			System.out.println("Number of words in the webpage is: "+words);
		} 
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
