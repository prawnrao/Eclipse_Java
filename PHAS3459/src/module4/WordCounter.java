package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL url = new URL(urlName);
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader url_br = new BufferedReader(isr);
		//		String line; 
		//		while ((line=url_br.readLine()) != null) {
		//			System.out.println(line);
		//		} 
		return url_br;
	}

	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader file_br = new BufferedReader(fr);
		String line; 
		while ((line=file_br.readLine()) != null) {
			System.out.println(line);
		} 
		return file_br;

	}

	public static int countWordsInResource(BufferedReader url1) {
		Scanner s = new Scanner(url1);
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
//		try {
//			brFromURL(url1);
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			brFromFile(file1);
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
		int words = 0;
		try {
			words = countWordsInResource(brFromURL(url1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n"+words);
		
	

	}
}
