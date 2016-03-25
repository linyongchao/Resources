package face;

public class StringBufferParam {
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("a");
		StringBuffer b = new StringBuffer("b");
		a(a, b);
		System.out.println(a + "," + b);
	}

	public static void a(StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x;
	}
}
