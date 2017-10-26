package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class NumericalReader {

	public static String getStringFromKeyboard() throws Exception{
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Please type something:");
		String s = br.readLine();
		return s;
	}

	public static void main(String[] args) {
		try {
			System.out.println(getStringFromKeyboard());
		} catch (Exception e) {
			System.out.println(e);
		}



	}

}
