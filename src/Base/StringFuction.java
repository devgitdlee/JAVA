package Base;


public class StringFuction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuc = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String ft = "���� �ٶ� �� �� ��";
		
		String ft1 = "A/B/C/D";
		
		//���� �ٿ��ִ� ���
		String t1 = fuc.concat("������");
		
		System.out.println(t1);
		
	    //�ٲܴܾ� 
		String t2 = fuc.replace('A', '��');
		
		System.out.println(t2);
		
		//���ڿ� �ڸ���
		String t3 = fuc.substring(0, 15);
		
		System.out.println(t3);
		
		//�ش� 'R'���� �ڸ��� ���ϱ�
		int t4 = fuc.indexOf("R");
		
		System.out.println(t4);
		
		//�μ� ���� ���ϱ�
		int t5 = fuc.length();
		
		System.out.println(t5);
		
		//�־��� ���ڷ� �и��Ͽ� �迭�� ����
		String[] t6 = ft.split(" ");
		
		for(int i = 0; i<t6.length; i++) {
			System.out.println(t6[i]);
		}
		
		//Ư������ �����
		String t7 = ft1.replaceAll("/", "");
		
		System.out.println(t7);
		
		//trim ��������
		
		
		//3��° �ڸ��� ���ϱ�
	    
		
		
		//
		
		
		
	}

}
