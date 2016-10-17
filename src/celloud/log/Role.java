package celloud.log;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Role {
	/**
	 * 日志路径
	 */
	public static String path = "/Users/lin/1.txt";

	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		Map<String, String> map = new HashMap<String, String>();
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			String x[] = line.split("\\|");
			String userId = x[1].trim();
			String roleId = x[2].trim();
			if (map.containsKey(userId)) {
				map.put(userId, map.get(userId) + "," + roleId);
			} else {
				map.put(userId, roleId);
			}
		}
		for (Entry<String, String> m : map.entrySet()) {
			if (m.getValue().contains("6") || m.getValue().contains("7")) {
				System.out.println(m.getValue());
			} else {
				System.out.println(m.getKey());
			}
		}
		System.out.println("over");
		reader.close();
		in.close();
	}

}
