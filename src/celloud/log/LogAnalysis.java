package celloud.log;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LogAnalysis {
	/**
	 * 日志路径
	 */
	public static String path = "/Users/lin/Dropbox/log/log3.1.10.txt";

	/**
	 * 日志保留规则
	 */
	public static String[] printResular = { "update", "fixed", "fix", "add", "delete" };

	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		int i = 0;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			String l[] = line.split("\t");
			for (String string : l) {
				if (isPrint(string)) {
					i++;
					// System.out.print(i + "\t");
					System.out.println(string);
				}
			}
		}
		reader.close();
		in.close();
	}

	private static boolean isPrint(String line) {
		for (String string : printResular) {
			if (line.startsWith(string))
				return true;
		}
		return false;
	}
}
