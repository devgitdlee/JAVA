package Introduction;

class cal{
	int left, right;

	
	public void setOprands(int left, int right) {
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
class SubstractionableCalculator extends cal{
	public void substract() {
		System.out.println(this.left - this.right);
	}
}
public class CalculatorDemo6 {

	public static void main(String[] args) {
		
		SubstractionableCalculator c1 = new SubstractionableCalculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		c1.substract();
	
		
		SubstractionableCalculator c2 = new SubstractionableCalculator();
		c2.setOprands(30,40);
		c2.sum();
		c2.avg();
		c2.substract();
		
	
		
	}

}
