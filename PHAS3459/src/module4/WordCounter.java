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

	public static int countWordsInResource(String url1) {
			Scanner s = new Scanner(url1);
			int i = 0;
			while (s.hasNext()) {
				String token = s.next();
				try {
					i += 1;
				} catch (NumberFormatException e) {
					// Ignore anything that is not a number!
				}
			}
		return i;
	}



}
