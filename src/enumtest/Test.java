package enumtest;

public class Test {
	public static void main(String[] args) {
		String state = State.Deleted.getState();
		System.out.println(state);
		State.Deleted.read();;
	}
}
