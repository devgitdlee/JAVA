package Introduction2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class D{
	void run() throws FileNotFoundException, IOException {
		BufferedReader bReader = null;
		String input = null;
		bReader = new BufferedReader(new FileReader("out.txt"));
		input = bReader.readLine();
		System.out.println(input);
	}
}

class C{
	void run() throws FileNotFoundException, IOException {
		D b = new D();
		b.run();
	}
}
public class CheckedDemo2 {

	public static void main(String[] args) {
		C c = new C();
		try {
			c.run();
		} catch (FileNotFoundException e) {
			System.out.println("out.txt 파일이 필요합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
