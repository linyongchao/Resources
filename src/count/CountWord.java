package count;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CountWord {
	private static String path = "/Users/lin/count.txt";

	public static void main(String[] args) throws IOException {
		String src = FileUtils.readFileToString(new File(path));
		char[] t1 = null;
		t1 = src.toCharArray();
		int t0 = t1.length;
		int count = 0;
		for (int i = 0; i < t0; i++) {
			if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
				count++;
			}
		}
		System.out.println(count);

	}
}
