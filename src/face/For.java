package face;

public class For {
	public static boolean foo(char c) {
		System.out.println(c);
		return true;
	}

	public static void main(String[] args) {
		int i = 0;
		for (foo('A'); i <= 3 & foo('B'); foo('C')) {
			foo('D');
			i++;
		}
	}
}
