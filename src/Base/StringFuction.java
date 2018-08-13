package Base;


public class StringFuction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuc = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String ft = "가나 다라 마 바 사";
		
		String ft1 = "A/B/C/D";
		
		//문장 붙여주는 기능
		String t1 = fuc.concat("ㄱㄴㄷ");
		
		System.out.println(t1);
		
	    //바꿀단어 
		String t2 = fuc.replace('A', 'ㄱ');
		
		System.out.println(t2);
		
		//문자열 자르기
		String t3 = fuc.substring(0, 15);
		
		System.out.println(t3);
		
		//해당 'R'글자 자릿수 구하기
		int t4 = fuc.indexOf("R");
		
		System.out.println(t4);
		
		//인수 길이 구하기
		int t5 = fuc.length();
		
		System.out.println(t5);
		
		//주어진 문자로 분리하여 배열에 저장
		String[] t6 = ft.split(" ");
		
		for(int i = 0; i<t6.length; i++) {
			System.out.println(t6[i]);
		}
		
		//특정문자 지욱기
		String t7 = ft1.replaceAll("/", "");
		
		System.out.println(t7);
		
		//trim 공백제거
		
		
		//3번째 자릿수 구하기
	    
		
		
		//
		
		
		
	}

}
