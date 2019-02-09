package Introduction;

public class CalculatorDemo {
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}
	public static void avg(int left, int right) {
		System.out.println(left + right / 2);
	}
	public static void main(String[] args) {
		int left, right;
		
		left = 10;
		right = 20;
		
		sum(left, right);
		avg(left, right);
		
		left = 30;
		right = 40;
		
		sum(left, right);
		avg(left, right);
	}

}
