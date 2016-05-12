package celloud.log;

import java.util.ArrayList;

public class A {
	public static void main(String[] args) {
		ArrayList<String> x = new ArrayList<String>();
		x.add("x");
		for (String s : x) {
			x.remove(s);
		}
	}
}
