package celloud.ruanzhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utils.FileTools;

public class RemoveBlank {
	public static String result = "/Users/lin/RunZhu.txt";

	public static void main(String[] args) {
		System.out.println(FileTools.countLines(result));
		blank(result);
		System.out.println(FileTools.countLines(result));
	}

	public static void blank(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println(file.getAbsolutePath() + "文件不存在");
		}
		if (br == null)
			return;
		try {
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					sb.append(line).append("\n");
				}
			}
			new File(path).delete();
			FileTools.createFile(path);
			FileTools.appendWrite(path, sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
