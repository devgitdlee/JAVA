package Introduction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>(); //�ߺ� ������ ���� ����
		A.add(1);
		A.add(2);
		System.out.println("�����Է����ּ���.");
		Scanner sc = new Scanner(System.in);
		//int i = sc.nextInt();
		A.add(sc.nextInt());
		A.add(4);
		
		
		HashSet<Integer> B = new HashSet<Integer>();
		B.add(3);
		B.add(4);
		B.add(5);
		
		HashSet<Integer> C = new HashSet<Integer>();
		C.add(1);
		C.add(2);
		
		
		Iterator hi = (Iterator) A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		hi = (Iterator) B.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		hi = (Iterator) C.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		
		
		
	}

}
