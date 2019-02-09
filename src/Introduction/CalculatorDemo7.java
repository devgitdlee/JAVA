package Introduction;

class calcul{
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
class multiplicationCalculator extends calcul{
	public void multiplication() {
		System.out.println(this.left * this.right);
	}
	
}
class division extends multiplicationCalculator {
	public void division() {
		System.out.println(this.left / this.right);
	}
}
public class CalculatorDemo7 {

	public static void main(String[] args) {
		
		division c1 = new division();
		c1.setOprands(100, 20);
		c1.sum();
		c1.avg();
		c1.multiplication();
		c1.division();
	
		
		division c2 = new division();
		c2.setOprands(80,40);
		c2.sum();
		c2.avg();
		c2.multiplication();
		c2.division();
		
	
		
	}

}
