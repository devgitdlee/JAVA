package Algorithm;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0, i, j;
		int n = 100000;
		for(i=2; i<=n; i++) {
			
			if(i!=2 && i%2==0) continue;
	        if(i!=3 && i%3==0) continue;
	        if(i!=5 && i%5==0) continue;
	        if(i!=7 && i%7==0) continue;
	        if(i!=13 && i%13==0) continue;
	        if(i!=17 && i%17==0) continue;
	        if(i!=19 && i%19==0) continue;
	        if(i!=23 && i%23==0) continue;
	        if(i!=27 && i%27==0) continue;
	        if(i!=29 && i%29==0) continue;
	        if(i!=31 && i%31==0) continue;
	        if(i!=37 && i%37==0) continue;
	        if(i!=41 && i%41==0) continue;
	        if(i!=43 && i%43==0) continue;
	        if(i!=47 && i%47==0) continue;
	        if(i!=53 && i%53==0) continue;
	        if(i!=59 && i%59==0) continue;
	        if(i!=61 && i%61==0) continue;
	        if(i!=67 && i%67==0) continue;
	        if(i!=71 && i%71==0) continue;
	        if(i!=73 && i%73==0) continue;
	        if(i!=79 && i%79==0) continue;
	        if(i!=83 && i%83==0) continue;
	        if(i!=89 && i%89==0) continue;
	        if(i!=97 && i%97==0) continue;
			for(j=2; j<i; j++) {
				if(i%j==0) break;
				
			}
			if(i==j) System.out.println(i);
		}
		//System.out.println(i);
		
	}

}
