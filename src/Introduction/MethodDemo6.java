package Introduction;

public class MethodDemo6 {
	public static String[] getMembers() {
		String[] members = {"������", "������", "�Ѿƶ�", "�̰���" };
		return members;
	}
	public static void main(String[] args) {
		String[] members = getMembers();
		for(String e : members) { //members ������ e�� ������Ƽ� �����
			System.out.println(e + "�л��� ����� �޾ҽ��ϴ�.");
		}

	}

}
