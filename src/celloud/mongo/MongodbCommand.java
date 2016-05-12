package celloud.mongo;

import java.io.File;

public class MongodbCommand {
	static String base = "./mongoimport -h192.168.22.129 -dcelloud  -c ";
	static String path = "/Users/lin/celloud/";

	public static void main(String[] args) {
		File f = new File(path);
		File[] list = f.listFiles();
		for (File file : list) {
			String name = file.getName();
			if (name.endsWith(".metadata.json")) {
				System.out.println(base + name.replace(".metadata.json", "") +" "+ path + name);
			}
		}
	}
}
