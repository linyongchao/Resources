package celloud.log;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LogAnalysis {
	/**
	 * 日志路径
	 */
	public static String path = "/Users/lin/celloud3.1.2.txt";

	/**
	 * 日志丢弃规则
	 */
	public static String[] dropRegular = { "@han608github","Merge","merge" };

	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (isDrop(line)) {
				continue;
			}
			String l[] = line.split("\t");
			if (l.length < 3) {
				continue;
			}
			if (isDrop(l[2])) {
				continue;
			}
			System.out.println(l[2]);
		}
		reader.close();
		in.close();
	}

	private static boolean isDrop(String line) {
		for (String string : dropRegular) {
			if (line.startsWith(string))
				return true;
		}
		return false;
	}
}
