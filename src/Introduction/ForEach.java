package Introduction;


public class ForEach {

	public static void main(String[] args) {
		/*원래 for문을 사용하기 위해서 해당 배열을 사용하기위해서 배열의 수를 알아내야하고
		 *복잡하게 사용하기 때문에 foreach를 쓴다. 
		 */
		String[] members = {"최진혁", "최유빈", "한아람", "이고잉" };
		for(String e : members) { //members 변수를 e의 변수담아서 출력함
			System.out.println(e + "학생이 상담을 받았습니다.");
		}

	}

}
