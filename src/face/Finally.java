package face;

public class Finally {
	public int add(int a, int b) {
		try {
			return a + b;
		} catch (Exception e) {
			System.out.println("e1");
		} finally {
			System.out.println("e2");
		}
		return 0;
	}

	public static void main(String[] args) {
		Finally t = new Finally();
		System.out.println("add:" + t.add(9, 34));
	}
}
