package Introduction2;

class calcultor{
	int left, right;
	//생성자 클래스 생성될 떄 어느 메소드보다 먼저 실행됨 construtor 초기화 작업을 실행함
	public calcultor(int left, int right) {
		this.left = left;
		this.right = right;
	}
	


}

class CalculatorDecoPlus extends calcultor{
	public void sum() {
		System.out.println("+ sum : "+this.left + this.right);
	}
	public void avg() {
		System.out.println("+ avg : "+(this.left + this.right) / 2);
	}
}

class CalculatorDecoMinus extends calcultor {
	public void sum() {System.out.println("- sum : "+this.left + this.right);}
	public void avg() {System.out.println("- avg : "+(this.left + this.right) / 2);}
}
public class CalculatorDemo5 {

	public static void main(String[] args) {
		
		calcultor c1 = new calcultor(10,20);
		c1.sum();
		c1.avg();
	
		
		
	
		
	}

}
