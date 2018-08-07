package Base;
/*
 * ¹Ýº¹¹®
 */
public class Repeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<5; i++) {
			for(int j=4; j>0;j--) {
				if(i<j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			
			}
			System.out.println("");
		}
	}

}
