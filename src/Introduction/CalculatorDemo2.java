package Introduction;


class Calculator{
	static double PI = 3.14;
	static int base = 0;
	int left, right;

	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void sum() {
		System.out.println(this.left + this.right + base);
	}
	public void avg() {
		System.out.println(this.left + this.right / 2);
	}

}
public class CalculatorDemo2 {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		System.out.println(c1.PI);
	
		
		Calculator c2 = new Calculator();
		System.out.println(c2.PI);
		
		System.out.println(Calculator.PI);//클래스를 직접적으로 접근할 수 있다.
	
		
	}

}
