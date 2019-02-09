package Introduction2;

import Bean.*;

public class ValuesOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErrCodeAndErrMesg err = new ErrCodeAndErrMesg();
		
		System.out.println(err.getErrcode());
		System.out.println(err.getErrMesg());
	}

}
