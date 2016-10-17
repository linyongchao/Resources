package celloud.log;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Count {
	/**
	 * 日志路径
	 */
	public static String path = "/Users/lin/1.txt";


	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			String x[] = line.split("\\|");
			int i = 0;
			for (String s : x) {
				if (!s.trim().equals("")) {
					if (i == 0) {
						String p = "select user_id,log_date from tb_log where user_id=" + s.trim()
								+ " order by log_date desc limit 1;";
						System.out.print(p);
						System.out.print("\t");
					}
					//					System.out.print(s.trim());
					//					System.out.print("\t");
					i++;
				}
			}
			System.out.println();
		}
		System.out.println("over");
		reader.close();
		in.close();
	}

}
