package Introduction;

class calcultor{
	int left, right;
	//������ Ŭ���� ������ �� ��� �޼ҵ庸�� ���� ����� construtor �ʱ�ȭ �۾��� ������
	public calcultor(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void sum() {
		System.out.println(this.left + this.right);
	}
	public void avg() {
		System.out.println((this.left + this.right) / 2);
	}

}
public class CalculatorDemo5 {

	public static void main(String[] args) {
		
		calcultor c1 = new calcultor(10,20);
		c1.sum();
		c1.avg();
	
		
		calcultor c2 = new calcultor(30,40);
		c2.sum();
		c2.avg();
		
	
		
	}

}
