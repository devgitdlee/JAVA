package Introduction;


class A{
	public String x() {return "A.x";}
	//public String y() {return "A.y";}
}
class B extends A { //Ŭ���� B�� Ŭ���� A�� ��ӹް� �ִ�.
	public String x() {return "B.x";} // AŬ������ �޼ҵ� x�� �������̵� ��
	public String y() {return "B.y";}
} 
public class PolymorphismDemo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new B (); //AŬ���� ��ü�� �����ߴٰ� ������ 
		//�θ�Ŭ���� �������̵� ���� ��� �ڽ�Ŭ���� �޼ҵ带 ����� �� ����
		System.out.println(obj.x()); //BŬ���� �޼ҵ带 ����� 
		//System.out.println(obj.y());
	}

}
