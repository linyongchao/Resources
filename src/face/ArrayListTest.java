package face;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}
		System.err.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				list.remove(i);
			}
		}
		System.err.println(list.size());
		for (String s : list) {
			list.remove(s);
		}
	}
}
