package parameter;

public class TransferParameter {
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Before change, n = " + n);
		changeData(n);
		System.out.println("After changeData(n), n = " + n);
	}

	public static void changeData(int nn) {
		nn = 10;
	}
}

class PPP {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("Before change, sb = " + sb);
		changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);
	}

	public static void changeData(StringBuffer strBuf) {
		strBuf.append("World!");
	}
}

class JJJ {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("Before change, sb = " + sb);
		changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);
	}

	public static void changeData(StringBuffer strBuf) {
		strBuf = new StringBuffer("Hi ");
		strBuf.append("World!");
	}
}

class QQQ {
	public static void main(String[] args) {
		String sb = "Hello ";
		System.out.println("Before change, sb = " + sb);
		changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);
	}

	public static void changeData(String strBuf) {
		strBuf = "Hi ";
	}
}
