package face;

public class SysPrint {
	private static void testMethod() {
		System.out.println("test");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		((SysPrint) null).testMethod();
	}
}
