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
		
		//ArrayList al = new ArrayList(); //��� Ÿ�� �����͸� ������
		ArrayList<String> al = new ArrayList<String>(); //String Ÿ�� �����͸� �����
		al.add("one");
		al.add("two");
		al.add("three");
		for(int i=0; i<al.size(); i++) {
			//String value = (String) al.get(i); //����ȯ�� ��������� ����
			String value = al.get(i); //����ȯ�� ��������� ����
			System.out.println(value);
		}
		
		
	}

}
