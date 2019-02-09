package Introduction2;
/*
class Human {
	protected String test() {
		return "test";
		
	}
}
*/
class Student implements Cloneable {
	String name;
	Student(String name){
		this.name = name;
	}
	public Object clone () throws CloneNotSupportedException {
		return super.clone();
	}
}
public class CloneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("egoing");
		try {
			Student s2 = (Student)s1.clone();
			System.out.println(s1.name);
			System.out.println(s2.name);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
