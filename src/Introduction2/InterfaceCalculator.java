package Introduction2;


public interface Calculatable {
	public void setOprands(int first, int second, int third);
	public int sum();
	public int avg();
}

class Calculator  {
	
	int first, second, third;
	public void setOprands(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	public int sum() {
		return this.first + this.second + this.third;
	}
	public int avg() {
		return (this.first + this.second + this.third)/3;
	}
	
	
}

public class InterfaceCalculator {

	public static void main(String[] args) {
		
	}

}
