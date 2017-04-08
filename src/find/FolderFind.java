package find;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FolderFind {
	public static int i = 0;
	public static String path = "/Users/lin/Documents/apache-tomcat-8.5.11";
	public static String keyword = "CelLoudAPI";

	public static void main(String[] args) {
		find(path);
		System.out.println(i);
		System.out.println("over");
	}

	public static void find(String path) {
		File[] array = new File(path).listFiles();
		for (File file : array) {
			if (file.isDirectory()) {
				find(file.getAbsolutePath());
			} else {
				match(file);
			}
		}
	}

	public static String match(File file) {
		FileReader in = null;
		try {
			in = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println(file.getAbsolutePath() + "文件不存在");
		}
		if (in == null)
			return null;
		LineNumberReader reader = new LineNumberReader(in);
		String s = null;
		String line = null;
		try {
			int count = 0;
			while ((line = reader.readLine()) != null) {
				count++;
				if (!"".equals(line.trim()) && line.contains(keyword)) {
					System.out.println(count + "--" + file.getAbsolutePath());
					i++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
