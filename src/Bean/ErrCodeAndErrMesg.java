package Bean;

public class ErrCodeAndErrMesg {
	//ErrCode นื ErrMesg ภ๚ภๅ
	private int Errcode;
	private String ErrMesg;
	
	public ErrCodeAndErrMesg()
	{
		super();
	}

	public ErrCodeAndErrMesg(int Errcode, String ErrMesg) {
	  super();
	  this.Errcode = Errcode;
	  this.ErrMesg = ErrMesg;
	}
	
	public int getErrcode() {
		return Errcode;
	}
	public void setErrcode(int errcode) {
		this.Errcode = errcode;
	}
	public String getErrMesg() {
		return ErrMesg;
	}
	public void setErrMesg(String errMesg) {
		this.ErrMesg = errMesg;
	}

	
}
