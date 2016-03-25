package face;

public class ThreadTest {

	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				pang(1);
			}
		};
//		t.start();
		t.run();
		Thread t2 = new Thread(){
			public void run(){
				pang(2);
			}
		};
//		t2.start();
		t2.run();
		Thread t3 = new Thread(){
			public void run(){
				pang(3);
			}
		};
//		t3.start();
		t3.run();
		Thread t4 = new Thread(){
			public void run(){
				pang(4);
			}
		};
//		t4.start();
		t4.run();
		System.out.println("ping");
	}
	static void pang(int i){
		System.out.println("pang"+i);
	}
}
