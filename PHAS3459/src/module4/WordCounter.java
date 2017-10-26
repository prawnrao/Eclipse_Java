package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	//This method allows an input URL and converts its content to text stored in the buffer
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader url_br = new BufferedReader(isr);
		return url_br;
	}
	
	//This method allows an input file and converts its context to text stored in the buffer
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader file_br = new BufferedReader(fr);
		return file_br;
	}
	
	//This method scans the buffered reader for 'words' (string of characters between whitespace) and counts how many there are
	public static int countWordsInResource(BufferedReader br) {
		Scanner s = new Scanner(br);
		int i = 0;
		while (s.hasNext()) {
			s.next();
			i += 1;
		}
		return i;
	}


	public static void main(String[] args){
		String url1 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt";
		String file1 = "N:\\Documents\\M4_test.txt";
		BufferedReader br = null; //initialises the buffered reader
		
		//tries to count the number of words in the text file
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
