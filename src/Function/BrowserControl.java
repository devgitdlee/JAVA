package Function;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.util.Scanner;



public class BrowserControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("C:\\test\\Instar.txt");
			FileReader fileReader =  new FileReader(file);
			BufferedReader bufreader = new BufferedReader(fileReader);
			String line = "";
			while((line = bufreader.readLine()) != null) {
				Browser(line);
			}
			//bufreader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Browser (String url) {
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("explorer.exe "+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
