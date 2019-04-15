package Thread;

public class MutilRunable {

	public static void main(String[] args) {
		ThreadEX the1 = new ThreadEX();
		ThreadEX the2 = new ThreadEX();
		Thread th1 = new Thread(the1,"A");
		Thread th2 = new Thread(the2,"B");
		
		th1.start();
		th2.start();
		
		Thread.currentThread().getName();

	}

}

class ThreadEX implements Runnable{
	
	int TestNum = 0;
	@Override
	public /*synchronized 하나가 끝나야 실행됨*/ void run() {
		
		for(int i=0;i<10;i++) {
				if(Thread.currentThread().getName().equals("A")) {
					System.out.println("=============================");
					TestNum++;
				}
				System.out.println("ThreadName ="+Thread.currentThread().getName()+"TestNum ="+TestNum);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	
}
