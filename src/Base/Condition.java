package Base;
/*
 * 조건문
 */

public class Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score = 100;
		String grade;
		if(score >= 90) {
			grade = "A";
			
			if(score >= 98) {
				grade += "+";
			} else if (score < 94) {
				grade += "-";
			}
		} else if (score > 80) {
			grade = "B";
			
			if(score >= 88) {
				grade += "+";
			} else if (score < 84) {
				grade += "-";
			}
		} else if (score > 70) {
			grade = "C";
			
			if(score >= 78) {
				grade += "+";
			} else if (score < 74) {
				grade += "-";
			}
		} else {
			grade = "C";
		}
		
		System.out.println("당신의 성적은 " + grade + " 입니다.");
		

	}

}
