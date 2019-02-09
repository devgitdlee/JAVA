package Introduction2;


import Bean.*;

class Returnout{
	public void print() {
		
		//System.out.println(ErrCodeAndErrMesg.getErrcode());
		//System.out.println(ErrCodeAndErrMesg.getErrMesg());
	}
}

public class ReturnValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErrCodeAndErrMesg err = new ErrCodeAndErrMesg();
		
		err.setErrcode(400);
		err.setErrMesg("값 전달이 완료되었습니다.");
		System.out.println(err.getErrcode());
		System.out.println(err.getErrMesg());
		Returnout out = new Returnout();
		
		out.print();
		
	}

}
