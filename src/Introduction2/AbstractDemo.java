package Introduction2;
abstract class A { //�߻� Ŭ����
	public abstract int b (); //b �޼ҵ带 ����ϱ� ���ؼ� �����ε��� �ؾ��Ѵ�.
	//��ü�� �ִ� �޼ҵ�� abstract Ű���带 ���� �� ����.
	//�ϳ��̻� �޼ҵ尡 �߻� �޼ҵ��� ��쿡�� �ش� Ŭ������ �߻�Ŭ������ �ȴ�.
	public abstract int c(){System.out.print("Hello");}
	//�߻� Ŭ���� ������ �߻� �޼ҵ尡 �ƴ� �޼ҵ尡 ���� �� �� �ִ�.
	public void d() {
		System.out.print("world");
	}
}
class B extends A{
	public int b() {
		return 1;
	}
}
public class AbstractDemo{

	public static void main(String[] args) {
		//A obj = new A();
		B obj = new B();
	}

}
