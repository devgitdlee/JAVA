package Introduction;

import java.util.ArrayList;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
		for(int i=0; i<arrayObj.length; i++) {
			System.out.println(arrayObj[i]);
		}
		
		//ArrayList al = new ArrayList(); //어떠한 타입 데이터를 수용함
		ArrayList<String> al = new ArrayList<String>(); //String 타입 데이터를 명시함
		al.add("one");
		al.add("two");
		al.add("three");
		for(int i=0; i<al.size(); i++) {
			//String value = (String) al.get(i); //형변환에 제약사항이 있음
			String value = al.get(i); //형변환에 제약사항이 있음
			System.out.println(value);
		}
		
		
	}

}
