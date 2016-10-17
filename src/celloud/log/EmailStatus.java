package celloud.log;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class EmailStatus {
	/**
	 * 路径
	 */
	public static String path = "/Users/lin/emailState.txt";

	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			String l[] = line.split("\t");
			// System.out.println("//" + l[1]);
			System.out.println("System.out.println(\"" + l[1] + "\" +r.get(\"" + l[0] + "\"));");
		}
		reader.close();
		in.close();
	}

}
