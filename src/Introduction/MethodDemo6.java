package Introduction;

public class MethodDemo6 {
	public static String[] getMembers() {
		String[] members = {"최진혁", "최유빈", "한아람", "이고잉" };
		return members;
	}
	public static void main(String[] args) {
		String[] members = getMembers();
		for(String e : members) { //members 변수를 e의 변수담아서 출력함
			System.out.println(e + "학생이 상담을 받았습니다.");
		}

	}

}
