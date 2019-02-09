package Introduction2;
abstract class A { //추상 클래스
	public abstract int b (); //b 메소드를 사용하기 위해서 오버로딩을 해야한다.
	//본체가 있는 메소드는 abstract 키워드를 가질 수 없다.
	//하나이상에 메소드가 추상 메소드인 경우에는 해당 클래스는 추상클래스가 된다.
	public abstract int c(){System.out.print("Hello");}
	//추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재 할 수 있다.
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
