package Introduction;


class A{
	public String x() {return "A.x";}
	//public String y() {return "A.y";}
}
class B extends A { //클래스 B가 클래스 A를 상속받고 있다.
	public String x() {return "B.x";} // A클래스의 메소드 x를 오버라이딩 함
	public String y() {return "B.y";}
} 
public class PolymorphismDemo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new B (); //A클래스 객체를 생성했다고 생각함 
		//부모클래스 오버라이딩 했을 경우 자식클래스 메소드를 사용할 수 있음
		System.out.println(obj.x()); //B클래스 메소드를 사용함 
		//System.out.println(obj.y());
	}

}
