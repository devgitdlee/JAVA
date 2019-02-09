package Algorithm;

public class MiddleString {

	public static void main(String[] args) {
		String s = "abcde";
		String answer = "";
		int len = 0;
		double dlen = 0;
		len = s.length();
		if (len%2==0){
			answer = s.substring(len/2-1,len/2+1); 
		}else{
    	  dlen = len;
    	  len = (int) (dlen / 2 + 0.5);
    	  System.out.println(len);
    	  answer = s.substring(len-1,len);
		}	
		System.out.print(answer);
	}
}
