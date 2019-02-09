package Algorithm;

public class EssenceSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int a= 3, b=5, i;
		
		if (a>b){
			int temp = a;
			a = b;
			b = temp;
		}
		for(i=a; i<=b; i++){
			sum = sum + i;
	    } 
		System.out.println(sum);
	}

}
